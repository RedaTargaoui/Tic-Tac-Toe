/**
 * @file Main.java
 * @brief The test file
 * @author Reda TARGAOUI
 * @version 1.0
 * @date 04/23/2023
 */

import java.util.Scanner;

public class Main {

    /**
     * @fn getRowColumn()
     * @brief Get the row and column that matches to the box number
     * @param boxNumber Box number
     * @return int[] array contains row and column values
     */
    public static int[] getRowColumn(int boxNumber) {
        int row = -1;
        int column = -1;

        switch (boxNumber) {
            case 1 -> {
                row = 0;
                column = 0;
            }
            case 2 -> {
                row = 0;
                column = 1;
            }
            case 3 -> {
                row = 0;
                column = 2;
            }
            case 4 -> {
                row = 1;
                column = 0;
            }
            case 5 -> {
                row = 1;
                column = 1;
            }
            case 6 -> {
                row = 1;
                column = 2;
            }
            case 7 -> {
                row = 2;
                column = 0;
            }
            case 8 -> {
                row = 2;
                column = 1;
            }
            case 9 -> {
                row = 2;
                column = 2;
            }
        }

        return new int[]{row, column};
    }

    /**
     * @fn main()
     * @brief Principal function
     */
    public static void main(String[] args) {
        // Creating Game board :
        GameBoard gameBoard = new GameBoard();

        // Creating players :
        Player player1 = new Player("Player1", 'X');
        Player player2 = new Player("Player2", 'O');

        int playerChoice;
        int[] RowColumn; // To get row and column

        Scanner scanner = new Scanner(System.in);// To scan user's input

        gameBoard.DisplayBoard();// Display game board

        // Game loop :
        while ( true ) {

            // Get which player's turn is it
            if ( gameBoard.getTurn() == 'X' ) {
                System.out.println("\t*Your turn " + player1.getPlayerName() + "*");

                System.out.print("->Write box number : ");
                playerChoice = scanner.nextInt();

                RowColumn = getRowColumn(playerChoice);
                player1.makeMove(gameBoard.board, RowColumn[0], RowColumn[1]);//this!!
            }
            if ( gameBoard.getTurn() == 'O' ) {
                System.out.println("\t*Your turn " + player2.getPlayerName() + "*");

                System.out.print("->Write box number : ");
                playerChoice = scanner.nextInt();

                RowColumn = getRowColumn(playerChoice);
                player2.makeMove(gameBoard.board, RowColumn[0], RowColumn[1]);
            }

            gameBoard.DisplayBoard();// Display game board

            // Check if a player won or not :
            if ( gameBoard.checkWin(player1.getSymbol()) ) {
                System.out.println("\t*****PLAYER1 WIN*****");
                break;
            }
            if ( gameBoard.checkWin(player2.getSymbol()) ) {
                System.out.println("\t*****PLAYER2 WIN****");
                break;
            }
            if ( gameBoard.fullBoard() ) {
                System.out.println("\t*****GAME ENDED : NO WINNER*****");
                break;
            }

            // Switch turns between players :
            gameBoard.switchTurn();
        }
    }
}
