package q1ex4;

/**
 * Represents a Song
 * @author Hans Gabriel D. De Vera
 */
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
    
    // Accessors and Mutators
    public String getName() {
        return name;
    }
    
    public String getComposer() {
        return composer;
    }
    
    public int getTrackLengthSeconds() {
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
    
    public void setTrackLengthSeconds(int minutes, int seconds) {
        trackLengthSeconds = minutes * 60 + seconds;
    }
    
    // Methods
    public String toString() {
        return String.format("Song {\n\tname: %s\n\tcomposer: %s\n\ttrackLength: %02d:%02d\n}", name, composer, trackLengthSeconds / 60, trackLengthSeconds % 60);
    }
}
