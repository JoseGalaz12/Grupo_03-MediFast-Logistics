
package com.mycompany.main;

public class ArbolAVL {
    private NodoAVL raiz;
    
    public ArbolAVL(){
        raiz = null;
    }
    
    private int altura(NodoAVL nodo){
        if (nodo == null){
            return 0;
        }
        return nodo.altura;
    }
    
    private int balance(NodoAVL nodo){
        if (nodo == null){
            return 0;
        }
        return altura(nodo.izquierda) - altura(nodo.derecha);
    }
    
    private NodoAVL rotarDerecha(NodoAVL i){
        NodoAVL d = i.izquierda;
        NodoAVL temp = d.derecha;
        
        d.derecha = i;
        i.izquierda = temp;
        
        i.altura = Math.max(altura(i.izquierda), altura(i.derecha)) + 1;
        d.altura = Math.max(altura(d.izquierda), altura(d.derecha)) + 1;
        
        return d;
    }
    private NodoAVL rotarIzquierda(NodoAVL d){
        NodoAVL i = d.derecha;
        NodoAVL temp = i.izquierda;
        
        i.izquierda = d;
        d.derecha = temp;
        
        d.altura = Math.max(altura(d.izquierda), altura(d.derecha)) + 1;
        i.altura = Math.max(altura(i.izquierda), altura(i.derecha)) + 1;
        
        return i;
    }
    public void insertar(Pedido pedido){
        raiz = insertarRecursivo(raiz, pedido);
    }
    
    private NodoAVL insertarRecursivo(NodoAVL nodo, Pedido pedido){
        // Una hoja vacia
        if (nodo == null){
            return new NodoAVL(pedido);
        }
        // insertar segun prioridad
        if (pedido.getPrioridad() < nodo.pedido.getPrioridad()){
            nodo.izquierda = insertarRecursivo(nodo.izquierda, pedido);
        }else if (pedido.getPrioridad() > nodo.pedido.getPrioridad()){
            nodo.derecha = insertarRecursivo(nodo.derecha, pedido);
        }else{
            return nodo;
        }
        
        //actualizar la altura
        int alturaIzquierda = altura(nodo.izquierda);
        int alturaDerecha = altura(nodo.derecha);
        nodo.altura = 1 + Math.max(alturaIzquierda, alturaDerecha);
        
        //revision si es que esta desbalanciado
        int diferencia = alturaIzquierda - alturaDerecha;
        
        //si la izquierda es mas pesada entonces: 
        if (diferencia > 1){
            if (pedido.getPrioridad() > nodo.izquierda.pedido.getPrioridad()){
                nodo.izquierda = rotarIzquierda(nodo.izquierda);
            }
            return rotarDerecha(nodo);
        }
        
        //si la derecha es mas pesada entonces: 
        if (diferencia < -1){
            if (pedido.getPrioridad() < nodo.derecha.pedido.getPrioridad()){
                nodo.derecha = rotarDerecha(nodo.derecha);
            }
            return rotarIzquierda(nodo);
        }
        
        //si esta todo bien entonces: 
        return nodo;
    }
    
    public void inOrden(){
        inOrdenRecursivo(raiz);
    }
    
    private void inOrdenRecursivo(NodoAVL nodo){
        if (nodo != null){
            inOrdenRecursivo(nodo.izquierda);
            System.out.println(nodo.pedido);
            inOrdenRecursivo(nodo.derecha);        
        }
    }
    
}
