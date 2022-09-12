package q1ex3;

/**
 *
 * @author Gabee De Vera
 */
// Represents a Singer
public class Singer {
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
    
//    private String name;
//    private int noOfPerformances;
//    private double earnings;
//    private Song favoriteSong;
//    private double earningsPerPerson;
//    private boolean logActions;
    
    public String getName() {
        return name;
    }
    
    public int getNumPerformances() {
        return noOfPerformances;
    }
    
    public double getEarnings() {
        return earnings;
    }
    
    public Song getFavoriteSong() {
        return favoriteSong;
    }
    
    public double getEarningsPerPerson() {
        return earningsPerPerson;
    }
    
    public void setName(String a_name) {
        logAction(String.format("singer's name is now %s\n", a_name));
        name = a_name;
    }
    
    public void setEarningsPerPerson(double a_earningsPerPerson) {
        logAction(String.format("singer now earns %f money per person\n", a_earningsPerPerson));
        earningsPerPerson = a_earningsPerPerson;
    }
    
    public void setFavoriteSong(Song a_song) {
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
