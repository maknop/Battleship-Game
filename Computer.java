/************************************************************************************
*                             Computer.java                                         *
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
import java.util.Random;

public class Computer
{
    // Attribute(s)
    private static char playerBoard[][] = new char[10][10];


    // Constructor: 2D Array for player's game board.
    public Computer(char[][] playerBoard)
    {
        this.playerBoard = playerBoard;
    }


    /*********************************************************************************
    *   computerTurn                                                                 *
    *                                                                                *
    *   Purpose:        Computer takes a turn to attack the player.                  *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public static void computerTurn()
    {
        // Declares random object.
        Random rand = new Random();

        // Opens the Scanner object.
        Scanner in = new Scanner(System.in);

        // Creates a random integer that corresponds to a
        // letter between A-J.
        int randLetter = rand.nextInt(10);

        // Creates a random integer from 1-10.
        int randNum = rand.nextInt(9)+1;
        String letter = "";

        // Random integer is assigned to a character between A-J.
        if (randLetter == 0)
            letter = "a";
        else if (randLetter == 1)
            letter = "b";
        else if (randLetter == 2)
            letter = "c";
        else if (randLetter == 3)
            letter = "d";
        else if (randLetter == 4)
            letter = "e";
        else if (randLetter == 5)
            letter = "f";
        else if (randLetter == 6)
            letter = "g";
        else if (randLetter == 7)
            letter = "h";
        else if (randLetter == 8)
            letter = "i";
        else if (randLetter == 9)
            letter = "j";

        in.nextLine();

        // The computer's choice is created.
        String computerChoice = letter + randNum;
        System.out.println("Computer chooses to attack " + computerChoice + "!");
        in.nextLine();

        // The computer's choice is passed to the GameBoard method. 
        GameBoard.checkHit(computerChoice);

    }



}
