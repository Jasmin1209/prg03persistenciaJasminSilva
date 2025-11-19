/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

/**
 *
 * @author USER
 */
public class StringUtil {
    
    //Verifica se uma string é nula ou vazia
    public static boolean isNullOrEmpty(String texto){
        return texto == null || texto.trim().isEmpty();
    }
    
    //Verifica se contém apenas números
    public static boolean isNumeric(String texto){
        if(isNullOrEmpty(texto)){
            return false;
        }
        
        return texto.matches("[0-9]+");
    }
}
