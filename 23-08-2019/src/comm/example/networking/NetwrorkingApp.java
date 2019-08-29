package comm.example.networking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class NetwrorkingApp {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NetwrorkingApp window = new NetwrorkingApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NetwrorkingApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Generate Factorial");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Socket client = null;
		        
		        // Default port number we are going to use
		        int portnumber = 4321;
		        
		        
		        
		            try {
		                String msg = "";
		                
		                // Create a client socket
		                
		                client = new Socket(InetAddress.getLocalHost(), portnumber);
		                System.out.println("Client socket is created " + client);
		                
		                // Create an output stream of the client socket
		                OutputStream clientOut = client.getOutputStream();
		                PrintWriter pw = new PrintWriter(clientOut, true);
		                
		                // Create an input stream of the client socket
		                InputStream clientIn = client.getInputStream();
		                BufferedReader br = new BufferedReader(new
		                        InputStreamReader(clientIn));
		                
		                // Create BufferedReader for a standard input
		                BufferedReader stdIn = new BufferedReader(new
		                        InputStreamReader(System.in));
		                
		               // System.out.println("Enter your name. Type Bye to exit. ");
		                
		                // Read data from standard input device and write it
		                // to the output stream of the client socket.
		                
		                pw.println(textField.getText());
		                
		                // Read data from the input stream of the client socket.
		                //System.out.println("Message returned from the server = " + br.readLine());
		                textField_1.setText(br.readLine());
		                pw.close();
		                br.close();
		                client.close();
		                
		                // Stop the operation
		             
		                
		            } catch (IOException ie) {
		                System.out.println("I/O error - Start server and turn off Firewall" + ie);
		            }
		        }

			
		});
		btnNewButton.setBounds(33, 147, 159, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(138, 37, 159, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterANumber = new JLabel("Enter A number");
		lblEnterANumber.setBounds(33, 40, 95, 14);
		frame.getContentPane().add(lblEnterANumber);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 96, 159, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFactorial = new JLabel("Factorial");
		lblFactorial.setBounds(33, 99, 65, 14);
		frame.getContentPane().add(lblFactorial);
	}
}
