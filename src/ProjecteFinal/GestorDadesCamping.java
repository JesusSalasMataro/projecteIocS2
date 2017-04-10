
package ProjecteFinal;

/**
 *
 * @author Dani
 */
public class GestorDadesCamping {
    
    public int primeraParcelaBuida (Camping camping, int idParcela) {
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
    
    public int parcelesComprobar (Camping camping, int idParcela) {
        int idPrimeraParcelaAComprobar = -1;
        boolean parcelaPagada = false;
        int nombreParceles = camping.parceles.length;
        int i = idParcela;
        
        while (!parcelaPagada && i < nombreParceles) {
            if (camping.parceles[i].pagat == true) {
                parcelaPagada = true;
                idPrimeraParcelaAComprobar = camping.parceles[i].id;
            }
        }
        
        return idPrimeraParcelaAComprobar;
    }
    
    public void desocuparParcela (Camping camping, int idParcela) {
        camping.parceles[idParcela].dataEntrada = 0;
        camping.parceles[idParcela].numAdults = 0;
        camping.parceles[idParcela].numMenors = 0;
        camping.parceles[idParcela].cotxe = false;
        camping.parceles[idParcela].moto = false;
        camping.parceles[idParcela].xarxaElectricitat = false;
        camping.parceles[idParcela].aiguaCorrent = false;
    }
    
    public void registreParcela (Camping camping, int idParcela, int dataEntrada, int numAdults, int numMenors, boolean cotxe, boolean moto, boolean xarxaElec, boolean aigua) {
        camping.parceles[idParcela].dataEntrada = dataEntrada;
        camping.parceles[idParcela].numAdults = numAdults;
        camping.parceles[idParcela].numMenors = numMenors;
        camping.parceles[idParcela].cotxe = cotxe;
        camping.parceles[idParcela].moto = moto;
        camping.parceles[idParcela].xarxaElectricitat = xarxaElec;
        camping.parceles[idParcela].aiguaCorrent = aigua;
    }
    
    public void procesFactura(Camping camping, int idParcela, int dataPartida, Tarifa tarifa) {
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
}
