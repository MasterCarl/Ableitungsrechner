/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ableitungsrechner.math;

import java.util.ArrayList;

/**
 *
 * @author Carl
 */
public abstract class Expandable {
    
    public ArrayList<Ableitbar> members = new ArrayList();
    boolean modifiedSinceConsolidation = false;

    public abstract void consolidate();

    public void add(Ableitbar a) {
        modifiedSinceConsolidation = true;
        members.add(a);
    }
}
