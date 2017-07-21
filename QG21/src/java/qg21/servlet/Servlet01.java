/*
This code use connectionstring and driver call in same code.
 */
package qg21.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet01", urlPatterns = {"/test/servlet/01"})
public class Servlet01 extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8"); //response for the browser

        PrintWriter out = response.getWriter(); //print response 

        try {

            //create connection string to SQL Server
            // Create a variable for the connection string.  
            String url = "jdbc:sqlserver://192.168.1.126:1433;"
                    + "databaseName=AdventureWorksDW2014;user=Rushamir;password=abc123";

            String drv = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(drv);
            
            //get connection
            Connection conn = DriverManager.getConnection(url);
            
            //do something with the connection here
            //for example, get name and version
            DatabaseMetaData dbmd = conn.getMetaData();
            dbmd.getDatabaseProductName();
            dbmd.getDatabaseProductVersion();
            
            out.println("Database info:\n" 
                    + "name:" + dbmd.getDatabaseProductName()
                    + "\nversion:" + dbmd.getDatabaseProductVersion()
            );
            
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace(out); //display error happened to browser
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
