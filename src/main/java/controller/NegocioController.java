package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import beans.Negocio;
import connection.DBConnection;

public class NegocioController implements INegocioController {

    @Override
    public String listarServicio(boolean ordenar, String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from negocio";

        if (ordenar == true) {
            sql += " order by servicio " + orden;
        }

        List<String> negocios = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
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
                

                Negocio negocio = new Negocio(id, servicio, 
                        nombre_negocio, imagen, direccion, zona, precio_minimo, 
                        precio_maximo, hora_abierto, hora_cierre, dias, ubicacion, 
                        url, descripcion);

                negocios.add(gson.toJson(negocio));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(negocios);

    }
    
     @Override
    public String retirar(int id, String username) {

        DBConnection con = new DBConnection();
        String sql = "DELETE FROM itinerario WHERE id= " + id + " and username = '" 
                + username + "' limit 1";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeQuery(sql);
            return "true";
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    
    @Override
    public String itinerario(int id, String username) {
        
        Timestamp fecha_inicio = new Timestamp(new Date().getTime());
        DBConnection con = new DBConnection();
        String sql = "INSERT INTO itinerario VALUES ('" + id + "', '" + username + "', '" + fecha_inicio + "')";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            return "true";

        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            con.desconectar();
        }
        return "false";
    }

}