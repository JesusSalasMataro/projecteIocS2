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
public class Camping {
    private final int MAX_PARCELES = 15;
    
    public Parcela[] parceles;
    
    public Camping() {
        parceles = new Parcela[MAX_PARCELES];
    }
}
