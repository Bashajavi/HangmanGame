import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

    public static void main(String[] args) {
        // List of words to choose from
        String[] words = {"java", "python", "programming", "computer", "developer"};

        // Select a random word
        Random random = new Random();
        String selectedWord = words[random.nextInt(words.length)];

        // Initialize variables
        char[] guessedWord = new char[selectedWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        int incorrectGuesses = 0;
        int maxGuesses = 6;
        boolean isWordGuessed = false;
        Scanner scanner = new Scanner(System.in);

        while (incorrectGuesses < maxGuesses && !isWordGuessed) {
            // Display the current state of the guessed word
            System.out.print("Current word: ");
            for (char c : guessedWord) {
                System.out.print(c + " ");
            }
            System.out.println();

            // Prompt the user for a letter
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);

            // Check if the letter is in the word
            boolean correctGuess = false;
            for (int i = 0; i < selectedWord.length(); i++) {
                if (selectedWord.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    correctGuess = true;
                }
            }

            // Update the hangman figure based on incorrect guesses
            if (!correctGuess) {
                incorrectGuesses++;
                System.out.println("Incorrect guess. You have " + (maxGuesses - incorrectGuesses) + " guesses left.");
            }

            displayHangman(incorrectGuesses);

            // Check if the word is completely guessed
            isWordGuessed = true;
            for (char c : guessedWord) {
                if (c == '_') {
                    isWordGuessed = false;
                    break;
                }
            }
        }

        // Display the result of the game
        if (isWordGuessed) {
            System.out.println("Congratulations! You guessed the word: " + selectedWord);
        } else {
            System.out.println("Sorry, you lost. The word was: " + selectedWord);
        }

        scanner.close();
    }

    // Function to display the hangman figure
    public static void displayHangman(int incorrectGuesses) {
        System.out.println("Hangman figure:");
        switch (incorrectGuesses) {
            case 1:
                System.out.println(" O ");
                break;
            case 2:
                System.out.println(" O ");
                System.out.println(" | ");
                break;
            case 3:
                System.out.println(" O ");
                System.out.println(" | ");
                System.out.println("/");
                break;
            case 4:
                System.out.println(" O ");
                System.out.println(" | ");
                System.out.println("/ \\");
                break;
            case 5:
                System.out.println(" O ");
                System.out.println("/| ");
                System.out.println("/ \\");
                break;
            case 6:
                System.out.println(" O ");
                System.out.println("/|\\");
                System.out.println("/ \\");
                break;
            default:
                System.out.println();
                break;
        }
    }
}
