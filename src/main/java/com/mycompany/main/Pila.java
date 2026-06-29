
package com.mycompany.main;
// Guarda el historial de cambios de los pedidos
public class Pila {
    private NodoLista tope;
    private int tamano;

    public Pila() {
        tope = null;
        tamano = 0;
    }
    public boolean estaVacia(){ //revis si la pila esta vacia 
        return tope == null;
    }
    
    public int cantidadCambios(){ //Muestra la cantidad de cambios
        return tamano;
    }
    
    //Agrega un cambio al tope de la pila
    public void apilar(Pedido pedido){
        NodoLista nuevoNodo = new NodoLista(pedido);
        
        //El nuevo nodo apunta al tope actual
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
        
        tamano++;
        System.out.println("Cambio registrado en el historial");
    }
    
    public Pedido desapilar(){
        if (estaVacia()){
            System.out.println("No hay cambios en el historial");
            return null;
        }
        
        //Guarda el tope para mostrar
        Pedido pedido = tope.dato;
        tope = tope.siguiente;
        
        tamano--;
        System.out.println("Ultimo cambio revertido");
        return pedido;
    }
    public void mostrarHistorial(){
        if (estaVacia()){
            System.out.println("No hay cambios en el historial");
            return;
        }
        System.out.println("-----HISTORIAL DE CAMBIOS-----");
        NodoLista actual = tope;
        while (actual != null){
            System.out.println("- " + actual.dato);
            actual = actual.siguiente;
        }
        System.out.println("Total: " + tamano + " cambios");
        System.out.println();
    }
    
}
