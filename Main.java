package RockPaperShoot;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static int wins = 0, looses = 0;
    private static String[] choices = new String[2];


    public static void main(String[] args) {
        play();
    }

    public static void play(){
        System.out.println("---- Rock, Paper, Shoot ----");
        String choice;
        boolean exit;
        do {
            tablero();
            do {
                System.out.println("Choose (R/P/S): ");
                choice = sc.nextLine();
                if (!choice.equals("R") && !choice.equals("P") && !choice.equals("S")) {
                    System.out.println("Invalid choice");
                }
            } while (!choice.equals("R") && !choice.equals("P") && !choice.equals("S"));
            choices[0] = choice;

            Random rand = new Random();
            int randomNum = rand.nextInt(3) + 1;
            String enemyChoice = switch (randomNum) {
                case 1 -> "P";
                case 2 -> "R";
                case 3 -> "S";
                default -> "";
            };

            choices[1] = enemyChoice;
            tablero();
            if (choice.equals(enemyChoice)) {
                System.out.println("Empate");
            } else if (choice.equals("P")) {
                if (enemyChoice.equals("S")) {
                    loose();
                } else {
                    win();
                }
            } else if (choice.equals("R")) {
                if (enemyChoice.equals("P")) {
                    loose();
                } else {
                    win();
                }
            } else {
                if (enemyChoice.equals("R")) {
                    loose();
                } else {
                    win();
                }
            }
            System.out.println("Victorias : " + wins);
            System.out.println("Derrotas : " + looses);
            System.out.println("Keep playing? (Y)es/(N)o");
            exit = sc.nextLine().equals("N");
            choices[0] = null;
            choices[1] = null;
        }while(!exit);
    }

    public static void loose(){
        looses++;
        System.out.println("You loose");
    }

    public static void win(){
        wins++;
        System.out.println("You Win");
    }

    public static void tablero(){
        System.out.println("+-----------+");
        System.out.println("|           |");
        System.out.println("|  " + (choices[0] == null ? "?": choices[0]) + "  x  " + (choices[1] == null ? "?": choices[1]) + "  |");
        System.out.println("|           |");
        System.out.println("+-----------+");
    }
}
