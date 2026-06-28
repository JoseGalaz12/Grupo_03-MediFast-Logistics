
package com.mycompany.main;

public class Pedido {
    private String codigoPedido;
    private String nombreInstitucion;
    private String tipoInstitucion;
    private String fechaSolicitud;
    private String tipoMedicamento;
    private String fechaMaximaEntregar;
    private String estadoPedido;
    private String encargadoEntrega;
    private int cantidadSolicitada;
    private int nivelPrioridad;

    public Pedido(String codigoPedido, String nombreInstitucion, String tipoInstitucion, String fechaSolicitud, String tipoMedicamento, String fechaMaximaEntregar, String estadoPedido, String encargadoEntrega, int cantidadSolicitada, int nivelPrioridad) {
        this.codigoPedido = codigoPedido;
        this.nombreInstitucion = nombreInstitucion;
        this.tipoInstitucion = tipoInstitucion;
        this.fechaSolicitud = fechaSolicitud;
        this.tipoMedicamento = tipoMedicamento;
        this.fechaMaximaEntregar = fechaMaximaEntregar;
        this.estadoPedido = estadoPedido;
        this.encargadoEntrega = encargadoEntrega;
        
        if (cantidadSolicitada <= 0){
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        this.cantidadSolicitada = cantidadSolicitada;

        this.nivelPrioridad = nivelPrioridad;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public String getTipoInstitucion() {
        return tipoInstitucion;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public String getTipoMedicamento() {
        return tipoMedicamento;
    }

    public String getFechaMaximaEntregar() {
        return fechaMaximaEntregar;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public String getEncargadoEntrega() {
        return encargadoEntrega;
    }

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public int getNivelPrioridad() {
        return nivelPrioridad;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public void setTipoInstitucion(String tipoInstitucion) {
        this.tipoInstitucion = tipoInstitucion;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public void setTipoMedicamento(String tipoMedicamento) {
        this.tipoMedicamento = tipoMedicamento;
    }

    public void setFechaMaximaEntregar(String fechaMaximaEntregar) {
        this.fechaMaximaEntregar = fechaMaximaEntregar;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public void setEncargadoEntrega(String encargadoEntrega) {
        this.encargadoEntrega = encargadoEntrega;
    }

    public void setCantidadSolicitada(int cantidadSolicitada) {
        if (cantidadSolicitada <= 0){
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public void setNivelPrioridad(int nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigoPedido=" + codigoPedido + ", nombreInstitucion=" + nombreInstitucion + ", tipoInstitucion=" + tipoInstitucion + ", fechaSolicitud=" + fechaSolicitud + ", tipoMedicamento=" + tipoMedicamento + ", fechaMaximaEntregar=" + fechaMaximaEntregar + ", estadoPedido=" + estadoPedido + ", encargadoEntrega=" + encargadoEntrega + ", cantidadSolicitada=" + cantidadSolicitada + ", nivelPrioridad=" + nivelPrioridad + '}';
    }
    
    
}
