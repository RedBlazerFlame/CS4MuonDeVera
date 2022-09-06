package q1ex2;

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

class Subroutines {
    public static void startGame(Scanner sc, int maxNum, int maxGuesses) {
        // Generate a random number in the range [1, 10]
        int random = Random.randInt(1, maxNum);
        
        // Declaring a guess variable to store the user's guess
        int guess = 0;
        int guessesLeft = maxGuesses;
                
        do {
            System.out.printf("You have %d guess%s left. What is your guess? %n", guessesLeft, (guessesLeft > 1 ? "es" : ""));
            guess = InputUtils.nextInt(sc);
            if(guess < random) {
                System.out.print("Guess higher! ");
            } else {
                System.out.print("Guess lower! ");
            }
            
            guessesLeft --;
        } while(guess != random);
    }
}

public class Q1Ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declaring a scanner object
        Scanner sc = new Scanner(System.in);
    }

}
