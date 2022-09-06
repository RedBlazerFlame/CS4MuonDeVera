// package q1ex2;

import java.util.Scanner;

/**
 *
 * @author Hans Gabriel D. De Vera
 */
class Random {
    /**
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
     * @param sc the scanner to use
     */
    public static int nextInt(Scanner sc) {
        return Integer.parseInt(sc.nextLine());
    }
}

class Settings {
    // Attributes
    public int lowerBound;
    public int upperBound;
    private int numGuesses;
    
    // Constructor
    public Settings(int a_lowerBound, int a_upperBound, int a_numGuesses) {
        lowerBound = a_lowerBound;
        upperBound = a_upperBound;
        numGuesses = a_numGuesses;
    }
    
    // Getters and Setters
    public int getNumGuesses() {
        return numGuesses;
    }
    
    public Settings setNumGuesses(int a_numGuesses) {
        if(a_numGuesses > 0) {
            numGuesses = a_numGuesses;
        }
        return this;
    }
}

class Subroutines {
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
    
    public static void startGame(Scanner sc, Settings settings) {
        // Generate a random number in the range [1, 10]
        int random = Random.randInt(settings.lowerBound, settings.upperBound);
        
        // Declaring a guess variable to store the user's guess
        int guess = 0;
        int guessesLeft = settings.getNumGuesses();
                
        do {
            System.out.printf("You have %d guess%s left. What is your guess? %n", guessesLeft, (guessesLeft > 1 ? "es" : ""));
            guess = InputUtils.nextInt(sc);
            
            guessesLeft --;
            
            if(guessesLeft == 0) break;
            
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
    }
    
    public static void changeSettings(Scanner sc, Settings settings) {
        // Setting the Lower Bound
        System.out.print("What is the lower limit of the random number? ");
        settings.lowerBound = InputUtils.nextInt(sc);
        
        // Setting the Upper Bound
        System.out.print("What is the upper limit of the random number? ");
        settings.upperBound = InputUtils.nextInt(sc);
        
        // Setting the number of guesses
        System.out.print("How many guesses are allowed? ");
        settings.setNumGuesses(InputUtils.nextInt(sc));
    }
    
    public static void endApplication() {
        System.out.println("Thank you for playing!");
        System.exit(0);
    }
}

public class Q1Ex2 {

    /**
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
