
package com.mycompany.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestorPedidos gestor = new GestorPedidos();

        int opcion;

        do {

            System.out.println("\n------------------------------------");
            System.out.println("   SISTEMA MEDIFAST LOGISTICS");
            System.out.println("------------------------------------");
            System.out.println("1. Registrar pedido");
            System.out.println("2. Mostrar pedidos");
            System.out.println("3. Buscar pedido");
            System.out.println("4. Eliminar pedido");
            System.out.println("5. Ordenar (Bubble Sort)");
            System.out.println("6. Ordenar (Merge Sort)");
            System.out.println("7. Mostrar BST (InOrden)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:
                    gestor.registrarPedido(sc);
                    break;

                case 2:
                    gestor.mostrarPedidos();
                    break;

                case 3:
                    gestor.buscarPedido(sc);
                    break;

                case 4:
                    gestor.eliminarPedido(sc);
                    break;

                case 5:
                    gestor.ordenarBubble();
                    break;

                case 6:
                    gestor.ordenarMerge();
                    break;

                case 7:
                    gestor.mostrarBST();
                    break;

                case 0:
                    System.out.println("Cerrando MediFast.");
                    break;

                default:
                    System.out.println("Opcion invalida.");

            }

        } while (opcion != 0);

        sc.close();

    }

}
