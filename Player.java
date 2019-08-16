/************************************************************************************
*                               Player.java                                         *
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

public class Player
{
    /*********************************************************************************
    *   userInput                                                                    *
    *                                                                                *
    *   Purpose:        Accepts user's input for attacking the computer.             *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public static void userInput(String playerName) {
        int playerShip = 0,
            computerShip = 0;
        String input = "";

        String playerChoice = "";

        Scanner in = new Scanner(System.in);

        // Array containing possible valid input from user
        String[] options = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a10",
                            "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b10",
                            "c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10",
                            "d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10",
                            "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9", "e10",
                            "f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "f10",
                            "g1", "g2", "g3", "g4", "g5", "g6", "g7", "g8", "g9", "g10",
                            "h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10",
                            "i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", "i10",
                            "j1", "j2", "j3", "j4", "j5", "j6", "j7", "j8", "j9", "j10"
        };

        // Check if player/computer ship is destroyed
        System.out.print("Select your next attack: ");
        input = in.nextLine().toLowerCase();

        // Iterate through possible options for ship position
        for (int i = 0; i < options.length; i++) {
            //If input matches array index, break loop
            if (options[i].equals(input)) {
                playerChoice = input;
                GameBoard.checkPlayer(playerChoice);
            }

            if (i == options.length) {
                System.out.println("\nInvalid input, try again.\n");
                continue;
            }
        }
    }

}
