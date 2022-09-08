/*
INSTRUCTIONS
Create your own Java class (you may use as a basis the one represented by data in Exercise 01) with at least one constructor, and create three instances of that class in the main method.

Make another class called Song with at least one constructor. Determine the fields and methods that would belong to such a class and create another two instances.

Lastly, create a class called Singer with at least one constructor with the following fields and methods:

name - String
noOfPerformances - integer
earnings - double
favoriteSong - Song
performForAudience(given number of people) - increases noOfPerformances by 1 and earnings by 100 for each person (e.g. 5 people results in 500 increase)
changeFavSong(new Song) - changes favoriteSong
In the main method, make an instance of a Singer. Assign a favorite Song to the Singer, and have the Singer perform for 12 people. Then, change the favorite Song of the Singer.

Send a zip containing the project (should have 4 java files, one for each class and one with a main method). IntelliJ and Netbeans have an Export Project as ZIP option that you can use.
*/
package q1ex3;

// Represents members of the field of Complex Numbers
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
        return new ComplexNumber(im + other.im, re + other.re);
    }
}

// Represents a Song
class Song {
    // Attributes
    enum PlayState {
        PAUSED,
        PLAYING
    }
    
    private PlayState playState;
    private String name;
    private String composer;
    private int trackLengthSeconds;
    
    // Constructor
    public Song(String a_name, String a_composer, int a_trackLengthSeconds, PlayState a_initPlayState) {
        name = a_name;
        composer = a_composer;
        trackLengthSeconds = a_trackLengthSeconds;
        playState = a_initPlayState;
    }
    
    // Getters and Setters
    
    public PlayState getPlayState() {
        return playState;
    }
    
    public String getName() {
        return name;
    }
    
    public String getComposer() {
        return composer;
    }
    
    public int getTrackLengthInSeconds() {
        return trackLengthSeconds;
    }
    
    public void play() {
        playState = PlayState.PLAYING;
    }
    
    public void pause() {
        playState = PlayState.PAUSED;
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
    
}

// Represents a Singer
class Singer {
    // Attributes
    private String name;
    private int noOfPerformances;
    private double earnings;
    private Song favoriteSong;
    
    // Constructors
    
    // Getters and Setters
    
    // Methods
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
        // TODO make instances of classes
    }
    
}
