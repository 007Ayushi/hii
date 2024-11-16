package servlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/showlibrary"})
public class showlibrary extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set content type
        response.setContentType("text/html");
        
        // Fetch parameters from the request
        int bookid = Integer.parseInt(request.getParameter("bookid"));
        System.out.print(bookid);

        try {
            // Setup the connection to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/books";
            String user = "root";
            String pwd = "";
            Connection con = DriverManager.getConnection(url, user, pwd);
            // Query to select the specific book by ID
            String query = "SELECT * FROM library WHERE bookid = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, bookid);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                // Set attributes to forward to JSP
                request.setAttribute("bookid", rs.getInt("bookid"));
                request.setAttribute("bookname", rs.getString("bookname"));
                request.setAttribute("authorname", rs.getString("authorname"));
                request.setAttribute("category", rs.getString("category"));
                
                // Forward the request to the JSP page
                RequestDispatcher rd = request.getRequestDispatcher("/showLibrary.jsp");
                rd.forward(request, response);
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database connection issue.");
            RequestDispatcher rd = request.getRequestDispatcher("/showLibrary.jsp");
            rd.forward(request, response);
        } 
    }
}

