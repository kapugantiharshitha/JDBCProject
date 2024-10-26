package com.klef.ep.CallableStatementDemo;

import java.util.*;
import java.sql.*;

public class CallableStatementCRUDOperations 
{
 public static void main(String args[]) 
 {
  CallableStatementCRUDOperations crud = new CallableStatementCRUDOperations();
  
  //crud.addfaculty();
  //crud.updatefaculty();
  //crud.deletefaculty();
  //crud.viewallfaculty();
  crud.getfacultynamebyid();
 }
 
 
 public void addfaculty()
 {
  try 
  {
            Connection con= null;
   
   Class.forName("com.mysql.cj.jdbc.Driver");
   System.out.println("Driver Class Loaded");
   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs3","root","Harshitha64@");
   System.out.println("Connection Established");
   
   
   
   
   int  fid=3;
   String fname="Harshi";
   String fgender="FEMALE";
   
   
   CallableStatement cstmt=  con.prepareCall(" {call Insertfaculty(?,?,?)} ");
   
   cstmt.setInt(1, fid);
   cstmt.setString(2, fname);
   cstmt.setString(3, fgender);
   
            int n=cstmt.executeUpdate();
   
      System.out.println(n +"Record(s) Inserted Successfully");
      
   con.close();
   
   
  } catch (Exception e) 
  {
   System.out.println(e);
   
  }
 }
 
 public void updatefaculty()
 {
  try {
            Connection con= null;
   
   Class.forName("com.mysql.cj.jdbc.Driver");
   System.out.println("Driver Class Loaded");
   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs3","root","Harshitha64@");
   System.out.println("Connection Established");
   
   int fid=3;
   String fname="KRISHNA";
   
   
   CallableStatement cstmt=con.prepareCall("{call updatefaculty(?,?)}");
   
   cstmt.setInt(1,fid);
   cstmt.setString(2, fname);
   

            int n=cstmt.executeUpdate();
   
      System.out.println(n +"Record(s) Updated Successfully");
      
   con.close();
   
   
   
   
  } 
  catch (Exception e) 
  {
   System.out.println(e);
  }
 }
 
 public void deletefaculty()
 {
	 try {
		 Connection con= null;
		   
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   System.out.println("Driver Class Loaded");
		   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs3","root","Harshitha64@");
		   System.out.println("Connection Established");
		   
		   int fid=30;
		   CallableStatement cstmt=con.prepareCall("{call deletefaculty(?)}");
		   cstmt.setInt(1,fid);
		   int n = cstmt.executeUpdate();
		   if(n>0) {
			   System.out.println(n+"Record(s) Deleted Successfully");
		   }
		   else
		   {
			   System.out.println("Faculty ID Not Found");
		   }
		   con.close();
		 
	 }
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
 }

 public void viewallfaculty()
 {
	 try {
		 Connection con= null;
		   
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   System.out.println("Driver Class Loaded");
		   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs3","root","Harshitha64@");
		   System.out.println("Connection Established");
		   
		   
		   CallableStatement cstmt = con.prepareCall("{call viewallfaculty()}");
		   ResultSet rs= cstmt.executeQuery();
		   
		   System.out.println("****Faculty Information****");
		   while(rs.next()) {
			   System.out.println("Faculty Record"+rs.getRow());
			   System.out.println("Faculty ID="+rs.getInt("id"));
			   System.out.println("Faculty Name="+rs.getString("name"));
			   System.out.println("Faculty Gender="+rs.getString("gender"));
			   
		   }
		   con.close();
	 }
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
	 
 }
 
 public void getfacultynamebyid() {
	 try {
		 Connection con= null;
		   
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   System.out.println("Driver Class Loaded");
		   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs3","root","Harshitha64@");
		   System.out.println("Connection Established");
		   
		   CallableStatement cstmt = con.prepareCall("{call getfacultynamebyid(?,?)}");
		   
		   int fid=101;
		   cstmt.setInt(1, fid);
		   cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
		   cstmt.execute();
		   System.out.println("Faculty Name:"+cstmt.getString("fname"));
		   System.out.println("Faculty Name:"+cstmt.getString(2));
		   
		   
		   
		   
		   
		   con.close();
		   
	 }
	 catch(Exception e )
	 {
		 System.out.println(e); 
	 }
 }
 
}