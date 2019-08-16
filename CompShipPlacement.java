import java.util.Random;

public class CompShipPlacement
{
    // Attributes
    private char board[][];
    private char hiddenBoard[][];

    public CompShipPlacement(char[][] board, char[][] hiddenBoard)
    {
        this.board = board;
        this.hiddenBoard = hiddenBoard;
    }

    /*********************************************************************************
    *   placeCarrier                                                                 *
    *                                                                                *
    *   Purpose:        Places ships for player's boards.                            *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public void placeCompCarrier()  // Occupies 5 spaces
    {
        int compRowSideOne = 0;
        int compColSideOne = 0;
        int compRowSideTwo = 0;
        int compColSideTwo = 0;
        int compRowSideThree = 0;
        int compColSideThree = 0;
        int compRowSideFour = 0;
        int compColSideFour = 0;
        int compBoatDirection = 0;
        int compRowMid = 0;
        int compColMid = 0;

        do {
            Random compRand = new Random();

            // Computer boat direction
            compBoatDirection = compRand.nextInt(2);

            // Player coordinates
            compRowMid = compRand.nextInt(6) + 1;
            compColMid = compRand.nextInt(6) + 1;

            // Player boat location
            if (compBoatDirection == 0) {           // horizontal direction
                compRowSideOne = compRowMid;
                compColSideOne = compColMid - 1;
                compRowSideTwo = compRowMid;
                compColSideTwo = compColMid + 1;
                compRowSideThree = compRowMid;
                compColSideThree = compColMid - 2;
                compRowSideFour = compRowMid;
                compColSideFour = compColMid + 2;
            } else if (compBoatDirection == 1) {    // Vertical direction
                compRowSideOne = compRowMid - 1;
                compColSideOne = compColMid;
                compRowSideTwo = compRowMid + 1;
                compColSideTwo = compColMid;
                compRowSideThree = compRowMid - 2;
                compColSideThree = compColMid;
                compRowSideFour = compRowMid + 2;
                compColSideFour = compColMid;
            }

            // Checks for empty spaces, places complete ship.
            if (hiddenBoard[compRowMid][compColMid] == ' ' && hiddenBoard[compRowSideOne][compColSideOne] == ' ' && hiddenBoard[compRowSideTwo][compColSideTwo] == ' ') {
                hiddenBoard[compRowMid][compColMid] = 'A';
                hiddenBoard[compRowSideOne][compColSideOne] = 'A';
                hiddenBoard[compRowSideTwo][compColSideTwo] = 'A';
                hiddenBoard[compRowSideThree][compColSideThree] = 'A';
                hiddenBoard[compRowSideFour][compColSideFour] = 'A';
                break;
            }
        } while (hiddenBoard[compRowMid][compColMid] != ' ' || hiddenBoard[compRowSideOne][compColSideOne] != ' ' || hiddenBoard[compRowSideTwo][compColSideTwo] != ' ');

    }


    /*********************************************************************************
    *   placeBattleship                                                              *
    *                                                                                *
    *   Purpose:        Places ships for player's boards.                            *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public void placeCompBattleship()  // Occupies 4 spaces
    {
        int compRowSideOne = 0;
        int compColSideOne = 0;
        int compRowSideTwo = 0;
        int compColSideTwo = 0;
        int compRowSideThree = 0;
        int compColSideThree = 0;
        int compBoatDirection = 0;
        int compRowMid = 0;
        int compColMid = 0;

        do {
            Random rand = new Random();
            // Computer boat direction
            compBoatDirection = rand.nextInt(2);

            // Player coordinates
            compRowMid = rand.nextInt(7) + 1;
            compColMid = rand.nextInt(7) + 1;

            // Player boat location
            if (compBoatDirection == 0) {           // horizontal direction
                compRowSideOne = compRowMid;
                compColSideOne = compColMid - 1;
                compRowSideTwo = compRowMid;
                compColSideTwo = compColMid + 1;
                compRowSideThree = compRowMid;
                compColSideThree = compColMid + 2;
            } else if (compBoatDirection == 1) {    // Vertical direction
                compRowSideOne = compRowMid - 1;
                compColSideOne = compColMid;
                compRowSideTwo = compRowMid + 1;
                compColSideTwo = compColMid;
                compRowSideThree = compRowMid + 2;
                compColSideThree = compColMid;
            }

            // Checks for empty spaces, places complete ship.
            if (hiddenBoard[compRowMid][compColMid] == ' ' && hiddenBoard[compRowSideOne][compColSideOne] == ' ' && hiddenBoard[compRowSideTwo][compColSideTwo] == ' ') {
                hiddenBoard[compRowMid][compColMid] = 'B';
                hiddenBoard[compRowSideOne][compColSideOne] = 'B';
                hiddenBoard[compRowSideTwo][compColSideTwo] = 'B';
                hiddenBoard[compRowSideThree][compColSideThree] = 'B';

                break;
            }
        } while (hiddenBoard[compRowMid][compColMid] != ' ' || hiddenBoard[compRowSideOne][compColSideOne] != ' ' || hiddenBoard[compRowSideTwo][compColSideTwo] != ' ');

    }


    /*********************************************************************************
    *   placeCruiser                                                                 *
    *                                                                                *
    *   Purpose:        Places ships for player's boards.                            *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public void placeCompCrusier() // Occupies 3 spaces.
    {
        int compRowSideOne = 0;
        int compColSideOne = 0;
        int compRowSideTwo = 0;
        int compColSideTwo = 0;
        int compBoatDirection = 0;
        int compRowMid = 0;
        int compColMid = 0;

        do {
            Random rand = new Random();

            // Computer boat direction.
            compBoatDirection = rand.nextInt(2);

            // Player coordinates
            compRowMid = rand.nextInt(8) + 1;
            compColMid = rand.nextInt(8) + 1;

            // Player boat location.
            if (compBoatDirection == 0) {           // horizontal direction.
                compRowSideOne = compRowMid;
                compColSideOne = compColMid - 1;
                compRowSideTwo = compRowMid;
                compColSideTwo = compColMid + 1;
            } else if (compBoatDirection == 1) {    // Vertical direction.
                compRowSideOne = compRowMid - 1;
                compColSideOne = compColMid;
                compRowSideTwo = compRowMid + 1;
                compColSideTwo = compColMid;
            }

            // Checks for empty spaces, places complete ship.
            if (hiddenBoard[compRowMid][compColMid] == ' ' && hiddenBoard[compRowSideOne][compColSideOne] == ' ' && hiddenBoard[compRowSideTwo][compColSideTwo] == ' ') {
                hiddenBoard[compRowMid][compColMid] = 'C';
                hiddenBoard[compRowSideOne][compColSideOne] = 'C';
                hiddenBoard[compRowSideTwo][compColSideTwo] = 'C';
                break;
            }
        } while (hiddenBoard[compRowMid][compColMid] != ' ' || hiddenBoard[compRowSideOne][compColSideOne] != ' ' || hiddenBoard[compRowSideTwo][compColSideTwo] != ' ');

    }


    /*********************************************************************************
    *   placeSubmarine                                                               *
    *                                                                                *
    *   Purpose:        Places ships for player's boards.                            *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public void placeCompSubmarine()  // Occupies 3 spaces.
    {
        int compRowSideOne = 0;
        int compColSideOne = 0;
        int compRowSideTwo = 0;
        int compColSideTwo = 0;
        int compBoatDirection = 0;
        int compRowMid = 0;
        int compColMid = 0;

        do {
            Random rand = new Random();

            // Computer boat direction.
            compBoatDirection = rand.nextInt(2);

            // Player coordinates.
            compRowMid = rand.nextInt(8) + 1;
            compColMid = rand.nextInt(8) + 1;

            // Player boat location
            if (compBoatDirection == 0) {           // horizontal direction.
                compRowSideOne = compRowMid;
                compColSideOne = compColMid - 1;
                compRowSideTwo = compRowMid;
                compColSideTwo = compColMid + 1;
            } else if (compBoatDirection == 1) {    // Vertical direction.
                compRowSideOne = compRowMid - 1;
                compColSideOne = compColMid;
                compRowSideTwo = compRowMid + 1;
                compColSideTwo = compColMid;
            }

            // Checks for empty spaces, places complete ship.
            if (hiddenBoard[compRowMid][compColMid] == ' ' && hiddenBoard[compRowSideOne][compColSideOne] == ' ' && hiddenBoard[compRowSideTwo][compColSideTwo] == ' ') {
                hiddenBoard[compRowMid][compColMid] = 'S';
                hiddenBoard[compRowSideOne][compColSideOne] = 'S';
                hiddenBoard[compRowSideTwo][compColSideTwo] = 'S';
                break;
            }
        } while (hiddenBoard[compRowMid][compColMid] != ' ' || hiddenBoard[compRowSideOne][compColSideOne] != ' ' || hiddenBoard[compRowSideTwo][compColSideTwo] != ' ');

    }


    /*********************************************************************************
    *   placeDestroyer                                                               *
    *                                                                                *
    *   Purpose:        Places ships for player's boards.                            *
    *   Parameters:     args                                                         *
    *   Return Value:   void - this method does not return a type                    *
    *********************************************************************************/
    public void placeCompDestroyer()  // Occupies Destroyer.
    {
        int compRowSideOne = 0;
        int compColSideOne = 0;
        int compRowSideTwo = 0;
        int compColSideTwo = 0;
        int compBoatDirection = 0;
        int compRowMid = 0;
        int compColMid = 0;
        int fourthSpot = 0;
        int fifthSpot = 0;

        do {
            Random rand = new Random();

            // Computer boat direction.
            compBoatDirection = rand.nextInt(2);

            // Player coordinates.
            compRowMid = rand.nextInt(8) + 1;
            compColMid = rand.nextInt(8) + 1;

            // Player boat location
            if (compBoatDirection == 0) {           // horizontal direction.
                compRowSideOne = compRowMid;
                compColSideOne = compColMid - 1;
                compRowSideTwo = compRowMid;
                compColSideTwo = compColMid + 1;
                fifthSpot = compColMid + 2;
                fourthSpot = compColMid - 2;
            } else if (compBoatDirection == 1) {    // Vertical direction.
                compRowSideOne = compRowMid - 1;
                compColSideOne = compColMid;
                fifthSpot = compRowMid + 2;
                fourthSpot = compRowMid - 2;
            }

            // Checks for empty spaces, places complete ship.
            if (hiddenBoard[compRowMid][compColMid] == ' ' && hiddenBoard[compRowSideOne][compColSideOne] == ' ') {
                hiddenBoard[compRowMid][compColMid] = 'D';
                hiddenBoard[compRowSideOne][compColSideOne] = 'D';
                //hiddenBoard[compRowSideTwo][compColSideTwo] = 'D';
                break;
            }
        } while (hiddenBoard[compRowMid][compColMid] != ' ' || hiddenBoard[compRowSideOne][compColSideOne] != ' ' || hiddenBoard[compRowSideTwo][compColSideTwo] != ' ');

    }
}
