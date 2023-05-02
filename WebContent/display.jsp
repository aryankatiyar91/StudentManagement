<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="com.techpalle.model.Students"%>
<%@page import ="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Page</title>
</head>
<body>
	<h1>Displaying Students Details Below</h1>
	<br>

	<table cellspacing="5" cellpadding="5" style="text-align:left;">
	  <tr>
	    <th>id:</th>
	    <th>Name:</th>
	    <th>Email:</th>
	    <th>Qualification:</th>
	    <th>password:</th>
	    <th>Mobile:</th>
	  </tr>
	  
	  <%
	  	ArrayList<Students> stud =(ArrayList<Students>) request.getAttribute("studentData");
	  	for(Students s: stud)
		{
	  		out.println("<tr>");
	  		
	  		out.println("<td>"+s.getId()+"</td>");
	  		out.println("<td>"+s.getName()+"</td>");
	  		out.println("<td>"+s.getEmail()+"</td>");
	  		out.println("<td>"+s.getQual()+"</td>");
	  		out.println("<td>"+s.getPass()+"</td>");
	  		out.println("<td>"+s.getMobile()+"</td>");
	  		
	  		out.println("</tr>");
		}
	  %>
	  
	  <%
	  	ArrayList<Students> stu =(ArrayList) request.getAttribute("studentData");
	  	for(Students s: stu)
		{
	  	%>
  			<tr>
			    <td><%=s.getId() %></td>
			    <td><%=s.getName() %></td>
			    <td><%=s.getEmail() %></td>
			    <td><%=s.getQual() %></td>
			    <td><%=s.getPass() %></td>
			    <td><%=s.getMobile() %></td>
		  	</tr>
  		<%
	  	}
	  %>
	  
  </table>
</body>
</html>