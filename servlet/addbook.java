package servlet;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
 @WebServlet("/add")
 public class  addBook extends HttpServlet {
     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
         
         PrintWriter out=response.getWriter();
        String mybookid=request.getParameter("bookid");
        String mybookname=request.getParameter("bookname");
        String myauthorname=request.getParameter("authorname");
        String mycategory=request.getParameter("category");
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","");
            PreparedStatement ps=conn.prepareStatement("insert into library values(?,?,?,?)");
            ps.setString(1,mybookid);
            ps.setString(2, mybookname);
            ps.setString(3,myauthorname);
            ps.setString(4,mycategory);
            int count=ps.executeUpdate();
            if(count>0)
            {
                response.setContentType("text/html");
                out.print("<h3>success</h3>");
               RequestDispatcher rd=request.getRequestDispatcher("/addBook.jsp");
               rd.include(request,response);
            }
            else
            {
              response.setContentType("text/html");
                out.print("<h3>unsuccess</h3>");
               RequestDispatcher rd=request.getRequestDispatcher("/addBook.jsp");
               rd.include(request,response);  
            }
 
        }
        catch(Exception e){
            response.setContentType("text/html");
                out.print("<h3>unsuccess</h3>"+e.getMessage());
               RequestDispatcher rd=request.getRequestDispatcher("/addBook.jsp");
               rd.include(request,response);
            e.printStackTrace();
        }
     }
 }
     
     
  
 
   
 
 
 
 
 
