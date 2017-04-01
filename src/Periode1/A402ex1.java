package Periode1;

/**
 *
 * @author Dani
 */
import java.util.Scanner;
public class A402ex1 {
    public static void main (String[] args){
        A402ex1 programa = new A402ex1();
        programa.inici();
    }
    private void inici(){
        double mida;
        char opcio=0;
        
        presentacio();
        mida = entrarUnNumero("Entreu la mida del costat del quadrat: ");
        
        System.out.print("La mesura entrada és: ");
        System.out.println(mida);
        
        mostrarResultat ("Cercle", 28.51);
        
        opcio = menu();
        
        System.out.print("La opció escollida és: ");
        System.out.println(opcio);
        
    }
    
    private double entrarUnNumero(String missatge){
        Scanner scanner = new Scanner(System.in);
        double ret; //No sé porque el nombre ret
        boolean correcte=false;
        do {
            System.out.print(missatge);
            correcte=scanner.hasNextDouble();
            if(!correcte){ //Comprovació dada correcte
                scanner.next();
                System.out.println("Cal que entrar un valor numéric.");
            }
        }while(!correcte);
        ret = scanner.nextDouble();
        scanner.nextLine();
        return ret;
    }
    
    private void mostrarResultat (String tipus, double resultat){
        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.print("L'àrea del ");
        System.out.print(tipus);
        System.out.print(" val: ");
        System.out.println(resultat);
        System.out.println("---------------------------------------------------");
        System.out.println();
    }
    
    private char menu (){
        Scanner scanner = new Scanner(System.in);
        String line;
        char opcio=0;
        System.out.println("---------------------------------------");
        System.out.println("         Menú càlcul àrees");
        System.out.println("---------------------------------------");
        System.out.println("1. Triangle");
        System.out.println("2. Quadrat");
        System.out.println("3. Rectangle");
        System.out.println("4. Cercle");
        System.out.println("0. Sortir");
        System.out.println();
        System.out.print("Escull una opció i prem [ENTRAR]: ");
        line = scanner.nextLine();
        //Evitem l'error si l'usuari prem només [ENTRAR]
        if(line.length()>0){
            opcio = line.charAt(0);
        }
        return opcio;
    }
    
    private void presentacio(){
        System.out.println("======================================================================");
        System.out.println("Benvinguts a la calculadora d'àrees.");
        System.out.println("Seleccioneu la figura geomèrica de la que volugueu calcular l'àrea, ");
        System.out.println("introduïu  les dades que se us dmanin i espereu el resultat.");
        System.out.println("======================================================================");
        System.out.println();
    }
}
