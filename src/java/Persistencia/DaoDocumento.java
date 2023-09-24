/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Documento;
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
public class DaoDocumento {

    static Conexion dao = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    //static Documento documento = new Documento();

    public static boolean registrar(Documento documento) {

        try {
            con = dao.conectar();
            String sql = "INSERT INTO documento(tipo_documento) VALUES(?);";
            ps = con.prepareStatement(sql);
            ps.setString(1, documento.getTipo_documento());
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public static List< Documento> listar() {
        List< Documento> lista = new ArrayList<>();
        try {
            con = dao.conectar();
            String sql = "SELECT * FROM documento";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Documento documento = new Documento();
                documento.setIdDocumento(rs.getInt("idDocumento"));
                documento.setTipo_documento(rs.getString("tipo_Documento"));
                lista.add(documento);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public static String obtenerTipoDocumento(int id) {
        try {
            con = dao.conectar();
            String sql = "SELECT tipo_documento FROM documento WHERE idDocumento=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("tipo_documento");
            } else {
                return "error";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "error";
    }
}
