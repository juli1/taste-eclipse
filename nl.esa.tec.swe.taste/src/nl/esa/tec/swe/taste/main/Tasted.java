package nl.esa.tec.swe.taste.main;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import nl.esa.tec.swe.taste.commands.Utils;
import nl.esa.tec.swe.taste.wizard.preferences.PreferencesHelper;


public class Tasted {
	private String 			serverName 		= "localhost";
	private int 			serverPort    	= 1234;
	private Socket 			serverSocket;
	private PrintWriter 	socketOut;
	private BufferedReader 	socketIn;
	private Document 		dom 			= null;
	private DocumentBuilder db 				= null;
	private DocumentBuilderFactory 			dbf;
	
	public Tasted ()
	{
		dbf = DocumentBuilderFactory.newInstance();

		//Using factory get an instance of document builder
		try
		{
			db = dbf.newDocumentBuilder();
		}
		catch(ParserConfigurationException pce) 
		{
			System.out.println("[Tasted] Bad XML parser configuration");

			pce.printStackTrace();
		}

		//parse using builder to get DOM representation of the XML file
		dbf.setValidating(false);
		dbf.setSchema(null);
	}
	
	public void disconnect ()
	{
		if ((serverSocket != null) && (serverSocket.isConnected()))
		{
			try 
			{
				serverSocket.close();
			} 
			catch (IOException e) 
			{
				System.out.println ("[Tasted] Cannot close socket ");
				e.printStackTrace();
			}
		}
	}
	
	public void connect ()
	{
		String[] tmp = new String[2];
		
		String serverStr = PreferencesHelper.getTastedServer();
		System.out.println ("[Tasted] Server string " + serverStr);
		tmp = serverStr.split (" ");
		if (tmp.length > 1)
		{
			if (tmp[0] != null)
			{
				serverName = tmp[0];
			}

			if (tmp[1] != null)
			{
				serverPort = Integer.parseInt(tmp[1]);
			}
			
		}
		
		System.out.println ("[Tasted] Server name " + serverName );
		System.out.println ("[Tasted] Server port " + serverPort );

		try{
			serverSocket = new Socket(serverName, serverPort);
			socketOut = new PrintWriter(serverSocket.getOutputStream(),true);
			socketIn = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
		}
		catch (UnknownHostException e) 
		{
			System.out.println("[Tasted] Unknown host");
			Utils.showError("TASTEd server unknown", "");

		}
		catch  (IOException e) 
		{
			System.out.println("[Tasted] No I/O");
			Utils.showError("Cannot connect to the remote host", "");
		}
	}
	
	public boolean checkConnection ()
	{
		return ((serverSocket != null) && (serverSocket.isConnected()));
	}
	
	public int sendCommandAndWaitForPort (String command)
	{
		connect();
		String line = "";

		int binPort = -1;
		

		if (checkConnection() == false)
		{
			System.out.println("[Tasted] Not connected, will exit");
			return -1;
		}
		
		socketOut.write("<request type=\""+ command + " \"/>\n");
		socketOut.flush();
		try 
		{
			line = socketIn.readLine();
		} 
		catch (IOException e) 
		{
			System.out.println("[Tasted] Received exception when trying to read the socket");
			e.printStackTrace();
		}
		System.out.println("[Tasted] Received from server" + line);

		try 
		{


			dom = db.parse (new InputSource(new ByteArrayInputStream(line.getBytes("utf-8"))));

		}
		catch(SAXException se) 
		{
			System.out.println("[Tasted] SAX Exception");

			se.printStackTrace();
		
		}catch(IOException ioe) {
			System.out.println("[Tasted] I/OError");

			ioe.printStackTrace();
		}
		Element docEle = dom.getDocumentElement();
		System.out.println("[Tasted] main node name=" + docEle.getNodeName());
		if (docEle.getNodeName().equalsIgnoreCase("answer"))
		{
			String attrType = docEle.getAttribute("type");
			if (attrType.equals("send-archive"))
			{
				for (int i = 0 ; i < docEle.getChildNodes().getLength() ; i++)
				{
					Node n = docEle.getChildNodes().item(i);
					if (n.getNodeType() == Node.ELEMENT_NODE)
					{
						Element child = (Element) n;
						if (child.getNodeName().equals("option"))
						{
							String attrName = child.getAttribute("name");
							String attrVal = child.getAttribute("value");
							System.out.println("[Tasted] attr name=" + attrName);
							System.out.println("[Tasted] attr val =" + attrVal);
							if (attrName.equalsIgnoreCase("port"))
							{
								binPort = Integer.parseInt(attrVal);
							}

						}
					}
				}
			}
		}

		return binPort;
	}
	
	
	private boolean checkAnswer (String ans)
	{
		String line = "";
		try 
		{
			line = socketIn.readLine();
		} 
		catch (IOException e) 
		{
			System.out.println("[Tasted] Received exception when trying to read the socket");
			e.printStackTrace();
		}
		System.out.println("[Tasted] Received from server" + line);

		try 
		{
			dom = db.parse (new InputSource(new ByteArrayInputStream(line.getBytes("utf-8"))));
		}
		catch(SAXException se) 
		{
			System.out.println("[Tasted] SAX Exception");

			se.printStackTrace();
			return false;
		}
		catch(IOException ioe) {
			System.out.println("[Tasted] I/OError");

			ioe.printStackTrace();
			return false;
		}
		
		Element docEle = dom.getDocumentElement();
		System.out.println("[Tasted] main node name=" + docEle.getNodeName());
		if (docEle.getNodeName().equalsIgnoreCase("answer"))
		{
			String attrType = docEle.getAttribute("type");
			if (attrType.equals(ans))
			{
				String attrStatus = docEle.getAttribute("status");
				if (attrStatus.equalsIgnoreCase("ok"))
				{
					return true;
				}		
			}
		}
		return false;
	}
	
