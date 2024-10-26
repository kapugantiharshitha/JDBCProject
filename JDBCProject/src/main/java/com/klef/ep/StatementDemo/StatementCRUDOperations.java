package com.klef.ep.StatementDemo;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;

import java.sql.*;
import java.util.Scanner;

public class StatementCRUDOperations 
{
  public static void main(String args[])
  {
    StatementCRUDOperations crud = new StatementCRUDOperations();
    
    //crud.insertstudent();
    //crud.updatestudent();
    //crud.deletestudent();
    crud.viewallstudents();
  }
  public void insertstudent()
  {
    try
    {
      Connection con = null;
      
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Driver Classes Loaded");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs3","root","Harshitha64@");
      System.out.println("Connection Established");
      
      Statement stmt=null;
      stmt = con.createStatement();
      
      int sid= 103;
     String sname="channnds";
     String sgender="FEMALE";
     double scgpa=9.16;
     int sbacklogs=2;
     String semail="chanddds@gmail.com";
     String scontact="7410394668";
      
      String qry = " insert into student value("+sid+",'"+sname+"','"+sgender+"',"+scgpa+","+sbacklogs+",'"+semail+"','"+scontact+"') ";
      
      int n = stmt.executeUpdate(qry);
      
      System.out.println(n+"Record(s) Inserted Successfully");
      
      con.close();
      
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }//closing of insert student
  public void updatestudent()
  {
    try
    {
            Connection con = null;
      
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Driver Classes Loaded");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs3","root","Harshitha64@");
      System.out.println("Connection Established");
      
      Statement stmt=con.createStatement();
      
      int sid=102;
      String sname="KLEF";
      double scgpa=6.72;
      
      
      String qry=" update student set name='"+sname+"',cgpa="+scgpa+" where id="+sid+" ";
      
      int n=stmt.executeUpdate(qry);
      System.out.println(n+"Record(s) Updated Successfully");
      con.close();
      
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
  public void deletestudent()
  {
    try
    {
      Connection con = null;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Classes Loaded");
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs3","root","Harshitha64@");
        System.out.println("Connection Established");
        
        Statement stmt=con.createStatement();
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Student ID:");
        int sid= sc.nextInt();
        
        String sql=" delete from student where id="+sid+" ";
        
        stmt.executeUpdate(sql);
        
        int n = stmt.executeUpdate(sql);
        
        System.out.println(n+"Record(s) Deleted Successfully");
        
        con.close();
        
    }
    catch(Exception e)
    {
    System.out.println(e);  
    }
  }
  public void viewallstudents()
  {
 try
 {
   Connection con = null;
         
         Class.forName("com.mysql.cj.jdbc.Driver");
         System.out.println("Driver Classes Loaded");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs3","root","Harshitha64@");
         System.out.println("Connection Established");
         
         Statement stmt = con.createStatement();
         
         String qry = "select * from student";
         
         ResultSet rs = stmt.executeQuery(qry);
         
         while(rs.next())
         {
          System.out.println(rs.getInt(1));//student id
          System.out.println(rs.getString(2));//student name
          System.out.println(rs.getString("gender"));
          System.out.println(rs.getDouble(4));
          System.out.println(rs.getString(7));
         }
 }
 catch(Exception e)
 {
	 System.out.println(e);
 }
  }
}