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

public class Exemple2DissenyDescendent {
    public static void main(String[] args) {
        Exemple2DissenyDescendent programa = new Exemple2DissenyDescendent();
        programa.inici();
    }
    
    void inici(){
        String frase;
        int resultat;
        int digits;
        presentarAplicacio();
        frase = demanarFrase();
        //digits = entrarEnter("Seguidament indiqueu quin és el nombre de dígits minim que han de tenir els números a comptabilitzar: ");
        digits = demanarNumDigits();
        resultat = comptarNumeros(frase, digits);
        mostrarResultats(frase, digits, resultat);
    }
    
    void presentarAplicacio(){
        System.out.println("Aquesta aplicació trobarà quants números, "
                + "amb un nombre mínim de dígits, estan \n"
                + "continguts en una cadena de caràcters.\n");
    }
    
    String demanarFrase(){
        Scanner scanner = new Scanner(System.in);
        String frase;
        System.out.print("En primer lloc, introduïu una frase que "
                + "contingui paraules i números: ");
        frase = scanner.nextLine();
        System.out.println();
        return frase;
    }
    
    int demanarNumDigits(){
        int digits;
        digits = entrarEnter("Seguidament indiqueu quin és el nombre de "
                    + "dígits minim que han de tenir els números a "
                    + "comptabilitzar: ");
        System.out.println();
        return digits;
    }
    
    
    int entrarEnter(String missatge){
        Scanner scanner = new Scanner(System.in);
        int enter;
        boolean correcte=false;
        do {
            System.out.print(missatge);
            correcte=scanner.hasNextInt();
            if(!correcte){ //Comprovació dada correcte
                scanner.next();
                System.out.println("Cal entrar un valor numéric.");
            }
        }while(!correcte);
        enter = scanner.nextInt();
        scanner.nextLine();
        return enter;
    }
    
    int comptarNumeros(String frase, int numMinimDigits){
        int numDigits;
        int resultat=0;
        int posFrase=0;
        
        while(posFrase<frase.length()){
            posFrase = trobarSeguentNumero(frase, posFrase);
            numDigits = comptarDigits(frase, posFrase);
            if(numDigits>=numMinimDigits){
                resultat++;
            }
            //com a mínim el numero ocuparà el nombre de dígits, encara que és 
            //possible que ocupi més degut als caracters numèrics que no siguin 
            //dígits (.,+-)
            posFrase=trobarFinalNumero(frase, posFrase+numDigits);
        }
        return resultat;
    }
    
    void mostrarResultats(String frase, int numMinimDigits, int resultat){
        System.out.println("La frase que heu introduït: ");
        System.out.println(frase);
        System.out.println("conté " + resultat + " números amb un nombre de "
                + "dígits superior o igual a " + numMinimDigits);
        
    }   

    int trobarSeguentNumero(String frase, int posFrase) {  
         while(posFrase<frase.length() && !esDigit(frase.charAt(posFrase))){
             posFrase++;
         }
         return posFrase;
    }
    
    int comptarDigits(String frase, int posFrase) {
        int numDigits=0;
        while(posFrase<frase.length() 
                && esSimbolNumeric(frase.charAt(posFrase))){
            if(esDigit(frase.charAt(posFrase))){
                numDigits++;
            }
            posFrase++;
        }
        return numDigits;
    }     
    
    int trobarFinalNumero(String frase, int posFrase) {    
         while(posFrase<frase.length() && esSimbolNumeric(frase.charAt(posFrase))){
             posFrase++;
         }
         return posFrase;
    }
    
    boolean esDigit(char caracter) {
        return (caracter>='0' && caracter<='9'); 
    }

    boolean esSimbolNumeric(char caracter){
        return esDigit(caracter)
                || caracter=='+' 
                || caracter=='-'
                || caracter=='.'
                || caracter==',';
    }
}
