/************************************************************************************
*                                 Main.java                                         *
*                                                                                   *
*  PROGRAMMER:         Matthew Knop                                                 *
*  CLASS:              cs102                                                        *
*  ASSIGNMENT:         Final Project - Battleship!                                  *
*  INSTRUCTOR:         Dean Zeller                                                  *
*  SUBMISSION DATE:    4/27/2019                                                    *
*                                                                                   *
*  DESCRIPTION:        This program simulates a real game of Battleship between     *
*                      the computer and user.                                       *
*                                                                                   *
*  COPYRIGHT:                                                                       *
*  This program is copyright (c) 2019 Matthew Knop and Dean Zeller. This is         *
*  original work, without use of outside sources.                                   *
************************************************************************************/
import java.util.Scanner;

public class Main extends GameBoard {
    /*********************************************************************************
    *   main                                                                         *
    *                                                                                *
    *   Purpose:        The main method.                                             *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public static void main(String[] args) {
        String playerInput = "PASS";
        String computerChoice = "PASS";
        instructions();                     // Displays the instructions.
        String playerName = enterName();    // Reads user input for player name.
        GameBoard.initializePlayerBoard();  // Initalizes plyaer's game board.
        GameBoard.initializeBoard();        // Initalizes computer's game board.
        GameBoard.computerBoard();          // Initalizes hidden computer board.
        GameBoard.populateBoards();         // Randomly places ships for computer and player boards.
        System.out.println("GAME START!");
        boolean checkComp = false;
        boolean checkPlayer = false;
        Scanner in = new Scanner(System.in);

        // Loop for cycling through game states.
        while (true) {
            GameBoard.board(playerInput, playerName);   // Displays the game boards.
            Computer.computerTurn();                    // Computer takes turn.

            GameBoard.board(playerInput, playerName);   // Displays the game boards.
            Player.userInput(playerName);               // User takes their turn.

            checkPlayer = GameBoard.checkPlayerBoard(); // Checks if player won.
            checkComp = GameBoard.checkCompBoard();     // Checks if computer won.

            // Prints winner.
            if (checkPlayer == true) {
                System.out.println("Computer Wins!");
                break;
            } else if (checkComp == true) {
                System.out.println("Player Wins!");
                break;
            }
        }

    }

    /*********************************************************************************
    *   instructions                                                                 *
    *                                                                                *
    *   Purpose:        Prints the instructions for the game.                        *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public static void instructions() {
        System.out.println("\n|------------------------------------------------------|\n"
                         + "|       ========================================       |\n"
                         + "|                   Battleship                         |\n"
                         + "|       ========================================       |\n"
                         + "|                                                      |\n"
                         + "|  The objective is to sink the computer's battleships |\n"
                         + "|  before it sinks yours. Ships are three spaces       |\n"
                         + "|  long and are not diagonal.                          |\n"
                         + "|                                                      |\n"
                         + "|                                                      |\n"
                         + "|                                                      |\n"
                         + "|                                                      |\n"
                         + "|------------------------------------------------------|"
        );
    }


    /*********************************************************************************
    *   enterName                                                                    *
    *                                                                                *
    *   Purpose:        Accepts input from the user for their name.                  *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public static String enterName() {
        String userName = "";
        Scanner in = new Scanner(System.in);

        // Accepts user input for their name.
        System.out.print(" Enter player name:  ");
        userName = in.nextLine();
        System.out.println("|------------------------------------------------------|\n\n\n");

        return userName;
    }
}
