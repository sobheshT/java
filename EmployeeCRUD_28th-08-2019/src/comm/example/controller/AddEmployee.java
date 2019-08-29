package comm.example.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.model.Employee;
import comm.example.factory.MyConnectionFactory;
import comm.example.model.Employee;


@WebServlet(name = "AddEmployeeController", urlPatterns = { "/AddEmployeeController" })
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String name,password,email,country;
    
       private List<String> errMsgs;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		doProcess(request,response);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		errMsgs=new LinkedList<String>();
		name=request.getParameter("name");
		
		
		password=request.getParameter("password");
		
		country=request.getParameter("country");
		
		email=request.getParameter("email");
//		if(email.toString().length()<5)
//		{
//			errMsgs.add("email is too short.");
//		}
		
		if(errMsgs.isEmpty())
		{
			request.setAttribute("SUCCESS", new Employee(name, password, email,country));
			Connection connection=MyConnectionFactory.getMySqlConnectionForHR();
			PreparedStatement pst=connection.prepareStatement("insert into emp2(name,password,email,country) values(?,?,?,?)");
			pst.setString(1, name);
			pst.setString(2, password);
			pst.setString(3, email);
			pst.setString(4,country);
		
			pst.executeUpdate();
			RequestDispatcher  view=request.getRequestDispatcher("success.view");
			view.forward(request, response);
		}
		else {
			request.setAttribute("ERROR", errMsgs);
			RequestDispatcher view=request.getRequestDispatcher("error.view");
			view.forward(request, response);
		}
	
		
	}

}
