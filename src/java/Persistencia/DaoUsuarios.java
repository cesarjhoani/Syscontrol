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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesar
 */
public class DaoUsuarios {

    static Conexion dao = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static Usuarios usuarios = new Usuarios();

    public static boolean registrar(Usuarios usuarios) {
        try {
            con = dao.conectar();
            String sql = "INSERT INTO usuarios(nombres,apellidos,razon_Social,numero_Documento,direccion,numero_Telefono,"
                    + "correo,usuario,clave,perfil_idperfil,Documento_idDocumento) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
            ps = con.prepareStatement(sql);
            ps.setString(1, usuarios.getNombres());
            ps.setString(2, usuarios.getApellidos());
            ps.setString(3, usuarios.getRazon_Social());
            ps.setString(4, usuarios.getNumero_Documento());
            ps.setString(5, usuarios.getDireccion());
            ps.setString(6, usuarios.getNumero_Telefono());
            ps.setString(7, usuarios.getCorreo());
            ps.setString(8, usuarios.getUsuario());
            ps.setString(9, usuarios.getClave());
            ps.setInt(10, usuarios.getPerfil_idperfil().getIdperfil());
            ps.setInt(11, usuarios.getDocumento_idDocumento());
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static List<Usuarios> listar() {
        List<Usuarios> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT * FROM usuarios;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuarios usuarios = new Usuarios();
                usuarios.setIdUsuarios(rs.getInt("idUsuarios"));
                usuarios.setNombres(rs.getString("nombres"));
                usuarios.setApellidos(rs.getString("apellidos"));
                usuarios.setRazon_Social(rs.getString("razon_Social"));
                usuarios.setNumero_Documento(rs.getString("numero_Documento"));
                usuarios.setDireccion(rs.getString("direccion"));
                usuarios.setNumero_Telefono(rs.getString("numero_Telefono"));
                usuarios.setCorreo(rs.getString("correo"));
                usuarios.setUsuario(rs.getString("usuario"));
                usuarios.setClave(rs.getString("clave"));
                // Obtén el ID del perfil desde la base de datos
                int perfilId = rs.getInt("perfil_idperfil");
                // Crea un objeto Perfil y configúralo con el ID del perfil
                Perfil perfil = new Perfil();
                perfil.setIdperfil(perfilId);
                // Asigna el objeto Perfil a la propiedad perfil_idperfil de Usuarios
                usuarios.setPerfil_idperfil(perfil);
                usuarios.setDocumento_idDocumento(rs.getInt("Documento_idDocumento"));
                lista.add(usuarios);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public static boolean eliminar(int id) {
        try {
            con = dao.conectar();
            String sql = "DELETE FROM usuarios WHERE idUsuarios=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Usuarios list(int id) {
        try {
            con = dao.conectar();
            String sql = "SELECT * FROM usuarios where idUsuarios=" + id;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                usuarios.setIdUsuarios(rs.getInt("idUsuarios"));
                usuarios.setNombres(rs.getString("nombres"));
                usuarios.setApellidos(rs.getString("apellidos"));
                usuarios.setRazon_Social(rs.getString("razon_Social"));
                usuarios.setNumero_Documento(rs.getString("numero_Documento"));
                usuarios.setDireccion(rs.getString("direccion"));
                usuarios.setNumero_Telefono(rs.getString("numero_Telefono"));
                usuarios.setCorreo(rs.getString("correo"));
                usuarios.setUsuario(rs.getString("usuario"));
                usuarios.setClave(rs.getString("clave"));
                //Obtén el ID del perfil desde la base de datos
                int perfilId = rs.getInt("perfil_idperfil");
                // Crea un objeto Perfil y configúralo con el ID del perfil
                Perfil perfil = new Perfil();
                perfil.setIdperfil(perfilId);
                // Asigna el objeto Perfil a la propiedad perfil_idperfil de Usuarios
                usuarios.setPerfil_idperfil(perfil);
                usuarios.setDocumento_idDocumento(rs.getInt("Documento_idDocumento"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    public static boolean editar(Usuarios usuarios) {
        try {
            con = dao.conectar();
            String sql = "UPDATE usuarios SET nombres = ?,apellidos = ?,razon_Social = ?,"
                    + "numero_Documento =?,direccion = ?,numero_Telefono =?,correo =?,"
                    + "usuario =?,clave =?,perfil_idperfil = ?,Documento_idDocumento =? WHERE idUsuarios =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, usuarios.getNombres());
            ps.setString(2, usuarios.getApellidos());
            ps.setString(3, usuarios.getRazon_Social());
            ps.setString(4, usuarios.getNumero_Documento());
            ps.setString(5, usuarios.getDireccion());
            ps.setString(6, usuarios.getNumero_Telefono());
            ps.setString(7, usuarios.getCorreo());
            ps.setString(8, usuarios.getUsuario());
            ps.setString(9, usuarios.getClave());
            ps.setInt(10, usuarios.getPerfil_idperfil().getIdperfil());
            ps.setInt(11, usuarios.getDocumento_idDocumento());
            ps.setInt(12, usuarios.getIdUsuarios());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static List<Usuarios> Buscar(String texto) {
        List<Usuarios> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT * FROM usuarios WHERE nombres LIKE '%" + texto + "%' or numero_Documento LIKE"
                    + "'%" + texto + "%' or correo LIKE '%" + texto + "%' or perfil_idperfil LIKE '%" + texto + "%';";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuarios usuarios = new Usuarios();
                usuarios.setIdUsuarios(rs.getInt("idUsuarios"));
                usuarios.setNombres(rs.getString("nombres"));
                usuarios.setApellidos(rs.getString("apellidos"));
                usuarios.setRazon_Social(rs.getString("razon_Social"));
                usuarios.setNumero_Documento(rs.getString("numero_Documento"));
                usuarios.setDireccion(rs.getString("direccion"));
                usuarios.setNumero_Telefono(rs.getString("numero_Telefono"));
                usuarios.setCorreo(rs.getString("correo"));
                usuarios.setUsuario(rs.getString("usuario"));
                usuarios.setClave(rs.getString("clave"));
                // Obtén el ID del perfil desde la base de datos
                int perfilId = rs.getInt("perfil_idperfil");
                // Crea un objeto Perfil y configúralo con el ID del perfil
                Perfil perfil = new Perfil();
                perfil.setIdperfil(perfilId);
                // Asigna el objeto Perfil a la propiedad perfil_idperfil de Usuarios
                usuarios.setPerfil_idperfil(perfil);
                usuarios.setDocumento_idDocumento(rs.getInt("Documento_idDocumento"));
                lista.add(usuarios);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
     /*public static void main(String[]args){
         List<Usuarios> lista = new ArrayList();
         lista = DaoUsuarios.listar();
        
         for(Usuarios usu:lista){
             System.out.println(usu.getApellidos());
             System.out.println(usu.getIdUsuarios());
         }
    }*/
}
