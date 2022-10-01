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

        String sql = "SELECT N.id, N.servicio, N.nombre_negocio, I.fecha_inicio FROM negocio N "
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

                Itinerario itinerario = new Itinerario(id, nombre_negocio, fecha_inicio, servicio);

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