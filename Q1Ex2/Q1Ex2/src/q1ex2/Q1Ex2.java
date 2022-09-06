// package q1ex2;

import java.util.Scanner;

/**
 *
 * @author Hans Gabriel D. De Vera
 */
class Random {
    /**
     * Generates a random number in the range [a, b]
     * 
     * @param a the inclusive lower bound
     * @param b the inclusive upper bound
     */
    public static int randInt(int a, int b) {
        // Swap arguments if they're in the wrong order
        if (a > b) {
            int temp = b;
            b = a;
            a = temp;
        }

        // Return a random number in the range [a, b]
        return (int) Math.floor(Math.random() * (b - a + 1)) + a;
    }
}

class InputUtils {
    /**
     * A function that emulates the behavior of sc.nextInt
     * 
     * @param sc the scanner to use
     */
    public static int nextInt(Scanner sc) {
        return Integer.parseInt(sc.nextLine());
    }
}

class MathUtils {
    /**
     * Checks if a number c is in the range [a, b]
     * 
     * @param a the inclusive lower bound of the interval
     * @param b the inclusive upper bound of the interval
     * @param c the value to test
     */
    public static boolean inRange(int a, int b, int c) {
        // Swap arguments if a > b
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        return a <= c && c <= b;
    }
}

class Settings {
    // Attributes
    private int lowerBound;
    private int upperBound;
    private int numGuesses;
    
    // Constructor
    /**
     * A constructor that will initialize all setting fields
     * 
     * @param a_lowerBound the lower bound of the random number
     * @param a_upperBound the upper bound of the random number
     * @param a_numGuesses the number of guesses per round
     */
    public Settings(int a_lowerBound, int a_upperBound, int a_numGuesses) {
        lowerBound = a_lowerBound;
        upperBound = a_upperBound;
        numGuesses = a_numGuesses;
    }
    
    // Getters and Setters
    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    /**
     * Sets the lower and upper bound of the random number.
     * This setter ensures that lowerBound <= upperBound.
     * 
     * @param a_lowerBound new lower bound of random numbers
     * @param a_upperBound new upper bound of random numbers
     * @return {@link Settings}
     */
    public Settings setBounds(int a_lowerBound, int a_upperBound) {
        // Ensuring that lower bound gets the lower value and vice versa
        if(a_lowerBound < a_upperBound) {
            lowerBound = a_lowerBound;
            upperBound = a_upperBound;
        } else {
            lowerBound = a_upperBound;
            upperBound = a_lowerBound;
        }

        return this;
    };

    public int getNumGuesses() {
        return numGuesses;
    }
    
    /**
     * Sets the number of guesses per game
     * 
     * @param a_numGuesses new number of guesses per game
     * @return
     */
    public Settings setNumGuesses(int a_numGuesses) {
        if(a_numGuesses > 0) {
            numGuesses = a_numGuesses;
        }
        return this;
    }
}

class Subroutines {

    /**
     * Shows the main menu
     * 
     * @param sc the scanner to use for input
     * @param settings the settings object of the current game instance
     */
    public static void showMenu(Scanner sc, Settings settings) {
        // Showing options
        System.out.println("Welcome to Higher or Lower! What will you do?\n-Start game\n-Change settings\n-End application");
        String action = sc.nextLine();
        String actionLowerCase = action.toLowerCase();
        
        if(actionLowerCase.equals("start game")) {
            startGame(sc, settings);
        } else if(actionLowerCase.equals("change settings")) {
            changeSettings(sc, settings);
        } else if(actionLowerCase.equals("end application")) {
            endApplication();
        } else {
            System.out.println("Invalid Action");
        }
        showMenu(sc, settings);
    }
    
    /**
     * Starts a game
     * 
     * @param sc the scanner to use for input
     * @param settings the settings object of the current game instance
     */
    public static void startGame(Scanner sc, Settings settings) {
        // Generate a random number in the range [1, 10]
        int random = Random.randInt(settings.getLowerBound(), settings.getUpperBound());
        
        // Declaring a guess variable to store the user's guess
        int guess = 0;
        int guessesLeft = settings.getNumGuesses();
                
        do {
            // Ask for Input
            System.out.printf("You have %d guess%s left. What is your guess? %n", guessesLeft, (guessesLeft > 1 ? "es" : ""));
            guess = InputUtils.nextInt(sc);
            
            // Perform bounds checking
            if(!MathUtils.inRange(settings.getLowerBound(), settings.getUpperBound(), guess)) {
                System.out.printf("Guess something in the range [ %d, %d ]%n", settings.getLowerBound(), settings.getUpperBound());
                continue;
            };

            // Reduce Guesses and handle the case where no guesses are left
            guessesLeft --;
            
            if(guessesLeft == 0) break;
            
            // Display the appropriate message
            if(guess < random) {
                System.out.print("Guess higher! ");
            } else if(guess > random) {
                System.out.print("Guess lower! ");
            }
        } while(guess != random);
        
        // Concluding the game
        if(guess == random) {
            System.out.println("You got it!");
        } else {
            System.out.println("You lost...");
        }

        // Ask the user if they want to play again
        System.out.print("Play again? ");

        boolean playAgain = sc.nextLine().toLowerCase().equals("y");

        if(playAgain) {
            startGame(sc, settings);
        }
    }
    
    /**
     * Allows the user to change the settings
     * 
     * @param sc the scanner to use for input
     * @param settings the settings object of the current game instance
     */
    public static void changeSettings(Scanner sc, Settings settings) {
        // Setting the Lower Bound
        System.out.print("What is the lower limit of the random number? ");
        int newLowerBound = InputUtils.nextInt(sc);
        
        // Setting the Upper Bound
        System.out.print("What is the upper limit of the random number? ");
        int newUpperBound = InputUtils.nextInt(sc);
        
        // Setting the number of guesses
        int newNumGuesses;

        do { 
            System.out.print("How many guesses are allowed? ");
            newNumGuesses = InputUtils.nextInt(sc);
            if(newNumGuesses < 1) {
                System.out.println("Please input a positive integer greater than or equal to 1.");
            }
        }
        while(newNumGuesses < 1);

        // Updating settings
        settings.setBounds(newLowerBound, newUpperBound)
        .setNumGuesses(newNumGuesses);
    }
    
    public static void endApplication() {
        System.out.println("Thank you for playing!");
        System.exit(0);
    }
}

public class Q1Ex2 {

    /**
     * The Driver Function
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declaring a scanner object
        Scanner sc = new Scanner(System.in);
        
        // Declaring the settings object
        Settings settings = new Settings(1, 10, 3);
        
        Subroutines.showMenu(sc, settings);
    }

}
