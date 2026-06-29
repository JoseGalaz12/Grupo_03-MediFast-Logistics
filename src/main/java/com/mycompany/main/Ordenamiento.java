package com.mycompany.main;


public class Ordenamiento {
    public static void bubbleSort(Pedido[] pedidos) {
        int n = pedidos.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (pedidos[j].getPrioridad() > pedidos[j + 1].getPrioridad()) {

                    Pedido aux = pedidos[j];
                    pedidos[j] = pedidos[j + 1];
                    pedidos[j + 1] = aux;
                }
            }
        }
    }
    public static void mergeSort(Pedido[] pedidos, int izquierda, int derecha) {

        if (izquierda < derecha) {

            int medio = (izquierda + derecha) / 2;
            mergeSort(pedidos, izquierda, medio);
            mergeSort(pedidos, medio + 1, derecha);
            merge(pedidos, izquierda, medio, derecha);

        }
    }
    private static void merge(Pedido[] pedidos, int izquierda, int medio, int derecha) {

        int tamIzq = medio - izquierda + 1;
        int tamDer = derecha - medio;

        Pedido[] izquierdaArray = new Pedido[tamIzq];
        Pedido[] derechaArray = new Pedido[tamDer];

        for (int i = 0; i < tamIzq; i++) {
            izquierdaArray[i] = pedidos[izquierda + i];
        }

        for (int j = 0; j < tamDer; j++) {
            derechaArray[j] = pedidos[medio + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = izquierda;

        while (i < tamIzq && j < tamDer) {

            if (izquierdaArray[i].getPrioridad() <= derechaArray[j].getPrioridad()) {
                pedidos[k] = izquierdaArray[i];
                i++;
            } else {
                pedidos[k] = derechaArray[j];
                j++;
            }
            k++;
        }
        while (i < tamIzq) {
            pedidos[k] = izquierdaArray[i];
            i++;
            k++;
        }
        while (j < tamDer) {
            pedidos[k] = derechaArray[j];
            j++;
            k++;
        }
    }
}
