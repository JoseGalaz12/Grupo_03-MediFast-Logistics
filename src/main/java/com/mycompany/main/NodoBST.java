/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author sophy
 */
//esta clase representa un nodo de el arbol binario
public class NodoBST {
    
    int dato; // almacera el valor del dato a ingresar
    NodoBST izquierda; 
    NodoBST derecha;
    
    public NodoBST(int dato){ // el constructor 
        this.dato = dato;
        
        // el nodo tiene que estar vacio para comenzar
        izquierda = null;
        derecha = null;
    }
  
}
