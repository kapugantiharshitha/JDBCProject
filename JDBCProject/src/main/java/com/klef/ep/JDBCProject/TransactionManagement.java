package com.klef.ep.JDBCProject;

import java.sql.*;
public class TransactionManagement {

	public static void main(String[] args)
	{
		try {
			Connection con= null;
			   
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   System.out.println("Driver Class Loaded");
			   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs3","root","Harshitha64@");
			   System.out.println("Connection Established");
			   con.setAutoCommit(false);
			   //con.createStatement().executeUpdate(" insert into faculty values(1000,'KLU','FEMALE')");
//			   con.createStatement().executeUpdate(" insert into faculty values(1001,'ABC','FEMALE')");
//			   con.createStatement().executeUpdate(" insert into faculty values(1002,'XYZ','MALE')");
//			   con.createStatement().executeUpdate(" insert into faculty values(1003,'PQR','MALE')");
			   
			   Savepoint s1=con.setSavepoint("s1");
			   
			   con.createStatement().executeUpdate("delete from faculty where id=1002");
			   Savepoint s2=con.setSavepoint("s2");
			   
			   con.rollback(s2);
			   con.commit();
			   con.close();
			  
		}
		catch(Exception e){
			
		}

	}

}
