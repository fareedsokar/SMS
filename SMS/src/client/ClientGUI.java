package client;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.IOException;
import OurMessage.Message;
import javax.swing.JScrollPane;


public class ClientGUI extends JFrame {
	private JPanel contentPane; // the panel
	private JTextField serveradd; // text field for enter server address
	private JTextField port; // NO port
	private JButton btnConnect; // button to connect to the server
	private JButton btnRead; // button to get the database table
	private JButton btnUpdate; // button to insert to the database
	JTextArea notification; // TextArea to notify the user 
	JTextArea emptyfield;//Read Teacher notification box
	JTextArea emptyfield2;//Update teaching unit notification box
	JTextArea fromserver; // the output or the answer for the client's request
	Client client;
	private JTextField txtTeach; // New teacher name
	private JTextField txtTeachID; // new Teacher ID 
	private JTextField txtTeachUnit; //new Teaching Unit
	

	private static final long serialVersionUID = 1L; 
	/**
	 * Create the frame.
	 */
	public ClientGUI() {
		//Create The Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 450);
		setTitle("Client Side");
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		//Server & Port Labels
			//Server Address Label
			JLabel lblServerAddress = new JLabel("Server Address:");
			lblServerAddress.setForeground(Color.BLACK);
			lblServerAddress.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblServerAddress.setBounds(10, 29, 140, 26);
			contentPane.add(lblServerAddress);
		
			//Port Number Label
			JLabel lblPort = new JLabel("Port Number:");
			lblPort.setForeground(Color.BLACK);
			lblPort.setFont(new Font("Calibri", Font.PLAIN, 16));
			lblPort.setBounds(10, 80, 140, 17);
			contentPane.add(lblPort);
		
		
		//Server & Port TextFields
			//Server Address TextField
			serveradd = new JTextField();
			serveradd.setForeground(Color.BLACK);
			serveradd.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
			serveradd.setBounds(153, 34, 266, 20);
			contentPane.add(serveradd);
			serveradd.setColumns(15);
			
			//Port Number TextField
			port = new JTextField();
			port.setForeground(Color.BLACK);
			port.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
			port.setBounds(153, 79, 266, 20);
			contentPane.add(port);
			port.setColumns(10);
			
		//Connection Button & Vertification
			//Connect Button
			btnConnect = new JButton("Connect");
			btnConnect.setFont(new Font("Calibri", Font.PLAIN | Font.BOLD, 13));
			btnConnect.setForeground(Color.BLACK);
			btnConnect.setBounds(10, 126, 89, 23);
			btnConnect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String Host,PPort;
					int Port;
					Host = serveradd.getText();
					PPort = port.getText();
				if(!Host.isEmpty() && !PPort.isEmpty()){
					 try {
							client.setHost(Host);
							Port = Integer.parseInt(PPort);
							client.setPort(Port);
						 	client.openConnection();
						 	notification.setForeground(Color.black);
						 	notification.setText("Connection to server succeeded.");
						 	client.handleMessageFromClientUI(new Message("Client connected.",Message.display));
					 } catch (IOException e) { 
						 notification.setForeground(Color.RED); 
					 notification.setText("Connection to server failed.");
					 }
				}
				else
				{
				 notification.setForeground(Color.RED); 
				 notification.setText("Enter server address and port number");
				}
				}
			});
			contentPane.add(btnConnect);
			
		//Get Teacher information by ID
			//Teacher ID label
			JLabel lblTeachID = new JLabel("Teacher ID:");
			lblTeachID.setBounds(10, 174, 70, 23);
			contentPane.add(lblTeachID);
			
			//Teacher ID TextField
			txtTeachID = new JTextField();
			txtTeachID.setColumns(10);
			txtTeachID.setBounds(100, 174, 320, 23);
			contentPane.add(txtTeachID);
			
			//Read Button
			btnRead = new JButton("Read");
			btnRead.setFont(new Font("Calibri", Font.PLAIN, 13));
			btnRead.setForeground(Color.BLACK);
			btnRead.setToolTipText("");
			btnRead.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Message msg1 = new Message("SELECT * FROM teachers WHERE ID="+txtTeachID.getText(),Message.select);
					if(!txtTeachID.getText().isEmpty())
					{
					try {
							fromserver.setText(null);
							client.handleMessageFromClientUI(msg1);
							emptyfield.setForeground(Color.black);
							emptyfield.setText("DB read succeeded.");
					} catch (IOException e1) {
						emptyfield.setForeground(Color.RED);
						emptyfield.setText("DB Read failed.");}
					}
					else
					{
						
						emptyfield.setForeground(Color.RED);
						emptyfield.setText("Field is Empty.");}
						
					}
			});
			btnRead.setBounds(10, 217, 89, 23);
			contentPane.add(btnRead);
			
		//Update Teaching Unit By TeacherID
			//Explaining
			JLabel lblexplain = new JLabel("-Updating Teaching unit by Teacher ID-");
			lblexplain.setForeground(Color.BLUE);
			lblexplain.setBounds(220, 245, 218, 14);
			contentPane.add(lblexplain);
			//TeacherID Title
			JLabel lblTeach = new JLabel("Teacher ID:");
			lblTeach.setBounds(220, 270, 100, 14);
			contentPane.add(lblTeach);
			//Teaching Unit Title
			JLabel lblTeachUnit = new JLabel("Teaching Unit:");
			lblTeachUnit.setBounds(220, 300, 100, 14);
			contentPane.add(lblTeachUnit);
			//Teacher ID TextField
			txtTeach = new JTextField();
			txtTeach.setBounds(309, 267, 118, 20);
			contentPane.add(txtTeach);
			txtTeach.setColumns(10);
			//Teach Unit TextField
			txtTeachUnit = new JTextField();
			txtTeachUnit.setColumns(10);
			txtTeachUnit.setBounds(309, 300, 118, 20);
			contentPane.add(txtTeachUnit);
		//Update Button
			 btnUpdate = new JButton("Update DB");
				btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 13));
				btnUpdate.setForeground(Color.BLACK);
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String name,id,teachunit;
					//name = txtTeachName.getText();!name.isEmpty() && 
					id =txtTeach.getText();
					teachunit=txtTeachUnit.getText();
					if(!id.isEmpty() && !teachunit.isEmpty())
					{
						//Message msg2 = new Message("insert into teachers values ('"+ '"'+txtTeachName.getText()+'"'+ "','"+ '"'+txtTeachID.getText()+"','"+ '"'+txtTeachUnit.getText()+ '"'+"')",Message.insert);
						Message msg2 = new Message("UPDATE TEACHERS SET TEACHINGUNIT = ? WHERE ID = ?/" +txtTeachUnit.getText() + "/"+txtTeach.getText(),Message.update);
						try {
							 fromserver.setText(null);
							   client.handleMessageFromClientUI(msg2);
							   emptyfield2.setForeground(Color.black);
							   emptyfield2.setText("DB write succeeded.");
							   txtTeach.setText(null);
							   //txtTeachName.setText(null);
							   txtTeachUnit.setText(null);
						} catch (IOException e1) {
							emptyfield2.setForeground(Color.RED);
							emptyfield2.setText("DB write failed.");}
					}
					else
					{
						emptyfield2.setForeground(Color.RED);
						emptyfield2.setText("Fill the fields");
					}
					}
				});
				btnUpdate.setBounds(265, 325, 118, 23);
				contentPane.add(btnUpdate);
			
			
			//Add the server's answer for client request 
			fromserver = new JTextArea();
			fromserver.setEditable(false);
			fromserver.setFont(new Font("Calibri", Font.BOLD, 11));
			fromserver.setForeground(Color.BLACK);
			fromserver.setBackground(Color.WHITE);
			fromserver.setBounds(65, 306, 309, 42);
			contentPane.add(fromserver);
			//Connection Notification
			notification = new JTextArea();
			notification.setForeground(new Color(210, 105, 30));
			notification.setBounds(110, 126, 310, 23);
			notification.setEditable(false);
			contentPane.add(notification);
			//read DB Notification
			emptyfield = new JTextArea();
			emptyfield.setForeground(new Color(210, 105, 30));
			emptyfield.setBounds(110, 217, 310, 23);
			emptyfield.setEditable(false);
			contentPane.add(emptyfield);
			//Update DB Notification
			emptyfield2 = new JTextArea();
			emptyfield2.setForeground(new Color(210, 105, 30));
			emptyfield2.setBounds(10, 355, 420, 23);
			emptyfield2.setEditable(false);
			contentPane.add(emptyfield2);
			//ScrollPane
			JScrollPane scrollPane = new JScrollPane(fromserver);
			scrollPane.setBounds(10, 245, 200, 100);
			contentPane.add(scrollPane);
	}

	
	public void setNotification(String s)
	{
		notification.setText(s);
	}
	
	public void displayFromServer(String s)
	{
		fromserver.append(s + " \n");
	}
	
	  public static void main(String[] args) throws IOException {
			
		 ClientGUI clientui = new ClientGUI();
		clientui.setVisible(true);
		Client client = new Client(clientui);
		clientui.client = client;
	
		
	  }
}

	
