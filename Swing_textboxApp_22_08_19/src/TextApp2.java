import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TextApp2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextApp2 window = new TextApp2();
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
	public TextApp2() {
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
		textArea.setBounds(33, 45, 315, 171);
		frame.getContentPane().add(textArea);
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File outfile=new File("outfile.txt");
				FileOutputStream out=null;
				String text=textArea.getText();
				textArea.setText("");
				int c=0;
				try {
					
					out=new FileOutputStream(outfile);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int i=0;i<text.length();i++) {
					c=text.charAt(i);
					try {
						out.write(c);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
			
		});
		btnSave.setBounds(33, 227, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileReader in=null;
				try {
					in = new FileReader("outfile.txt");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int c;
				String text="";
				try {
					while((c=in.read())!=-1) {
						text=text+(char)c;
						textArea.setText(text);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace() ;
				}
				try {
					in.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnView.setBounds(206, 227, 89, 23);
		frame.getContentPane().add(btnView);
		
		
		
		JLabel lblEnterYourText = new JLabel("Enter Your Text");
		lblEnterYourText.setBounds(140, 11, 136, 14);
		frame.getContentPane().add(lblEnterYourText);
	}

}
