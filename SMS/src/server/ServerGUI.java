package server;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import server.Server;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;


import javax.swing.border.MatteBorder;

public class ServerGUI extends JFrame {

	private JPanel contentPane;
	private JTextArea serverConsole;
	private JLabel lblDbName;
	private JTextField textFieldDBName;
	private JLabel lblPort;
	private JTextField textFieldPort;
	private JButton btnConnect;
	private JTextField textFieldUser;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JPasswordField textFieldPass;
    public Server server;
	public static JLabel lblNewLabel;
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ServerGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		setTitle("Server - Side");
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1,Color.WHITE));
		scrollPane.setBounds(60, 218, 300, 122);
		contentPane.add(scrollPane);
		
		serverConsole = new JTextArea();
		scrollPane.setViewportView(serverConsole);
		serverConsole.setEditable(false);
		
		lblDbName = new JLabel("DB Name:");
		lblDbName.setFont(new Font("Calibri",Font.PLAIN, 16));
		lblDbName.setBounds(60, 34, 120, 14);
		contentPane.add(lblDbName);
		
		textFieldDBName = new JTextField();
		textFieldDBName.setForeground(new Color(139, 0, 0));
		textFieldDBName.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		textFieldDBName.setBounds(171, 34, 186, 20);
		contentPane.add(textFieldDBName);
		textFieldDBName.setColumns(10);
		
		lblPort = new JLabel("Port:");
		lblPort.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPort.setBounds(60, 67, 64, 14);
		contentPane.add(lblPort);
		
		textFieldPort = new JTextField();
		textFieldPort.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		textFieldPort.setForeground(new Color(165, 42, 42));
		textFieldPort.setBounds(171, 67, 186, 20);
		contentPane.add(textFieldPort);
		textFieldPort.setColumns(10);
		
		btnConnect = new JButton("Connect to DB");
		btnConnect.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnConnect.setBounds(58, 184, 120, 23);
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dbname, portid , usrname , pass;
					try{
					
				            dbname = textFieldDBName.getText();
				            portid = textFieldPort.getText();
				            usrname = textFieldUser.getText();
				            pass = new String (textFieldPass.getPassword());
				            if(!(dbname.isEmpty() || portid.isEmpty() || usrname.isEmpty() || pass.isEmpty()))
				            {
				            	if(server.initDBConnection(dbname,usrname, pass))
				            	{
				            		server.setPort(Integer.valueOf(textFieldPort.getText()));
				            		display("SQL connection succeed");	
				            		try{
				            			server.listen(); //Start listening for connections
				            			display("Server is listening on port " + textFieldPort.getText());
				            			}catch(Exception ex){display("ERROR - Could not listen for clients!");}
				            	}
				        		else 
				        			display("SQL connection failed.");
				            }
				            else
				            	display("You must Fill all the fields");
					}catch(Exception ex1){e.toString();};
			}
		});
		contentPane.add(btnConnect);
		
		textFieldUser = new JTextField();
		textFieldUser.setForeground(new Color(165, 42, 42));
		textFieldUser.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		textFieldUser.setBounds(171, 98, 186, 20);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblUsername.setBounds(60, 98, 101, 14);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPassword.setBounds(60, 133, 101, 14);
		contentPane.add(lblPassword);
		
		textFieldPass = new JPasswordField();
		textFieldPass.setForeground(new Color(165, 42, 42));
		textFieldPass.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		textFieldPass.setBounds(171, 133, 186, 20);
		contentPane.add(textFieldPass);
		textFieldPass.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel.setForeground(new Color(165, 42, 42));
		lblNewLabel.setBounds(0, 0, 400, 260);
		contentPane.add(lblNewLabel);
	}
	
	public  void display(String s)
	{
		serverConsole.append(s + "\n");
	}
	
	
	public Server getserver()
	{return this.server;}
	public static void main(String[] args) {
	    
	     ServerGUI servergui = new ServerGUI();
	    Server server = new Server(servergui);
	    servergui.server = server;
	 
	}
}
