package servlet;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 import java.util.Scanner;
 import java.io.IOException;
 import java.io.PrintWriter;
 import java.sql.*;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import javax.servlet.RequestDispatcher;
 import javax.servlet.ServletException;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 
 /**
  *
  * @author user
  */
 @WebServlet("/delete")
 public class  deleteBook extends HttpServlet {
     public static Scanner sc=new Scanner(System.in);
     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
         
         PrintWriter out=response.getWriter();
        String mybookid=request.getParameter("bookid");
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","");
         System.out.println("Enter bookid to delete:");
        String sql="DELETE FROM library where bookid=?";
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setInt(1, Integer.parseInt(mybookid));
         int count = preparedStatement.executeUpdate();
         System.out.println("Rows affected: " + count);
            if(count>0)
            {
                response.setContentType("text/html");
                out.print("<h3>success</h3>");
               RequestDispatcher rd=request.getRequestDispatcher("/deleteBook.jsp");
               rd.include(request,response);
            }
            else
            {
              response.setContentType("text/html");
                out.print("<h3>unsuccess</h3>");
               RequestDispatcher rd=request.getRequestDispatcher("/deleteBook.jsp");
               rd.include(request,response);  
            }
 
        }
        catch(Exception e){
            response.setContentType("text/html");
                out.print("<h3>unsuccess</h3>"+e.getMessage());
               RequestDispatcher rd=request.getRequestDispatcher("/deleteBook.jsp");
               rd.include(request,response);
            e.printStackTrace();
        }
     }
 }
     
     
  
 
   
 
 
 
 
 
 
