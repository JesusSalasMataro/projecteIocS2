package ProjecteFinal;

/**
 *
 * @author Dani
 */
import java.util.Calendar;
import java.util.Scanner;
public class Utils {
    
    static String obtenirDataAvui(){
        Calendar calendar = Calendar.getInstance();
        
        /*
        return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) 
                + "/" 
                + String.valueOf(calendar.get(Calendar.MONTH) + 1)
                + "/" 
                + String.valueOf(calendar.get(Calendar.YEAR)); */
        
        return String.format("%td/%tm/%tY", calendar, calendar, calendar);
    }
    
    static String obtenirHoraAra(){
        Calendar calendar = Calendar.getInstance();
        
        return String.format("%tH:%tM", calendar, calendar);
    }
    
    static int convertirStringDataAInt(String data){
        String stringData;
        stringData = data.substring(6,10);
        stringData += data.substring(3,5);
        stringData += data.substring(0,2);
        
        return Integer.valueOf(stringData);
    }
    
    static String convertirIntDataAString(int data){
        String datastr = "";
        //Extreiem i convertim els int de la dreta corresponents al dia en String
        datastr += String.format("%02d", data%100);
        //Retallem el dia per a que quedi aaaamm
        data /= 100;
        datastr += "/";
        //Extreiem i convertim els int de la dreta corresponents al mes en String
        datastr += String.format("%02d", data%100);
        //Retallem els dies per a que quedi aaaa
        data /= 100;
        datastr += "/";
        //Extreiem i convertim els int que queden corresponents a l'any en String
        datastr += String.format("%04d", data);
        return datastr;
        
    }
    
    static boolean esData(String data){
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
    
    static boolean comprobarFecha ( int dia, int mes) {
        
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

    static int trobarPrimeraFilaCoincidentAPartirDe(int[][] matriu, 
                                                int valorAComparar, 
                                                int columnaOnComparar, 
                                                int cercarDesDeFila){
        /*La funció trobarPrimeraFilaConicidentAPartirDe rebrà una matriu d'enters, un valor enter qeu servirè per a comparar-lo amb els valors
        de les columnes situades on indiqui el paràmetre columnaOnComparar i retornarà la posició de la primera fila coincident.
        La cerca es començarà sempre a partir de la posició indicada en el paràmetre cercarDesDeFila. En cas qeu no existeixi cap fila amb un 
        valor coincident, es retornarà -1. */
        
        //Codifiqueu aquí el vostre codi
    int pos = cercarDesDeFila;
        while ( pos < matriu.length ) {
            if ( matriu [pos][columnaOnComparar] == valorAComparar) {                
                return pos;
            }            
            pos++;            
        }
        
        return -1;
    }
    
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
}
