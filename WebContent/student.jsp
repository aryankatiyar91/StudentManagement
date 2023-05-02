<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Page</title>
</head>
<body>

<!--h1>Login Form</h1>

<form action="login" method="post">
	Email:	<input type="email" name="tbEmail" />
	<br>
	Password:	<input type="password" name="tbPass" />
	<br>
	
	<button>Login</button>
</form-->


	<h1>Welcome to Student page...</h1>
	<form action="student" method="post">
		Name:	<input type="text" name="tbName"/>
		<br>
		Email:	<input type="email" name="tbEmail"/>
		<br>
		Qualification:	<input type="text" name="tbQual"/>
		<br>
		Password:	<input type="password" name="tbPass"/>
		<br>
	
		Mobile:	<input type="tel" name="tbMobile" value=" "/>
		<br>
		<br>
	
		<input type="submit" name="action" value="insert" />
		<input type="submit" name="action" value="update" />
		<input type="submit" name="action" value="delete"/>
		<input type="submit" name="action" value="ShowAll" />
	</form>
</body>
</html>