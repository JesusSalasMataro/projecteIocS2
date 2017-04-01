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
//Funció que calculi el nombre de dies que hi ha entre dues dates
//Entre en format String dd/mm/aaaa
//Tots els anys tenen 365 dies i sempre febrer té 28
//Pista 1: 
public class Tasca2 {

    static int calcularPeriodeEnDies(String dataInicial, String dataFinal) {
        //Codifiqueu aquí
        String datosIniciales[] = dataInicial.split("/");
        String datosFinales[] = dataFinal.split("/");

        int dia_inicial = Integer.parseInt(datosIniciales[0]);
        int mes_inicial = Integer.parseInt(datosIniciales[1]);
        int año_inicial = Integer.parseInt(datosIniciales[2]);

        int dia_final = Integer.parseInt(datosFinales[0]);
        int mes_final = Integer.parseInt(datosFinales[1]);
        int año_final = Integer.parseInt(datosFinales[2]);
        
        int dias_pasados;
        
        dias_pasados = dia_final - dia_inicial;
        
        if(mes_inicial<mes_final){
            for(int i=mes_inicial;i<mes_final;i++){
                dias_pasados += numeroDeDiasMes(i);
            }
        }else{
            for(int i=mes_inicial;i>mes_final;i--){
                dias_pasados -= numeroDeDiasMes(i);
            }
        }
        
        dias_pasados += (año_final - año_inicial)*365;
        
        return dias_pasados;
    }

    public static int numeroDeDiasMes(int mes) {

        int numeroDias = -1;

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numeroDias = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numeroDias = 30;
                break;
            case 2:
                numeroDias = 28;
                break;

        }

        return numeroDias;
    }

    //podeu crear altres funcions auxiliars si ho considereu necessari
    /**
     * ***************************************************
     */
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

    void mostrarResultat(String data1, String data2, int valor) {
        System.out.print("Entre la data ");
        System.out.print(data1);
        System.out.print(" i la data ");
        System.out.print(data2);
        System.out.print(", hi ha ");
        System.out.println(valor);
        System.out.print(" dies.");
    }

    void mostrarVerificacio(int valorObtingut, int valorEsperat) {
        if (valorObtingut == valorEsperat) {
            System.out.println("*** la funció calcularPeriodeEnDies funciona correctament ***");
        } else {
            System.out.println("*** la funció calcularPeriodeEnDies no acaba de funcionar bé ***");
        }
        System.out.println();
    }
}
