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
        
        mostrarMenuPrincipal(camping, tarifa);
    }
    
    public static int EscollirTarifa() {
        int tipusTarifa = -1;
        BibliotecaInterficieUsuari.mostraTitol("Selecció tarifa");
        System.out.println("Introdueix el tipus de tarifa.");
        System.out.println("1 Tarifa Temporada Baixa");
        System.out.println("2 Tarifa Temporada Alta");
        
        while (tipusTarifa != 1 && tipusTarifa != 2) {
            tipusTarifa = Utils.demanarEnter();
        }
        //TODO: ajustar filas
        BibliotecaInterficieUsuari.afegirFiles(15);
        //TODO: añadir para ir a menu principal
        return tipusTarifa;
    }
    
    public static void mostrarMenuPrincipal(Camping camping, Tarifa tarifa) {
        int opcio = -1;     
        
        String[] opcionsMenu = new String[4];
        opcionsMenu[0] = "Registre Client";
        opcionsMenu[1] = "Sortida Client";
        opcionsMenu[2] = "Control Parcel·les";
        opcionsMenu[3] = "Canvi Tarifa";
        BibliotecaInterficieUsuari.afegirFiles(15);
        BibliotecaInterficieUsuari.mostraTitol("Menú Principal");
        
        while (opcio != 0) {
            opcio = BibliotecaInterficieUsuari.mostrarMenu(opcionsMenu, "Sortir");

            switch (opcio) {
                case 1:
                    mostrarMenuRegistreClient(camping, tarifa);
                    break;
                case 2:
                    mostrarSortidaClient(camping, tarifa);
                    break;
                case 3:
                    //Informacio parceles
                    mostrarMenuControlParcela(camping, tarifa);
                    break;
                case 4:
                    EscollirTarifa();
                    break;
            }
        }
    }
    
    public static void mostrarMenuRegistreClient(Camping camping, Tarifa tarifa) {
        int opcio;
        
        String[] opcionsRegistre = new String[2];
        opcionsRegistre[0] = "Primera Parcel·la Buida";
        opcionsRegistre[1] = "Registre Parcel·la";
        BibliotecaInterficieUsuari.afegirFiles(15);
        BibliotecaInterficieUsuari.mostraTitol("Registre Client");
        opcio = BibliotecaInterficieUsuari.mostrarMenu(opcionsRegistre, "Tornar");
        
        if (opcio == 1) {
            BibliotecaInterficieUsuari.mostraTitol("Primera Parcel·la buida");
            GestorDadesCamping.mostraPriParBuida(camping, tarifa); 
        } else if (opcio == 2){
            BibliotecaInterficieUsuari.mostraTitol("Registre Parcel·la");
            GestorDadesCamping.entradaParcela(camping, tarifa);
        } else {
            mostrarMenuPrincipal(camping, tarifa);
        }
    }
    
    public static void mostrarSortidaClient(Camping camping, Tarifa tarifa){
        int numPar, dataSortida, pagat;
        String data;
        BibliotecaInterficieUsuari.afegirFiles(15);
        BibliotecaInterficieUsuari.mostraTitol("Sortida Client");
        System.out.print("Número Parcel·la: ");
        numPar = Utils.demanarEnter();
        data = BibliotecaInterficieUsuari.entrarCadena("Data Sortida: ");
        dataSortida = Utils.convertirStringDataAInt(data);
        GestorDadesCamping.procesFactura(camping, numPar, dataSortida, tarifa);
        System.out.print("Queda pagat? 1 (Si) 2 (No) ");
        pagat = Utils.demanarEnter();
        while (pagat != 1 && pagat != 2){
            pagat = Utils.demanarEnter();
        }
        if (pagat == 1){
            camping.parceles[numPar].pagat = true;
        } else {
            camping.parceles[numPar].pagat = false;
        }
        
        
        BibliotecaInterficieUsuari.missatgeExit();
        System.out.println("prem 'Entrar' per a continuar");
        BibliotecaInterficieUsuari.esperarEntrar();
        Programa.mostrarMenuPrincipal(camping, tarifa);
        
    }
    
    public static void mostrarMenuControlParcela(Camping camping, Tarifa tarifa) {
        int opcio;
        
        String[] opcionsRegistre = new String[3];
        opcionsRegistre[0] = "Parcel·les Buides";
        opcionsRegistre[1] = "Parcel·les a Controlar";
        opcionsRegistre[2] = "Buidar Parcel·les";
        BibliotecaInterficieUsuari.afegirFiles(15);
        BibliotecaInterficieUsuari.mostraTitol("Control Parcel·les");
        opcio = BibliotecaInterficieUsuari.mostrarMenu(opcionsRegistre, "Tornar");
        
        if (opcio == 1) {
            BibliotecaInterficieUsuari.mostraTitol("Parcel·les buides");
            GestorDadesCamping.mostraPriParBuida(camping, tarifa); 
        } else if (opcio == 2){
            BibliotecaInterficieUsuari.mostraTitol("Parcel·les a Controlar");
            GestorDadesCamping.mostraParcelesControl(camping, tarifa);
        } else if (opcio == 3) {
            //TODO: Vaciar parcela
            GestorDadesCamping.buidarParcela(camping, tarifa);
        } else {
            mostrarMenuPrincipal(camping, tarifa);
        }
    }
}
