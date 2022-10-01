
package beans;
import java.sql.Date;

public class Itinerario {
    private int id;
    private String username;
    private Date fecha_inicio;
    private String servicio;

    public Itinerario(int id, String username, Date fecha_inicio, String servicio) {
        this.id = id;
        this.username = username;
        this.fecha_inicio = fecha_inicio;
        this.servicio = servicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return "Itinerario{" + "id=" + id + ", username=" + username + ", fecha_inicio=" + fecha_inicio + ", servicio=" + servicio + '}';
    }

            
    
    
    
}
