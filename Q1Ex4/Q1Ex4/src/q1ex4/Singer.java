package q1ex4;

/**
 * Represents a Singer
 * @author Hans Gabriel D. De Vera
 */
public class Singer {
    // Static Fields
    private static int totalPerformances = 0;
    
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
    
    public int getNoOfPerformances() {
        return noOfPerformances;
    }
    
    public double getEarnings() {
        return earnings;
    }
    
    public Song getFavoriteSong() {
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
    
    public void setFavoriteSong(Song a_song) {
        logAction(String.format("favorite song changed to %s\n", a_song.getName()));
        favoriteSong = a_song;
    }
    
    public void shouldLogActions(boolean a_logActions) {
        logActions = a_logActions;
    }
    
    /// No setter for earnings, since the only way the singer should be able to get money
    /// Is through performances
    
    // Methods
    public void performForAudience(int numPeople) {
        // Update the total number of performances
        totalPerformances ++;
        
        // Compute earnings and change the # of performances for this singer
        double earningsFromPerformance = numPeople * earningsPerPerson;
        noOfPerformances ++;
        earnings += earningsFromPerformance;
        logAction(String.format("singer performed for %d human%s and earned %f money. Singer now has %f money\n", numPeople, (numPeople == 1 ? "" : "s"), earningsFromPerformance, earnings));
    }
    
    public void performForAudience(Singer otherSinger, int numPeople) {
        // Update the total number of performances
        totalPerformances ++;
        
        // Compute total earnings
        double earningsFromPerformance = numPeople * (earningsPerPerson + otherSinger.earningsPerPerson);
        
        // Changing the # of performances for both singers
        noOfPerformances ++;
        
        // Updating earnings
        // Singers split the money equally, hence the division by 2
        earnings += earningsFromPerformance / 2;
        otherSinger.earnings += earningsFromPerformance / 2;
        
        // Log out the event
        logAction(String.format("singer performed for %d human%s with singer %s and earned %f money. Singer now has %f money\n", numPeople, (numPeople == 1 ? "" : "s"), otherSinger.name, earningsFromPerformance / 2, earnings));
        otherSinger.logAction(String.format("singer performed for %d human%s with singer %s and earned %f money. Singer now has %f money\n", numPeople, (numPeople == 1 ? "" : "s"), name, earningsFromPerformance / 2, otherSinger.earnings));
    }
    
    public String toString() {
        return String.format("Singer {\n\tname: %s\n\tnoOfPerformances : %d\n\tearnings: %f\n\tearningsPerPerson: %f\n\tfavoriteSong: %s\n}", name, noOfPerformances, earnings, earningsPerPerson, favoriteSong.toString());
    }
    
    public void logAction(String log) {
        if(logActions) {
            System.out.printf("Singer Log (%s): %s", name, log);
        }
    }
    
    // Static Methods
    public static int getTotalPerformances() {
        return totalPerformances;
    }
}
