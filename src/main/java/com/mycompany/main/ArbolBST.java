package com.mycompany.main;

public class ArbolBST {

    private NodoBST raiz;

    public ArbolBST() {
        raiz = null;
    }

   public void insertar(Pedido pedido) {
    raiz = insertarRec(raiz, pedido);
}

private NodoBST insertarRec(NodoBST raiz, Pedido pedido) {
    if (raiz == null) {
        raiz = new NodoBST(pedido);
        return raiz;
    }
    // comparar con los codigos
    if (pedido.getCodigo() < raiz.pedido.getCodigo()) {
        raiz.izquierda = insertarRec(raiz.izquierda, pedido);
    } else if (pedido.getCodigo() > raiz.pedido.getCodigo()) {
        raiz.derecha = insertarRec(raiz.derecha, pedido);
    }
    return raiz;
}

    public Pedido buscar(int codigo) {

        NodoBST actual = raiz;

        while (actual != null) {

            if (codigo == actual.pedido.getCodigo()) {
                return actual.pedido;
            }

            if (codigo < actual.pedido.getCodigo()) {
                actual = actual.izquierda;
            } else {
                actual = actual.derecha;
            }

        }

        return null;
    }

    public void inOrden() {
        inOrdenRec(raiz);
    }

    private void inOrdenRec(NodoBST nodo) {

        if (nodo != null) {
            inOrdenRec(nodo.izquierda);
            System.out.println(nodo.pedido);
            inOrdenRec(nodo.derecha);

        }

    }

    public void preOrden() {
        preOrdenRec(raiz);
    }

    private void preOrdenRec(NodoBST nodo) {

        if (nodo != null) {
            System.out.println(nodo.pedido);
            preOrdenRec(nodo.izquierda);
            preOrdenRec(nodo.derecha);

        }

    }

    public void postOrden() {
        postOrdenRec(raiz);
    }

    private void postOrdenRec(NodoBST nodo) {

        if (nodo != null) {
            postOrdenRec(nodo.izquierda);
            postOrdenRec(nodo.derecha);
            System.out.println(nodo.pedido);

        }

    }

}
