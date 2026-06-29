
package com.mycompany.main;

public class Busqueda {
    //su comportamiento es de 0(log n) y se usa cuando la lista esta ordenada
    //divide el arreglo a la mitad en cada paso
    public static Pedido busquedaBinaria(Pedido[] pedidos, int codigo){
        int izquierda = 0;
        int derecha = pedidos.length - 1;
        
        while (izquierda <= derecha){
            int medio = (izquierda + derecha) /2;
            
            if (pedidos[medio].getCodigo() == codigo){
                System.out.println("Pedido encontrado en la posicion: " + medio);
                return pedidos[medio];
            }
            
            if (codigo < pedidos[medio].getCodigo()){
                derecha = medio-1;
            }else{
                izquierda = medio+1;
            }
        }
        System.out.println("Pedido no encontrado");
        return null;
    }
    
    //se comporta como O(n) y se usa cuando la lista no esta ordenada
    //recorre uno por uno hasta encontrar el pedido
    public static Pedido busquedaSecuencial(Pedido[] pedidos, int codigo){
        for (int i = 0; i < pedidos.length; i++){
            if (pedidos[i].getCodigo() == codigo){
                System.out.println("Pedido encontrado en la posicion: " + i);
                return pedidos[i];
            }
        }
        System.out.println("Pedido no  encontrado");
        return null;
    }
}
