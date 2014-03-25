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
public class Term extends Expandable implements Ableitbar{

    ArrayList<Ableitbar> members = new ArrayList();
    
    public Ableitbar getAbleitung() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*public Ableitbar getMember(int i)   {
        return members.get(i);
    }*/

    @Override
    public void consolidate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
