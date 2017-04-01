package Periode1;

import java.util.Scanner;

/**
 *
 * @author Dani
 */
public class A402ex3 {
    
    public static void main (String[] args){
        A402ex3 programa = new A402ex3();
        programa.inici();
    }
    
    private void inici(){
        char opcio=0;
        presentacio();
        
        //Mostrem el menu i cridem la funcio corresponent
        do{
            opcio=menu();
            executaModul(opcio);
        } while(opcio!='0');
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
    
    private void presentacio(){
        System.out.println("======================================================================");
        System.out.println("Benvinguts a la calculadora d'àrees.");
        System.out.println("Seleccioneu la figura geomèrica de la que volugueu calcular l'àrea, ");
        System.out.println("introduïu  les dades que se us dmanin i espereu el resultat.");
        System.out.println("======================================================================");
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
    
    private void executaModul(char opcio){
        switch(opcio){
        case '1':
            modulCalculAreaTriangle();
            break;
        case '2':
            modulCalculAreaQuadrat();
            break;
        case '3':
            modulCalculAreaRectangle();
            break;
        case '4':
            modulCalculAreaCercle();
        }
    }
}
