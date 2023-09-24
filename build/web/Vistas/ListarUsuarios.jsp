<%-- 
    Document   : ListarUsuarios
    Created on : 3/09/2023, 11:24:46 a. m.
    Author     : cesar
--%>

<%@page import="java.util.List"%>
<%@page import="Persistencia.DaoPerfil"%>
<%@page import="Persistencia.DaoDocumento"%>
<%@page import="Persistencia.DaoUsuarios"%>
<%@page import="Modelo.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listar</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <h1>lista de todos los usuarios</h1>
        <a href="ControladorUsuarios?accion=add">registrar usuarios</a>

        <h3>buscar un usuario por el correo nombre o  numero documento</h3>
        <form action="ControladorUsuarios" method="get">
            <input type="text" name="txtbuscar">
            <input type="submit" name="accion" value="buscar"> 

        </form>

        <br>
        <table border="1">
            <thead>
                <tr>
                    <th>id:</th>
                    <th>nombres:</th>
                    <th>apellidos:</th>
                    <th>razon social</th>
                    <th>tipo documento</th>
                    <th>numero documento</th>
                    <th>direccion</th>
                    <th>numero telefono</th>
                    <th>correo</th>
                    <th>usuario</th>
                    <th>clave</th>
                    <th>perfil</th>
                    <th>acciones</th>
                </tr>
            </thead>
            <tbody>


                <%
                    List<Usuarios> lista = (List<Usuarios>) request.getAttribute("resultadoListar");

                    for (Usuarios usuarios : lista) {

                %>
                <tr>
                    <td><%=usuarios.getIdUsuarios()%></td>
                    <td><%=usuarios.getNombres()%></td>
                    <td><%=usuarios.getApellidos()%></td>
                    <td><%=usuarios.getRazon_Social()%></td>
                    <td><%=DaoDocumento.obtenerTipoDocumento(usuarios.getDocumento_idDocumento())%></td>
                    <td><%=usuarios.getNumero_Documento()%></td>
                    <td><%=usuarios.getDireccion()%></td>
                    <td><%=usuarios.getNumero_Telefono()%></td>
                    <td><%=usuarios.getCorreo()%></td>
                    <td><%=usuarios.getUsuario()%></td>
                    <td><%=usuarios.getClave()%></td>
                    <td><%=DaoPerfil.obtenerNombrePerfil(usuarios.getPerfil_idperfil().getIdperfil())%></td>
                    <td>
                        <a href="ControladorUsuarios?accion=eliminar&id=<%= usuarios.getIdUsuarios()%>"
                           class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de que deseas eliminar este usuario?')">
                            <i class="fas fa-trash"></i> <!-- Ícono de papelera -->
                        </a>


                        <a href="ControladorUsuarios?accion=editar&id=<%=usuarios.getIdUsuarios()%>">editar</a>        
                    </td>
                </tr>
                <%}
                %>
            </tbody>
        </table>
        <h4>${mensaje}</h4>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    </body>
</html>
