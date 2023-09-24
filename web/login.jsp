<%-- 
    Document   : login
    Created on : 5/09/2023, 10:06:02 p. m.
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
        <h1>login</h1>
        
        <form action="ControladorLogin?accion=verificar" method="post">
                <div> 
                    <p><strong>bienvenidos a mi sistema</strong></p>
                </div>
                <div> 
                    <label>Username:</label>
                    <input type="text" name="txtUsername" placeholder="ingrese el username" required>
                </div>
                <div> 
                    <label>calve:</label>
                    <input type="password" name="txtPasword" placeholder="*****" required>
                    
                </div>
                <input type="submit" name="accion" value="verificar">
            </form>
        
        <h1>
            ${mensaje}
        </h1>
    </body>
</html>
