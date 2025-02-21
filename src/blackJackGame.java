import java.util.Scanner;
import java.util.Random;

/**
 * Blackjack rules:
 * The user starts out by throwing 2 dice, and gets the sum of the dice.
 * The user can then throw again or stop.
 * If the user exceeds the sum of 21 the user loses the game.
 * When the user decides to stop, the machine starts the same procedure.
 * The machine will stop throwing dice if it reaches 16 or above.
 * The one with the highest sum and below 21 in the end is the winner.
 * If the user and the machine get the same, the machine wins.
 * if you get 21, you have Black Jack and win without the machine throwing.
 */

public class blackJackGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Invoke scanner
        Random random = new Random(); //Invoke random

        printWelcome(scanner);
        playerGame(scanner, random);
    }


    //INTRO
    public static void printWelcome(Scanner scanner) {
        System.out.println("-------------------- Welcome --------------------");

        while (true) {
            String areYouReady;
            System.out.println("Are you ready to play a riveting game of BlackJack?");
            areYouReady = scanner.nextLine();

            if (areYouReady.equals("yes") || areYouReady.equals("Yes")) {
                System.out.println("\nGreat! Get ready!!\n");
                break;
            } else if (areYouReady.equals("no") || areYouReady.equals("No")){
                System.out.println("\nOh okay...\n");
                System.out.println("are you ready now?...");
                String areYouReadyNow;
                areYouReadyNow = scanner.nextLine();
                if (areYouReadyNow.equals("yes") || areYouReadyNow.equals("Yes")) {
                    System.out.println("\nGreat! Get ready!!\n");
                    break;
                } else if (areYouReadyNow.equals("no") || areYouReadyNow.equals("No")){
                    System.out.println("\nWell... Ready or not!! Here we go!\n");
                    break;
                }
            }
        }
        System.out.println("Blackjack rules:\n" +
                " * You will start out by throwing 2 dice.\n" +
                " * You can then choose to throw again or stop.\n" +
                " * If you exceed the sum of 21 you will lose the game.\n" +
                " * When you decide to stop, the machine will start the same procedure.\n" +
                //" * The machine will stop throwing dice if it reaches 16 or above.\n" +
                " * The one with the highest sum and below 21 in the end is the winner.\n" +
                " * If you and the machine get the same, the machine wins.\n" +
                " * If you get 21, you have Black Jack and win without the machine throwing.\n");
    }


    //GAME START - PLAYER METHOD
    public static void playerGame(Scanner scanner, Random random) {

        int firstDiceRoll = random.nextInt(6) + 1;
        int secondDiceRoll = random.nextInt(6) + 1;
        int twoDiceRoll = firstDiceRoll + secondDiceRoll;

        System.out.println("You start out with a: " + twoDiceRoll);

        int machine2DiceRoll;
        String yesNoAnswer;

        while (twoDiceRoll <= 21) {
            System.out.println("Do you want to roll the dice again? (yes/no): ");
            yesNoAnswer = scanner.nextLine();

            if (yesNoAnswer.equals("yes") || yesNoAnswer.equals("Yes")) {
                int firstDiceRoll2 = random.nextInt(6) + 1;
                int secondDiceRoll2 = random.nextInt(6) + 1;
                int newTwoDiceRoll = firstDiceRoll2 + secondDiceRoll2;

                twoDiceRoll = twoDiceRoll + newTwoDiceRoll;
                System.out.println("You now have a: " + twoDiceRoll + "\n");

                if (twoDiceRoll > 21) {
                    System.out.println("You lose! Your rolls exceeded 21.");
                } else if (twoDiceRoll == 21) {
                    System.out.println("BlackJack! You win!!");
                    break;
                }

            } else if (yesNoAnswer.equals("no") || yesNoAnswer.equals("No")) {
                System.out.println("Your final score is: " + twoDiceRoll + "\n");

                machine2DiceRoll = machineGame(random);
                System.out.println("The machine got: " + machine2DiceRoll);
                if (machine2DiceRoll > twoDiceRoll) {
                    if (machine2DiceRoll > 21){
                        System.out.println("You win!");
                    } else {
                        System.out.println("The machine wins!");
                    }
                    break;
                } else if (machine2DiceRoll < twoDiceRoll){
                    System.out.println("You win!");
                    break;
                } else {
                    System.out.println("The machine wins!");
                    break;
                }
            }
        }
    }

    //MACHINE ROLLS
    public static int machineGame(Random random) {
        int firstMachineDice = random.nextInt(6) + 1;
        int secondMachineDice = random.nextInt(6) + 1;
        int machine2DiceRoll = firstMachineDice + secondMachineDice;

        //System.out.println("Machine starts out with a: " + machine2DiceRoll);

        while (machine2DiceRoll < 16) {
            int firstMachineDice2 = random.nextInt(6) + 1;
            int secondMachineDice2 = random.nextInt(6) +1;
            int newMachine2DiceRoll = firstMachineDice2 + secondMachineDice2;

            machine2DiceRoll = machine2DiceRoll + newMachine2DiceRoll;
        }
        return machine2DiceRoll;
    }
}

