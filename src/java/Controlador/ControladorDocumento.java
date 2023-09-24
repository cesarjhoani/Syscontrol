/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Documento;
import Persistencia.DaoDocumento;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
@WebServlet(name = "ControladorDocumento", urlPatterns = {"/ControladorDocumento"})
public class ControladorDocumento extends HttpServlet {

    String add = "Vistas/RegistrarDocumento.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");
        String acceso = "";
        
        if(action.equalsIgnoreCase("add")){
            acceso = add;
        }else if(action.equalsIgnoreCase("registrar")){
                String tipoDocumento = request.getParameter("documento");
                Documento documento = new Documento();
                documento.setTipo_documento(tipoDocumento);
                if(DaoDocumento.registrar(documento)){
                    request.setAttribute("mensaje", "tipo documento registrado");
                    request.getRequestDispatcher("Vistas/RegistrarDocumento.jsp").forward(request, response);
                }else{
                    request.setAttribute("mensaje", "tipo documento no se registro");
                     request.getRequestDispatcher("Vistas/RegistrarDocumento.jsp").forward(request, response);
                }
            }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doGet(request,response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
