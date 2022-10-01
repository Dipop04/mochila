package beans;

public class Usuario {

    private String username;
    private String contrasena;
    private int cedula;
    private String nombre;
    private String apellidos;
    private String email;
    private boolean rol;

    public Usuario(String username, String contrasena, int cedula, String nombre, String apellidos, String email, boolean rol) {
        this.username = username;
        this.contrasena = contrasena;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRol() {
        return rol;
    }

    public void setRol(boolean rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", contrasena=" + contrasena + ", cedula=" + cedula + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", rol=" + rol + '}';
    }

    
   
    
    
    
}
