
package com.mycompany.main;

public class Pedido {
    private int codigoPedido; //cambiado a int para el BST
    private String nombreInstitucion;
    private String tipoInstitucion;
    private String fechaSolicitud;
    private String tipoMedicamento;
    private int cantidadSolicitada; 
    private int nivelPrioridad;
    private String fechaMaximaEntregar;
    private String estadoPedido;
    private String encargadoEntrega;

    //cambio el orden para no perderme mientras hago gestorPedidos
    public Pedido(int codigoPedido, String nombreInstitucion, String tipoInstitucion, String fechaSolicitud, 
                  String tipoMedicamento, int cantidadSolicitada, int nivelPrioridad, 
                  String fechaMaximaEntregar, String estadoPedido, String encargadoEntrega) {
        this.codigoPedido = codigoPedido;
        this.nombreInstitucion = nombreInstitucion;
        this.tipoInstitucion = tipoInstitucion;
        this.fechaSolicitud = fechaSolicitud;
        this.tipoMedicamento = tipoMedicamento;
        
        if (cantidadSolicitada <= 0){
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        this.cantidadSolicitada = cantidadSolicitada;
        this.nivelPrioridad = nivelPrioridad;
        this.fechaMaximaEntregar = fechaMaximaEntregar;
        this.estadoPedido = estadoPedido;
        this.encargadoEntrega = encargadoEntrega;
    }

    //metodos agregados para otras clases
    public int getCodigo() {
        return codigoPedido;
    }

    public int getPrioridad() {
        return nivelPrioridad;
    }
    public String getCodigoPedido(){
        return String.valueOf(codigoPedido);
    }

    @Override
    public String toString() {
        return "-" + codigoPedido + "-" + nombreInstitucion + 
                " | " + tipoMedicamento + 
                " | Prioridad: " + nivelPrioridad +
                " | Estado: " + estadoPedido + 
                " | Entrega: " + fechaMaximaEntregar;
    }
}
