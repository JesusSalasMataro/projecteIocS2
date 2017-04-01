/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projecte;

/**
 *
 * @author edlobez
 */
public class Tasca3Edu {

    int trobarPrimeraFilaCoincidentAPartirDe(int[][] matriu, 
                                                int valorAComparar, 
                                                int columnaOnComparar, 
                                                int cercarDesDeFila){
        //Codifiqueu aquí el vostre codi
        
        int pos = cercarDesDeFila;
        while ( pos < matriu.length ) {
            if ( matriu [pos][columnaOnComparar] == valorAComparar) {                
                return pos;
            }            
            pos++;            
        }
        
        return -1;
    }
    
    /*******************************************************/
    /*                Activitat A404 Tasca 3               */
    /*                   Codi per provar                   */
    /*******************************************************/
    public static void main(String[] args) {
        // TODO code application logic here
        Tasca3 prg = new Tasca3(); 
        prg.prova();
    }
    void prova(){
        int resposta;
        int[][] valors = {
            {0,0,0,0,0,0,0,0},        //0
            {1,20161001,1,0,0,0,0,0}, //1
            {2,20161001,2,2,1,0,1,0}, //2
            {0,0,0,0,0,0,0,0},        //3
            {2,20161001,4,2,1,0,1,1}, //4
            {2,20161001,0,0,0,0,0,0}, //5
            {1,0,0,0,0,0,0,0},        //6
            {1,20161001,0,0,0,0,0,0}, //7
            {2,20161001,2,1,1,0,0,0}  //8
        };

        resposta = trobarPrimeraFilaCoincidentAPartirDe(valors, 0, 1, 0);
        mostrarResultat(0, resposta, 0, 1);
        mostrarVerificacio(resposta, 0);
        resposta = trobarPrimeraFilaCoincidentAPartirDe(valors, 0, 1, 2);
        mostrarResultat(2, resposta, 0, 1);
        mostrarVerificacio(resposta, 3);
        resposta = trobarPrimeraFilaCoincidentAPartirDe(valors, 0, 1, 4);
        mostrarResultat(4, resposta, 0, 1);
        mostrarVerificacio(resposta, 6);
        resposta = trobarPrimeraFilaCoincidentAPartirDe(valors, 0, 1, 7);
        mostrarResultat(7, resposta, 0, 1);
        mostrarVerificacio(resposta, -1);        
    }

    void mostrarResultat(int cercatDesDe, int resposta, int valorComparat, int columnaComparada){
        System.out.print("La primera fila trobada amb la columna ");
        System.out.print(columnaComparada);
        System.out.print(" de valor ");
        System.out.print(valorComparat);
        System.out.print(" des de la posicio ");
        System.out.print(cercatDesDe);
        System.out.print(" ha estat: ");
        System.out.print(resposta);
        System.out.println(".");
    }
    
    void mostrarVerificacio(int valorObtingut, int valorEsperat){
        if(valorObtingut == valorEsperat){
            System.out.println("*** la funció calcularPeriodeEnDies funciona correctament ***");
        }else{
            System.out.println("*** la funció calcularPeriodeEnDies no acaba de funcionar bé ***");
        }
        System.out.println();
    }
}
