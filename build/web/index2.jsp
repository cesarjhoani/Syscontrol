<%-- 
    Document   : index2
    Created on : 6/09/2023, 5:58:59 p. m.
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
        
        <h1>hola empleado</h1>
        <a href="ControladorUsuarios?accion=listar">listar usuarios</a>
        <h2>Bienvenido, usted es un ${empleado.perfil_idperfil.tipo_Perfil}</h2>
        
        <h2>username ${empleado.usuario}</h2>
         
         <h2>su verdadero nombre es ${empleado.nombres}</h2>
    </body>
</html>
