
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
        int i = 0;
        
        while (!parcelaBuida && i < nombreParceles) {
            if (camping.parceles[i].dataEntrada == 0 && camping.parceles[i].id >= idParcela) {
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
        int i = 0;
        
        while (!parcelaPagada && i < nombreParceles) {
            if (camping.parceles[i].pagat == true && camping.parceles[i].id >= idParcela) {
                parcelaPagada = true;
                idPrimeraParcelaAComprobar = camping.parceles[i].id;
            }
        }
        
        return idPrimeraParcelaAComprobar;
    }
    
    public void OcuparParcela (Camping camping, int idParcela) {
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
    
    public void calculFactura(Camping camping, Factura preus, int idParcela, int dataPartida) {
        camping.parceles[idParcela].dataSortida = dataPartida;
        String diaEntrada;
        String diaSortida;
        int diesTotals;

        diaEntrada = Utils.convertirIntDataAString(camping.parceles[idParcela].dataEntrada);
        diaSortida = Utils.convertirIntDataAString(camping.parceles[idParcela].dataSortida);
        diesTotals = Utils.calcularPeriodeEnDies(diaEntrada, diaSortida);
        
        //Calculem imports
        float preuTotalParcela = preus.preuParcela * diesTotals;
        float preuTotalAdults = preus.preuAdult * camping.parceles[idParcela].numAdults;
        float preuTotalMenors = preus.preuMenor * camping.parceles[idParcela].numMenors;
        float preuTotalCotxe;
        float preuTotalMoto;
        float preuTotalElec;
        float preuTotalAigua;
        if (camping.parceles[idParcela].cotxe == true) {
            preuTotalCotxe = diesTotals * preus.preuCotxe;
        } else {
            preuTotalCotxe = 0;
        }
        if (camping.parceles[idParcela].moto == true) {
            preuTotalMoto = diesTotals * preus.preuMoto;
        } else {
            preuTotalMoto = 0;
        }
        if (camping.parceles[idParcela].xarxaElectricitat == true) {
            preuTotalElec = diesTotals * preus.preuElec;
        } else {
            preuTotalElec = 0;
        }
        if (camping.parceles[idParcela].aiguaCorrent == true) {
            preuTotalAigua = diesTotals * preus.preuAigua;
        } else {
            preuTotalAigua = 0;
        }
        
        float totalFactura = preuTotalParcela + preuTotalAdults + preuTotalMenors + preuTotalCotxe + preuTotalMoto + preuTotalElec + preuTotalAigua;
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
        System.out.println("Parcel·la: \t\t\t" + preus.preuParcela + "\t\t" + preuTotalParcela);
        System.out.println("Nombre d'adults:" + camping.parceles[idParcela].numAdults + "\t\t" + preus.preuAdult + "\t\t" + preuTotalAdults);
        System.out.println("Nombre de menors:" + camping.parceles[idParcela].numMenors + "\t\t" + preus.preuMenor + "\t\t" + preuTotalMenors);
        System.out.println("Cotxe \t\t\t\t" + preus.preuCotxe + "\t\t" + preuTotalCotxe);
        System.out.println("Motocicleta \t\t\t" + preus.preuMoto + "\t\t" + preuTotalMoto);
        System.out.println("Electricitat \t\t\t" + preus.preuElec + "\t\t" + preuTotalElec);
        System.out.println("Aigua \t\t\t\t" + preus.preuAigua + "\t\t" + preuTotalAigua);
        System.out.println("============================================================================");
        System.out.println("\t\t\t\t\t\t Total a pagar: " + (totalFactura));  
    }
}
