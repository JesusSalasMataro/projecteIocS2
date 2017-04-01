/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Periode3;

/**
 *
 * @author Dani
 */
public class A406ex1 {
    public int cercarPosicioValor(double[] colleccio, double aCercar){
        boolean trobat = false;
        int posicio=0;
        
        while(posicio<colleccio.length && !trobat){
            trobat = colleccio[posicio]==aCercar;
            posicio++;
        }
        
        return posicio;
    }
}
