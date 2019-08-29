package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.factory.MyConnectionFactory;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String param;
	private String country, name, email, password;
	private int id;
	private List<String> errMsgs;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		id = Integer.parseInt(request.getParameter("id").toString());
		name = request.getParameter("name");
		email = request.getParameter("email");
		password = request.getParameter("password");
		country = request.getParameter("country");
		//out.println(id);
		try {
		Connection connection = MyConnectionFactory.getMySqlConnectionForHR();
		
		PreparedStatement pst = connection.prepareStatement("update emp2 set name =?"
				+ ",email=? "+",password =? "+",country=?"+"where id=?");
		out.println(country);
		
		pst.setString(1, name);
		pst.setString(2, email);
		pst.setString(3, password);
		pst.setString(4, country);
		pst.setInt(5, id);
		
		pst.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher view = request.getRequestDispatcher("AllDataView");
		view.forward(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		param = request.getParameter("id").toString();
		id = Integer.parseInt(param);
		Connection connection = MyConnectionFactory.getMySqlConnectionForHR();
		PreparedStatement pst = connection.prepareStatement("select * from emp2 where id =" + id);
		ResultSet rs = pst.executeQuery();

		if (rs.next()) {
			out.println("<form action ='Edit' method='post'>" + "<table>"
					+ "<tr><th>Fields</th><th>Input</th></tr>" + "<tbody>"
					+ "<tr><td>Name :</td><td><input type='text' name='name' value=" + rs.getString(2)
					+ " /></td></tr>" + "<tr><td>Password :</td><td><input type='text' name='password' value="
					+ rs.getString(3) + " /></td></tr>"
					+ "<tr><td>Email :</td><td><input type='email' name='email' value=" + rs.getString(4)
					+ " /></td></tr>" + "<tr><td>Country :</td><td><select name='country'>"
					+ "			<option selected>India</option>" + "			<option>Pakistan</option>"
					+ "			<option>other</option>" + "		</select></td></tr>" + "<tbody>" + "</table>"
					+ "<input type='text' name='id' hidden value ='" + id+"'/>"
					+ "<tr><td></td><td><input type='submit' value='Save' /></td></tr>" + "</form>");
		} else {
			out.println("No record Fetched");
		}
		out.println("</table>");

	}}