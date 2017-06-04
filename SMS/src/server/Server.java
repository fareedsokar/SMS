package server;

import java.io.IOException;
import java.sql.*;

import OurMessage.Message;
import ocsf.server.*;
public class Server extends AbstractServer {
	//Class variables ***************************************************
	  
	  /**
	   * The default port to listen on.
	   */
	  final public static int DEFAULT_PORT = 5555;
	  private Connection conn;
	  private ServerGUI serv;
	  //Constructors ****************************************************
	  
	  /**
	   * Constructs an instance of the echo server.
	   *
	   * @param port The port number to connect on.
	   */
	  
	  public Server(ServerGUI srv)
	  {
		  super();
		  this.serv = srv;
		  srv.setVisible(true);
	  }
	  
	  //Instance methods ************************************************
	  
	  /**
	   * This method create the connection between the server and the DB
	   *
	   * @param dbName The database name.
	   * @param user mysql username.
	   * @param pass mysql password.
	   */
	  
	  public boolean initDBConnection(String dbName,String user, String pass) throws Exception
	  {
		  try 
			{
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName, user, pass);
	            System.out.println("SQL connection succeed");
	            return true;
	        } catch (SQLException ex) {return false;}
	  }
	 
	  /**
	   * This method handles any messages received from the client.
	   *
	   * @param msg The message received from the client , it's the query that the server should do.
	   * @param client The connection from which the message originated.
	   */
	  public void handleMessageFromClient(Object msg, ConnectionToClient client)
	  {
		  
		  Statement stmt;//INSERT & SELECT Query statement;
		  PreparedStatement pstmt;//UPDATE prepared statement
		  ResultSet rs;
		  try 
		  {
			  //Creating The Statemnet to work with
			  stmt = conn.createStatement();
			  int op = ((Message)msg).GetQType();
			 
			  switch(op){
			  		case 1: // insert to the DB
			  				serv.display("WRITE request.");
			  				stmt.executeUpdate(((Message)msg).GetQuery());
			  				break;
				 
			  		case 2: // select from DB
			  				serv.display("Read Request");
			  				rs = stmt.executeQuery(((Message)msg).GetQuery());
			  				while(rs.next()){
			  					try {
			  						
			  						client.sendToClient(rs.getString(1) + " " + rs.getString(2)+" "+rs.getString(3));
			  					} catch (IOException e) {
			  						// TODO Auto-generated catch block
			  						e.printStackTrace();
			  					}//catch
			  				}// while
			  				break;
			  case 3: // display
				  serv.display(((Message)msg).GetQuery());
				  break;
			  case 4:
				  serv.display("UPDATE request.");
				  
				  String[] parts=((Message)msg).GetQuery().split("/");
				  pstmt= conn.prepareStatement(parts[0]);
				  for(int i=1;i<parts.length;i++)
				  {
					  pstmt.setString(i, parts[i]);
				  }
				  //pstmt= conn.prepareStatement(((Message)msg).GetQuery());
				  pstmt.executeUpdate();
				  break;
			  }
		  } catch (SQLException e) 
		  {
			  this.sendToAllClients("Faild!");
		  }
		  
	  }

	    
	  /**
	   * This method overrides the one in the superclass.  Called
	   * when the server starts listening for connections.
	   */
	  protected void serverStarted()
	  {
		  System.out.println
		    ("Server listening for connections on port " + getPort());
	  }
	  
	  /**
	   * This method overrides the one in the superclass.  Called
	   * when the server stops listening for connections.
	   */
	  protected void serverStopped()
	  {
		  System.out.println
	       ("Server has stopped listening for connections.");
	  }
	  
	  
}
