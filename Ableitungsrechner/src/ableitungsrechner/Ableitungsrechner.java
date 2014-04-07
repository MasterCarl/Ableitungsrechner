/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ableitungsrechner;

import ableitungsrechner.math.*;

/**
 *
 * @author Carl
 */
public class Ableitungsrechner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Term term = new Term();
        
            Summe summe = new Summe();
                Produkt produkt1 = new Produkt();
                produkt1.add(new Zahl(2));
                //produkt1.add(new Potenz());
            summe.add(produkt1);
        term.add(summe);
        
    }
}
