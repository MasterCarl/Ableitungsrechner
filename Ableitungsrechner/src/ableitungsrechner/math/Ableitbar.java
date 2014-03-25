/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ableitungsrechner.math;

/**
 *
 * @author Carl
 */
public interface Ableitbar {
    public Ableitbar getAbleitung();
    public Ableitbar sumWith(Ableitbar b) throws CloneNotSupportedException;
    public Ableitbar multiplyWith(Ableitbar b) throws CloneNotSupportedException;
}
