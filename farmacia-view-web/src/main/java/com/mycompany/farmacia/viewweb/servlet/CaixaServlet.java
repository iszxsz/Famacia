package com.mycompany.farmacia.viewweb.servlet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import com.mycompany.farmacia.common.NegocioException;
import com.mycompany.farmacia.dto.Produto;
import com.mycompany.farmacia.servico.ManterCaixa;
import com.mycompany.farmacia.servico.ManterProduto;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
//import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "CaixaServlet", urlPatterns = "/CaixaServlet")
public class CaixaServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException, NegocioException {
        response.setContentType("text/html;charset=UTF-8");
        
            
        List<String> listaPreco = new ArrayList<>();
        String codigo = request.getParameter("codigo");
        if(request.getParameter("limparLista") != null){
            for(String s : listaPreco)
                listaPreco.remove(s);
            RequestDispatcher forward = request.getRequestDispatcher("telaCaixa.jsp");
            forward.forward(request, response);
        }
        /*
        String rotulo = request.getParameter("rotulo");
        String codigo = request.getParameter("codigo");
        double preco = Double.parseDouble(request.getParameter("preco"));
        String radio[] = request.getParameterValues("bula");
        String bula = radio[0];
        boolean precisaBula;
        
        if(bula.equals("sim"))
            precisaBula = true;
        else
            precisaBula = false;
        */
        
        
        listaPreco.add(ManterCaixa.adicionarAoCaixa(codigo));
        
        request.setAttribute("listaPreco", listaPreco);
        
        
        RequestDispatcher forward = request.getRequestDispatcher("telaCaixa.jsp");
        forward.forward(request, response);
        
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NegocioException ex) {
            Logger.getLogger(CaixaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NegocioException ex) {
            Logger.getLogger(CaixaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
