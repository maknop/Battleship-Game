/************************************************************************************
*                             GameBoard.java                                        *
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
import java.util.Scanner;

public class GameBoard {

    private static char board[][] = new char[10][10];
    private static char hiddenBoard[][] = new char[10][10];
    private static char playerBoard[][] = new char[10][10];

    /*********************************************************************************
    *   computerBoard                                                                *
    *                                                                                *
    *   Purpose:        Creates computer game board.                                 *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public static void computerBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // Initalizes every indice of the 2d array to an empty char.
                hiddenBoard[i][j] = ' ';
            }
        }
    }


    /*********************************************************************************
    *   initializeBoard                                                              *
    *                                                                                *
    *   Purpose:        Creates computer's game board.                               *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public static void initializeBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // Initalizes every indice of the 2d array to an empty char.
                board[i][j] = ' ';
            }
        }
    }


    /*********************************************************************************
    *   initializePlayerBoard                                                        *
    *                                                                                *
    *   Purpose:        Creates player game board.                                   *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public static void initializePlayerBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // Initalizes every indice of the 2d array to an empty char.
                playerBoard[i][j] = ' ';
            }
        }
    }


    /*********************************************************************************
    *   populateBoards                                                               *
    *                                                                                *
    *   Purpose:        Creates random locations for ships. This happens for         *
    *                   computer and player game boards.                             *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public static void populateBoards()
    {
        // Creates a player ship object and computer ship object.
        ShipPlacement playerShips = new ShipPlacement(playerBoard);
        CompShipPlacement compShips = new CompShipPlacement(board, hiddenBoard);

        // Places all player ships randomly.
        playerShips.placeCarrier();
        playerShips.placeBattleship();
        playerShips.placeCruiser();
        playerShips.placeSubmarine();
        playerShips.placeDestroyer();

        // Places all computer ships randomly.
        compShips.placeCompCarrier();
        compShips.placeCompBattleship();
        compShips.placeCompCrusier();
        compShips.placeCompSubmarine();
        compShips.placeCompDestroyer();

    }


    /*********************************************************************************
    *   checkPlayerBoard                                                             *
    *                                                                                *
    *   Purpose:        Checks if all player ships are destroyed.                    *
    *   Parameters:     args                                                         *
    *   Return Value:   boolean - returns true or false                              *
    *********************************************************************************/
    public static boolean checkPlayerBoard() {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // Counts how many of the player's targets have been destroyed.
                if (playerBoard[i][j] != '@')
                    count++;
            }
        }
        // Checks if all player targets have been destroyed.
        if (count == 15)
            return true;

        return false;
    }


    /*********************************************************************************
    *   checkCompBoard                                                               *
    *                                                                                *
    *   Purpose:        Checks if all computer ships are destroyed.                  *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public static boolean checkCompBoard() {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // Counts how many of the computer's targets have been destroyed.
                if (hiddenBoard[i][j] != '@')
                    count++;
            }
        }

        // Checks if all computer targets have been destroyed.
        if (count == 15)
            return true;

        return false;
    }



    /*********************************************************************************
    *   checkPlayer                                                                  *
    *                                                                                *
    *   Purpose:        Checks if player hits a computer's target.                   *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public static void checkPlayer(String playerInput) {
        // Checks player's input for a hit or miss, prints accordingly.
        if ((playerInput.equals("A1") || playerInput.equals("a1")) && hiddenBoard[0][0] != (' ')) {
            System.out.println("That's a hit!");
            board[0][0] = '@';
        } else if ((playerInput.equals("A2") || playerInput.equals("a2")) && hiddenBoard[1][0] != (' ')) {
            System.out.println("That's a hit!");
            board[1][0] = '@';
        } else if ((playerInput.equals("A3") || playerInput.equals("a3")) && hiddenBoard[2][0] != ' ') {
            System.out.println("That's a hit!");
            board[2][0] = '@';
        } else if ((playerInput.equals("A4") || playerInput.equals("A4")) && hiddenBoard[3][0] != ' ') {
            System.out.println("That's a hit!");
            board[3][0] = '@';
        }  else if ((playerInput.equals("A5") || playerInput.equals("a5")) && hiddenBoard[4][0] != ' ') {
            System.out.println("That's a hit!");
            board[4][0] = '@';
        }  else if ((playerInput.equals("A6") || playerInput.equals("a6")) && hiddenBoard[5][0] != ' ') {
            System.out.println("That's a hit!");
            board[5][0] = '@';
        }  else if ((playerInput.equals("A7") || playerInput.equals("a7")) && hiddenBoard[6][0] != ' ') {
            System.out.println("That's a hit!");
            board[6][0] = '@';
        }  else if ((playerInput.equals("A8") || playerInput.equals("a8")) && hiddenBoard[7][0] != ' ') {
            System.out.println("That's a hit!");
            board[7][0] = '@';
        }  else if ((playerInput.equals("A9") || playerInput.equals("a9")) && hiddenBoard[8][0] != ' ') {
            System.out.println("That's a hit!");
            board[8][0] = '@';
        }  else if ((playerInput.equals("A10") || playerInput.equals("a10")) && hiddenBoard[9][0] != ' ') {
            System.out.println("That's a hit!");
            board[9][0] = '@';
        } else if ((playerInput.equals("B1") || playerInput.equals("b1")) && hiddenBoard[0][1] != ' ') {
            System.out.println("That's a hit!");
            board[0][1] = '@';
        } else if ((playerInput.equals("B2") || playerInput.equals("b2")) && hiddenBoard[1][1] != ' ') {
            System.out.println("That's a hit!");
            board[1][1] = '@';
        } else if ((playerInput.equals("B3") || playerInput.equals("b3")) && hiddenBoard[2][1] != ' ') {
            System.out.println("That's a hit!");
            board[2][1] = '@';
        } else if ((playerInput.equals("B4") || playerInput.equals("b4")) && hiddenBoard[3][1] != ' ') {
            System.out.println("That's a hit!");
            board[3][1] = '@';
        }  else if ((playerInput.equals("B5") || playerInput.equals("b5")) && hiddenBoard[4][1] != ' ') {
            System.out.println("That's a hit!");
            board[4][1] = '@';
        }  else if ((playerInput.equals("B6") || playerInput.equals("b6")) &&  hiddenBoard[5][1] != ' ') {
            System.out.println("That's a hit!");
            board[5][1] = '@';
        }  else if ((playerInput.equals("B7") || playerInput.equals("b7")) && hiddenBoard[6][1] != ' ') {
            System.out.println("That's a hit!");
            board[6][1] = '@';
        }  else if ((playerInput.equals("B8") || playerInput.equals("b8")) && hiddenBoard[7][1] != ' ') {
            System.out.println("That's a hit!");
            board[7][1] = '@';
        }  else if ((playerInput.equals("B9") || playerInput.equals("b9")) && hiddenBoard[8][1] != ' ') {
            System.out.println("That's a hit!");
            board[8][1] = '@';
        }  else if ((playerInput.equals("B10") || playerInput.equals("b10")) && hiddenBoard[9][1] != ' ') {
            System.out.println("That's a hit!");
            board[9][1] = '@';
        } else if ((playerInput.equals("C1") || playerInput.equals("c1")) && hiddenBoard[0][2] != ' ') {
            System.out.println("That's a hit!");
            board[0][2] = '@';
        } else if ((playerInput.equals("C2") || playerInput.equals("c2")) && hiddenBoard[1][2] != ' ') {
            System.out.println("That's a hit!");
            board[1][2] = '@';
        } else if ((playerInput.equals("C3") || playerInput.equals("c3")) && hiddenBoard[2][2] != ' ') {
            System.out.println("That's a hit!");
            board[2][2] = '@';
        } else if ((playerInput.equals("C4") || playerInput.equals("c4")) && hiddenBoard[3][2] != ' ') {
            System.out.println("That's a hit!");
            board[3][2] = '@';
        }  else if ((playerInput.equals("C5") || playerInput.equals("c5")) && hiddenBoard[4][2] != ' ') {
            System.out.println("That's a hit!");
            board[4][2] = '@';
        }  else if ((playerInput.equals("C6") || playerInput.equals("c6")) && hiddenBoard[5][2] != ' ') {
            System.out.println("That's a hit!");
            board[5][2] = '@';
        }  else if ((playerInput.equals("C7") || playerInput.equals("c7")) && hiddenBoard[6][2] != ' ') {
            System.out.println("That's a hit!");
            board[6][2] = '@';
        }  else if ((playerInput.equals("C8") || playerInput.equals("c8")) && hiddenBoard[7][2] != ' ') {
            System.out.println("That's a hit!");
            board[7][2] = '@';
        }  else if ((playerInput.equals("C9") || playerInput.equals("c9")) && hiddenBoard[8][2] != ' ') {
            System.out.println("That's a hit!");
            board[8][2] = '@';
        }  else if ((playerInput.equals("C10") || playerInput.equals("c10")) && hiddenBoard[9][2] != ' ') {
            System.out.println("That's a hit!");
            board[9][2] = '@';
        } else if ((playerInput.equals("D1") || playerInput.equals("d1")) && hiddenBoard[0][3] != ' ') {
            System.out.println("That's a hit!");
            board[0][3] = '@';
        } else if ((playerInput.equals("D2") || playerInput.equals("d2")) && hiddenBoard[1][3] != ' ') {
            System.out.println("That's a hit!");
            board[1][3] = '@';
        } else if ((playerInput.equals("D3") || playerInput.equals("d3")) && hiddenBoard[2][3] != ' ') {
            System.out.println("That's a hit!");
            board[2][3] = '@';
        } else if ((playerInput.equals("D4") || playerInput.equals("d4")) && hiddenBoard[3][3] != ' ') {
            System.out.println("That's a hit!");
            board[3][3] = '@';
        }  else if ((playerInput.equals("D5") || playerInput.equals("d5")) && hiddenBoard[4][3] != ' ') {
            System.out.println("That's a hit!");
            board[4][3] = '@';
        }  else if ((playerInput.equals("D6") || playerInput.equals("d6")) && hiddenBoard[5][3] != ' ') {
            System.out.println("That's a hit!");
            board[5][3] = '@';
        }  else if ((playerInput.equals("D7") || playerInput.equals("d7")) && hiddenBoard[6][3] != ' ') {
            System.out.println("That's a hit!");
            board[6][3] = '@';
        }  else if ((playerInput.equals("D8") || playerInput.equals("d8"))&& hiddenBoard[7][3] != ' ') {
            System.out.println("That's a hit!");
            board[7][3] = '@';
        }  else if ((playerInput.equals("D9") || playerInput.equals("d9")) && hiddenBoard[8][3] != ' ') {
            System.out.println("That's a hit!");
            board[8][3] = '@';
        }  else if ((playerInput.equals("D10") || playerInput.equals("d10")) && hiddenBoard[9][3] != ' ') {
            System.out.println("That's a hit!");
            board[9][3] = '@';
        } else if ((playerInput.equals("E1") || playerInput.equals("e1")) && hiddenBoard[0][4] != ' ') {
            System.out.println("That's a hit!");
            board[0][4] = '@';
        } else if ((playerInput.equals("E2") || playerInput.equals("e2")) && hiddenBoard[1][4] != ' ') {
            System.out.println("That's a hit!");
            board[1][4] = '@';
        } else if ((playerInput.equals("E3") || playerInput.equals("e3")) && hiddenBoard[2][4] != ' ') {
            System.out.println("That's a hit!");
            board[2][4] = '@';
        } else if ((playerInput.equals("E4") || playerInput.equals("e4")) && hiddenBoard[3][4] != ' ') {
            System.out.println("That's a hit!");
            board[3][4] = '@';
        }  else if ((playerInput.equals("E5") || playerInput.equals("e5")) && hiddenBoard[4][4] != ' ') {
            System.out.println("That's a hit!");
            board[4][4] = '@';
        }  else if ((playerInput.equals("E6") || playerInput.equals("e6")) && hiddenBoard[5][4] != ' ') {
            System.out.println("That's a hit!");
            board[5][4] = '@';
        }  else if ((playerInput.equals("E7") || playerInput.equals("e7")) && hiddenBoard[6][4] != ' ') {
            System.out.println("That's a hit!");
            board[6][4] = '@';
        }  else if ((playerInput.equals("E8") || playerInput.equals("e8")) && hiddenBoard[7][4] != ' ') {
            System.out.println("That's a hit!");
            board[7][4] = '@';
        }  else if ((playerInput.equals("E9") || playerInput.equals("e9")) && hiddenBoard[8][4] != ' ') {
            System.out.println("That's a hit!");
            board[8][4] = '@';
        }  else if ((playerInput.equals("E10") || playerInput.equals("e10")) && hiddenBoard[9][4] != ' ') {
            System.out.println("That's a hit!");
            board[9][4] = '@';
        } else if ((playerInput.equals("F1") || playerInput.equals("f1")) && hiddenBoard[0][5] != ' ') {
            System.out.println("That's a hit!");
            board[0][5] = '@';
        } else if ((playerInput.equals("F2") || playerInput.equals("f2")) && hiddenBoard[1][5] != ' ') {
            System.out.println("That's a hit!");
            board[1][5] = '@';
        } else if ((playerInput.equals("F3") || playerInput.equals("f3")) && hiddenBoard[2][5] != ' ') {
            System.out.println("That's a hit!");
            board[2][5] = '@';
        } else if ((playerInput.equals("F4") || playerInput.equals("f4")) && hiddenBoard[3][5] != ' ') {
            System.out.println("That's a hit!");
            board[3][5] = '@';
        }  else if ((playerInput.equals("F5") || playerInput.equals("f5")) && hiddenBoard[4][5] != ' ') {
            System.out.println("That's a hit!");
            board[4][5] = '@';
        }  else if ((playerInput.equals("F6") || playerInput.equals("f6")) && hiddenBoard[5][5] != ' ') {
            System.out.println("That's a hit!");
            board[5][5] = '@';
        }  else if ((playerInput.equals("F7") || playerInput.equals("f7")) && hiddenBoard[6][5] != ' ') {
            System.out.println("That's a hit!");
            board[6][5] = '@';
        }  else if ((playerInput.equals("F8") || playerInput.equals("f8")) && hiddenBoard[7][5] != ' ') {
            System.out.println("That's a hit!");
            board[7][5] = '@';
        }  else if ((playerInput.equals("F9") || playerInput.equals("f9")) && hiddenBoard[8][5] != ' ') {
            System.out.println("That's a hit!");
            board[8][5] = '@';
        }  else if ((playerInput.equals("F10") || playerInput.equals("f10")) && hiddenBoard[9][5] != ' ') {
            System.out.println("That's a hit!");
            board[9][5] = '@';
        } else if ((playerInput.equals("G1") || playerInput.equals("g1")) && hiddenBoard[0][6] != ' ') {
            System.out.println("That's a hit!");
            board[0][6] = '@';
        } else if ((playerInput.equals("G2") || playerInput.equals("g2")) && hiddenBoard[1][6] != ' ') {
            System.out.println("That's a hit!");
            board[1][6] = '@';
        } else if ((playerInput.equals("G3") || playerInput.equals("g3")) && hiddenBoard[2][6] != ' ') {
            System.out.println("That's a hit!");
            board[2][6] = '@';
        } else if ((playerInput.equals("G4") || playerInput.equals("g4")) && hiddenBoard[3][6] != ' ') {
            System.out.println("That's a hit!");
            board[3][6] = '@';
        }  else if ((playerInput.equals("G5") || playerInput.equals("g5")) && hiddenBoard[4][6] != ' ') {
            System.out.println("That's a hit!");
            board[4][6] = '@';
        }  else if ((playerInput.equals("G6") || playerInput.equals("g6")) && hiddenBoard[5][6] != ' ') {
            System.out.println("That's a hit!");
            board[5][6] = '@';
        }  else if ((playerInput.equals("G7") || playerInput.equals("g7")) && hiddenBoard[6][6] != ' ') {
            System.out.println("That's a hit!");
            board[6][6] = '@';
        }  else if ((playerInput.equals("G8") || playerInput.equals("g8")) && hiddenBoard[7][6] != ' ') {
            System.out.println("That's a hit!");
            board[7][6] = '@';
        }  else if ((playerInput.equals("G9") || playerInput.equals("g9")) && hiddenBoard[8][6] != ' ') {
            System.out.println("That's a hit!");
            board[8][6] = '@';
        }  else if ((playerInput.equals("G10") || playerInput.equals("g10")) && hiddenBoard[9][6] != ' ') {
            System.out.println("That's a hit!");
            board[9][6] = '@';
        } else if ((playerInput.equals("H1") || playerInput.equals("h1")) && hiddenBoard[0][7] != ' ') {
            System.out.println("That's a hit!");
            board[0][7] = '@';
        } else if ((playerInput.equals("H2") || playerInput.equals("h2")) && hiddenBoard[1][7] != ' ') {
            System.out.println("That's a hit!");
            board[1][7] = '@';
        } else if ((playerInput.equals("H3") || playerInput.equals("h3")) && hiddenBoard[2][7] != ' ') {
            System.out.println("That's a hit!");
            board[2][7] = '@';
        } else if ((playerInput.equals("H4") || playerInput.equals("h4")) && hiddenBoard[3][7] != ' ') {
            System.out.println("That's a hit!");
            board[3][7] = '@';
        }  else if ((playerInput.equals("H5") || playerInput.equals("h5")) && hiddenBoard[4][7] != ' ') {
            System.out.println("That's a hit!");
            board[4][7] = '@';
        }  else if ((playerInput.equals("H6") || playerInput.equals("h6")) && hiddenBoard[5][7] != ' ') {
            System.out.println("That's a hit!");
            board[5][7] = '@';
        }  else if ((playerInput.equals("H7") || playerInput.equals("h7")) && hiddenBoard[6][7] != ' ') {
            System.out.println("That's a hit!");
            board[6][7] = '@';
        }  else if ((playerInput.equals("H8") || playerInput.equals("h8")) && hiddenBoard[7][7] != ' ') {
            System.out.println("That's a hit!");
            board[7][7] = '@';
        }  else if ((playerInput.equals("H9") || playerInput.equals("h9")) && hiddenBoard[8][7] != ' ') {
            System.out.println("That's a hit!");
            board[8][7] = '@';
        }  else if ((playerInput.equals("H10") || playerInput.equals("h10")) && hiddenBoard[9][7] != ' ') {
            System.out.println("That's a hit!");
            board[9][7] = '@';
        } else if ((playerInput.equals("I1") || playerInput.equals("i1")) && hiddenBoard[0][8] != ' ') {
            System.out.println("That's a hit!");
            board[0][8] = '@';
        } else if ((playerInput.equals("I2") || playerInput.equals("i2")) && hiddenBoard[1][8] != ' ') {
            System.out.println("That's a hit!");
            board[1][8] = '@';
        } else if ((playerInput.equals("I3") || playerInput.equals("i3")) && hiddenBoard[2][8] != ' ') {
            System.out.println("That's a hit!");
            board[2][8] = '@';
        } else if ((playerInput.equals("I4") || playerInput.equals("i4")) && hiddenBoard[3][8] != ' ') {
            System.out.println("That's a hit!");
            board[3][8] = '@';
        }  else if ((playerInput.equals("I5") || playerInput.equals("i5")) && hiddenBoard[4][8] != ' ') {
            System.out.println("That's a hit!");
            board[4][8] = '@';
        }  else if ((playerInput.equals("I6") || playerInput.equals("i6")) && hiddenBoard[5][8] != ' ') {
            System.out.println("That's a hit!");
            board[5][8] = '@';
        }  else if ((playerInput.equals("I7") || playerInput.equals("i7")) && hiddenBoard[6][8] != ' ') {
            System.out.println("That's a hit!");
            board[6][8] = '@';
        }  else if ((playerInput.equals("I8") || playerInput.equals("i8")) && hiddenBoard[7][8] != ' ') {
            System.out.println("That's a hit!");
            board[7][8] = '@';
        }  else if ((playerInput.equals("I9") || playerInput.equals("i9")) && hiddenBoard[8][8] != ' ') {
            System.out.println("That's a hit!");
            board[8][8] = '@';
        }  else if ((playerInput.equals("I10") || playerInput.equals("i10")) && hiddenBoard[9][8] != ' ') {
            System.out.println("That's a hit!");
            board[9][8] = '@';
        } else if ((playerInput.equals("J1") || playerInput.equals("j1")) && hiddenBoard[0][9] != ' ') {
            System.out.println("That's a hit!");
            board[0][9] = '@';
        } else if ((playerInput.equals("J2") || playerInput.equals("j2")) && hiddenBoard[1][9] != ' ') {
            System.out.println("That's a hit!");
            board[1][9] = '@';
        } else if ((playerInput.equals("J3") || playerInput.equals("j3")) && hiddenBoard[2][9] != ' ') {
            System.out.println("That's a hit!");
            board[2][9] = '@';
        } else if ((playerInput.equals("J4") || playerInput.equals("j4")) && hiddenBoard[3][9] != ' ') {
            System.out.println("That's a hit!");
            board[3][9] = '@';
        }  else if ((playerInput.equals("J5") || playerInput.equals("j5")) && hiddenBoard[4][9] != ' ') {
            System.out.println("That's a hit!");
            board[4][9] = '@';
        }  else if ((playerInput.equals("J6") || playerInput.equals("j6")) && hiddenBoard[5][9] != ' ') {
            System.out.println("That's a hit!");
            board[5][9] = '@';
        }  else if ((playerInput.equals("J7") || playerInput.equals("j7")) && hiddenBoard[6][9] != ' ') {
            System.out.println("That's a hit!");
            board[6][9] = '@';
        }  else if ((playerInput.equals("J8") || playerInput.equals("j8")) && hiddenBoard[7][9] != ' ') {
            System.out.println("That's a hit!");
            board[7][9] = '@';
        }  else if ((playerInput.equals("J9") || playerInput.equals("j9")) && hiddenBoard[8][9] != ' ') {
            System.out.println("That's a hit!");
            board[8][9] = '@';
        }  else if ((playerInput.equals("J10") || playerInput.equals("j10")) && hiddenBoard[9][9] != ' ') {
            System.out.println("That's a hit!");
            board[9][9] = '@';
        } else {
            System.out.println("That's a miss!");
        }
    }



    /*********************************************************************************
    *   board                                                                        *
    *                                                                                *
    *   Purpose:        Prints board and checks if player's option hit an enemy      *
    *                   ship.                                                        *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public static void board(String playerInput, String playerName) {
        Scanner in = new Scanner(System.in);

        System.out.println();
        System.out.println("Hit 'Enter' to continue...");
        in.nextLine();

        // Prints the game board.
        System.out.printf("     Computer's Board %100s's Board\n----------------------------------------------------------------------------------------------------------------------------------------\n\n", playerName);

        System.out.print("   |  A     B     C     D     E     F     G     H     I     J  |\t   |  A     B     C     D     E     F     G     H     I     J  |\n"
                        + "---+-----------------------------------------------------------+\t---+-----------------------------------------------------------+\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + " 1 |  "+board[0][0]+"  |  "+board[0][1]+"  |  "+board[0][2]+"  |  "+board[0][3]+"  |  "+board[0][4]+"  |  "+board[0][5]+"  |  "+board[0][6]+"  |  "+board[0][7]+"  |  "+board[0][8]+"  |  "+board[0][9]+"  |\t"
                        + " 1 |  "+playerBoard[0][0]+"  |  "+playerBoard[0][1]+"  |  "+playerBoard[0][2]+"  |  "+playerBoard[0][3]+"  |  "+playerBoard[0][4]+"  |  "+playerBoard[0][5]+"  |  "+playerBoard[0][6]+"  |  "+playerBoard[0][7]+"  |  "+playerBoard[0][8]+"  |  "+playerBoard[0][9]+"  |\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + "---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\t---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + " 2 |  "+board[1][0]+"  |  "+board[1][1]+"  |  "+board[1][2]+"  |  "+board[1][3]+"  |  "+board[1][4]+"  |  "+board[1][5]+"  |  "+board[1][6]+"  |  "+board[1][7]+"  |  "+board[1][8]+"  |  "+board[1][9]+"  |\t"
                        + " 2 |  "+playerBoard[1][0]+"  |  "+playerBoard[1][1]+"  |  "+playerBoard[1][2]+"  |  "+playerBoard[1][3]+"  |  "+playerBoard[1][4]+"  |  "+playerBoard[1][5]+"  |  "+playerBoard[1][6]+"  |  "+playerBoard[1][7]+"  |  "+playerBoard[1][8]+"  |  "+playerBoard[1][9]+"  |\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + "---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\t---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + " 3 |  "+board[2][0]+"  |  "+board[2][1]+"  |  "+board[2][2]+"  |  "+board[2][3]+"  |  "+board[2][4]+"  |  "+board[2][5]+"  |  "+board[2][6]+"  |  "+board[2][7]+"  |  "+board[2][8]+"  |  "+board[2][9]+"  |\t"
                        + " 3 |  "+playerBoard[2][0]+"  |  "+playerBoard[2][1]+"  |  "+playerBoard[2][2]+"  |  "+playerBoard[2][3]+"  |  "+playerBoard[2][4]+"  |  "+playerBoard[2][5]+"  |  "+playerBoard[2][6]+"  |  "+playerBoard[2][7]+"  |  "+playerBoard[2][8]+"  |  "+playerBoard[2][9]+"  |\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + "---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\t---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + " 4 |  "+board[3][0]+"  |  "+board[3][1]+"  |  "+board[3][2]+"  |  "+board[3][3]+"  |  "+board[3][4]+"  |  "+board[3][5]+"  |  "+board[3][6]+"  |  "+board[3][7]+"  |  "+board[3][8]+"  |  "+board[3][9]+"  |\t"
                        + " 4 |  "+playerBoard[3][0]+"  |  "+playerBoard[3][1]+"  |  "+playerBoard[3][2]+"  |  "+playerBoard[3][3]+"  |  "+playerBoard[3][4]+"  |  "+playerBoard[3][5]+"  |  "+playerBoard[3][6]+"  |  "+playerBoard[3][7]+"  |  "+playerBoard[3][8]+"  |  "+playerBoard[3][9]+"  |\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + "---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\t---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + " 5 |  "+board[4][0]+"  |  "+board[4][1]+"  |  "+board[4][2]+"  |  "+board[4][3]+"  |  "+board[4][4]+"  |  "+board[4][5]+"  |  "+board[4][6]+"  |  "+board[4][7]+"  |  "+board[4][8]+"  |  "+board[4][9]+"  |\t"
                        + " 5 |  "+playerBoard[4][0]+"  |  "+playerBoard[4][1]+"  |  "+playerBoard[4][2]+"  |  "+playerBoard[4][3]+"  |  "+playerBoard[4][4]+"  |  "+playerBoard[4][5]+"  |  "+playerBoard[4][6]+"  |  "+playerBoard[4][7]+"  |  "+playerBoard[4][8]+"  |  "+playerBoard[4][9]+"  |\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + "---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\t---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + " 6 |  "+board[5][0]+"  |  "+board[5][1]+"  |  "+board[5][2]+"  |  "+board[5][3]+"  |  "+board[5][4]+"  |  "+board[5][5]+"  |  "+board[5][6]+"  |  "+board[5][7]+"  |  "+board[5][8]+"  |  "+board[5][9]+"  |\t"
                        + " 6 |  "+playerBoard[5][0]+"  |  "+playerBoard[5][1]+"  |  "+playerBoard[5][2]+"  |  "+playerBoard[5][3]+"  |  "+playerBoard[5][4]+"  |  "+playerBoard[5][5]+"  |  "+playerBoard[5][6]+"  |  "+playerBoard[5][7]+"  |  "+playerBoard[5][8]+"  |  "+playerBoard[5][9]+"  |\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + "---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\t---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + " 7 |  "+board[6][0]+"  |  "+board[6][1]+"  |  "+board[6][2]+"  |  "+board[6][3]+"  |  "+board[6][4]+"  |  "+board[6][5]+"  |  "+board[6][6]+"  |  "+board[6][7]+"  |  "+board[6][8]+"  |  "+board[6][9]+"  |\t"
                        + " 7 |  "+playerBoard[6][0]+"  |  "+playerBoard[6][1]+"  |  "+playerBoard[6][2]+"  |  "+playerBoard[6][3]+"  |  "+playerBoard[6][4]+"  |  "+playerBoard[6][5]+"  |  "+playerBoard[6][6]+"  |  "+playerBoard[6][7]+"  |  "+playerBoard[6][8]+"  |  "+playerBoard[6][9]+"  |\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + "---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\t---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + " 8 |  "+board[7][0]+"  |  "+board[7][1]+"  |  "+board[7][2]+"  |  "+board[7][3]+"  |  "+board[7][4]+"  |  "+board[7][5]+"  |  "+board[7][6]+"  |  "+board[7][7]+"  |  "+board[7][8]+"  |  "+board[7][9]+"  |\t"
                        + " 8 |  "+playerBoard[7][0]+"  |  "+playerBoard[7][1]+"  |  "+playerBoard[7][2]+"  |  "+playerBoard[7][3]+"  |  "+playerBoard[7][4]+"  |  "+playerBoard[7][5]+"  |  "+playerBoard[7][6]+"  |  "+playerBoard[7][7]+"  |  "+playerBoard[7][8]+"  |  "+playerBoard[7][9]+"  |\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + "---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\t---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + " 9 |  "+board[8][0]+"  |  "+board[8][1]+"  |  "+board[8][2]+"  |  "+board[8][3]+"  |  "+board[8][4]+"  |  "+board[8][5]+"  |  "+board[8][6]+"  |  "+board[8][7]+"  |  "+board[8][8]+"  |  "+board[8][9]+"  |\t"
                        + " 9 |  "+playerBoard[8][0]+"  |  "+playerBoard[8][1]+"  |  "+playerBoard[8][2]+"  |  "+playerBoard[8][3]+"  |  "+playerBoard[8][4]+"  |  "+playerBoard[8][5]+"  |  "+playerBoard[8][6]+"  |  "+playerBoard[8][7]+"  |  "+playerBoard[8][8]+"  |  "+playerBoard[8][9]+"  |\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + "---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\t---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + "10 |  "+board[9][0]+"  |  "+board[9][1]+"  |  "+board[9][2]+"  |  "+board[9][3]+"  |  "+board[9][4]+"  |  "+board[9][5]+"  |  "+board[9][6]+"  |  "+board[9][7]+"  |  "+board[9][8]+"  |  "+board[9][9]+"  |\t"
                        + "10 |  "+playerBoard[9][0]+"  |  "+playerBoard[9][1]+"  |  "+playerBoard[9][2]+"  |  "+playerBoard[9][3]+"  |  "+playerBoard[9][4]+"  |  "+playerBoard[9][5]+"  |  "+playerBoard[9][6]+"  |  "+playerBoard[9][7]+"  |  "+playerBoard[9][8]+"  |  "+playerBoard[9][9]+"  |\n"
                        + "   |     |     |     |     |     |     |     |     |     |     |\t   |     |     |     |     |     |     |     |     |     |     |\n"
                        + "---+-----------------------------------------------------------+\t---+-----------------------------------------------------------+\n"

        );


    }


    /*********************************************************************************
    *   checkHit                                                                     *
    *                                                                                *
    *   Purpose:        Check if computer input hit a player's ship.                 *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public static void checkHit(String computerChoice)
    {
        Scanner in = new Scanner(System.in);
        // Checks computer's input for a hit or miss, prints accordingly.
        if ((computerChoice.equals("A1") || computerChoice.equals("a1")) && playerBoard[0][0] != (' ')) {
            System.out.println("The Computer got a hit!");
            playerBoard[0][0] = '@';
        } else if ((computerChoice.equals("A2") || computerChoice.equals("a2")) && playerBoard[1][0] != (' ')) {
            System.out.println("The Computer got a hit!");
            playerBoard[1][0] = '@';
        } else if ((computerChoice.equals("A3") || computerChoice.equals("a3")) && playerBoard[2][0] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[2][0] = '@';
        } else if ((computerChoice.equals("A4") || computerChoice.equals("A4")) && playerBoard[3][0] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[3][0] = '@';
        }  else if ((computerChoice.equals("A5") || computerChoice.equals("a5")) && playerBoard[4][0] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[4][0] = '@';
        }  else if ((computerChoice.equals("A6") || computerChoice.equals("a6")) && playerBoard[5][0] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[5][0] = '@';
        }  else if ((computerChoice.equals("A7") || computerChoice.equals("a7")) && playerBoard[6][0] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[6][0] = '@';
        }  else if ((computerChoice.equals("A8") || computerChoice.equals("a8")) && playerBoard[7][0] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[7][0] = '@';
        }  else if ((computerChoice.equals("A9") || computerChoice.equals("a9")) && playerBoard[8][0] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[8][0] = '@';
        }  else if ((computerChoice.equals("A10") || computerChoice.equals("a10")) && playerBoard[9][0] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[9][0] = '@';
        } else if ((computerChoice.equals("B1") || computerChoice.equals("b1")) && playerBoard[0][1] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[0][1] = '@';
        } else if ((computerChoice.equals("B2") || computerChoice.equals("b2")) && playerBoard[1][1] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[1][1] = '@';
        } else if ((computerChoice.equals("B3") || computerChoice.equals("b3")) && playerBoard[2][1] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[2][1] = '@';
        } else if ((computerChoice.equals("B4") || computerChoice.equals("b4")) && playerBoard[3][1] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[3][1] = '@';
        }  else if ((computerChoice.equals("B5") || computerChoice.equals("b5")) && playerBoard[4][1] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[4][1] = '@';
        }  else if ((computerChoice.equals("B6") || computerChoice.equals("b6")) &&  playerBoard[5][1] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[5][1] = '@';
        }  else if ((computerChoice.equals("B7") || computerChoice.equals("b7")) && playerBoard[6][1] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[6][1] = '@';
        }  else if ((computerChoice.equals("B8") || computerChoice.equals("b8")) && playerBoard[7][1] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[7][1] = '@';
        }  else if ((computerChoice.equals("B9") || computerChoice.equals("b9")) && playerBoard[8][1] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[8][1] = '@';
        }  else if ((computerChoice.equals("B10") || computerChoice.equals("b10")) && playerBoard[9][1] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[9][1] = '@';
        } else if ((computerChoice.equals("C1") || computerChoice.equals("c1")) && playerBoard[0][2] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[0][2] = '@';
        } else if ((computerChoice.equals("C2") || computerChoice.equals("c2")) && playerBoard[1][2] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[1][2] = '@';
        } else if ((computerChoice.equals("C3") || computerChoice.equals("c3")) && playerBoard[2][2] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[2][2] = '@';
        } else if ((computerChoice.equals("C4") || computerChoice.equals("c4")) && playerBoard[3][2] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[3][2] = '@';
        }  else if ((computerChoice.equals("C5") || computerChoice.equals("c5")) && playerBoard[4][2] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[4][2] = '@';
        }  else if ((computerChoice.equals("C6") || computerChoice.equals("c6")) && playerBoard[5][2] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[5][2] = '@';
        }  else if ((computerChoice.equals("C7") || computerChoice.equals("c7")) && playerBoard[6][2] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[6][2] = '@';
        }  else if ((computerChoice.equals("C8") || computerChoice.equals("c8")) && playerBoard[7][2] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[7][2] = '@';
        }  else if ((computerChoice.equals("C9") || computerChoice.equals("c9")) && playerBoard[8][2] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[8][2] = '@';
        }  else if ((computerChoice.equals("C10") || computerChoice.equals("c10")) && playerBoard[9][2] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[9][2] = '@';
        } else if ((computerChoice.equals("D1") || computerChoice.equals("d1")) && playerBoard[0][3] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[0][3] = '@';
        } else if ((computerChoice.equals("D2") || computerChoice.equals("d2")) && playerBoard[1][3] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[1][3] = '@';
        } else if ((computerChoice.equals("D3") || computerChoice.equals("d3")) && playerBoard[2][3] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[2][3] = '@';
        } else if ((computerChoice.equals("D4") || computerChoice.equals("d4")) && playerBoard[3][3] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[3][3] = '@';
        }  else if ((computerChoice.equals("D5") || computerChoice.equals("d5")) && playerBoard[4][3] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[4][3] = '@';
        }  else if ((computerChoice.equals("D6") || computerChoice.equals("d6")) && playerBoard[5][3] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[5][3] = '@';
        }  else if ((computerChoice.equals("D7") || computerChoice.equals("d7")) && playerBoard[6][3] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[6][3] = '@';
        }  else if ((computerChoice.equals("D8") || computerChoice.equals("d8"))&& playerBoard[7][3] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[7][3] = '@';
        }  else if ((computerChoice.equals("D9") || computerChoice.equals("d9")) && playerBoard[8][3] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[8][3] = '@';
        }  else if ((computerChoice.equals("D10") || computerChoice.equals("d10")) && playerBoard[9][3] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[9][3] = '@';
        } else if ((computerChoice.equals("E1") || computerChoice.equals("e1")) && playerBoard[0][4] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[0][4] = '@';
        } else if ((computerChoice.equals("E2") || computerChoice.equals("e2")) && playerBoard[1][4] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[1][4] = '@';
        } else if ((computerChoice.equals("E3") || computerChoice.equals("e3")) && playerBoard[2][4] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[2][4] = '@';
        } else if ((computerChoice.equals("E4") || computerChoice.equals("e4")) && playerBoard[3][4] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[3][4] = '@';
        }  else if ((computerChoice.equals("E5") || computerChoice.equals("e5")) && playerBoard[4][4] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[4][4] = '@';
        }  else if ((computerChoice.equals("E6") || computerChoice.equals("e6")) && playerBoard[5][4] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[5][4] = '@';
        }  else if ((computerChoice.equals("E7") || computerChoice.equals("e7")) && playerBoard[6][4] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[6][4] = '@';
        }  else if ((computerChoice.equals("E8") || computerChoice.equals("e8")) && playerBoard[7][4] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[7][4] = '@';
        }  else if ((computerChoice.equals("E9") || computerChoice.equals("e9")) && playerBoard[8][4] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[8][4] = '@';
        }  else if ((computerChoice.equals("E10") || computerChoice.equals("e10")) && playerBoard[9][4] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[9][4] = '@';
        } else if ((computerChoice.equals("F1") || computerChoice.equals("f1")) && playerBoard[0][5] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[0][5] = '@';
        } else if ((computerChoice.equals("F2") || computerChoice.equals("f2")) && playerBoard[1][5] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[1][5] = '@';
        } else if ((computerChoice.equals("F3") || computerChoice.equals("f3")) && playerBoard[2][5] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[2][5] = '@';
        } else if ((computerChoice.equals("F4") || computerChoice.equals("f4")) && playerBoard[3][5] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[3][5] = '@';
        }  else if ((computerChoice.equals("F5") || computerChoice.equals("f5")) && playerBoard[4][5] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[4][5] = '@';
        }  else if ((computerChoice.equals("F6") || computerChoice.equals("f6")) && playerBoard[5][5] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[5][5] = '@';
        }  else if ((computerChoice.equals("F7") || computerChoice.equals("f7")) && playerBoard[6][5] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[6][5] = '@';
        }  else if ((computerChoice.equals("F8") || computerChoice.equals("f8")) && playerBoard[7][5] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[7][5] = '@';
        }  else if ((computerChoice.equals("F9") || computerChoice.equals("f9")) && playerBoard[8][5] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[8][5] = '@';
        }  else if ((computerChoice.equals("F10") || computerChoice.equals("f10")) && playerBoard[9][5] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[9][5] = '@';
        } else if ((computerChoice.equals("G1") || computerChoice.equals("g1")) && playerBoard[0][6] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[0][6] = '@';
        } else if ((computerChoice.equals("G2") || computerChoice.equals("g2")) && playerBoard[1][6] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[1][6] = '@';
        } else if ((computerChoice.equals("G3") || computerChoice.equals("g3")) && playerBoard[2][6] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[2][6] = '@';
        } else if ((computerChoice.equals("G4") || computerChoice.equals("g4")) && playerBoard[3][6] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[3][6] = '@';
        }  else if ((computerChoice.equals("G5") || computerChoice.equals("g5")) && playerBoard[4][6] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[4][6] = '@';
        }  else if ((computerChoice.equals("G6") || computerChoice.equals("g6")) && playerBoard[5][6] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[5][6] = '@';
        }  else if ((computerChoice.equals("G7") || computerChoice.equals("g7")) && playerBoard[6][6] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[6][6] = '@';
        }  else if ((computerChoice.equals("G8") || computerChoice.equals("g8")) && playerBoard[7][6] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[7][6] = '@';
        }  else if ((computerChoice.equals("G9") || computerChoice.equals("g9")) && playerBoard[8][6] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[8][6] = '@';
        }  else if ((computerChoice.equals("G10") || computerChoice.equals("g10")) && playerBoard[9][6] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[9][6] = '@';
        } else if ((computerChoice == "H1" || computerChoice == "h1") && playerBoard[0][7] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[0][7] = '@';
        } else if ((computerChoice == "H2" || computerChoice == "h2") && playerBoard[1][7] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[1][7] = '@';
        } else if ((computerChoice == "H3" || computerChoice == "h3") && playerBoard[2][7] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[2][7] = '@';
        } else if ((computerChoice == "H4" || computerChoice == "h4") && playerBoard[3][7] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[3][7] = '@';
        }  else if ((computerChoice == "H5" || computerChoice == "h5") && playerBoard[4][7] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[4][7] = '@';
        }  else if ((computerChoice == "H6" || computerChoice == "h6") && playerBoard[5][7] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[5][7] = '@';
        }  else if ((computerChoice == "H7" || computerChoice == "h7") && playerBoard[6][7] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[6][7] = '@';
        }  else if ((computerChoice == "H8" || computerChoice == "h8") && playerBoard[7][7] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[7][7] = '@';
        }  else if ((computerChoice == "H9" || computerChoice == "h9") && playerBoard[8][7] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[8][7] = '@';
        }  else if ((computerChoice == "H10" || computerChoice == "h10") && playerBoard[9][7] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[9][7] = '@';
        } else if ((computerChoice == "I1" || computerChoice == "i1") && playerBoard[0][8] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[0][8] = '@';
        } else if ((computerChoice == "I2" || computerChoice == "i2") && playerBoard[1][8] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[1][8] = '@';
        } else if ((computerChoice == "I3" || computerChoice == "i3") && playerBoard[2][8] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[2][8] = '@';
        } else if ((computerChoice == "I4" || computerChoice == "i4") && playerBoard[3][8] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[3][8] = '@';
        }  else if ((computerChoice == "I5" || computerChoice == "i5") && playerBoard[4][8] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[4][8] = '@';
        }  else if ((computerChoice == "I6" || computerChoice == "i6") && playerBoard[5][8] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[5][8] = '@';
        }  else if ((computerChoice == "I7" || computerChoice == "i7") && playerBoard[6][8] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[6][8] = '@';
        }  else if ((computerChoice == "I8" || computerChoice == "i8") && playerBoard[7][8] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[7][8] = '@';
        }  else if ((computerChoice == "I9" || computerChoice == "i9") && playerBoard[8][8] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[8][8] = '@';
        }  else if ((computerChoice == "I10" || computerChoice == "i10") && playerBoard[9][8] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[9][8] = '@';
        } else if ((computerChoice == "J1" || computerChoice == "j1") && playerBoard[0][9] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[0][9] = '@';
        } else if ((computerChoice == "J2" || computerChoice == "j2") && playerBoard[1][9] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[1][9] = '@';
        } else if ((computerChoice == "J3" || computerChoice == "j3") && playerBoard[2][9] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[2][9] = '@';
        } else if ((computerChoice == "J4" || computerChoice == "j4") && playerBoard[3][9] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[3][9] = '@';
        }  else if ((computerChoice == "J5" || computerChoice == "j5") && playerBoard[4][9] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[4][9] = '@';
        }  else if ((computerChoice == "J6" || computerChoice == "j6") && playerBoard[5][9] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[5][9] = '@';
        }  else if ((computerChoice == "J7" || computerChoice == "j7") && playerBoard[6][9] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[6][9] = '@';
        }  else if ((computerChoice == "J8" || computerChoice == "j8") && playerBoard[7][9] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[7][9] = '@';
        }  else if ((computerChoice == "J9" || computerChoice == "j9") && playerBoard[8][9] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[8][9] = '@';
        }  else if ((computerChoice == "J10" || computerChoice == "j10") && playerBoard[9][9] != ' ') {
            System.out.println("The Computer got a hit!");
            playerBoard[9][9] = '@';
        } else {
            System.out.println("Computer missed!");
        }
        System.out.println();
    }
}
