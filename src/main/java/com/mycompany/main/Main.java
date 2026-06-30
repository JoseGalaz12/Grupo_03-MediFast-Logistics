
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
            System.out.println("8. Mostrar cola de pedidos");
            System.out.println("9. Mostrar historial de cambios");
            System.out.println("10. Mostrar BST preOrden");
            System.out.println("11. Mostrar BST postOrden");
            System.out.println("12. Mostrar AVL por prioridad");
            System.out.println("13. Busqueda secuencial");
            System.out.println("14. Busqueda binaria");
            System.out.println("15. Ver pedidos que estan por vencer");
            System.out.println("16. Modificar pedido");
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
                    
                case 8:  
                    gestor.mostrarCola();
                    break;
                
                case 9:
                    gestor.mostrarHistorial();
                    break;
                    
                case 10:
                    gestor.mostrarBSTPreOrden();
                    break;
                    
                case 11:
                    gestor.mostrarBSTPostOrden();
                    break;
                    
                case 12:
                    gestor.mostrarAVL();
                    break;
                case 13:
                    gestor.busquedaSecuencial(sc);
                    break;
                    
                case 14:
                    gestor.busquedaBinaria(sc);
                    break;
                case 15:
                    gestor.verificarVencimiento();
                    break;
                    
                case 16:
                    gestor.modificarPedido(sc);
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
