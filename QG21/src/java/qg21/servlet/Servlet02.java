
/* This code separate the connectionstring and driver call using java class TestJdbc02.*/
package qg21.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import qg21.TestJdbc02;

@WebServlet(name = "Servlet02", urlPatterns = {"/test/servlet/02"})
public class Servlet02 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
    try {
      TestJdbc02 jdbc = new TestJdbc02(
          "com.microsoft.sqlserver.jdbc.SQLServerDriver");
      String url
          = "jdbc:sqlserver://192.168.1.126:1433;"
          + "databaseName=AdventureWorksDW2014;"
          + "user=Rushamir;password=abc123";
      jdbc.connect(url);

      out.println(jdbc.getSimpleMetaData());

      jdbc.close();
    } catch (ClassNotFoundException | SQLException ex) {
      ex.printStackTrace(out);
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
