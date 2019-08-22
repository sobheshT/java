package comm.tool;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import comm.example.model.Employee;
import comm.example.service.EmployeeService;
import comm.example.service.EmployeeServiceImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EmployeeForm {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeForm window = new EmployeeForm();
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
	public EmployeeForm() {
		//EmployeeService emp=new EmployeeServiceImpl();
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
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBounds(10, 30, 80, 14);
		frame.getContentPane().add(lblEmployeeId);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 62, 63, 14);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 87, 63, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 120, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(121, 27, 159, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(121, 59, 159, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(121, 84, 159, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(121, 117, 159, 20);
		frame.getContentPane().add(textField_3);
		
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EmployeeService employee=new EmployeeServiceImpl();
					employee.createemployee(new Employee(Integer.parseInt(textField.getText().toString()),textField_1.getText().toString(),textField_2.getText().toString(),textField_3.getText().toString()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(306, 26, 101, 23);
		frame.getContentPane().add(button);
		
		JLabel lblSearchById = new JLabel("Search By ID");
		lblSearchById.setBounds(10, 177, 89, 14);
		frame.getContentPane().add(lblSearchById);
		
		textField_4 = new JTextField();
		textField_4.setBounds(121, 174, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(306, 174, 101, 20);
		frame.getContentPane().add(btnSearch);
		
		JButton btnLoadAllData = new JButton("Load All Data");
		btnLoadAllData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new MyFrame2();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLoadAllData.setBounds(121, 211, 119, 23);
		frame.getContentPane().add(btnLoadAllData);
	}

}
