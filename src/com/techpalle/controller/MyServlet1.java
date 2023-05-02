package com.techpalle.controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Students;

@WebServlet("/")
public class MyServlet1 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private static Students stud=null;
	private static String action=null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path = request.getServletPath();
		action=request.getParameter("action");
		
		switch(path)
		{
		case "/student":
			if("ShowAll".equals(action) )
			{
				RequestDispatcher rd= request.getRequestDispatcher("display.jsp");	
				ArrayList<Students> sData=DataAccess.studentsData();
				request.setAttribute("studentData", sData);
				
				rd.forward(request, response);
			}
			else 
			{
				doOperations(request,response);
			}
			
			break;
		default:
			response.sendRedirect("student.jsp");
			break;
		}
		
		
		
		//Call the insertStudent method and pass the above values as input
		//DataAccess.insertStudent(name, email, qual, pass);
//		DataAccess.insertStudent(stud);
		
		//Display some success message
//		response.getWriter().append("<h1>Data is inserted into table</h1>");
		
		// Redirect user to login.jsp page
		//response.sendRedirect("login.jsp");
		//Note: sendRedirect method will only redirect to other page but will not transfer the data
		
		// Redirect user to login.jsp and transfer the data from reg.html to login.jsp file
		// Method: getRequestDispatcher(String jspFileName.jsp)
//		RequestDispatcher rd= request.getRequestDispatcher("registration.html");
		//Code to transfer the data
//		rd.forward(request, response);
	}

	private void doOperations(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		getData(request,response);
		if("insert".equals(action))
		{
			DataAccess.insertStudents(stud);
		}
		else if ("update".equals(action)) 
		{
			DataAccess.updateStudents(stud);
		}
		else 
		{
			DataAccess.deleteStudents(stud);
		}
		response.sendRedirect("student.jsp");
	}

	private void getData(HttpServletRequest request, HttpServletResponse response) 
	{
		
		// Read the data given by users/student
		String name= request.getParameter("tbName");
		String email= request.getParameter("tbEmail");
		String qual= request.getParameter("tbQual");
		String pass= request.getParameter("tbPass");
		long mobile= Long.parseLong(request.getParameter("tbMobile"));
		
		// Add above data to student object:
		stud = new Students(name, email, qual, pass, mobile);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
