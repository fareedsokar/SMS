

// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
package client;

import ocsf.client.*;

import java.io.*;

import OurMessage.*;

public class Client extends AbstractClient{
	/**
	 * @param args
	 * @throws IOException 
	 */
	
	private ClientGUI clientUI;
	
	public Client(ClientGUI clientUI) throws IOException  
	{
		 super(); //Call the superclass constructor
		 this.clientUI=clientUI;
		 clientUI.setVisible(true);
	}
	
	public Client(String host,int port,ClientGUI clientUI) throws IOException  
	{
		 super(host, port); //Call the superclass constructor
		 this.clientUI=clientUI;
		 clientUI.setVisible(true);
		 try {
			 	openConnection();
		 } catch (IOException e) {clientUI.setNotification("Connection to server failed."); }
	}
	
	public void handleMessageFromServer(Object msg) 
	{
		clientUI.displayFromServer((String)msg);
	}
	
	public void quit()
	{
	  try
	  {
	     closeConnection();
	  }
	  catch(IOException e) {e.printStackTrace();}
	  System.exit(0);
	}
	
	  public void handleMessageFromClientUI(Message msg) throws IOException
	  {
	    try
	    {
	    	sendToServer(msg);
	    }
	    catch(IOException e)
	    {
	      clientUI.setNotification("Could not send message to server.");
	      throw e;
	     // quit();
	    }
	  }
	  

}
//End of  class
