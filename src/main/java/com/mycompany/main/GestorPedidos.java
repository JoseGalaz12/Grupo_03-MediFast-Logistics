package com.mycompany.main;
import java.util.Scanner;

public class GestorPedidos {

    private ListaDinamica lista;
    private Cola cola;
    private ArbolBST arbol;
    private Pila historial;
    private ArbolAVL arbolAVL;

    public GestorPedidos() {
        lista = new ListaDinamica();
        cola = new Cola();
        arbol = new ArbolBST();
        historial = new Pila();
        arbolAVL = new ArbolAVL();
    }

    public void registrarPedido(Scanner sc) {

        System.out.println("-------- REGISTRAR PEDIDO --------");

        System.out.print("Codigo: ");
        int codigo = Integer.parseInt(sc.nextLine());

        System.out.print("Institucion: ");
        String institucion = sc.nextLine();

        System.out.print("Tipo de institucion: ");
        String tipo = sc.nextLine();

        System.out.print("Fecha solicitud: ");
        String fechaSolicitud = sc.nextLine();

        System.out.print("Medicamento: ");
        String medicamento = sc.nextLine();

        System.out.print("Cantidad: ");
        int cantidad = Integer.parseInt(sc.nextLine());

        System.out.print("Prioridad: ");
        int prioridad = Integer.parseInt(sc.nextLine());

        System.out.print("Fecha maxima entrega: ");
        String fechaEntrega = sc.nextLine();

        System.out.print("Estado (pendiente/en proceso): ");
        String estado = sc.nextLine();

        System.out.print("Responsable: ");
        String responsable = sc.nextLine();

        Pedido pedido = new Pedido(codigo , institucion, tipo, fechaSolicitud, medicamento, cantidad, prioridad, fechaEntrega, estado, responsable);

        lista.agregar(pedido);
        cola.encolar(pedido);
        arbol.insertar(pedido);
        arbolAVL.insertar(pedido);

        System.out.println("Pedido registrado correctamente.");
    }

    public void mostrarPedidos() {

        lista.mostrarPedidos();

    }

    public void buscarPedido(Scanner sc) {

        System.out.print("Codigo del pedido: ");
        int codigo = Integer.parseInt(sc.nextLine());

        Pedido pedido = arbol.buscar(codigo);

        if (pedido != null) {
            System.out.println(pedido);
        } else {
            System.out.println("Pedido no encontrado.");
        }

    }
    
    public void busquedaSecuencial(Scanner sc){
        System.out.println("Codigo que quiere buscar: ");
        int codigo = Integer.parseInt(sc.nextLine());
        
        Pedido[] pedidos = lista.convertirArreglo();
        if(pedidos.length == 0){
            System.out.println("No hay pedidos registrados");
            return;
        }
        Busqueda.busquedaSecuencial(pedidos, codigo);
    }
    
    public void busquedaBinaria(Scanner sc){
        System.out.println("Codigo que quiere buscar: ");
        int codigo = Integer.parseInt(sc.nextLine());
        
        Pedido[] pedidos = lista.convertirArreglo();
        if(pedidos.length == 0){
            System.out.println("No hay pedidos registrados");
            return;
        }
        
        for(int i = 0; i < pedidos.length - 1; i++){
            for(int j = 0; j < pedidos.length - i - 1; j++){
                if(pedidos[j].getCodigo() > pedidos[j+1].getCodigo()){
                    Pedido temp = pedidos[j];
                    pedidos[j] = pedidos[j+1];
                    pedidos[j+1] = temp;
                }    
            }
        }
        Busqueda.busquedaBinaria(pedidos, codigo);
    }

    public void eliminarPedido(Scanner sc) {

        System.out.print("Codigo a eliminar: ");
        int codigo = Integer.parseInt(sc.nextLine());

        lista.eliminar(codigo);
        arbol.eliminar(codigo);
        
        System.out.println("Pedido eliminado.");

    }

    public void ordenarBubble() {
    Pedido[] pedidos = lista.convertirArreglo();
    Ordenamiento.bubbleSort(pedidos);
    for (Pedido p : pedidos) {
        System.out.println(p);
    }
}

    public void ordenarMerge() {
    Pedido[] pedidos = lista.convertirArreglo();
    Ordenamiento.mergeSort(pedidos, 0, pedidos.length - 1);
    for (Pedido p : pedidos) {
        System.out.println(p);
    }
}

    
    public void mostrarBST() {

        arbol.inOrden();

    }
    
    public void modificarPedido(Scanner sc){
        System.out.println("Codigo del pedido que quiere modificar");
        int codigo = Integer.parseInt(sc.nextLine());
        
        //Buscando el pedido en el arbol
        Pedido pedido = arbol.buscar(codigo);
        
        if (pedido == null){
            System.out.println("Su pedido no fue encontrado");
            return;
        }
        
        //Se guarda el estado anterior en la pila
        historial.apilar(pedido);
        
        //Modfique el pedido
        System.out.println("Nuevo estado: ");
        String nuevoEstado = sc.nextLine();
        pedido.setEstadoPedido(nuevoEstado);
        System.out.println("Su pedido fue modificado ");
    }
    
    public void mostrarHistorial(){
        historial.mostrarHistorial();
    }
    
    public void mostrarAVL(){
        System.out.println("---ARBOLAVL Ordenamiento por prioridad---");
        arbolAVL.inOrden();
    }
    
    public void mostrarCola(){
        cola.mostrarCola();
    }
    
    public void mostrarBSTPreOrden(){
        arbol.preOrden();
    }
    
    public void mostrarBSTPostOrden(){
        arbol.postOrden();
    }
    
    public void verificarVencimiento(){
        Pedido[] pedidos = lista.convertirArreglo();
        
        if(pedidos.length == 0){
            System.out.println("No hay pedidos registrados");
            return;
        }
        System.out.println("---PEDIDOS QUE ESTAN POR VENCER---");
        boolean encontrado = false;
        
        for(Pedido p : pedidos){
            if(p.getPrioridad() <= 2){
                System.out.println("POR VENCER: " + p);
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("No hay pedidos Por vencer");
        }
    }

}
