package q1ex4;

/**
 *
 * @author Hans Gabriel D. De Vera
 */
public class Q1Ex4 {

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
        Singer mafumafu = new Singer("Amatsuki", 0, 0.0, bokuraMadaUnderground, 100.0, true);
        
        // Change Name, Perform, and Change the Favorite Song
        mafumafu.setName("Mafumafu"); // Amatsuki is actually Mafumafu in disguise! :O
        mafumafu.performForAudience(12);
        mafumafu.setFavoriteSong(atorakutoRaito);
        
        // After the events
        System.out.printf("mafumafu = %s\n", mafumafu.toString());
        
        // Creating another Singer
        Singer soraru = new Singer("Soraru", 0, 0.0, bokuraMadaUnderground, 100.0, true);
        soraru.performForAudience(12);
        mafumafu.performForAudience(soraru, 10000); // Soraru and Mafumafu host an After the Rain concert for the fans! :D
        
        // Soraru and Mafumafu sing a song for the fans!
        soraru.logAction("Sore wa yume to mimagau youna.\n");
        mafumafu.logAction("Sore wa koi to mimagau youna.\n");
        
        // Print out the total number of performances
        
        System.out.printf("\n\nTotal performances: %d\n", Singer.getTotalPerformances());
    }
}