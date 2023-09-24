<%-- 
    Document   : editarUsuarios
    Created on : 4/09/2023, 4:09:56 p. m.
    Author     : cesar
--%>

<%@page import="Persistencia.DaoUsuarios"%>
<%@page import="Persistencia.DaoPerfil"%>
<%@page import="Modelo.Perfil"%>
<%@page import="Persistencia.DaoDocumento"%>
<%@page import="Modelo.Documento"%>
<%@page import="Modelo.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>editar</title>
    </head>
    <body>
        <h1>editar Usuarios</h1>
        <%
            int id = Integer.parseInt((String)request.getAttribute("idEditar"));
            Usuarios usuarios = DaoUsuarios.list(id);  
        %>
        <form action="ControladorUsuarios" method="post">

            <p><label>nombres:</label><input type="text" name="txtnombres" value="<%=usuarios.getNombres()%>" placeholder="ingrese nombres"></p>
            <p><label>apellidos:</label><input type="text" name="txtapellidos" value="<%=usuarios.getApellidos()%>" placeholder="ingrese apellidos"></p>
            <p><label>Razon social:</label><input type="text" name="txtRazonSocial" value="<%=usuarios.getRazon_Social()%>" placeholder="ingrese razon social"></p>
            <select name="txtDocumentoidDocumento" value="<%=usuarios.getDocumento_idDocumento()%>">
                <option value="0">seleciona tipo documento</option>
                <% for (Documento documento : DaoDocumento.listar()) {%>
                <option value="<%=documento.getIdDocumento()%>"><%=documento.getTipo_documento()%></option>
                <%}%>      
            </select>
            <br>
            <br>
            <br>
            <p><label>numero documento:</label><input type="text" name="txtnumeroDocumento" value="<%=usuarios.getNumero_Documento()%>" placeholder="ingrese numero documento"></p>
            <p><label>direccion:</label><input type="text" name="txtdireccion" value="<%=usuarios.getDireccion()%>" placeholder="ingrese dirrecion"></p>
            <p><label>numero telefono:</label><input type="text" name="txtnumeroTelefono"value="" placeholder="ingrese telefono"></p>
            <p><label>correo:</label><input type="email" name="txtcorreo"value="<%=usuarios.getCorreo()%>" placeholder="ingrese correo"></p>
            <p><label>usuario:</label><input type="text" name="txtusuario" value="<%=usuarios.getUsuario()%>"placeholder="ingrese usuario"></p>
            <p><label>clave:</label><input type="password" name="txtclave" value="<%=usuarios.getClave()%>"placeholder="ingrese clave"></p>
            <select name="txtPerfilidperfil" value="<%=usuarios.getPerfil_idperfil()%>">
                <option value="0">ingrese el perfil</option>
                <% for (Perfil perfil : DaoPerfil.listar()) {%>
                <option value="<%=perfil.getIdperfil()%>"><%=perfil.getTipo_Perfil()%></option>
                <%}%>      
            </select>
            <br>
            <br>
            <input type="hidden" name="txtid" value="<%=usuarios.getIdUsuarios()%>">
            <button type="submit" name="accion" value="editarRegistro">editar usuarios</button>
        </form>

        <h1>
            ${mensaje}
        </h1>
        
    </body>
</html>