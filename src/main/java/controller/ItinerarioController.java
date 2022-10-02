package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;

import beans.Itinerario;
import connection.DBConnection;

public class ItinerarioController implements IItinerarioController {

    @Override
    public String listarItinerario(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "SELECT N.id, N.servicio, N.nombre_negocio, N.imagen, N.precio_minimo, N.precio_maximo, N.descripcion, N.direccion, N.zona, N.hora_abierto, N.hora_cierre, N.dias, N.ubicacion, N.url, I.fecha_inicio FROM negocio N "
                + "INNER JOIN itinerario I ON N.id = I.id INNER JOIN usuario U on I.username = U.username "
                + "WHERE I.username = '" + username + "'";

        List<String> itinerarios = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre_negocio = rs.getString("nombre_negocio");
                String servicio = rs.getString("servicio");
                Date fecha_inicio = rs.getDate("fecha_inicio");
                String imagen = rs.getString("imagen");
                float precio_minimo = rs.getFloat("precio_minimo");
                float precio_maximo = rs.getFloat("precio_maximo");
                String descripcion = rs.getString("descripcion");
                String direccion = rs.getString("direccion");
                String zona = rs.getString("zona");
                String hora_abierto = rs.getString("hora_abierto");
                String hora_cierre = rs.getString("hora_cierre");
                String dias = rs.getString("dias");
                String ubicacion = rs.getString("ubicacion");
                String url = rs.getString("url");

                Itinerario itinerario = new Itinerario(id, username, fecha_inicio, servicio, nombre_negocio, imagen, precio_minimo, precio_maximo, descripcion, direccion, zona, hora_abierto, hora_cierre, dias, ubicacion, url);

                itinerarios.add(gson.toJson(itinerario));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return gson.toJson(itinerarios);
    }
    
     
    
    
    
    
    
}