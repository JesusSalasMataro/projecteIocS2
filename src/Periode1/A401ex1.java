
package Periode1;

/**
 *
 * @author Dani
 */
import java.util.Scanner;
public class A401ex1 {
    public static void main (String[] args) {
        A401ex1 programa = new A401ex1();
        //Es crida el métode inici per començar a executar
        programa.inici();
    }
    
    public void inici(){
        //variables de les funcions
        int mes;
        int diesMes;
        
        //Cridem la funció demanarMes sense parámetres
        mes = demanarMes();
        //Cridem la funció calcularDiesQueTeElMes
        diesMes = calcularDiesQueTeElMes(mes);
        //Cridem la funció per mostrar els dies del mes
        mostrarDiesDelMes (mes, diesMes);
        
        
    }
    
    //Creem la funció demanarMes, per tal que demani a l'usuari que escrigui un mes i retorna el valor de l'usuari.
    public int demanarMes(){
        int mesUsuari;
        Scanner scanner = new Scanner (System.in);
        System.out.println("Indica el nombre d'un mes per saber quants dies té: ");
        mesUsuari = scanner.nextInt();
        return mesUsuari;
    }
    //Creem la funció calcularDiesQueTeElMes on calcularem els díes del mes que ens indica l'usuari
    public int calcularDiesQueTeElMes(int mes) {
        int numDiesMes = 0;
        switch(mes) {
            case 1:
                numDiesMes = 31;
                break;
            case 2:
                numDiesMes = 28;
                break;
            case 3:
                numDiesMes = 31;
                break;
            case 4:
                numDiesMes = 30;
                break;
            case 5:
                numDiesMes = 31;
                break;
            case 6:
                numDiesMes = 30;
                break;
            case 7:
                numDiesMes = 31;
                break;
            case 8:
                numDiesMes = 31;
                break;
            case 9:
                numDiesMes = 30;
                break;
            case 10:
                numDiesMes = 31;
                break;
            case 11:
                numDiesMes = 30;
                break;
            case 12:
                numDiesMes = 31;
                break;
        }
        return numDiesMes;    
            
    }
    //Creem la funció que ens mostri el mes numericament i els dies del més
    public void mostrarDiesDelMes(int mes, int diesMes) {
        System.out.print("T'informem que el mes ");
        System.out.print(mes);
        System.out.print(" conté ");
        System.out.print(diesMes);
        System.out.println(" dies");
    }
        
    }

