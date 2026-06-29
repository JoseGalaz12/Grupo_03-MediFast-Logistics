
package com.mycompany.main;

public class NodoAVL {
    Pedido pedido;
    NodoAVL izquierda;
    NodoAVL derecha;
    int altura;

    public NodoAVL(Pedido pedido, NodoAVL izquierda, NodoAVL derecha, int altura) {
        this.pedido = pedido;
        izquierda = null;
        derecha = null;
        altura = 1;
    }
    
    
}
