import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class MulticastApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MulticastApp window = new MulticastApp();
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
	public MulticastApp() {
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
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(82, 53, 279, 118);
		frame.getContentPane().add(textArea);
		
		JButton btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 // Default port number we are going to use
		        int portnumber = 1235;
		       
		        
		        // Create a MulticastSocket
		        MulticastSocket chatMulticastSocket = null;
				try {
					chatMulticastSocket = new MulticastSocket(portnumber);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
		        
		        // Determine the IP address of a host, given the host name
		        InetAddress group = null;
				try {
					group = InetAddress.getByName("225.0.0.1");
				} catch (UnknownHostException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		        
		        // Joins a multicast group
		        try {
					chatMulticastSocket.joinGroup(group);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
		        // Prompt a user to enter a message
		        String msg = "";
		        System.out.println("Type a message for the server:");
		        BufferedReader br =
		                new BufferedReader(new InputStreamReader(System.in));
		        try {
					msg = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        // Send the message to Multicast address
		        DatagramPacket data = new
		                DatagramPacket(msg.getBytes(), 0,
		                msg.length(), group, portnumber);
		        try {
					chatMulticastSocket.send(data);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        // Close the socket
		        chatMulticastSocket.close();
			}
		});
		btnSend.setBounds(174, 202, 89, 23);
		frame.getContentPane().add(btnSend);
	}
}
