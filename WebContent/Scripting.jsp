<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scripting Elements</title>
</head>
<body>

<h1>Below Output is All about Scripting</h1>
<%!
//It is declaration tag where you can declare any variable it will consider global variable we can use these variable outside the declaration tag also.

//Declaring global variable
int i=20;
int j=30;

public int f1()
{
	return 10;
}
public String f2()
{
	return "palle";
}

public int f3(int a)
{
	return i+a+1;
}
%>


<%
out.println("Global var. value="+i);
//Declaring local variables
/*int i=10;
int j=20;
//Do some operation
int k=i+j;
//Display the data in browser and console window:
out.println("<br>"+k);
System.out.println(k);*/

int i=f1();
String s=f2();
out.print(i);
out.print(s);

int a=20;
int b=f3(a);
out.print(b);
%>
</body>
</html>