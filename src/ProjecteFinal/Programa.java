/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjecteFinal;

import java.util.Scanner;

/**
 *
 * @author Dani
 */
public class Programa {
    public static void main (String[] args){

        int tipusTarifa = EscollirTarifa();
        Tarifa tarifa = new Tarifa(tipusTarifa);
        Camping camping = new Camping();
        
        mostrarMenuPrincipal(camping);
    }
    
    public static int EscollirTarifa() {
        int tipusTarifa = -1;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introdueix el tipus de tarifa.");
        System.out.println("1 ...");
        System.out.println("2 ...");
        
        while (tipusTarifa != 1 && tipusTarifa != 2) {
            tipusTarifa = scanner.nextInt();
        }
        
        return tipusTarifa;
    }
    
    public static void mostrarMenuPrincipal(Camping camping) {
        int opcio;     
        // TODO: rellenar opciones, títulos
        String[] opcionsMenu = new String[4];
        opcionsMenu[0] = "";
        opcionsMenu[1] = "";
        opcionsMenu[2] = "";
        opcionsMenu[3] = "";
        
        BibliotecaInterficieUsuari.mostraTitol("");
        opcio = BibliotecaInterficieUsuari.mostrarMenu("", opcionsMenu, "Sortir");
        
        if (opcio == 1) {
            mostrarMenuRegistreClient(camping);
        }
    }
    
    public static void mostrarMenuRegistreClient(Camping camping) {
        
    }
    
}
