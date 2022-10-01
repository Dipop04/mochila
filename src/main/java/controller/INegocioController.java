package controller;

public interface INegocioController {

    public String listarServicio(boolean ordenar_servicio, String orden_servicio);

    public String retirar(int id, String username);

    //public String sumarCantidad(int id);

    public String itinerario(int id, String username);

    //public String modificar(int id);

}
