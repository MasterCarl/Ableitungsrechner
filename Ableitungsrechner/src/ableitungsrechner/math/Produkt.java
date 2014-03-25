/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ableitungsrechner.math;

/**
 *
 * @author Carl
 */
public class Produkt extends Expandable implements Ableitbar {

    @Override
    public Ableitbar getAbleitung() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void consolidate() {
        //Check if members can be consolidated
        //Check if a Variable can be added to a Potenz
        //Check if a member has the value zero, in that case set members list to Zahl(0)
        //See if there are members of the same type that can be merged
    }
    
}
