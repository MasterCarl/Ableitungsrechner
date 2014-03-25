/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ableitungsrechner.math;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carl
 */
public class Summe extends Expandable implements Ableitbar {

    @Override
    public Ableitbar getAbleitung() {
        if (modifiedSinceConsolidation) {
            consolidate();
        }

        Summe ableitung = new Summe();

        for (Ableitbar thisMember : members) {
            ableitung.add(thisMember.getAbleitung());
        }

        ableitung.consolidate();
        return ableitung;
    }

    public void add(Produkt produkt) {
        modifiedSinceConsolidation = true;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        public void add(Summe summe) {
        modifiedSinceConsolidation = true;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consolidate() {
        boolean runAgain = true;
        while (runAgain) {
            runAgain = false;
            for (int i = 0; i < members.size() - 1; i++) {
                for (int j = i + 1; i < members.size(); j++) {
                    
                    //If the two members are of the same type, sum them
                    if(members.get(i).getClass()
                            .equals(members.get(j).getClass())) {
                        Ableitbar a = members.get(i);
                        members.remove(a);
                        Ableitbar b = members.get(j);
                        members.remove(b);
                        
                        members.add(a.sumWith(b));
                    }
                }
            }
        }
        modifiedSinceConsolidation = false;
    }

    @Override
    public Ableitbar sumWith(Ableitbar b) throws CloneNotSupportedException{
        Summe summe;
            summe = (Summe) this.clone();
        summe.add(b);
        
        return summe;
    }

    @Override
    public Ableitbar multiplyWith(Ableitbar b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
