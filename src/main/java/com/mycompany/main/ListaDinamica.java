
package com.mycompany.main;

public class ListaDinamica {
    private NodoLista cabeza;  // primer nodo de la lista
    private int tamano; // almacenamiento de pedidos en la lista

    public ListaDinamica() {
        cabeza = null;
        tamano = 0;
    }
    
    //Metodos
    
    public boolean estaVacia(){ //Revisa si la lista esta vacia
        return cabeza == null;
    }
    
    public int cantidadPedidos(){ //Retorna el almacenamiento de pedidos ya registrados
        return tamano;
    }
    
    public void agregar(Pedido pedido){
        NodoLista nuevoNodo = new NodoLista(pedido);
        
        if (estaVacia()){
            cabeza = nuevoNodo;
        }else{
            NodoLista actual = cabeza;
            while (actual.siguiente !=null){
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamano++;
        System.out.println("Pedido agregado");
    }
   public boolean eliminar(int codigoPedido){
        if(estaVacia()){ // 1) revisa si hay pedidos registrados
            System.out.println("No hay pedidos registrados");
            return false;
        }
        
        //2) revisa si el pedido a eliminar es el primero de la lista
        if (cabeza.dato.getCodigo() == (codigoPedido)){
            cabeza = cabeza.siguiente;
            tamano--;
            System.out.println("Pedido eliminado con exito");
            return true;
        }
        NodoLista actual = cabeza;
    while (actual.siguiente != null){
        if(actual.siguiente.dato.getCodigo() == codigoPedido){ //cambiado a ==
            actual.siguiente = actual.siguiente.siguiente;
            tamano--;
            System.out.println("Pedido eliminado con exito");
            return true;
        }
            actual = actual.siguiente;
        }
        //En caso de queno se encuentra en el resto
        System.out.println("Pedido no fue encontrado");
        return false;
    }
    public void mostrarPedidos(){
        if(estaVacia()){
            System.out.println("No hay pedidos registrados");
            return;
        }
        System.out.println("--------LISTA PEDIDOS---------");
        NodoLista actual = cabeza;
        while (actual != null){
            System.out.println("- " + actual.dato);
            actual = actual.siguiente;
        }
        System.out.println("Total: " + tamano + " pedidos");
        System.out.println();
    }
    public Pedido buscar(String codigoPedido){
        if(estaVacia()){ //Verifica que la lista no este vacia
            System.out.println("No hay pedidos registrados");
            return null;
        }
        
        NodoLista actual = cabeza;//Revisa en la lista
        while (actual != null){
            if (actual.dato.getCodigoPedido().equals((codigoPedido))){
                System.out.println("Pedido encontrado");
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        System.out.println("Pedido no encontrado");
        return null;
    
    }
    //Metodo que convierte la lista a arreglo para ordenamientos y busquedas binarias
    public Pedido[] convertirArreglo(){
        Pedido[] arreglo = new Pedido[tamano];
        NodoLista actual = cabeza;
        int i = 0;
        while(actual != null){
            arreglo[i] = actual.dato;
            actual = actual.siguiente;
            i++;
        }
        return arreglo;
    }
    
}   

