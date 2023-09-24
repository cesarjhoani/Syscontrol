/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;


import Modelo.Perfil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesar
 */
public class DaoPerfil {
       static Conexion dao = new Conexion();
       static Connection con;
       static PreparedStatement ps;
       static  ResultSet rs;
       //static Perfil perfil = new Perfil();
    public static boolean registrar(Perfil perfil){
       
           try {
               
               con = dao.conectar();
               String sql = "INSERT INTO perfil(tipo_Perfil) VALUES (?);";
               ps = con.prepareStatement(sql);
               ps.setString(1, perfil.getTipo_Perfil());
               if(ps.executeUpdate()>0){
                   return true;
               }else{
                   return false;
               }
           } catch (SQLException ex) {
               Logger.getLogger(DaoDocumento.class.getName()).log(Level.SEVERE, null, ex);
           }
           return false;
       
    }
    
    public static List<Perfil> listar(){
        List<Perfil> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT * FROM perfil";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
               Perfil perfil = new Perfil();
               perfil.setIdperfil(rs.getInt("idperfil"));
               perfil.setTipo_Perfil(rs.getString("tipo_Perfil"));
               lista.add(perfil);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public static String obtenerNombrePerfil(int id){
        try {
            con = dao.conectar();
            String sql = "SELECT tipo_Perfil FROM perfil WHERE idperfil=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
               return rs.getString("tipo_Perfil");
            }else {
                return "--";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "--";
    }
}
