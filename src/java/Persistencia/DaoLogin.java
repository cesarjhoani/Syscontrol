/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Perfil;
import Modelo.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author cesar
 */
public class DaoLogin {
    public  Usuarios identificar(Usuarios user)throws Exception{
        Conexion dao =  new Conexion();
        Usuarios usu = null;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT U.idUsuarios,U.nombres,P.tipo_Perfil from usuarios U INNER JOIN perfil P ON"
                + " U.perfil_idperfil = P.idperfil WHERE  U.usuario = "
                + "'"+user.getUsuario()+"' AND U.clave = '"+user.getClave()+"'";
        
        try {
            
          con = dao.conectar();
          st = con.createStatement();
          rs = st.executeQuery(sql);
          
          if(rs.next()== true){
             usu = new Usuarios();
             usu.setIdUsuarios(rs.getInt("idUsuarios"));
             usu.setUsuario(user.getUsuario());
             usu.setNombres(rs.getString("nombres"));
             usu.setPerfil_idperfil(new Perfil());
             usu.getPerfil_idperfil().setTipo_Perfil(rs.getString("tipo_Perfil"));
             
          }
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }finally{
           if(rs !=null && rs.isClosed()==false){
               rs.close();
           } 
           
           rs = null;
           if(st !=null && st.isClosed()==false){
               st.close();
           } 
           st = null;
           if(con !=null & con.isClosed()==false){
               con.close();
           } 
           con = null;
        }
        return usu;
    }
}
