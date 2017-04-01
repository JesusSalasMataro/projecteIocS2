/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Periode4;

/**
 *
 * @author Dani
 */
public class A501Tasca2 {
    public static void main (String [] args){
        A501Tasca2 prg = new A501Tasca2();
        prg.prova();
    }
    
    void prova(){
        String dadastr;
        int dadaint;
        
        dadastr = Utils.obtenirDataAvui();
        mostrarDataAvui(dadastr);
        
        dadastr = Utils.obtenirHoraAra();
        mostrarHoraAra(dadastr);
        
        dadastr = "20/03/2017";
        dadaint = Utils.convertirStringDataAInt(dadastr);
        mostrarConvertirStringAInt(dadastr, dadaint);
        verificacioStringAInt (dadaint, 20170320);
        
        dadaint = 20170320;
        dadastr = Utils.convertirIntDataAString(dadaint);
        mostrarConvertirIntAString(dadastr, dadaint);
        verificacioIntAString (dadastr, "20/03/2017");
        
    }
    
    void mostrarDataAvui(String valor){
        System.out.println("Avui estem a " + valor);
    }
    
    void mostrarHoraAra(String valor){
        System.out.println("Ara són les " + valor + " hores.");
    }
    
    void mostrarConvertirStringAInt(String valor, int numero){
        System.out.println("La data entrada és " + valor + " i la convertim a " + numero);
    }
    
    void mostrarConvertirIntAString (String valor, int numero){
        System.out.println("La data entrada és " + numero + " i la convertim a " + valor);
    }
    
    void verificacioStringAInt (int obtingut, int esperat){
        if (obtingut == esperat) {
            System.out.println("\\\\\\\\\\ ConvertirStringDataAInt funciona //////////");
        } else {
            System.out.println("\\\\\\\\\\ ConvertirStringDataAInt NO funciona //////////");
        }
        
    }
    
    void verificacioIntAString (String obtingut, String esperat){
        if (obtingut.equals(esperat)) {
            System.out.println("\\\\\\\\\\ ConvertirIntDataAString funciona //////////");
        } else {
            System.out.println("\\\\\\\\\\ ConvertirIntDataAString NO funciona //////////");
        }
        
    }
}
