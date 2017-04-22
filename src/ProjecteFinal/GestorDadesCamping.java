
package ProjecteFinal;

/**
 *
 * @author Dani
 */
public class GestorDadesCamping {
    
    public static int primeraParcelaBuida (Camping camping, int idParcela) {
        boolean parcelaBuida = false;
        int nombreParceles = camping.parceles.length;
        int idPrimeraParcelaBuida = -1;
        int i = idParcela;
        
        while (!parcelaBuida && i < nombreParceles) {
            if (camping.parceles[i].dataEntrada == 0) {
                parcelaBuida = true;
                idPrimeraParcelaBuida = camping.parceles[i].id;
            }
            
            i++;
        }
        
        return idPrimeraParcelaBuida;
    }
    
    public static int parcelesComprobar (Camping camping, int idParcela) {
        int idPrimeraParcelaAComprobar = -1;
        boolean parcelaPagada = false;
        int nombreParceles = camping.parceles.length;
        int i = idParcela;
        
        while (!parcelaPagada && i < nombreParceles) {
            if (camping.parceles[i].pagat == true) {
                parcelaPagada = true;
                idPrimeraParcelaAComprobar = camping.parceles[i].id;
            }
            i++;
        }
        
        return idPrimeraParcelaAComprobar;
    }
    
    public static void desocuparParcela (Camping camping, int idParcela) {
        camping.parceles[idParcela].dataEntrada = 0;
        camping.parceles[idParcela].numAdults = 0;
        camping.parceles[idParcela].numMenors = 0;
        camping.parceles[idParcela].cotxe = false;
        camping.parceles[idParcela].moto = false;
        camping.parceles[idParcela].xarxaElectricitat = false;
        camping.parceles[idParcela].aiguaCorrent = false;
        camping.parceles[idParcela].pagat = false;
        camping.parceles[idParcela].dataSortida = 0;
    }
    
    public static void registreParcela (Camping camping, int idParcela, int dataEntrada, int numAdults, int numMenors, boolean cotxe, boolean moto, boolean xarxaElec, boolean aigua) {
        camping.parceles[idParcela].dataEntrada = dataEntrada;
        camping.parceles[idParcela].numAdults = numAdults;
        camping.parceles[idParcela].numMenors = numMenors;
        camping.parceles[idParcela].cotxe = cotxe;
        camping.parceles[idParcela].moto = moto;
        camping.parceles[idParcela].xarxaElectricitat = xarxaElec;
        camping.parceles[idParcela].aiguaCorrent = aigua;
        camping.parceles[idParcela].parcelaBuida = false;
    }
    
    public static void procesFactura(Camping camping, int idParcela, int dataPartida, Tarifa tarifa) {
        camping.parceles[idParcela].dataSortida = dataPartida;
        
        String diaEntrada;
        String diaSortida;
        int diesTotals;
        
        diaEntrada = Utils.convertirIntDataAString(camping.parceles[idParcela].dataEntrada);
        diaSortida = Utils.convertirIntDataAString(camping.parceles[idParcela].dataSortida);
        diesTotals = Utils.calcularPeriodeEnDies(diaEntrada, diaSortida);        

        Factura factura = new Factura(camping.parceles[idParcela], diaEntrada, diaSortida, diesTotals, tarifa);

        //Mostrem la factura
        
        System.out.println("Data d'entrada: " 
                        + diaEntrada 
                        + "\t\t\t" 
                        + "Data de Sortida: "
                        + diaSortida
                        );
        System.out.println("Nombre de dies a facturar: " + diesTotals);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("conceptes a facturar \t preu unitari per dia \t total");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Parcel·la: \t\t\t" + tarifa.RetornaPreuParcela() + "\t\t" + factura.preuTotalParcela);
        System.out.println("Nombre d'adults:" + camping.parceles[idParcela].numAdults + "\t\t" + tarifa.RetornaPreuAdult() + "\t\t" + factura.preuTotalAdults);
        System.out.println("Nombre de menors:" + camping.parceles[idParcela].numMenors + "\t\t" + tarifa.RetornaPreuMenor() + "\t\t" + factura.preuTotalMenors);
        System.out.println("Cotxe \t\t\t\t" + tarifa.RetornaPreuCotxe() + "\t\t" + factura.preuTotalCotxe);
        System.out.println("Motocicleta \t\t\t" + tarifa.RetornaPreuMoto() + "\t\t" + factura.preuTotalMoto);
        System.out.println("Electricitat \t\t\t" + tarifa.RetornaPreuElec() + "\t\t" + factura.preuTotalElec);
        System.out.println("Aigua \t\t\t\t" + tarifa.RetornaPreuAigua() + "\t\t" + factura.preuTotalAigua);
        System.out.println("============================================================================");
        System.out.println("\t\t\t\t\t\t Total a pagar: " + (factura.CalcularTotalFactura()));  
    }
    
