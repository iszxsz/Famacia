/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import com.mycompany.farmacia.common.NegocioException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.mycompany.farmacia.servico.ManterLogin;
import jakarta.servlet.RequestDispatcher;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isabela
 */
@WebServlet(urlPatterns = {"/servletLogin"})
public class loginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NegocioException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletLogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
        String user = request.getParameter("user");
        String senha = request.getParameter("senha");
        
        try {
            if (!ManterLogin.verificarLogin(request.getParameter("user"), request.getParameter("senha"))) {
                  RequestDispatcher rd = request.getRequestDispatcher("/menuVendedor.jsp");
                  rd.forward(request, response);

                    }//acessado pelo vendedor
               
            else{
                RequestDispatcher rd = request.getRequestDispatcher("/menuVendedor.jsp");
                 rd.forward(request, response); //acessado gerente
            }
        } catch (NegocioException ex) {
             out.println("Não é  possivel logar");
        }
        
        
        
        
        /*if (ManterLogin.verificarLogin(user,senha)==true){//acessado gerente
            response.sendRedirect("menuVendedor.jsp");
        }
        else if (ManterLogin.verificarLogin(user,senha)==false){//acessado vendedor
            response.sendRedirect("menuVendedor.jsp");
        }*/
        

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
        try {
            processRequest(request, response);
        } catch (NegocioException ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NegocioException ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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