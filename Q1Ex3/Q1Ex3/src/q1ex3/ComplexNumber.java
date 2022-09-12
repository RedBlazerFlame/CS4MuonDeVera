/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1ex3;

import java.text.MessageFormat;

/**
 *
 * @author Gabee De Vera
 */
// Represents elements of the field of Complex Numbers that lie on lattice points
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
    
    // Getters and Setters
    public int getRealComponent() {
        return re;
    }
    public int getImaginaryComponent() {
        return im;
    }
    
    public void setRealComponent(int a_re) {
        re = a_re;
    }
    public void setImaginaryComponent(int a_im) {
        im = a_im;
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
}
