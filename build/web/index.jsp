<%-- 
    Document   : index
    Created on : 31/08/2023, 10:31:09 p. m.
    Author     : cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> bienvenidos a SysControll</h1>

        <a href="ControladorPerfil?accion=add">agregar un perfil</a>
        <br>
        <a href="ControladorDocumento?accion=add">agregar documento</a>
        <br>
        <a href="ControladorUsuarios?accion=add">registrar usuarios</a>
        <br>
        <a href="ControladorUsuarios?accion=listar">listar usuarios</a>
        

        <h1>bienvenido ${administrador.nombres} usted es un ${administrador.perfil_idperfil.tipo_Perfil}</h1>
    </body>
</html>
