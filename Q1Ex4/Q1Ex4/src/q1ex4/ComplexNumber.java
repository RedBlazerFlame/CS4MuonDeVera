
package q1ex4;

import java.text.MessageFormat;

/**
 * Represents elements of the field of Complex Numbers that lie on lattice points
 * @author Hans Gabriel D. De Vera
 */
public class ComplexNumber {
    // Class Attributes
    
    /// Imaginary Component
    private int im;
    
    /// Real Component
    private int re;
    
    // Constructors
    public ComplexNumber(int a_re, int a_im) {
        im = a_im;
        re = a_re;
    }
    
    // Accessors
    // Note that there are no mutators since I intend the
    // ComplexNumber class to be immutable
    public int getRe() {
        return re;
    }
    public int getIm() {
        return im;
    }
    
    // Methods
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(re + other.re, im + other.im);
    }
    
    public ComplexNumber sub(ComplexNumber other) {
        return new ComplexNumber(re - other.re, im - other.im);
    }
    
    public ComplexNumber mul(ComplexNumber other) {
        return new ComplexNumber(re * other.re - im * other.im, re * other.im + im * other.re);
    }
    
    public ComplexNumber mul(int other) {
        return new ComplexNumber(re * other, im * other);
    }
    
    public String toString() {
        return MessageFormat.format("{0} + {1}i", re, im);
    }
    
    // Static Methods
    public static ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        return a.add(b);
    }
    
    public static ComplexNumber sub(ComplexNumber a, ComplexNumber b) {
        return a.sub(b);
    }
    
    public static ComplexNumber mul(ComplexNumber a, ComplexNumber b) {
        return a.mul(b);
    }
    
    public static ComplexNumber mul(ComplexNumber a, int b) {
        return a.mul(b);
    }
    
    public static ComplexNumber mul(int a, ComplexNumber b) {
        return b.mul(a);
    }
    
    // There is no division operator since the set of complex numbers
    // with integral real and imaginary parts is not closed under it
}