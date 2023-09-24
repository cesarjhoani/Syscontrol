/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Usuarios;
import Persistencia.DaoLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cesar
 */
@WebServlet(name = "ControladorLogin", urlPatterns = {"/ControladorLogin"})
public class ControladorLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("accion");
        try {
            if (action != null) {
                switch (action) {
                    case "verificar":
                        verificar(request, response);
                        break;
                    case "cerrar":
                        cerrar(request, response);
                        break;
                    default:
                        response.sendRedirect("login.jsp");
                }
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void verificar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sesion;
        DaoLogin dao;
        Usuarios usuarios;
        usuarios = this.obtenerUsuario(request);
        dao = new DaoLogin();
        usuarios = dao.identificar(usuarios);
        if (usuarios != null && usuarios.getPerfil_idperfil().getTipo_Perfil().equals("administrador")) {
            sesion = request.getSession();
            sesion.setAttribute("administrador", usuarios);
            request.setAttribute("mensaje", "bienvenido al sistema");
            this.getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } else if (usuarios != null && usuarios.getPerfil_idperfil().getTipo_Perfil().equals("empleado")) {
           
            sesion = request.getSession();
            sesion.setAttribute("empleado", usuarios);

            request.setAttribute("mensaje", usuarios);
            this.getServletConfig().getServletContext().getRequestDispatcher("/index2.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "credenciales incorretas");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void cerrar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", null);
        sesion.invalidate();
        response.sendRedirect("login.jsp");
    }

    private Usuarios obtenerUsuario(HttpServletRequest request) {
        Usuarios usuarios = new Usuarios();
        usuarios.setUsuario(request.getParameter("txtUsername"));
        usuarios.setClave(request.getParameter("txtPasword"));
        return usuarios;
    }

}
