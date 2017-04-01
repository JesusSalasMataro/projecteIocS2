package Periode3;

/**
 *
 * @author Dani
 */

import java.util.Scanner;
public class A405ex2 {
    
    static final int VALOR_FIXAT = 30;
    public static void main(String[] args){
        A405ex2 programa = new A405ex2();
        programa.inici();
    }
    
    void inici(){
        int intents;
        boolean jocGuanyat;
        
        presentacioJoc();
        intents = demanarIntents();
        jocGuanyat = executarJoc(intents);
        mostrarResultat(jocGuanyat);
    }
    
    void mostrarResultat(boolean haGuanyat){
        if (haGuanyat) {
            System.out.println("Has encertat.");
        }
        else {
            System.out.println("Has perdut.");
        }
    }
    
    
    boolean executarJoc(int intents){
        int intentsGastats = 0;
        boolean haGuanyat = false;
        int proposta;
        
        while ((intentsGastats < intents)&& !haGuanyat ) {
            proposta = entrarEnter("Entrar un enter: ");
            if (proposta < VALOR_FIXAT){
                System.out.println("T'has quedat curt.");
            } 
            else if (proposta > VALOR_FIXAT) {
                System.out.println("T'has passat.");
            } 
            else {            
                haGuanyat = true;
            }
            intentsGastats++;
        }     
        return haGuanyat;
    }
    
    void presentacioJoc(){
        System.out.println("Amb aquest programa podrás jugar a encertar un número de l'1 al 100.");
        System.out.println("El límit d'intents el posaràs tu. Seràs capaç? ");
    }
    
    int demanarIntents(){
        int intents;
        intents = entrarEnter("Amb quants intents màxims creieu que endevinareu?");
        System.out.println();
        return intents;
    }
    
    
    int entrarEnter(String missatge){
        Scanner scanner = new Scanner(System.in);
        int enter;
        boolean correcte=false;
        do {
            System.out.print(missatge);
            correcte=scanner.hasNextInt();
            if(!correcte){ //Comprovació dada correcte
                scanner.next();
                System.out.println("Cal entrar un valor numéric.");
            }
        }while(!correcte);
        enter = scanner.nextInt();
        scanner.nextLine();
        return enter;
    }
}
