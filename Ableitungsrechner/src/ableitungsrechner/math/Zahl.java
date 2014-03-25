/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ableitungsrechner.math;

/**
 *
 * @author Carl
 */
public class Zahl implements Ableitbar{

    double value;

    public Zahl(){};
    public Zahl(int value) {
        this.value = value;
    }
    
    @Override
    public Ableitbar getAbleitung() {
        return new Zahl(0);
    }
    
}
