package Periode2;

/**
 *
 * @author Dani
 */
import java.util.Scanner;
public class A403ex3 {
    public static void main (String[] args) {
        A403ex3 prg = new A403ex3();
        prg.inici();

    }
    
    void inici () {
        
        //pedir tamaño del array
        Scanner scanner = new Scanner (System.in);
        System.out.print("De quin tamany vols l'array? ");
        int tamany = scanner.nextInt();
        String [] arrayString = iniArray(tamany);
        printStringArray(arrayString);
              
    }
      
    String [] iniArray(int tamany){
        String [] ArrayString = new String [tamany];
        for (int i = 0; i<tamany; i++){
            ArrayString [i] = "";
        }
        return ArrayString;
    }
    
    void printStringArray(String[] valors){
        int limitFor = valors.length-1;
        System.out.print("{ ");
        for(int i=0; i<limitFor; i++){
            System.out.print(valors[i]);        
            System.out.print(", ");        
        }
        if(limitFor>=0){
            System.out.print(valors[limitFor]);        
        }
        System.out.println(" }");        
    }
}
