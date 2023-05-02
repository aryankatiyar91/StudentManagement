package com.techpalle.model;

public class Students 
{
	private int id;
	private String name,email,qual,pass;
	private long mobile;
	
	
	public Students(String name, String email, String qual, String pass, long mobile) 
	{
		super();
		this.name = name;
		this.email = email;
		this.qual = qual;
		this.pass = pass;
		this.mobile = mobile;
	}
	
	public Students(int id, String name, String email, String qual, String pass, long mobile) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.qual = qual;
		this.pass = pass;
		this.mobile = mobile;
	}



	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getQual() 
	{
		return qual;
	}
	public void setQual(String qual) 
	{
		this.qual = qual;
	}
	public String getPass() 
	{
		return pass;
	}
	public void setPass(String pass) 
	{
		this.pass = pass;
	}
	public long getMobile() 
	{
		return mobile;
	}
	public void setMobile(long mobile) 
	{
		this.mobile = mobile;
	}
}
