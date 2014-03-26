/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ableitungsrechner.math;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carl
 */
public class Produkt extends Expandable implements Ableitbar {

    @Override
    public Ableitbar getAbleitung() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consolidate() {
        //Check if an element has the value zero, in that case set elements list to Zahl(0)
        for (int i = 0; i < elements.size(); i++) {
            if(elements.get(i) instanceof Zahl) {
                Zahl zahl = (Zahl) elements.get(i);
                if(zahl.value == 0) {
                    elements.clear();
                    elements.add(new Zahl(0));
                }
            }
        }
        //Check if a Variable can be added to a Potenz
                        //TODO
        //Check if elements can be consolidated
        for (int i = 0; i < elements.size() - 1; i++) {
            for (int j = i + 1; i < elements.size(); j++) {
                        
                //If the two elements are of the same type, multiply them
                if (elements.get(i).getClass()
                        .equals(elements.get(j).getClass())) {
                    Ableitbar a = elements.get(i);
                    elements.remove(a);
                    Ableitbar b = elements.get(j);
                    elements.remove(b);

                    try {

                        elements.add(a.multiplyWith(b));
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(Summe.class.getName()).log(Level.SEVERE, null, ex);
                        elements.add(a);
                        elements.add(b);
                    }
                }
                if (elements.size() > 1) {
                    //restart the loop
                    i = 0;
                    j = 1;
                }
            }
        }
        modifiedSinceConsolidation = false;

    }

    @Override
    public Ableitbar sumWith(Ableitbar b) throws CloneNotSupportedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ableitbar multiplyWith(Ableitbar b) throws CloneNotSupportedException {
        Produkt produkt = (Produkt) this.clone();
        produkt.multiplyWith(b);
        produkt.consolidate();
        //If the product contains a single item, return that
        if (produkt.elements.size() == 1) {
            return produkt.elements.get(0);
        }
        return produkt;
    }

}
