/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjecteFinal;

/**
 *
 * @author Dani
 */
public class Factura {    
    public float preuTotalParcela;
    public float preuTotalAdults;
    public float preuTotalMenors;
    public float preuTotalCotxe;
    public float preuTotalMoto;
    public float preuTotalElec;
    public float preuTotalAigua;
    
    public Factura (Parcela parcela, String diaEntrada, String diaSortida, int diesTotals, Tarifa tarifa) {
        
        //Calculem imports
        preuTotalParcela = tarifa.RetornaPreuParcela() * diesTotals;
        preuTotalAdults = tarifa.RetornaPreuAdult() * parcela.numAdults;
        preuTotalMenors = tarifa.RetornaPreuMenor() * parcela.numMenors;
        
        if (parcela.cotxe == true) {
            preuTotalCotxe = diesTotals * tarifa.RetornaPreuCotxe();
        } else {
            preuTotalCotxe = 0;
        }
        if (parcela.moto == true) {
            preuTotalMoto = diesTotals * tarifa.RetornaPreuMoto();
        } else {
            preuTotalMoto = 0;
        }
        if (parcela.xarxaElectricitat == true) {
            preuTotalElec = diesTotals * tarifa.RetornaPreuElec();
        } else {
            preuTotalElec = 0;
        }
        if (parcela.aiguaCorrent == true) {
            preuTotalAigua = diesTotals * tarifa.RetornaPreuAigua();
        } else {
            preuTotalAigua = 0;
        }       
    }
    
    public float CalcularTotalFactura() {
        return preuTotalParcela + preuTotalAdults + preuTotalMenors + preuTotalCotxe + preuTotalMoto + preuTotalElec + preuTotalAigua;
    }
    
}
