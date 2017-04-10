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
public class Tarifa {
    private float preuParcela = 15f;
    private float preuAdult = 6.80f;
    private float preuMenor = 5.5f;
    private float preuCotxe = 6f;
    private float preuMoto = 4.3f;
    private float preuElec = 6f;
    private float preuAigua = 5f;
    
    public Tarifa (int tipusTarifa) {
        if (tipusTarifa == 1) {
            FixarPreusTemporadaBaixa();
        }
        else {
            FixarPreusTemporadaAlta();
        }
    }
    
    private void FixarPreusTemporadaBaixa() {
        preuParcela = 10f;
        preuAdult = 4.80f;
        preuMenor = 3.75f;
        preuCotxe = 4f;
        preuMoto = 2.3f;
        preuElec = 5f;
        preuAigua = 3f;           
    }
    
    private void FixarPreusTemporadaAlta() {
        preuParcela = 15f;
        preuAdult = 6.80f;
        preuMenor = 5.5f;
        preuCotxe = 6f;
        preuMoto = 4.3f;
        preuElec = 6f;
        preuAigua = 5f;        
    }
    
    public float RetornaPreuParcela() {
        return preuParcela;
    }
    
    public float RetornaPreuAdult() {
        return preuAdult;
    }    
    
    public float RetornaPreuMenor() {
        return preuMenor;
    }
    public float RetornaPreuCotxe() {
        return preuCotxe;
    }
    
    public float RetornaPreuMoto() {
        return preuMoto;
    }
    
    public float RetornaPreuElec() {
        return preuElec;
    }
    
    public float RetornaPreuAigua() {
        return preuAigua;
    }
}
