package com.techpalle.dao;

import java.sql.*;
import java.util.ArrayList;

import com.techpalle.model.Students;

public class DataAccess 
{
	private static final String driverPath="com.mysql.cj.jdbc.Driver";
	private static final String dbUrl="jdbc:mysql://localhost:3306/palle";
	private static final String dbUsername="root";
	private static final String dbPassword="aryan";
	
	private static Connection con=null;
	private static Statement s=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	private static final String insertQry="insert into students(name,email,qual,password,mobile) values(?,?,?,?,?)";
	
	private static final String updateQry="update students set name=?,qual=?,password=?,mobile=? where email=?";
	
	private static final String deleteQry="delete from students where email=?";
	
	private static final String selectQry="select * from students";
	
	
	public static void insertStudents(Students s)
	{
		try 
		{				
			Class.forName(driverPath);
											
			con= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			
			ps = con.prepareStatement(insertQry);
			
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getQual());
			ps.setString(4, s.getPass());
			ps.setLong(5, s.getMobile());
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException | SQLException e1) 
		{
			e1.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(ps!=null)
				{
					ps.close();
				}
				if(con!=null)
				{
					con.close();
				}
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
	}
	
	public static void updateStudents (Students s) 
	{
		try 
		{
			Class.forName(driverPath);
			
			con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			
			ps=con.prepareStatement(updateQry);
			ps.setString(1, s.getName());
			ps.setString(2, s.getQual());
			ps.setString(3, s.getPass());
			ps.setLong(4, s.getMobile());
			ps.setString(5, s.getEmail());
			
			int row= ps.executeUpdate();
			System.out.println(row);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(ps!=null)
				{
					ps.close();
				}
				if(con!=null)
				{
					con.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public static void deleteStudents (Students s)
	{
		try
		{
			Class.forName(driverPath);
			
			con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			
			ps=con.prepareStatement(deleteQry);
			ps.setString(1, s.getEmail());
			
			int row= ps.executeUpdate();
			System.out.println(row);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if (ps!=null) 
				{
					ps.close();
				}
				if (con!=null) 
				{
					con.close();
				} 
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public static ArrayList<Students> studentsData() 
	{
		ArrayList<Students> alStud=new ArrayList<Students>();
		
		try 
		{
			Class.forName(driverPath);
			
			con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			
			s= con.createStatement();
			
			rs= s.executeQuery(selectQry);
			
			while (rs.next()) 
			{
				int id=(rs.getInt("id"));
				String name=(rs.getString("name"));
				String email= (rs.getString("email"));
				String qual=(rs.getString("qual"));
				String pass=(rs.getString("password"));
				Long mob=Long.parseLong(rs.getString("mobile"));
				
				Students s=new Students(id, name, email, qual, pass,mob);
				alStud.add(s);
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rs!=null)
				{
					rs.close();
				}
				if(s!=null)
				{
					s.close();
				}
				if(con!=null)
				{
					con.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return alStud;
	}
}
