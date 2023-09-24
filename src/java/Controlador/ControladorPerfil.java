/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Perfil;
import Persistencia.DaoPerfil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
public class ControladorPerfil extends HttpServlet {
    String registrar = "Vistas/RegistrarPerfil.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");
        String acceso = "";
        
        if(action.equalsIgnoreCase("add")){
            //response.sendRedirect("Vistas/RegistrarPerfil.jsp");
            //request.getRequestDispatcher("Vistas/RegistrarPerfil.jsp").forward(request, response);
            acceso = registrar;
        }else if(action.equalsIgnoreCase("registrar")){
            String nombre = request.getParameter("perfil");
            Perfil perfil = new Perfil();
            perfil.setTipo_Perfil(nombre);
            if(DaoPerfil.registrar(perfil)){
                request.setAttribute("mensaje", "el perfil fue registrado");
                 acceso = registrar;
                 //request.getRequestDispatcher("Vistas/RegistrarPerfil.jsp").forward(request, response);
            }else{
                 request.setAttribute("mensaje", "el perfil no fue registrado");
                  acceso = registrar;
                  //request.getRequestDispatcher("Vistas/RegistrarPerfil.jsp").forward(request, response);
            }
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response); // vista redireciona
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
