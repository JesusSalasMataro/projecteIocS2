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
    
    static int mostrarMenu (String titolMenu, String[] opcions, String tornarSortir){
        int seleccio, numOpcions;
        Scanner scanner = new Scanner(System.in);
        // Deberíamos usarla para todos los menús, según número de opciones
        System.out.println(titolMenu);
        
        numOpcions = opcions.length;
        for (int i = 1; i <= numOpcions; i++) {
            System.out.println(opcions[i] + " (" + String.valueOf(i) + ")");
        }
        
        System.out.println(tornarSortir + " (0)");
        
        seleccio = -1;
        while (seleccio < 0 || seleccio > numOpcions) {
            seleccio = scanner.nextInt();
        }
        
        return seleccio;
    }
    
    static void afegirFiles (){
        for (int i = 0; i < 20; i++){
            System.out.println("");
        } 
    }
    
    static void missatgeError (){
        //TODO: cambiar a paràmetro y hacer de llamar la atencion mas
        System.out.println("*********Hi ha hagut un error**********");
    }
    
    static void missatgeExit (){
        //TODO: cambiar a paràmetro y hacer de llamar la atencion mas
        System.out.println("L'execució s'ha realitzat amb èxit");
        
    }
    
    static void esperarEntrar (){
        
        Scanner scanner = new Scanner(System.in);
        String tecla = scanner.nextLine();
        
        while (!tecla.equals("")) {
            tecla = scanner.nextLine();
        }            
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
