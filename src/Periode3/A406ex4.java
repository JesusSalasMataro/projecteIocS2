/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Periode3;

/**
 *
 * @author Dani
 */
import java.util.Scanner;
public class A406ex4 {
    float[] valors = {4.2f, 2.5f, 3f, 1f};             
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        A406ex4 programa = new A406ex4();
        programa.cercarValor();
    }
    
    void cercarValor(){
        /* Aquest algorisme demana a l'usuari que introdueixi una col·lecció
         * de dades per teclat. Després demana que introdueixi un valor a 
         * cercar i finalment mostra per pantalla la posició dins la col·lecció
         * on es troba el valor cercat. 
         */
        Scanner scanner = new Scanner(System.in);
        int midaColleccio;
        double[] colleccio;        
        double aCercar;
        int posicio;
        boolean trobat;
        
        System.out.println("Aquest algorisme us demanarà que "
                + "introduïu una col·lecció de dades per teclat. Després "
                + "demana que introduïu un valor a cercar i finalment mostra "
                + "per pantalla la posició dins la col·lecció on es troba el "
                + "valor cercat.\n");
        System.out.println("Introduïu la mida de la col·lecció de números");
        midaColleccio = scanner.nextInt();
        
        colleccio = new double[midaColleccio];
        
        for(int i=0; i<midaColleccio; i++){
            System.out.print("\nIntrodueix el valor de la posició "+i+": ");
            colleccio[i]=scanner.nextDouble();
        }
        
        System.out.println("Ara introdueix un valor a cercar: ");
        aCercar = scanner.nextDouble();
        
        posicio=cercarPosicioValor(colleccio, aCercar);
        
        if(aCercar>=colleccio.length){
            System.out.println("El valor cercat no es troba a la col·lecció");
        }else{
            System.out.println("El valor: " + aCercar 
                    + " es troba a la posicio: " + posicio);
        }  
    }
    
    int cercarPosicioValor(double[] colleccio, double aCercar){
        boolean trobat = false;
        int posicio=0;
        
        while(posicio<colleccio.length && !trobat){
            trobat = colleccio[posicio]==aCercar;
            if(!trobat){
                posicio++;
            }
        }
        
        return posicio;
    }
}
