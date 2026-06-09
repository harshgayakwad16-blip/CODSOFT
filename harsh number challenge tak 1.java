import java.util.Random;
import java.util.Scanner;

class NumberGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int round = 1;
        char playAgain;

        System.out.println("=================================");
        System.out.println("       NUMBER GUESSING GAME      ");
        System.out.println("=================================");

        do {
            int randomNumber = random.nextInt(100) + 1;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round);
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {

                System.out.print("Attempt " + attempt + ": ");
                int guess = sc.nextInt();

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number.");

                    int score = (maxAttempts - attempt + 1) * 10;
                    totalScore += score;

                    System.out.println("Score this round: " + score);
                    guessedCorrectly = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too Low! Try Again.");
                } else {
                    System.out.println("Too High! Try Again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You lost this round.");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.println("Total Score: " + totalScore);

            System.out.print("\nDo you want to play again? (Y/N): ");
            playAgain = sc.next().charAt(0);

            round++;

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n=================================");
        System.out.println("Game Over!");
        System.out.println("Final Score: " + totalScore);
        System.out.println("Thanks for Playing!");
        System.out.println("=================================");

        sc.close();
    }
}