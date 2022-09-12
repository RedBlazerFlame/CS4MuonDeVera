package q1ex3;

import java.text.MessageFormat;

/**
 *
 * @author Hans Gabriel D. De Vera
 */
public class Q1Ex3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creating some Complex Numbers
        System.out.println("Complex Numbers\n");
        ComplexNumber a = new ComplexNumber(0, 1); // Represents i
        ComplexNumber b = new ComplexNumber(1, 0); // Represents 1
        
        // Equivalent to 1 + i^2 = 0
        // Note that the add static method instantiates a Complex Number in its implementation
        // Thus, c is a new instance of a complex number
        ComplexNumber c = ComplexNumber.add(b, ComplexNumber.mul(a, a));
        
        // Printing the Complex Numbers
        System.out.printf("a = %s\n", a.toString());
        System.out.printf("b = %s\n", b.toString());
        System.out.printf("c = b + a^2 = %s\n", c.toString());
        
        
        
        // Creating some Songs
        System.out.println("\n\nSongs\n");
        
        Song bokuraMadaUnderground = new Song("Bokura Mada Underground", "Eve", 284);
        Song atorakutoRaito = new Song("Attract Light", "*Luna", 272);
        
        // Printing out the songs
        System.out.printf("bokuraMadaUnderground = %s\n", bokuraMadaUnderground.toString());
        System.out.printf("atorakutoRaito = %s\n", atorakutoRaito.toString());
        
        
        
        // Creating a Singer
        System.out.println("\n\nSingers\n");
        Singer amatsuki = new Singer("Amatsuki", 0, 0.0, bokuraMadaUnderground, 100.0, true);
        
        // Change Name, Perform, and Change the Favorite Song
        amatsuki.setName("Mafumafu"); // Amatsuki is actually Mafumafu in disguise! :O
        amatsuki.performForAudience(12);
        amatsuki.changeFavSong(atorakutoRaito);
        
        // After the events
        System.out.printf("amatsuki = %s\n", amatsuki.toString());
    }
}
