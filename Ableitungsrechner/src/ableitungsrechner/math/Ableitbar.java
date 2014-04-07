/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ableitungsrechner.math;

/**
 *
 * @author Carl
 */
public abstract class Ableitbar {

    public abstract Ableitbar getAbleitung();

        public Ableitbar sumWith(Ableitbar b) throws CloneNotSupportedException{
        Summe summe = new Summe();
        summe.add(this);
        summe.add(b);
        summe.consolidate();
        //If there's only one element left, return that instead
        if(summe.elements.size()==1) {
            //...except if it's the number zero
            if(summe.elements.get(0) instanceof Zahl) {
                Zahl zahl = (Zahl) summe.elements.get(0);
                if(zahl.value==0) return null;
            }
            return summe.elements.get(0);
        }
        
        return summe;
    
    };
    
    public Ableitbar multiplyWith(Ableitbar b) throws CloneNotSupportedException {
        Produkt produkt = new Produkt();
        produkt.add(this);
        produkt.add(b);
        produkt.consolidate();
        //If the product contains a single item, return that
        if (produkt.elements.size() == 1) {
            return produkt.elements.get(0);
        }
        return produkt;
    }
;
}
