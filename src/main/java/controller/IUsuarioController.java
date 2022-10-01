package controller;

import java.util.Map;

public interface IUsuarioController {

    public String login(String username, String contrasena);

    public String register(String username, String contrasena, int cedula, String nombre, String apellidos, String email, boolean rol);
    
    public String pedir(String username);
    
    public String modificar(String username, String nuevaContrasena,
            int nuevoCedula, String nuevoNombre, String nuevosApellidos, 
            String nuevoEmail, boolean nuevoPremium);
    
    public String eliminar(String username);

}
