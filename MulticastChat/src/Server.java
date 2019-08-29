import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class Server {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server window = new Server();
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
	public Server() {
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
		textArea.setBounds(40, 29, 344, 188);
		frame.getContentPane().add(textArea);
		
		JButton btnStartServer = new JButton("Start Server");
		btnStartServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Default port number we are going to use
		        int portnumber = 1235;
		      
		        
		        // Create a MulticastSocket
		        MulticastSocket serverMulticastSocket = null;
				try {
					serverMulticastSocket = new MulticastSocket(portnumber);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		        textArea.setText("MulticastSocket is created...");
		        
		        // Determine the IP address of a host, given the host name
		        InetAddress group = null;
				try {
					group = InetAddress.getByName("225.0.0.2");
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
		        // getByName- returns IP address of given host
		        try {
					serverMulticastSocket.joinGroup(group);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		     textArea.setText("joinGroup method is called...");
		        boolean infinite = true;
		        
		        // Continually receives data and prints them 
		        while(infinite) {
		            byte buf[] = new byte[1024];
		            DatagramPacket data =
		                    new DatagramPacket(buf, buf.length);
		            try {
						serverMulticastSocket.receive(data);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            String msg =
		                    new String(data.getData()).trim();
		            textArea.setText("Message received from client = " + msg);
		         System.out.println("Message received from client = " + msg);
		        }
		        serverMulticastSocket.close();
		    }
			
		});
		btnStartServer.setBounds(158, 228, 118, 23);
		frame.getContentPane().add(btnStartServer);
	}

}