    public static void mostraPriParBuida (Camping camping, Tarifa tarifa){
        System.out.println("****************************************************************************");
        System.out.print("**\t\t\t");
        System.out.print("Llista de parcel·les buides");
        System.out.println("\t\t\t**");
        System.out.println("****************************************************************************");
        System.out.println();
        System.out.println("Data: " + Utils.obtenirDataAvui() + "\tHora: " + Utils.obtenirHoraAra());
        System.out.println();
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Els números de les parcel·les buides són:");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println();
        int seguentParcela = 0;
        int numParcelesVisualitzades = 0;

        while (seguentParcela != -1) {
            seguentParcela = GestorDadesCamping.primeraParcelaBuida(camping, seguentParcela);                

            if (numParcelesVisualitzades % 5 != 0 && seguentParcela != -1) {
                System.out.print(",");
            }

            if (seguentParcela != -1) {
                System.out.print("\t" + Integer.toString(seguentParcela));
                numParcelesVisualitzades++;

                if (numParcelesVisualitzades % 5 == 0) {
                    System.out.println();
                }                  
            }

            if (seguentParcela != -1) {
                seguentParcela++;
            }
        }
            
        System.out.println();
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("prem 'Entrar' per a continuar");
        BibliotecaInterficieUsuari.esperarEntrar();
        Programa.mostrarMenuRegistreClient(camping, tarifa);
    }
    
    public static void entradaParcela (Camping camping, Tarifa tarifa){
        int numPar, dataInt, numAdults, numMenors, cotxe, moto, elec, aigua;
        String data;
        boolean cotxeBool, motoBool, elecBool, aiguaBool;
        cotxeBool = motoBool = elecBool = aiguaBool = false;
        cotxe = moto = elec = aigua = -1;
        System.out.print("Número Parcel·la: ");
        numPar = Utils.demanarEnter();
        data = BibliotecaInterficieUsuari.entrarCadena("Data entrada(dd/mm/aaaa): ");
        dataInt = Utils.convertirStringDataAInt(data);
        System.out.print("Número Adults: ");
        numAdults = Utils.demanarEnter();
        System.out.print("Número Menors: ");
        numMenors = Utils.demanarEnter();
        System.out.print("Entra Cotxe? (Si (1) No (2)): ");
        while (cotxe != 1 && cotxe != 2) {
            cotxe = Utils.demanarEnter();
        }
        if (cotxe == 1){
            cotxeBool = true;
        }
        System.out.print("Entra Moto? (Si (1) No (2)): ");
        while (moto != 1 && moto != 2) {
            moto = Utils.demanarEnter();
        }
        if (cotxe == 1){
            motoBool = true;
        }
        System.out.print("Utilitza Xarxa elèctrica (Si (1) No (2)): ");
        while (elec != 1 && elec != 2) {
            elec = Utils.demanarEnter();
        }
        if (elec == 1){
            elecBool = true;
        }
        System.out.print("Utilitza Aigua corrent (Si (1) No (2)): ");
        while (aigua != 1 && aigua != 2) {
            aigua = Utils.demanarEnter();
        }
        if (aigua == 1){
            aiguaBool = true;
        }
        registreParcela(camping, numPar, dataInt, numAdults, numMenors, cotxeBool, motoBool, elecBool, aiguaBool);
        
        BibliotecaInterficieUsuari.missatgeExit();
        System.out.println("prem 'Entrar' per a continuar");
        BibliotecaInterficieUsuari.esperarEntrar();
        Programa.mostrarMenuRegistreClient(camping, tarifa);
    }
    
    public static void mostraParcelesControl (Camping camping, Tarifa tarifa){
    System.out.println("****************************************************************************");
    System.out.print("**\t\t\t");
    System.out.print("Llista de parcel·les a control");
    System.out.println("\t\t\t**");
    System.out.println("****************************************************************************");
    System.out.println();
    System.out.println("Data: " + Utils.obtenirDataAvui() + "\tHora: " + Utils.obtenirHoraAra());
    System.out.println();
    System.out.println("----------------------------------------------------------------------------");
    System.out.println("Els números de les parcel·les a controlar:");
    System.out.println("----------------------------------------------------------------------------");
    System.out.println();
    int seguentParcela = 0;
    int numParcelesVisualitzades = 0;

    while (seguentParcela != -1) {
        seguentParcela = parcelesComprobar(camping, seguentParcela);                

        if (numParcelesVisualitzades % 5 != 0 && seguentParcela != -1) {
            System.out.print(",");
        }

        if (seguentParcela != -1) {
            System.out.print("\t" + Integer.toString(seguentParcela));
            numParcelesVisualitzades++;

            if (numParcelesVisualitzades % 5 == 0) {
                System.out.println();
            }                  
        }

        if (seguentParcela != -1) {
            seguentParcela++;
        }
    }

    System.out.println();
    System.out.println("----------------------------------------------------------------------------");
    System.out.println("prem 'Entrar' per a continuar");
    BibliotecaInterficieUsuari.esperarEntrar();
    Programa.mostrarMenuControlParcela(camping, tarifa);
    }
    
    public static void buidarParcela (Camping camping, Tarifa tarifa){
        int numPar, continuar;
        BibliotecaInterficieUsuari.mostraTitol("Desocupar Parcel·la");
        System.out.print("Número Parcel·la: ");
        numPar = Utils.demanarEnter();
        desocuparParcela(camping, numPar);
        System.out.print("vols desocupar més parcel·les? 1 (Si) 2(No)");
        continuar = Utils.demanarEnter();
        while (continuar != 1 && continuar != 2) {
            continuar = Utils.demanarEnter();
        }
        if (continuar == 1){
            buidarParcela(camping, tarifa);
        } else {
            Programa.mostrarMenuControlParcela(camping, tarifa);
        }
    }
}