	public void buildProject(String inputZip, String outputZip) {
		int binPort;
		
		binPort = sendCommandAndWaitForPort ("build");		
		if (binPort == -1)
		{
			return;
		}
		
		sendAndReceiveArchive (binPort, inputZip, outputZip);

		if (! checkAnswer ("build-result"))
		{
			Utils.showError("Error while building the system");
		}
	
	}

	private void sendAndReceiveArchive(int binPort, String inputZip, String outputZip) 
	{
		Socket binSocket;
		OutputStream binOut;
		InputStream binIn;
		File inputFile;
		File outputFile;
		int inputFileSize;
		InputStream inputFileReader;
		OutputStream outputFileWriter;
		byte[] content;
		
		System.out.println("[Tasted] sendAndReceiveArchive on files " + inputZip + "," + outputZip);

		content = new byte[1024];
		int read;
		int off;
		try{
			binSocket = new Socket(serverName, binPort);
			binOut = binSocket.getOutputStream();
			binIn = binSocket.getInputStream();
			
		    inputFile = new File(inputZip);
		    outputFile = new File (outputZip);
		    inputFileReader = new BufferedInputStream (new FileInputStream (inputFile));
		    outputFileWriter = new BufferedOutputStream (new FileOutputStream (outputFile));
		    off = 0;
		    while ( (read = inputFileReader.read (content, 0, 1024)) > 0)
		    {
		    	off = off + read;
		    	binOut.write(content, 0, read);
		    	binOut.flush();
		    }
		    
		    off = 0;
		    while ( (read = binIn.read(content)) > 0)
		    {
		    	System.out.println ("[Tasted] Read " + read + " bytes from tasted");
		    	outputFileWriter.write(content, 0, read);
		    	off = off + read;
		    }
		    binIn.close();
		    outputFileWriter.close();
		    
		}
		catch (UnknownHostException e) 
		{
			System.out.println("[Tasted] Unknown host");
		}
		catch  (IOException e) 
		{
			System.out.println("[Tasted] No I/O");
		}
	}

	public void generateDataView(String inputZip, String outputZip) 
	{	
		int binPort;
			
		binPort = sendCommandAndWaitForPort ("generate-dataview-aadl");		
		if (binPort == -1)
		{
			return;
		}
		
		sendAndReceiveArchive (binPort, inputZip, outputZip);

		if (! checkAnswer ("generate-dataview-aadl-result"))
		{
			Utils.showError("Error while generating the data view");
		}
					
	}
	
	

	public void generateSkels(String inputZip, String outputZip) {
		int binPort;
		
		binPort = sendCommandAndWaitForPort ("generate-skels");		
		if (binPort == -1)
		{
			return;
		}
		
		sendAndReceiveArchive (binPort, inputZip, outputZip);

		if (! checkAnswer ("generate-skels-result"))
		{
			Utils.showError("Error while generating skeletons");
		}
		
	}

}
