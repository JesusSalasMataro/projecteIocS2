/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projecte;

/**
 *
 * @author edlobez
 */
public class Tasca2Edu {

    int calcularPeriodeEnDies(String dataInicial, String dataFinal){
        
        int dias = 0;
        
        int dia_inicial = Integer.parseInt(dataInicial.substring(0,2));
        int dia_final = Integer.parseInt(dataFinal.substring(0,2));
        int mes_inicial = Integer.parseInt(dataInicial.substring(3,5));
        int mes_final = Integer.parseInt(dataFinal.substring(3,5));
        int any_inicial= Integer.parseInt(dataInicial.substring(6,10));
        int any_final = Integer.parseInt(dataFinal.substring(6,10));
        
        if ( any_inicial < any_final ){
            for ( int i = any_inicial + 1 ; i < any_final - 1 ; i++ ) {
                dias = dias + 365;
            }
            
            dias = dias + diasDesInicioAny(dia_final, mes_final)+ diasParaFinAny(dia_inicial, mes_inicial);
        }        
        else if ( mes_inicial < mes_final ) {
            dias=  ( diasDesInicioAny(dia_final, mes_final) +  diasParaFinAny(dia_inicial, mes_inicial) )- 365;
        }       
        else {
            dias = dia_final - dia_inicial;
        }      
        
        
        return dias;   
        
        
    }
    
    int diasDesInicioAny ( int dia, int mes) {
       
        int[] diaMeses= {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};        
        int dias = 0;

        for ( int i = 1; i < mes ; i++ ) {
            dias = dias + diaMeses[i];
        }
        dias = dias + dia;        
               
        return dias;
        
    }
    
    int diasParaFinAny ( int dia, int mes ) {
        
        int dias = 0;
        int[] diaMeses= {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
           
        for ( int i = mes + 1; i < 13; i++ ) 
            dias = dias + diaMeses[i];
        
        dias = dias + diaMeses[mes] - dia;
       
        
        return dias;
    }
    
    
    
    //podeu crear altres funcions auxiliars si ho considereu necessari


    /******************************************************/
    /*                Activitat A404 Tasca 2              */
    /*                   Codi per provar                  */
    /* ****************************************************/
    public static void main(String[] args) {
        //adapteu la instanciació del programa d'acord amb el nom del fitxer (i nom de la classe) on treballeu.
        Tasca2 prg = new Tasca2();  //canvieu FuncionsIArrays pel nom del vostre fitxer.
        prg.prova();
    }

    void prova() {
        String data1;
        String data2;
        int diesPassats;

        data1 = "20/07/2018";
        data2 = "20/07/2018";
        diesPassats = calcularPeriodeEnDies(data1, data2);
        mostrarResultat(data1, data2, diesPassats);
        mostrarVerificacio(diesPassats, 0);

        data1 = "01/05/2015";
        data2 = "25/05/2015";
        diesPassats = calcularPeriodeEnDies(data1, data2);
        mostrarResultat(data1, data2, diesPassats);
        mostrarVerificacio(diesPassats, 24);

        data1 = "16/05/2017";
        data2 = "23/06/2017";
        diesPassats = calcularPeriodeEnDies(data1, data2);
        mostrarResultat(data1, data2, diesPassats);
        mostrarVerificacio(diesPassats, 38);

        data1 = "11/07/2016";
        data2 = "15/10/2017";
        diesPassats = calcularPeriodeEnDies(data1, data2);
        mostrarResultat(data1, data2, diesPassats);
        mostrarVerificacio(diesPassats, 461);

        data1 = "15/05/2015";
        data2 = "10/06/2015";
        diesPassats = calcularPeriodeEnDies(data1, data2);
        mostrarResultat(data1, data2, diesPassats);
        mostrarVerificacio(diesPassats, 26);

        data1 = "15/09/2015";
        data2 = "20/04/2016";
        diesPassats = calcularPeriodeEnDies(data1, data2);
        mostrarResultat(data1, data2, diesPassats);
        mostrarVerificacio(diesPassats, 217);

        data1 = "25/12/2015";
        data2 = "12/07/2016";
        diesPassats = calcularPeriodeEnDies(data1, data2);
        mostrarResultat(data1, data2, diesPassats);
        mostrarVerificacio(diesPassats, 199);
    }

    void mostrarResultat(String data1, String data2, int valor){
        System.out.print("Entre la data ");
        System.out.print(data1);
        System.out.print(" i la data ");
        System.out.print(data2);
        System.out.print(", hi ha ");
        System.out.println(valor);
        System.out.print(" dies.");
    }
    
    void mostrarVerificacio(int valorObtingut, int valorEsperat){
        if(valorObtingut==valorEsperat){
            System.out.println("*** la funció calcularPeriodeEnDies funciona correctament ***");
        }else{
            System.out.println("*** la funció calcularPeriodeEnDies no acaba de funcionar bé ***");
        }
        System.out.println();
    }
}
