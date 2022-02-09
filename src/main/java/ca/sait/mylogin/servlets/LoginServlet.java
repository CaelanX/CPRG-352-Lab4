
package ca.sait.mylogin.servlets;

import ca.sait.mylogin.models.User;
import ca.sait.mylogin.services.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author caelan
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    

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
        HttpSession session = request.getSession();
        
        if(session.getAttribute("username") != null){
            String query = request.getQueryString();
            
            if(query != null && query.contains("logout")){
            session.invalidate();
            
            request.setAttribute("message","Logged out.");
            }
        
        response.sendRedirect("home");
            return;
        }
        
        
            
            
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username == null || username.isEmpty()|| password == null || password.isEmpty()){
            request.setAttribute("message", "Please fill in both fields.");
        }else{
            AccountService account = new AccountService();
            
            User user = account.login(username, password);
            
            if (user != null){
                request.getSession().setAttribute("username", username);
                
                response.sendRedirect("home");
                return;
                
            }else{
                request.setAttribute("username", username);
                request.setAttribute("message", "The username or password you entered is incorrect.");
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        
        
        
    }

   
}
