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
import java.util.Scanner;
public class A501Tasca1 {
    
    public static void main (String[] args) {
        A501Tasca1 prg = new A501Tasca1();
        prg.inici();
    }
    
    void inici(){
        int numeroDades;
        float[] temperatures;
        int minim;
        numeroDades = quantitatDades("Quantes temperatures vols omplir? ");
        temperatures = omplirArray("Entra el valor de les temperatures", "Temperatura", numeroDades); 
        minim = valorMinim(temperatures);
        mostrarResultat (minim, "Temperatura", "mínima");
        
    }
    
    int quantitatDades(String missatge){
        Scanner scanner = new Scanner(System.in);
        System.out.print(missatge);
        int mida = scanner.nextInt();
        
        return mida;
    }
    
    float [] omplirArray(String missatge, String tipusValor, int mida){
        Scanner scanner = new Scanner(System.in);
        float[] valors = new float[mida];
        System.out.println(missatge);
        for(int i=0; i<valors.length; i++){
            System.out.print(tipusValor + " " + (i+1) + ": ");
            valors[i]=scanner.nextFloat();
        }
        
        return valors;
    }
    int valorMinim(float[] valors){
        int posMin;
        
        posMin=0;
        for(int i=1; i<valors.length; i++){
            if(valors[posMin]>valors[i]){
                posMin=i;
            }
        }
        
        return posMin;
    }
    
    void mostrarResultat(int resultat, String tipusValor, String tipusResultat){
            
        System.out.println(tipusValor + " " + tipusResultat + " és: " +  resultat);
    }
}
