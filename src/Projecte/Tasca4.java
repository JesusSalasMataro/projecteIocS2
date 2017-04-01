/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projecte;

/**
 *
 * @author Dani
 */
//entrarCadena: mostrarà per pantalla el ext qeu rebi com a únic paràmetre i seguidament esperarà a que l'usuari 
//escrigui per teclat qualsevol text fins que premi la tecla ENTRAR

//entrarDataAmbDef: espera la entrada d'una data en format dd/mm/aaaa. comprobar el formato.
//rep dos paràmetres 1 per mostrar el missatge per pantalla abans de començar a esperar la interacció de l'usuari.
//2 es farà servir com a valor per defecte en cas qeu l'usuari escrigui una cadena buida.

//confirmarAmbDef: per confirmar amb si o no, tenint que premer ENTRAR. Retornarà un valor boolean s-true n-false
//el segon paràmetre conte el valor per defecte s o n o bé el caràcter \0.

import java.util.Scanner;
public class Tasca4 {
    String entrarCadena(String missatgeExplicatiu){
        
        String cadena;
        
        Scanner in = new Scanner ( System.in );
        
        System.out.println ( missatgeExplicatiu );
        cadena = in.nextLine();
        
        return cadena;
    }
    
    String entrarDataAmbDef(String missatgeExplicatiu, String defaultValue){
        
         String cadena;
        
        do {
            cadena = entrarCadena ( missatgeExplicatiu );
            if ( cadena.length() == 0 ) return defaultValue;  
            if ( esData(cadena )) return cadena;
        } while (true); 
    }      

    boolean confirmarAmbDef(String missatgeExplicatiu, char defaultValue){
        
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
    
    private boolean esData(String data){
        // ""dd/mm/dddd" "54/87/2584"
        // Pos 0 y 1, tienes que haber dos nuermo
        // 3 - 4 numreo
        // 6-7-8-9 numero
        boolean datacorrecte = true;
        int dia, mes, any;
        
        
        if (data.length() != 10){
            return false;
        }
               
        if (data.charAt(2) != '/' && data.charAt(5) != '/') {
           return  false;
        }
        
        int i = 0;
        do {
            if ( i == 2 || i == 5 ){
                i++; 
            }
            if ((data.charAt(i) > '9') || (data.charAt(i) < '0')) {
                return false;
            }
            i++;
        }
        while ( i < data.length());
        
        // El formato es correcto
        // Ahora separar en dias meses años
        dia = Integer.parseInt(data.substring(0, 2));
        mes = Integer.parseInt(data.substring(3, 5));
        any = Integer.parseInt(data.substring(6, 9));
        
        //System.out.println(" ------" + datacorrecte);
        
        datacorrecte = comprobarFecha(dia, mes);      
        
       // System.out.println(" ------" + datacorrecte);
        
        return datacorrecte;
        
        
        
      
    }
    
    boolean comprobarFecha ( int dia, int mes) {
        
        //System.out.println ( " -----" + dia + " "+ mes);
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if ( dia > 31 ) { 
                return false;
                }
                break;
            case 4: case 6: case 9: case 11:
                if ( dia > 30) {
                    return false;
                }
                break;
            case 2:
                if ( dia > 28 ) {
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
        
    }
    
      
    /*******************************************************/
    /*                Activitat A404 Tasca 7               */
    /*                   Codi per provar                   */
    /*******************************************************/
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tasca4 prg = new Tasca4();
        prg.prova();
    }
    
    void prova() {
        boolean confirmacio;
        String valor;
        
        //Prova la funció entrarText
        valor = entrarCadena("Entra un text qualsevol. Pot ser buit:\n");
        System.out.print("El texte entrat per teclat és: " );
        System.out.println(valor);

        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------");
        valor = entrarDataAmbDef("Entra una data qualsevol. No deixa entrar dates no valides.\nSi entres una cadena buita, retornarà \"24/03/2000\":\n"
                                      , "24/03/2000");
        System.out.print("El texte entrat per teclat és: " );
        System.out.println(valor);

        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------");
        valor = entrarDataAmbDef("Entra una data qualsevol. No deixa entrar dates no valides:\n", "");
        System.out.print("El texte entrat per teclat és: " );
        System.out.println(valor);
        
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------");
        confirmacio = confirmarAmbDef("Confirmació 1: afirmatiu per defecte. Vols confirmar? (S/n) ", 's');
        System.out.print("La resposta a la confirmació ha estat: " );
        System.out.println(confirmacio?"Si":"No");

        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------");
        confirmacio = confirmarAmbDef("Confirmació 2: negatiu per defecte. Vols confirmar? (s/N) ", 'n');
        System.out.print("La resposta a la confirmació ha estat: " );
        System.out.println(confirmacio?"Si":"No");

        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------");
        confirmacio = confirmarAmbDef("Confirmació 3: cal contestar. Vols confirmar? (s/n) ", '\0');
        System.out.print("La resposta a la confirmació ha estat: " );
        System.out.println(confirmacio?"Si":"No");

        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------");
        confirmacio = confirmarAmbDef("Confirmació 4: cal contestar. Vols confirmar? (s/n) ", '\0');
        System.out.print("La resposta a la confirmació ha estat: " );
        System.out.println(confirmacio?"Si":"No");
    }
}
