/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Perfil;
import Modelo.Usuarios;
import Persistencia.DaoUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
public class ControladorUsuarios extends HttpServlet {

    //String registrar = "Vistas/RegistrarUsuarios.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");
        //String acceso = "";
        if (action.equalsIgnoreCase("add")) {
            request.getRequestDispatcher("Vistas/RegistrarUsuarios.jsp").forward(request, response);
            //response.sendRedirect("Vistas/RegistrarUsuarios.jsp");
        } else if (action.equalsIgnoreCase("registrar")) {
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String RazonSocial = request.getParameter("RazonSocial");
            String numeroDocumento = request.getParameter("numeroDocumento");
            String direccion = request.getParameter("direccion");
            String numeroTelefono = request.getParameter("numeroTelefono");
            String correo = request.getParameter("correo");
            String usuario = request.getParameter("usuario");
            String clave = request.getParameter("clave");
            int PerfilIdperfil = Integer.parseInt(request.getParameter("Perfilidperfil"));
            int DocumentoIdDocumento = Integer.parseInt(request.getParameter("DocumentoidDocumento"));

            Usuarios usuarios = new Usuarios();
            Perfil perfil = new Perfil();
            
            perfil.setIdperfil(PerfilIdperfil);
            usuarios.setNombres(nombres);
            usuarios.setApellidos(apellidos);
            usuarios.setRazon_Social(RazonSocial);
            usuarios.setNumero_Documento(numeroDocumento);
            usuarios.setDireccion(direccion);
            usuarios.setNumero_Telefono(numeroTelefono);
            usuarios.setCorreo(correo);
            usuarios.setUsuario(usuario);
            usuarios.setClave(clave);
            usuarios.setPerfil_idperfil(perfil);
            usuarios.setDocumento_idDocumento(DocumentoIdDocumento);
            
            if (DaoUsuarios.registrar(usuarios)) {
                request.setAttribute("mensaje", "el usuario fue registrado");
                
            } else {
                request.setAttribute("mensaje", "el usuario no fue registrado");
                
            }
            
            List<Usuarios> listaActualizada = DaoUsuarios.listar();
            request.setAttribute("resultadoListar", listaActualizada);
            request.getRequestDispatcher("Vistas/ListarUsuarios.jsp").forward(request, response);
            
        } else if (action.equalsIgnoreCase("listar")) {
            List<Usuarios> lista = DaoUsuarios.listar();
            request.setAttribute("resultadoListar", lista);

            request.getRequestDispatcher("Vistas/ListarUsuarios.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean eliminar = DaoUsuarios.eliminar(id);
            if (eliminar) {
                request.setAttribute("mensaje", "usuario eliminado");
            } else {
                request.setAttribute("mensaje", "usuario no eliminado");
            }
            List<Usuarios> listaActualizada = DaoUsuarios.listar();
            request.setAttribute("resultadoListar", listaActualizada);
            request.getRequestDispatcher("Vistas/ListarUsuarios.jsp").forward(request, response);
            //response.sendRedirect("ControladorUsuarios?accion=listar");
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idEditar", request.getParameter("id"));
            request.getRequestDispatcher("Vistas/editarUsuarios.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("editarRegistro")) {

            String nombres = request.getParameter("txtnombres");
            String apellidos = request.getParameter("txtapellidos");
            String txtRazonSocial = request.getParameter("txtRazonSocial");
            int txtDocumentoidDocumento = Integer.parseInt(request.getParameter("txtDocumentoidDocumento"));
            String txtnumeroDocumento = request.getParameter("txtnumeroDocumento");
            String txtdireccion = request.getParameter("txtdireccion");
            String txtnumeroTelefono = request.getParameter("txtnumeroTelefono");
            String txtcorreo = request.getParameter("txtcorreo");
            String txtusuario = request.getParameter("txtusuario");
            String txtclave = request.getParameter("txtclave");
            int txtPerfilidperfil = Integer.parseInt(request.getParameter("txtPerfilidperfil"));
            int txtid = Integer.parseInt(request.getParameter("txtid"));

            Perfil perfil = new Perfil();
            perfil.setIdperfil(txtPerfilidperfil);
            Usuarios usuarios = new Usuarios();

            usuarios.setIdUsuarios(txtid);
            usuarios.setNombres(nombres);
            usuarios.setApellidos(apellidos);
            usuarios.setRazon_Social(txtRazonSocial);
            usuarios.setDocumento_idDocumento(txtDocumentoidDocumento);
            usuarios.setNumero_Documento(txtnumeroDocumento);
            usuarios.setDireccion(txtdireccion);
            usuarios.setNumero_Telefono(txtnumeroTelefono);
            usuarios.setCorreo(txtcorreo);
            usuarios.setUsuario(txtusuario);
            usuarios.setClave(txtclave);
            usuarios.setPerfil_idperfil(perfil);
            DaoUsuarios.editar(usuarios);
            
            List<Usuarios> listaActualizada = DaoUsuarios.listar();
            request.setAttribute("resultadoListar", listaActualizada);
            request.getRequestDispatcher("Vistas/ListarUsuarios.jsp").forward(request, response);
            

        } else if (action.equalsIgnoreCase("buscar")) {
            String dato = request.getParameter("txtbuscar");
            List<Usuarios> lista = DaoUsuarios.Buscar(dato);
            request.setAttribute("resultadoListar", lista);
            request.getRequestDispatcher("Vistas/ListarUsuarios.jsp").forward(request, response);
        }
        //RequestDispatcher vista = request.getRequestDispatcher(acceso);
        //vista.forward(request, response); // vista redireciona
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
