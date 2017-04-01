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
public class A403ex1 {
    public static void main(String[] args) {
    //adapteu la instanciació del programa d'acord amb el nom del fitxer (i nom de la classe) on treballeu.
    A403ex1 prg = new A403ex1();  //canvieu FuncionsIArrays pel nom del vostre fitxer.
    prg.inici();
    }

    void inici(){
        double[] valors ={2.5, 8.34, 1.42, 7.59, 3.22, 4.57, 12.5, 6.01, 5.54, 8.31};
        /* Operar amb els valors d'una col·lecció*/
        double valorMitja;
        valorMitja = valorMitja(valors);
        System.out.print("El valor mitjà de la col·lecció de doubles és: ");
        System.out.println(valorMitja); //El valor que ha de sortir és 6.0

        /* Obtenir un valor d'una col·lecció */
        double valorMinim;
        valorMinim = valorMinim(valors);
        System.out.print("El valor mínim de la col·lecció de doubles és: ");
        System.out.println(valorMinim); //El valor mínim és 1.42

        /* Obtenir la posició en comptes del valor */
        int posicioNotaMaxima;
        double[] notes ={2.5, 8.34, 1.42, 7.69, 9.26, 5.57, 1.0, 6.01};
        String[] alumnes ={"Albert", "Rosalia", "Jaume", "Maria", "Joana", 
                           "Francesc", "Ramon", "Berta"};
        posicioNotaMaxima = posicioMaxim(notes);
        System.out.print("L'alumne/a ");
        System.out.print(alumnes[posicioNotaMaxima]);
        System.out.print(" ha tret un ");
        System.out.print(notes[posicioNotaMaxima]);
        System.out.println(", que és la nota màxima."); //la nota màxima l'ha tret la Joana
    }
    
    double valorMitja(double[] valors){
        double suma = 0;
        for(int i=0; i<valors.length; i++){
            suma+=valors[i];
        }
        return suma/valors.length;
    }
    
    double valorMinim(double[] valors){
        double minim = valors[0];
        for (int i=0; i<valors.length; i++){
            if(valors[i]<minim){
                minim=valors[i];
            }
        }
        return minim;
    }
    
    int posicioMaxim(double[] valors){ //es int para que cuadre con el tipo del array posiciNotaMaxima
        int maxim = 0;
        for(int i=1; i<valors.length; i++){
            if(valors[i]>valors[maxim]){ //Ponemos "valors[maxim]" para marcar la posición y no el valor.
                maxim=i;
            }
        }
        return maxim;
    }
}
