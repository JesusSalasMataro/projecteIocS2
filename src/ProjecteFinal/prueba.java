/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjecteFinal;

/**
 *
 * @author Dani
 */
public class prueba {
    public static void main (String[] args){
        System.out.println("Data d'entrada: " 
                        + "24/02/2017" 
                        + "\t\t\t" 
                        + "Data de Sortida: "
                        + "14/03/2017"
                        );
        System.out.println("Nombre de dies a facturar: " + 18);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("conceptes a facturar \t preu unitari per dia \t total");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Parcel·la: \t\t\t" + 15.00 + "\t\t" + 270.00);
        System.out.println("Nombre d'adults:" + 4 + "\t\t" + 6.80 + "\t\t" + 489.60);
        System.out.println("Nombre de menors:" + 4 + "\t\t" + 5.5 + "\t\t" + 396.00);
        System.out.println("Cotxe \t\t\t\t" + 6.00 + "\t\t" + 108.00);
        System.out.println("Motocicleta \t\t\t" + 4.30 + "\t\t" + 77.40);
        System.out.println("Electricitat \t\t\t" + 6.00 + "\t\t" + 108.00);
        System.out.println("Aigua \t\t\t\t" + 5.00 + "\t\t" + 90.00);
        System.out.println("============================================================================");
        System.out.println("\t\t\t\t\t\t Total a pagar: " + 1539.00);  
    }
}
