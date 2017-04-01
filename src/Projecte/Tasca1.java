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
public class Tasca1 {
    
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
    /*                Activitat A404 Tasca 1               */
    /*                   Codi per provar                   */
    /*******************************************************/
    public static void main(String[] args) {
        // TODO code application logic here
        Tasca1 prg = new Tasca1();
        prg.prova();
    }
    void prova() {
        String valor;
        boolean dataOk;
        
        valor = "18052017";
        dataOk = esData(valor);
        mostrarResultat(valor, 1);
        mostrarVerificacio(dataOk, false);

        valor = "18/05/2017";
        dataOk = esData(valor);
        mostrarResultat(valor, 0);
        mostrarVerificacio(dataOk, true);

        valor = "30-11-1929";
        dataOk = esData(valor);
        mostrarResultat(valor, 1);
        mostrarVerificacio(dataOk, false);

        valor = "30/11/1929";
        dataOk = esData(valor);
        mostrarResultat(valor, 0);
        mostrarVerificacio(dataOk, true);

        valor = "29/02/2001";
        dataOk = esData(valor);
        mostrarResultat(valor, 2);
        mostrarVerificacio(dataOk, false);

        valor = "20/02/2001";
        dataOk = esData(valor);
        mostrarResultat(valor, 0);
        mostrarVerificacio(dataOk, true);

        valor = "11/5/2001";
        dataOk = esData(valor);
        mostrarResultat(valor, 1);
        mostrarVerificacio(dataOk, false);

        valor = "11/05/2001";
        dataOk = esData(valor);
        mostrarResultat(valor, 0);
        mostrarVerificacio(dataOk, true);

        valor = "31/11/2025";
        dataOk = esData(valor);
        mostrarResultat(valor, 2);
        mostrarVerificacio(dataOk, false);

        valor = "30/11/2025";
        dataOk = esData(valor);
        mostrarResultat(valor, 0);
        mostrarVerificacio(dataOk, true);

        valor = "10/15/2015";
        dataOk = esData(valor);
        mostrarResultat(valor, 2);
        mostrarVerificacio(dataOk, false);

        valor = "10/12/2015";
        dataOk = esData(valor);
        mostrarResultat(valor, 0);
        mostrarVerificacio(dataOk, true);
    }
    
    void mostrarResultat(String valor, int rao){
        String[] raons = {" és correcta", " no segueix el format.", " no és vàlida"};
        System.out.print("La data ");
        System.out.print(valor);
        System.out.println(raons[rao]);
    }
    
    void mostrarVerificacio(boolean valorObtingut, boolean valorEsperat){
        if(valorObtingut==valorEsperat){
            System.out.println("*** la funció esData funciona correctament ***");
        }else{
            System.out.println("*** la funció esData no acaba de funcionar bé ***");
        }
        System.out.println();
    }
    
    
}
