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
public class Summe extends Expandable{

    @Override
    public Ableitbar getAbleitung() {
        if (modifiedSinceConsolidation) {
            consolidate();
        }

        Summe ableitung = new Summe();

        for (Ableitbar thisMember : elements) {
            ableitung.add(thisMember.getAbleitung());
        }

        ableitung.consolidate();
        return ableitung;
    }

    @Override
    public void add(Ableitbar a) {
        modifiedSinceConsolidation = true;
        elements.add(a);
    }

    @Override
            public void consolidate() {

            for (int i = 0; i < elements.size() - 1; i++) {
                for (int j = i + 1; i < elements.size(); j++) {
                    
                    //If the two elements are of the same type, sum/multiply/whatever them
                    if(elements.get(i).getClass()
                            .equals(elements.get(j).getClass())) {
                        Ableitbar a = elements.get(i);
                        elements.remove(a);
                        Ableitbar b = elements.get(j);
                        elements.remove(b);
                        
                        try {
                            elements.add(a.sumWith(b));   
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(Summe.class.getName()).log(Level.SEVERE, null, ex);
                            elements.add(a);
                            elements.add(b);
                        }
                    }
                    if(elements.size()>1)    {
                    //restart the loop
                    i = 0;
                    j = 1;
                    }
                }
            }
        modifiedSinceConsolidation = false;
    }
            public Summe sumWith(Summe b) throws CloneNotSupportedException   {
                Summe summe = (Summe) this.clone();
                summe.elements.addAll(b.elements);
                summe.consolidate();
                return summe;
            }
            public Summe multiplyWith(Summe b) throws CloneNotSupportedException   {
                //Summe summe = (Summe) this.clone();
                throw new UnsupportedOperationException("Not yet supported.");
            }
}
