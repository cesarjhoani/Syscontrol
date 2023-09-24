<%-- 
    Document   : RegistrarUsuarios
    Created on : 3/09/2023, 8:45:10 a. m.
    Author     : cesar
--%>

<%@page import="Persistencia.DaoDocumento"%>
<%@page import="Modelo.Documento"%>
<%@page import="Persistencia.DaoPerfil"%>
<%@page import="Modelo.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Usuarios</title>
    </head>
    <body>
        <h1>Registrar usuarios</h1>
        <form action="ControladorUsuarios" method="post">

            <p><label>nombres:</label><input type="text" name="nombres" placeholder="ingrese nombres"></p>
            <p><label>apellidos:</label><input type="text" name="apellidos" placeholder="ingrese apellidos"></p>
            <p><label>Razon social:</label><input type="text" name="RazonSocial" placeholder="ingrese razon social"></p>
            <select name="DocumentoidDocumento">
                <option value="0">seleciona tipo documento</option>
                <% for (Documento documento : DaoDocumento.listar()) {%>
                <option value="<%=documento.getIdDocumento()%>"><%=documento.getTipo_documento()%></option>
                <%}%>      
            </select>
            <br>
            <br>
            <br>
            <p><label>numero documento:</label><input type="text" name="numeroDocumento" placeholder="ingrese numero documento"></p>
            <p><label>direccion:</label><input type="text" name="direccion" placeholder="ingrese dirrecion"></p>
            <p><label>numero telefono:</label><input type="text" name="numeroTelefono" placeholder="ingrese telefono"></p>
            <p><label>correo:</label><input type="email" name="correo" placeholder="ingrese correo"></p>
            <p><label>usuario:</label><input type="text" name="usuario" placeholder="ingrese usuario"></p>
            <p><label>clave:</label><input type="password" name="clave" placeholder="ingrese clave"></p>
            <select name="Perfilidperfil">
                <option value="0">ingrese el perfil</option>
                <% for (Perfil perfil : DaoPerfil.listar()) {%>
                <option value="<%=perfil.getIdperfil()%>"><%=perfil.getTipo_Perfil()%></option>
                <%}%>      
            </select>
            <br>


            <br>
            <button type="submit" name="accion" value="registrar">registrar usuarios</button>
        </form>

        <h1>
            ${mensaje}
        </h1>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
