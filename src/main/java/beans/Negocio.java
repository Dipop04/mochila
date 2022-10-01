
package beans;

public class Negocio {
    private int id;
    private String servicio;
    private String nombre_negocio;
    private String imagen;
    private String direccion;
    private String zona;
    private float precio_minimo;
    private float precio_maximo;
    private String hora_abierto;
    private String hora_cierre;
    private String dias;
    private String ubicacion;
    private String url;
    private String descripcion;    

    public Negocio(int id, String servicio, String nombre_negocio, String imagen, String direccion, String zona, float precio_minimo, float precio_maximo, String hora_abierto, String hora_cierre, String dias, String ubicacion, String url, String descripcion) {
        this.id = id;
        this.servicio = servicio;
        this.nombre_negocio = nombre_negocio;
        this.imagen = imagen;
        this.direccion = direccion;
        this.zona = zona;
        this.precio_minimo = precio_minimo;
        this.precio_maximo = precio_maximo;
        this.hora_abierto = hora_abierto;
        this.hora_cierre = hora_cierre;
        this.dias = dias;
        this.ubicacion = ubicacion;
        this.url = url;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Negocio{" + "id=" + id + ", servicio=" + servicio + ", nombre_negocio=" + nombre_negocio + ", imagen=" + imagen + ", direccion=" + direccion + ", zona=" + zona + ", precio_minimo=" + precio_minimo + ", precio_maximo=" + precio_maximo + ", hora_abierto=" + hora_abierto + ", hora_cierre=" + hora_cierre + ", dias=" + dias + ", ubicacion=" + ubicacion + ", url=" + url + ", descripcion=" + descripcion + '}';
    }

    
        
    
    
}
