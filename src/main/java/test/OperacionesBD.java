
package test;
import beans.Negocio;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;


public class OperacionesBD {
    public static void main(String[] args) {
        //actualizarNegocio(1,"Bar","Nombre bar", "direccion bar", "zona bar", 10000, 200000, "14:00", "01:00", "M M J V S D", "ubicacion bar", "url bar", "descripcion bar");
        //crearNegocio(2,"Restaurante","Nombre restaurante", "direccion restaurante", "zona restaurante", 10000, 200000, "14:00", "01:00", "M M J V S D", "ubicacion restaurante", "url restaurante", "descripcion restaurante", "3", "false");
        //listarNegocio();
    }
    
    
   
    
    
    public static void actualizarNegocio(int negocio_id, String servicio, String nombre_negocio, String imagen, String direccion, String zona,
            float precio_minimo, float precio_maximo, String hora_abierto, String hora_cierre, String dias, String ubicacion, String url, String descripcion){
        DBConnection con = new DBConnection();
        String sql = String.format("UPDATE negocio SET servicio='"+servicio+", nombre_negocio='"+nombre_negocio+", imagen='"+imagen+", "
                + "direccion='"+direccion+", zona='"+zona+", precio_minimo='"+precio_minimo+", precio_maximo='"+precio_maximo+", "
                        + "hora_abierto='"+hora_abierto+", hora_cierre='"+hora_cierre+", dias='"+dias+", ubicacion='"+ubicacion+", "
                                + "url='"+url+", descripcion='"+descripcion+", ' WHERE id ="+negocio_id);
        
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("ex.getMessage()");
        } finally {
            con.desconectar();
        }
    }
    
        public static void crearNegocio(int negocio_id, String servicio, String nombre_negocio, String imagen, String direccion, String zona,
            float precio_minimo, float precio_maximo, String hora_abierto, String hora_cierre, String dias, String ubicacion, String url, String descripcion, int conteo_top, boolean promocion){
        DBConnection con = new DBConnection();
        String sql = String.format("INSERT INTO negocio (servicio, nombre_negocio, imagen, direccion, zona, precio_minimo, precio_maximo, "
                + "hora_abierto, hora_cierre, dias, ubicacion, url, descripcion, conteo_top, promocion) VALUES ("+negocio_id+","+servicio+","+nombre_negocio+""
                        + ","+imagen+","+direccion+","+zona+","+precio_minimo+","+precio_maximo+","+hora_abierto+","+hora_cierre+","+dias+","+ubicacion+","+url+","
                                + ""+descripcion+")");
        
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("ex.getMessage()");
        } finally {
            con.desconectar();
        }
    }
    
    
    
    public static void listarNegocio(){
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM negocio";
        
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                int negocio_id = rs.getInt("negocio_id");
                String servicio = rs.getString("servicio");
                String nombre_negocio = rs.getString("nombre_negocio");
                String imagen = rs.getString("imagen");
                String direccion = rs.getString("direccion");
                String zona = rs.getString("zona");
                float precio_minimo = rs.getFloat("precio_minimo");
                float precio_maximo = rs.getFloat("precio_maximo");
                String hora_abierto = rs.getString("hora_abierto");
                String hora_cierre = rs.getString("hora_cierre");
                String dias = rs.getString("dias");
                String ubicacion = rs.getString("ubicacion");
                String url = rs.getString("url");
                String descripcion = rs.getString("descripcion");
                
                Negocio negocios = new Negocio(negocio_id, servicio, nombre_negocio, imagen, direccion, zona, precio_minimo, precio_maximo, hora_abierto, hora_cierre, dias, ubicacion, url, descripcion);
                System.out.println(negocios.toString());
            }
            
        } catch (Exception ex) {
            System.out.println("ex.getMessage()");
        } finally {
            con.desconectar();
        }
    }
    
    public static void eliminarNegocio(int negocio_id, String servicio, String nombre_negocio, String imagen, String direccion, String zona,
            float precio_minimo, float precio_maximo, String hora_abierto, String hora_cierre, String dias, String ubicacion, String url, String descripcion){
        DBConnection con = new DBConnection();
        String sql = String.format("DELETE FROM Negocio WHERE negocio_id ="+negocio_id);
        
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("ex.getMessage()");
        } finally {
            con.desconectar();
        }
    }

    
}
