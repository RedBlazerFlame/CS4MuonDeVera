package q1ex3;

/**
 *
 * @author Gabee De Vera
 */
// Represents a Song
public class Song {
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
