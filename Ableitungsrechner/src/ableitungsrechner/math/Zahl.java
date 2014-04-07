/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ableitungsrechner.math;

/**
 *
 * @author Carl
 */
public class Zahl extends Ableitbar{

    double value;

    public Zahl(){};
    public Zahl(double value) {
        this.value = value;
    }
    
    @Override
    public Ableitbar getAbleitung() {
        return new Zahl(0);
    }
    public Zahl sumWith(Zahl b) {
        return new Zahl(this.value + b.value);
    }
    public Zahl multiplyWith(Zahl b) {
        return new Zahl(this.value * b.value);
    }
    
}
