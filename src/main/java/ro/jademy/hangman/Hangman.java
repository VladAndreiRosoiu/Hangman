package ro.jademy.hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static Scanner sc=new Scanner(System.in);
    public static Random rdm=new Random();
    public static char input;
    public static int tries;
    public static String[] word = {"USA", "FRANCE", "GERMANY", "FINLAND", "GREECE", "ROMANIA", "SPAIN", "POLAND", "AUSTRIA"};
    public static char[] playerGuess, toGuess;

    public static void main(String[] args) {
        System.out.println("\nWelcome to Hangman! Let's play guess the country name!");

        do {
            startToGuess();
            if (wordIsGuessed(playerGuess)) {
                System.out.println("\nYou won!\nThe word was : ");
                for (char guess : toGuess) {
                    System.out.print(guess);
                }
            }
            if (tries == 0 && !wordIsGuessed(playerGuess)) {
                System.out.println("\nYou've got hanged!\nThe word was : ");
                for (char guess : toGuess) {
                    System.out.print(guess);
                }
            }
        } while (playAgain());
    }

    public static void startToGuess() {
        toGuess = word[rdm.nextInt(word.length)].toCharArray();
        playerGuess = new char[toGuess.length];
        tries = 5;
        for (int i = 0; i < playerGuess.length; i++) {
            playerGuess[i] = '*';
            System.out.print("( " + playerGuess[i] + " )");
        }
        System.out.println("\nYou have " + tries + " tries to discover the word!");
        while (!wordIsGuessed(playerGuess) && tries >= 1) {
            System.out.println("\nEnter guess:");
            input = sc.next().toUpperCase().charAt(0);
            if (!isGuessValid()) {
                System.out.println("Wrong!");
                tries--;
            }
            System.out.println("You now have " + tries + " tries left!");
            for (int i = 0; i < toGuess.length; i++) {
                if (input == toGuess[i]) {
                    playerGuess[i] = input;
                }
                if (i == 0) {
                    System.out.print("|");
                }
                System.out.print(" " + playerGuess[i] + " |");
            }
            printHangMan(tries);
        }
    }

    public static boolean wordIsGuessed(char[] playerGuess) {
        for (char guess : playerGuess) {
            if (guess == '*') {
                return false;
            }
        }
        return true;
    }

    public static boolean playAgain() {
        System.out.println("\nDo you want to play again?! Y/N:");
        String playGame = sc.next().toUpperCase();
        if (playGame.equals("Y")) {
            return true;
        } else {
            System.out.println("Thank you for playing!");
            return false;
        }
    }

    public static void printHangMan(int tries) {
        if (tries == 5) {
            System.out.println();
            System.out.println("__________");
            System.out.println("|         |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("| ");
            System.out.println("||");
            System.out.println("|||");
            System.out.println("|||");
        } else if (tries == 4) {
            System.out.println();
            System.out.println("__________");
            System.out.println("|         |");
            System.out.println("|        ( )");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("||");
            System.out.println("|||");
            System.out.println("|||");
        } else if (tries == 3) {
            System.out.println();
            System.out.println("__________");
            System.out.println("|         |");
            System.out.println("|        ( )");
            System.out.println("|         '");
            System.out.println("|         |");
            System.out.println("|");
            System.out.println("||");
            System.out.println("|||");
            System.out.println("|||");
        } else if (tries == 2) {
            System.out.println();
            System.out.println("__________");
            System.out.println("|         |");
            System.out.println("|        ( )");
            System.out.println("|         '");
            System.out.println("|       / | \\");
            System.out.println("|");
            System.out.println("||");
            System.out.println("|||");
            System.out.println("|||");
        } else if (tries == 1) {
            System.out.println();
            System.out.println("__________");
            System.out.println("|         |");
            System.out.println("|        ( )");
            System.out.println("|         '");
            System.out.println("|       / | \\");
            System.out.println("|         |");
            System.out.println("||");
            System.out.println("|||");
            System.out.println("|||");
        } else if (tries == 0) {
            System.out.println();
            System.out.println("__________");
            System.out.println("|         |");
            System.out.println("|        ( )");
            System.out.println("|         '");
            System.out.println("|       / | \\");
            System.out.println("|         |");
            System.out.println("||       / \\");
            System.out.println("|||     /   \\");
            System.out.println("|||");
        }
    }

    public static boolean isGuessValid() {
        for (char c : toGuess) {
            if (input == c) return true;
        }
        return false;
    }
}
