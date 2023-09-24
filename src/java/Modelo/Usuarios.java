package Modelo;

/**
 *
 * @author Juan David
 */
public class Usuarios {

    private int idUsuarios;
    private String nombres;
    private String apellidos;
    private String razon_Social;
    private String numero_Documento;
    private String direccion;
    private String numero_Telefono;
    private String correo;
    private String usuario;
    private String clave;
    private Perfil perfil_idperfil;
    private int Documento_idDocumento;
    
    
    // <editor-fold defaultstate="collapsed" desc="Metodo Get y Set"> 
        public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRazon_Social() {
        return razon_Social;
    }

    public void setRazon_Social(String razon_Social) {
        this.razon_Social = razon_Social;
    }

    public String getNumero_Documento() {
        return numero_Documento;
    }

    public void setNumero_Documento(String numero_Documento) {
        this.numero_Documento = numero_Documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero_Telefono() {
        return numero_Telefono;
    }

    public void setNumero_Telefono(String numero_Telefono) {
        this.numero_Telefono = numero_Telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Perfil getPerfil_idperfil() {
        return perfil_idperfil;
    }

    public void setPerfil_idperfil(Perfil perfil_idperfil) {
        this.perfil_idperfil = perfil_idperfil;
    }

    public int getDocumento_idDocumento() {
        return Documento_idDocumento;
    }

    public void setDocumento_idDocumento(int Documento_idDocumento) {
        this.Documento_idDocumento = Documento_idDocumento;
    }
    
      // </editor-fold>

    
}
