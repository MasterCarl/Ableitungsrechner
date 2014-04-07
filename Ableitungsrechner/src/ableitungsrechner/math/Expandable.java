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
public abstract class Expandable extends Ableitbar{
    
    public ArrayList<Ableitbar> elements = new ArrayList();
    boolean modifiedSinceConsolidation = false;

    public abstract void consolidate();

    public void add(Ableitbar a) {
        modifiedSinceConsolidation = true;
        elements.add(a);
    }
}
