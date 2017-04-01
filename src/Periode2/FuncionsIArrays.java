/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Periode2;

/**
 *
 * @author Dani
 */
public class FuncionsIArrays {
    public static void main(String[] args) {
        //adapteu la instanciació del programa d'acord amb el fitxer on treballeu
        FuncionsIArrays prg = new FuncionsIArrays();
        prg.inici();
    }
    
        void inici(){
        /* retorn d'arrays*/
        int[] varArray;
       
        varArray = retornarArrayInicialitzat();
        System.out.print("varArray pren els valors retornats per la funció ");
        System.out.print("retornarArrayInicialitzat: ");
        printIntArray(varArray);
        
        varArray = retornarArrayInicialitzatIndicantMida(3);
        System.out.print("varArray pren els valors retornats per la funció ");
        System.out.print("retornarArrayInicialitzat: ");
        printIntArray(varArray);
    }
    
    int[] retornarArrayInicialitzat(){
        int[] valorARetornar = new int[8];
        for(int i=0; i<valorARetornar.length; i++){
            valorARetornar[i]=i*3;
        }
        return valorARetornar;
    }

    int[] retornarArrayInicialitzatIndicantMida(int mida){
        int[] valorARetornar = new int[mida];
        for(int i=0; i<valorARetornar.length; i++){
            valorARetornar[i]=0;
        }
        return valorARetornar;
    }

    void printIntArray(int[] valors){
        int limitFor = valors.length-1;
        System.out.print("{ ");
        for(int i=0; i<limitFor; i++){
            System.out.print(valors[i]);        
            System.out.print(", ");        
        }
        if(limitFor>=0){
            System.out.print(valors[limitFor]);        
        }
        System.out.println(" }");        
    }
}
