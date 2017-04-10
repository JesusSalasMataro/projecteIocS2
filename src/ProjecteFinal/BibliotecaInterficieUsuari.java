/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjecteFinal;

import static ProjecteFinal.Utils.esData;
import java.util.Scanner;

/**
 *
 * @author Dani
 */
public class BibliotecaInterficieUsuari {
    
    static void mostraTitol (String titol){
        
        System.out.println("**************************" +
                            titol +
                            "**************************");
    }
    
    static int mostrarMenu (String opcio1, String opcio2, String opcio3){
        int seleccio;
        Scanner scanner = new Scanner(System.in);
        // Deberíamos usarla para todos los menús, según número de opciones
        System.out.println("Quin color de cinturó té?:");
        System.out.println(opcio1 + " (1)");
        System.out.println(opcio2 + " (2)");
        System.out.println(opcio3 + " (3)");
        System.out.print(":");
        seleccio = scanner.nextInt();
        return seleccio;
    }
    
    static void afegirFiles (){
        for (int i = 0; i < 20; i++){
            System.out.println("");
        } 
    }
    
    static void missatgeError (){
        System.out.println("Hi ha hagut un error");
    }
    
    static void missatgeExit (){
        System.out.println("L'execució s'ha realitzat amb èxit");
        
    }
    
    static void textVisible (String premEntrar){
        // no se como poner que tenga que clicar enter para llamar a la función afegirFiles()
        /*if ( premEntrar == ENTRAR)
        También podría hacerlo con un do, pero entonces la función sería boolean
        */
    }
    
    
    static String entrarCadena(String missatgeExplicatiu){
        
        String cadena;
        
        Scanner in = new Scanner ( System.in );
        
        System.out.println ( missatgeExplicatiu );
        cadena = in.nextLine();
        
        return cadena;
    }
    
    static String entrarDataAmbDef(String missatgeExplicatiu, String defaultValue){
        
         String cadena;
        
        do {
            cadena = entrarCadena ( missatgeExplicatiu );
            if ( cadena.length() == 0 ) return defaultValue;  
            if ( esData(cadena )) return cadena;
        } while (true); 
    }      

    static boolean confirmarAmbDef(String missatgeExplicatiu, char defaultValue){
        
        String cadena;       
        
        do {
            cadena = entrarCadena ( missatgeExplicatiu ).toLowerCase();
            if ( cadena.length() == 0 && defaultValue != '\0' ) 
                return (defaultValue == 's' 
                    ||  defaultValue == 'S');
            if ( cadena.startsWith("s") ) return true;
            if ( cadena.startsWith("n") ) return false;     
            
        }while ( true );
    }
}
