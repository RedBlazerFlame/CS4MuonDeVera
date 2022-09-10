package q1ex3;

import java.text.MessageFormat;

// Represents elements of the field of Complex Numbers that lie on lattice points
class ComplexNumber {
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

// Represents a Song
class Song {
    // Attributes
    private String name;
    private String composer;
    private int trackLengthSeconds;
    
    // Constructor
    public Song(String a_name, String a_composer, int a_trackLengthSeconds) {
        name = a_name;
        composer = a_composer;
        trackLengthSeconds = a_trackLengthSeconds;
    }
    
    // Getters and Setters
    
    public String getName() {
        return name;
    }
    
    public String getComposer() {
        return composer;
    }
    
    public int getTrackLengthInSeconds() {
        return trackLengthSeconds;
    }
    
    public void setName(String a_songName) {
        name = a_songName;
    }
    
    public void setComposer(String a_composerName) {
        composer = a_composerName;
    }
    
    public void setTrackLengthSeconds(int seconds) {
        trackLengthSeconds = seconds;
    }
    
    public void setTrackLength(int minutes, int seconds) {
        trackLengthSeconds = minutes * 60 + seconds;
    }
    
    public String toString() {
        return String.format("Song {\n\tname: %s\n\tcomposer: %s\n\ttrackLength: %02d:%02d\n}", name, composer, trackLengthSeconds / 60, trackLengthSeconds % 60);
    }
}

// Represents a Singer
class Singer {
    // Attributes
    private String name;
    private int noOfPerformances;
    private double earnings;
    private Song favoriteSong;
    private double earningsPerPerson;
    private boolean logActions;
    
    // Constructors
    public Singer(String a_name, int a_performances, double a_earnings, Song a_favoriteSong, double a_earningsPerPerson, boolean a_logActions) {
        name = a_name;
        noOfPerformances = a_performances;
        earnings = a_earnings;
        favoriteSong = a_favoriteSong;
        earningsPerPerson = a_earningsPerPerson;
        logActions = a_logActions;
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public int getNumPerformances() {
        return noOfPerformances;
    }
    
    public double getEarnings() {
        return earnings;
    }
    
    public Song getFavSong() {
        return favoriteSong;
    }
    
    public void setName(String a_name) {
        logAction(String.format("singer's name is now %s\n", a_name));
        name = a_name;
    }
    
    public void setEarningsPerPerson(double a_earningsPerPerson) {
        logAction(String.format("singer now earns %f money per person\n", a_earningsPerPerson));
        earningsPerPerson = a_earningsPerPerson;
    }
    
    public void changeFavSong(Song a_song) {
        logAction(String.format("favorite song changed to %s\n", a_song.getName()));
        favoriteSong = a_song;
    }
    
    public void shouldLogActions(boolean a_logActions) {
        logActions = a_logActions;
    }
    
    // Methods
    public void performForAudience(int numPeople) {
        double earningsFromPerformance = numPeople * earningsPerPerson;
        noOfPerformances ++;
        earnings += earningsFromPerformance;
        logAction(String.format("singer performed for %d human%s and earned %f money. Singer now has %f money\n", numPeople, (numPeople == 1 ? "" : "s"), earningsFromPerformance, earnings));
    }
    
    public String toString() {
        return String.format("Singer {\n\tname: %s\n\tnoOfPerformances : %d\n\tearnings: %f\n\tearningsPerPerson: %f\n\tfavoriteSong: %s\n}", name, noOfPerformances, earnings, earningsPerPerson, favoriteSong.toString());
    }
    
    public void logAction(String log) {
        if(logActions) {
            System.out.printf("Singer Log (%s): %s", name, log);
        }
    }
}

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
