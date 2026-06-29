
package com.mycompany.main;

//Pedidos pendientes en el almacen 
public class Cola {
    private NodoLista primero;
    private NodoLista ultimo;
    private int tamano;

    public Cola() {
        this.primero = null;
        this.ultimo = null;
        this.tamano = 0;
    }
    //metodos 
    
    
    public boolean estaVacia(){ //revisa que la cola no este vacia
        return primero == null;
    }
    public int cantidadPedidos(){ //almacen de pedidos en la cola
        return tamano;
    }
    
    public void encolar(Pedido pedido){ //Agrega el pedido al final de la cola
        NodoLista nuevoNodo = new NodoLista(pedido);
        if (estaVacia()){
            //si esta vacia el nuevo nodo es primero y ultimo
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        }else{
            //Si no esta vacia se agrega al final 
            ultimo.siguiente = nuevoNodo;
            ultimo = nuevoNodo;
        }
        tamano++;
        System.out.println("Su pedido fue agregado a la cola");
    }
    
    //Retirar y mostrar el primer pedido de la cola
    public Pedido desencolar(){
        if (estaVacia()){
            System.out.println("No hay pedidos en la cola");
            return null;
        }
        //Guarda el primer pedido para poder mostrarlo
        Pedido pedido = primero.dato;
        primero = primero.siguiente;
        
        //Si la cola quedo vacia el ultimo tambien es null
        if(primero == null){
            ultimo = null;
        }
        tamano--;
        System.out.println("Pedido retirado de la cola");
        return pedido;
    }
    
    public void mostrarCola(){
        if(estaVacia()){
            System.out.println("No hay pedidos en al cola");
            return;
        }
        System.out.println("-----COLA DE PEDIDOS-----");
        NodoLista actual = primero;
        while (actual != null){
            System.out.println("- " + actual.dato);
            actual = actual.siguiente;
        }
        System.out.println("Total: " + tamano + " pedidos");
        System.out.println();
    }
    
}
