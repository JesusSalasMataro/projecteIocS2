
package Periode1;

/**
 *
 * @author Dani
 */
import java.util.Scanner;
public class A402ex2 {
    public static void main (String[] args){
        A402ex2 programa = new A402ex2();
        programa.inici();
    }
    private void inici(){
        modulCalculAreaTriangle();
        modulCalculAreaQuadrat();
        modulCalculAreaRectangle();
        modulCalculAreaCercle();
        
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
    
    double calcularAreaTriangle(double base, double alcada){
        return base*alcada/2;
    }
    double calcularAreaRectangle (double base, double alcada){
        return base*alcada;
    }
    double calcularAreaQuadrat (double costat){
        return costat*costat;
    }
    double calcularAreaCercle(double radi){
        return 3.14159265*radi*radi;
    }
    
    private void modulCalculAreaTriangle(){
        double base;
        double alcada;
        double area;
        
        base = entrarUnNumero("Quina és la base del triangle? ");
        alcada = entrarUnNumero ("Quina és la alçada? ");
        
        area = calcularAreaTriangle(base, alcada);
        
        mostrarResultat("triangle", area);
    }
    
    private void modulCalculAreaRectangle(){
        double base;
        double alcada;
        double area;
        
        base = entrarUnNumero("Quina és la base del rectangle? ");
        alcada = entrarUnNumero("I l'alçada? ");
        
        area = calcularAreaRectangle(base, alcada);
        
        mostrarResultat("rectangle", area); 
    }
    
    private void modulCalculAreaQuadrat() {
        double costat;
        double area;
        costat = entrarUnNumero("Quant mesura el costat del quadrat? ");
             
        area = calcularAreaQuadrat(costat);
        
        mostrarResultat("quadrat", area);        
    }
    
    private void modulCalculAreaCercle() {
        double radi;
        double area;
        radi = entrarUnNumero("Quant mesura el radi del cercle? ");
             
        area = calcularAreaCercle(radi);
        
        mostrarResultat("cercle", area);        
    }
}
