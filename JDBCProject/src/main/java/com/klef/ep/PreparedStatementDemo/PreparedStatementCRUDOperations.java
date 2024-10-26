package com.klef.ep.PreparedStatementDemo;

import java.util.*;
import java.sql.*;

public class PreparedStatementCRUDOperations {
 public static void main(String args[])
 {
  PreparedStatementCRUDOperations crud = new PreparedStatementCRUDOperations();
  //crud.addemployee();
  //crud.updatemployee();
  //crud.deleteemp();
  //crud.viewallemps();
  crud.viewempbyid();
 }
 public void addemployee()
 {
  try
  {
   Connection con = null;
         
         Class.forName("com.mysql.cj.jdbc.Driver");
         System.out.println("Driver Classes Loaded");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs3","root","Harshitha64@");
         System.out.println("Connection Established");
         
         int eid = 102;
         String ename="harshi";
         String egender="FEMALE";
         String edob="12/10/2001";
         double esalary = 23000.00;
         String empemail="harshi@gmail.com";
         String epwd="rama";
         String econtact = "7950396468";
         
         
         PreparedStatement pstmt = con.prepareStatement(" insert into employee values(?,?,?,?,?,?,?,?)");
         pstmt.setInt(1, eid);
         pstmt.setString(2, ename);
         pstmt.setString(3, egender);
         pstmt.setString(4, edob);
         pstmt.setDouble(5, esalary);
         pstmt.setString(6, empemail);
         pstmt.setString(7, epwd);
         pstmt.setString(8, econtact);
         
         int n = pstmt.executeUpdate();
         
         System.out.println(n+"Record(s) Inserted Successfully");
         
         con.close();
         
         
         
         
  }
  catch(Exception e)
  {
   System.out.println(e);
  }
 }
 public void updatemployee()
 {
  try
  {
   Connection con = null;
         
         Class.forName("com.mysql.cj.jdbc.Driver");
         System.out.println("Driver Classes Loaded");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs3","root","Harshitha64@");
         System.out.println("Connection Established"); 
         
         int eid=102;
         String ename="SURYA KIRAN";
         double esal=6000.50;
         
         PreparedStatement pstmt = con.prepareStatement(" update employee set name=?,salary=? where id=? ");
         pstmt.setString(1, ename);
         pstmt.setDouble(2,esal);
         pstmt.setInt(3, eid);
         
         int n=pstmt.executeUpdate();
         
         System.out.println(n+"Record(s) Updated Successfully");
         
         con.close();
         
  }
  catch(Exception e)
  {
   System.out.println(e);
  }
 }
 
public void deleteemp()
{
 try {
  Connection con = null;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Classes Loaded");
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs3","root","Harshitha64@");
        System.out.println("Connection Established"); 
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID:");
        int eid=sc.nextInt();
        
        PreparedStatement pstmt=con.prepareStatement(" delete from employee where id=? ");
        pstmt.setInt(1, eid);
        
        int n=pstmt.executeUpdate();
        
        if(n>0)
        {
         System.out.println("Employee Record Deleted Successfully");
        }
        else
        {
         System.out.println("Employee ID not found");
        }
        sc.close();
        con.close();
        
 }
 catch(Exception e)
 {
  System.out.println(e);
 }
}
public void viewallemps()
{
 try
 {
Connection con = null;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Classes Loaded");
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs3","root","Harshitha64@");
        System.out.println("Connection Established"); 
        
        PreparedStatement pstmt = con.prepareStatement(" select * from employee");
        ResultSet rs = pstmt.executeQuery();
        System.out.println("**Employee Record**");
        while(rs.next())
        {
         System.out.println("Employee Record"+rs.getRow());
         System.out.println(rs.getInt(1));//employee id
         System.out.println(rs.getString(2));//employee name
         System.out.println(rs.getDouble(5));//employee salary
         System.out.println(rs.getString(4));//employee dob
         System.out.println(rs.getString("email"));
        }
        con.close();
 }
 catch(Exception e)
 {
  System.out.println(e);
 }
}
public void viewempbyid()
{
 try
 {
Connection con = null;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Classes Loaded");
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs3","root","Harshitha64@");
        System.out.println("Connection Established"); 
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID:");
        int eid=sc.nextInt();
        
        PreparedStatement pstmt = con.prepareStatement("select id,name,gender from employee where id=?");
        pstmt.setInt(1, eid);
        
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next())
        {
         System.out.println(rs.getInt("id"));//employee id
         System.out.println(rs.getString("name"));//employee name
         System.out.println(rs.getString("gender"));//employee salary
        }
        else
        {
         System.out.println("Employee ID Not Found");
        }
        
        con.close();
 }
 catch(Exception e)
 {
  System.out.println(e);
 }
}
}