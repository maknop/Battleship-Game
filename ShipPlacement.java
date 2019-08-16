/************************************************************************************
*                         ShipPlacement.java                                        *
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
import java.util.Random;

public class ShipPlacement
{
    // Attribute(s)
    private char playerBoard[][];

    // Contructor: computer board, hidden board, player board.
    public ShipPlacement(char[][] playerBoard)
    {
        this.playerBoard = playerBoard;
    }


    /*********************************************************************************
    *   placeCarrier                                                                 *
    *                                                                                *
    *   Purpose:        Places ships for player's boards.                            *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public void placeCarrier()  // Occupies 5 spaces.
    {
        int rowSideOne = 0;
        int colSideOne = 0;
        int rowSideTwo = 0;
        int colSideTwo = 0;
        int rowSideThree = 0;
        int colSideThree = 0;
        int rowSideFour = 0;
        int colSideFour = 0;
        int boatDirection = 0;
        int rowMid = 0;
        int colMid = 0;

        do {
            Random rand = new Random();
            // Computer boat direction.
            boatDirection = rand.nextInt(2);

            // Player coordinates.
            rowMid = rand.nextInt(6) + 1;
            colMid = rand.nextInt(6) + 1;

            // Player boat location.
            if (boatDirection == 0) {           // horizontal direction.
                rowSideOne = rowMid;
                colSideOne = colMid - 1;
                rowSideTwo = rowMid;
                colSideTwo = colMid + 1;
                rowSideThree = rowMid;
                colSideThree = colMid - 2;
                rowSideFour = rowMid;
                colSideFour = colMid + 2;
            } else if (boatDirection == 1) {    // Vertical direction.
                rowSideOne = rowMid - 1;
                colSideOne = colMid;
                rowSideTwo = rowMid + 1;
                colSideTwo = colMid;
                rowSideThree = rowMid - 2;
                colSideThree = colMid;
                rowSideFour = rowMid + 2;
                colSideFour = colMid;
            }

            // Checks for empty spaces, places complete ship.
            if (playerBoard[rowMid][colMid] == ' ' && playerBoard[rowSideOne][colSideOne] == ' ' && playerBoard[rowSideTwo][colSideTwo] == ' ') {
                playerBoard[rowMid][colMid] = 'A';
                playerBoard[rowSideOne][colSideOne] = 'A';
                playerBoard[rowSideTwo][colSideTwo] = 'A';
                playerBoard[rowSideThree][colSideThree] = 'A';
                playerBoard[rowSideFour][colSideFour] = 'A';
                break;
            }
        } while (playerBoard[rowMid][colMid] != ' ' || playerBoard[rowSideOne][colSideOne] != ' ' || playerBoard[rowSideTwo][colSideTwo] != ' ');

    }


    /*********************************************************************************
    *   placeBattleship                                                              *
    *                                                                                *
    *   Purpose:        Places ships for player's boards.                            *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public void placeBattleship()  // Occupies 4 spaces.
    {
        int rowSideOne = 0;
        int colSideOne = 0;
        int rowSideTwo = 0;
        int colSideTwo = 0;
        int rowSideThree = 0;
        int colSideThree = 0;
        int boatDirection = 0;
        int rowMid = 0;
        int colMid = 0;

        do {
            Random rand = new Random();

            // Computer boat direction.
            boatDirection = rand.nextInt(2);

            // Player coordinates
            rowMid = rand.nextInt(7) + 1;
            colMid = rand.nextInt(7) + 1;

            // Player boat location.
            if (boatDirection == 0) {           // horizontal direction.
                rowSideOne = rowMid;
                colSideOne = colMid - 1;
                rowSideTwo = rowMid;
                colSideTwo = colMid + 1;
                rowSideThree = rowMid;
                colSideThree = colMid + 2;
            } else if (boatDirection == 1) {    // Vertical direction.
                rowSideOne = rowMid - 1;
                colSideOne = colMid;
                rowSideTwo = rowMid + 1;
                colSideTwo = colMid;
                rowSideThree = rowMid + 2;
                colSideThree = colMid;
            }


            // Checks for empty spaces, places complete ship.
            if (playerBoard[rowMid][colMid] == ' ' && playerBoard[rowSideOne][colSideOne] == ' ' && playerBoard[rowSideTwo][colSideTwo] == ' ') {
                playerBoard[rowMid][colMid] = 'B';
                playerBoard[rowSideOne][colSideOne] = 'B';
                playerBoard[rowSideTwo][colSideTwo] = 'B';
                playerBoard[rowSideThree][colSideThree] = 'B';

                break;
            }
        } while (playerBoard[rowMid][colMid] != ' ' || playerBoard[rowSideOne][colSideOne] != ' ' || playerBoard[rowSideTwo][colSideTwo] != ' ');

    }


    /*********************************************************************************
    *   placeCruiser                                                                 *
    *                                                                                *
    *   Purpose:        Places ships for player's boards.                            *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public void placeCruiser() // Occupies 3 spaces.
    {
        int rowSideOne = 0;
        int colSideOne = 0;
        int rowSideTwo = 0;
        int colSideTwo = 0;
        int boatDirection = 0;
        int rowMid = 0;
        int colMid = 0;

        do {
            Random rand = new Random();

            // Computer boat direction.
            boatDirection = rand.nextInt(2);

            // Player coordinates.
            rowMid = rand.nextInt(8) + 1;
            colMid = rand.nextInt(8) + 1;

            // Player boat location.
            if (boatDirection == 0) {           // horizontal direction.
                rowSideOne = rowMid;
                colSideOne = colMid - 1;
                rowSideTwo = rowMid;
                colSideTwo = colMid + 1;
            } else if (boatDirection == 1) {    // Vertical direction.
                rowSideOne = rowMid - 1;
                colSideOne = colMid;
                rowSideTwo = rowMid + 1;
                colSideTwo = colMid;
            }


            // Checks for empty spaces, places complete ship.
            if (playerBoard[rowMid][colMid] == ' ' && playerBoard[rowSideOne][colSideOne] == ' ' && playerBoard[rowSideTwo][colSideTwo] == ' ') {
                playerBoard[rowMid][colMid] = 'C';
                playerBoard[rowSideOne][colSideOne] = 'C';
                playerBoard[rowSideTwo][colSideTwo] = 'C';
                break;
            }
        } while (playerBoard[rowMid][colMid] != ' ' || playerBoard[rowSideOne][colSideOne] != ' ' || playerBoard[rowSideTwo][colSideTwo] != ' ');

    }


    /*********************************************************************************
    *   placeSubmarine                                                               *
    *                                                                                *
    *   Purpose:        Places ships for player's boards.                            *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public void placeSubmarine()  // Occupies 3 spaces.
    {
        int rowSideOne = 0;
        int colSideOne = 0;
        int rowSideTwo = 0;
        int colSideTwo = 0;
        int boatDirection = 0;
        int rowMid = 0;
        int colMid = 0;

        do {
            Random rand = new Random();

            // Computer boat direction.
            boatDirection = rand.nextInt(2);

            // Player coordinates.
            rowMid = rand.nextInt(8) + 1;
            colMid = rand.nextInt(8) + 1;

            // Player boat location.
            if (boatDirection == 0) {           // horizontal direction.
                rowSideOne = rowMid;
                colSideOne = colMid - 1;
                rowSideTwo = rowMid;
                colSideTwo = colMid + 1;
            } else if (boatDirection == 1) {    // Vertical direction.
                rowSideOne = rowMid - 1;
                colSideOne = colMid;
                rowSideTwo = rowMid + 1;
                colSideTwo = colMid;
            }

            // Checks for empty spaces, places complete ship.
            if (playerBoard[rowMid][colMid] == ' ' && playerBoard[rowSideOne][colSideOne] == ' ' && playerBoard[rowSideTwo][colSideTwo] == ' ') {
                playerBoard[rowMid][colMid] = 'S';
                playerBoard[rowSideOne][colSideOne] = 'S';
                playerBoard[rowSideTwo][colSideTwo] = 'S';
                break;
            }
        } while (playerBoard[rowMid][colMid] != ' ' || playerBoard[rowSideOne][colSideOne] != ' ' || playerBoard[rowSideTwo][colSideTwo] != ' ');

    }


    /*********************************************************************************
    *   placeDestroyer                                                               *
    *                                                                                *
    *   Purpose:        Places ships for player's boards.                            *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public void placeDestroyer()  // Occupies 2 spaces.
    {
        int rowSideOne = 0;
        int colSideOne = 0;
        int rowSideTwo = 0;
        int colSideTwo = 0;
        int boatDirection = 0;
        int rowMid = 0;
        int colMid = 0;
        int fourthSpot = 0;
        int fifthSpot = 0;

        do {
            Random rand = new Random();

            // Computer boat direction.
            boatDirection = rand.nextInt(2);

            // Player coordinates.
            rowMid = rand.nextInt(8) + 1;
            colMid = rand.nextInt(8) + 1;

            // Player boat location.
            if (boatDirection == 0) {           // horizontal direction.
                rowSideOne = rowMid;
                colSideOne = colMid - 1;
                rowSideTwo = rowMid;
                colSideTwo = colMid + 1;
                fifthSpot = colMid + 2;
                fourthSpot = colMid - 2;
            } else if (boatDirection == 1) {    // Vertical direction.
                rowSideOne = rowMid - 1;
                colSideOne = colMid;
                //rowSideTwo = rowMid + 1;
                //colSideTwo = colMid;
                fifthSpot = rowMid + 2;
                fourthSpot = rowMid - 2;
            }


            // Checks for empty spaces, places complete ship.
            if (playerBoard[rowMid][colMid] == ' ' && playerBoard[rowSideOne][colSideOne] == ' ') {
                playerBoard[rowMid][colMid] = 'D';
                playerBoard[rowSideOne][colSideOne] = 'D';
                break;
            }
        } while (playerBoard[rowMid][colMid] != ' ' || playerBoard[rowSideOne][colSideOne] != ' ' || playerBoard[rowSideTwo][colSideTwo] != ' ');

    }

}
