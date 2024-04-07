

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.util.HashMap;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * izzati najwa s65417
 * Lab 2 Task 1
 */
public class LoginServlet extends HttpServlet {

    HashMap <String, String> users = new HashMap();
    
    @Override
    public void init() throws ServletException {
        super.init();
        users.put("Ali", "1234");
        users.put("Ahmad", "4567");
        users.put("Muthu", "8910");
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        
        if (!username.equals("")&& !password.equals("")
                && users.get(username).equals(password)) {
            request.setAttribute("userid", username);
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("/AccountServlet");
            rd.forward(request, response);
        } else {
            //avoid direct access to the servlet
            RequestDispatcher rd = request.getRequestDispatcher("/login.html");
            rd.forward(request,response);
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
