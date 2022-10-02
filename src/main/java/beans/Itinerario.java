
package beans;
import java.sql.Date;

public class Itinerario {
    private int id;
    private String username;
    private Date fecha_inicio;
    private String servicio;
    private String nombre_negocio;
    private String imagen;
    private float precio_minimo;
    private float precio_maximo;
    private String descripcion;
    private String direccion;
    private String zona;
    private String hora_abierto;
    private String hora_cierre;
    private String dias;
    private String ubicacion;
    private String url;

    public Itinerario(int id, String username, Date fecha_inicio, String servicio, String nombre_negocio, String imagen, float precio_minimo, float precio_maximo, String descripcion, String direccion, String zona, String hora_abierto, String hora_cierre, String dias, String ubicacion, String url) {
        this.id = id;
        this.username = username;
        this.fecha_inicio = fecha_inicio;
        this.servicio = servicio;
        this.nombre_negocio = nombre_negocio;
        this.imagen = imagen;
        this.precio_minimo = precio_minimo;
        this.precio_maximo = precio_maximo;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.zona = zona;
        this.hora_abierto = hora_abierto;
        this.hora_cierre = hora_cierre;
        this.dias = dias;
        this.ubicacion = ubicacion;
        this.url = url;
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

    public String getNombre_negocio() {
        return nombre_negocio;
    }

    public void setNombre_negocio(String nombre_negocio) {
        this.nombre_negocio = nombre_negocio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public float getPrecio_minimo() {
        return precio_minimo;
    }

    public void setPrecio_minimo(float precio_minimo) {
        this.precio_minimo = precio_minimo;
    }

    public float getPrecio_maximo() {
        return precio_maximo;
    }

    public void setPrecio_maximo(float precio_maximo) {
        this.precio_maximo = precio_maximo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getHora_abierto() {
        return hora_abierto;
    }

    public void setHora_abierto(String hora_abierto) {
        this.hora_abierto = hora_abierto;
    }

    public String getHora_cierre() {
        return hora_cierre;
    }

    public void setHora_cierre(String hora_cierre) {
        this.hora_cierre = hora_cierre;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Itinerario{" + "id=" + id + ", username=" + username + ", fecha_inicio=" + fecha_inicio + ", servicio=" + servicio + ", nombre_negocio=" + nombre_negocio + ", imagen=" + imagen + ", precio_minimo=" + precio_minimo + ", precio_maximo=" + precio_maximo + ", descripcion=" + descripcion + ", direccion=" + direccion + ", zona=" + zona + ", hora_abierto=" + hora_abierto + ", hora_cierre=" + hora_cierre + ", dias=" + dias + ", ubicacion=" + ubicacion + ", url=" + url + '}';
    }

    
    
            
    
    
    
}
