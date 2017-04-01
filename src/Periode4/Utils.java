/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Periode4;

/**
 *
 * @author Dani
 */
import java.util.Calendar;
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
}
