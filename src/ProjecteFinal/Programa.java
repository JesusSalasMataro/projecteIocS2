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
        
        System.out.println("Introdueix el tipus de tarifa.");
        System.out.println("1 Tarifa Temporada Baixa");
        System.out.println("2 Tarifa Temporada Alta");
        
        while (tipusTarifa != 1 && tipusTarifa != 2) {
            tipusTarifa = Utils.demanarEnter();
        }
        //TODO: ajustar filas
        BibliotecaInterficieUsuari.afegirFiles(15);
        return tipusTarifa;
    }
    
    public static void mostrarMenuPrincipal(Camping camping) {
        int opcio;     
        
        String[] opcionsMenu = new String[4];
        opcionsMenu[0] = "Registre Client";
        opcionsMenu[1] = "Sortida Client";
        opcionsMenu[2] = "Informació Parcel·les";
        opcionsMenu[3] = "Canvi Tarifa";
        
        BibliotecaInterficieUsuari.mostraTitol("Menú Principal");
        opcio = BibliotecaInterficieUsuari.mostrarMenu(opcionsMenu, "Sortir");
        
        switch (opcio) {
            case 1:
                mostrarMenuRegistreClient(camping);
                break;
            case 2:
                //sortida client
                break;
            case 3:
                //Informacio parceles
                break;
            case 4:
                //canvi tarifa
                BibliotecaInterficieUsuari.mostraTitol("Selecció tarifa");
                EscollirTarifa();
                break;
        } 
    }
    
    public static void mostrarMenuRegistreClient(Camping camping) {
        int opcio;
        //TODO: rellenar titulo y opciones
        String[] opcionsRegistre = new String[2];
        opcionsRegistre[0] = "Primera Parcel·la Buida";
        opcionsRegistre[1] = "";
        
        BibliotecaInterficieUsuari.mostraTitol("asdjd");
        opcio = BibliotecaInterficieUsuari.mostrarMenu(opcionsRegistre, "Tornar");
        
        if (opcio == 1) {
            BibliotecaInterficieUsuari.mostraTitol("Parcela vacia");
            int seguentParcela = 0;
            int numParcelesVisualitzades = 0;
            
            while (seguentParcela != -1) {
                seguentParcela = GestorDadesCamping.primeraParcelaBuida(camping, seguentParcela);                
                
                if (numParcelesVisualitzades % 5 != 0 && seguentParcela != -1) {
                    System.out.print(",");
                }
                
                if (seguentParcela != -1) {
                    System.out.print("\t" + Integer.toString(seguentParcela));
                    numParcelesVisualitzades++;

                    if (numParcelesVisualitzades % 5 == 0) {
                        System.out.println();
                    }                  
                }

                if (seguentParcela != -1) {
                    seguentParcela++;
                }
            }
            
            System.out.println();
            
        } else {
            //Registro parcela
        }
    }
    
}
