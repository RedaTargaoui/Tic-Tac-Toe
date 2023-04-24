/**
 * @file GameBoard.java
 * @brief Represents the board part in the game
 * @author Reda TARGAOUI
 * @version 1.0
 * @date 04/23/2023
 */

public class GameBoard {
    // Attributes :
    public char[][] board;
    private char currentPlayer;

    // Constructor & destructor :
    /**
     * @fn GameBoard()
     * @brief Initialise the object
     */
    public GameBoard() {
        this.currentPlayer = 'X';// Set X as the first turn

        board = new char[3][3]; // Create board
        char boxNumber = '1';
        // Initialise game board :
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = boxNumber;
                boxNumber++;
            }
        }
    }

    /**
     * @fn DisplayBoard()
     * @brief Display game board
     */
    public void DisplayBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(" " + board[i][j] + " ");
                if ( (board[0].length - 1) > j ) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if ( (board.length - 1) > i ) {
                System.out.println("---+---+---");
            }
        }
    }

    /**
     * @fn fullBoard()
     * @brief Check if the board is full or not
     * @return boolean true in case the board is full, false otherwise
     */
    public boolean fullBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ( board[i][j] != 'X' && board[i][j] != 'O' ) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * @fn getTurn()
     * @brief Get turn variable's content
     * @return turn variable
     */
    public char getTurn() {
        return this.currentPlayer;
    }

    /**
     * @fn switchTurn()
     * @brief Switch players turns
     */
    public void switchTurn() {
        if ( this.currentPlayer == 'X' ) {
            this.currentPlayer = 'O';
        }
        else if ( this.currentPlayer == 'O' ) {
            this.currentPlayer = 'X';
        }
    }

    /**
     * @fn checkWin()
     * @brief Check if a player won or not
     * @param playerSymbol the player's symbol
     * @return boolean true in case of winning, false otherwise
     */
    public boolean checkWin(char playerSymbol) {
        // Rows check :
        for (int row = 0; row < board.length; row++) {
            if ( board[row][0] == playerSymbol && board[row][1] == playerSymbol && board[row][2] == playerSymbol ) {
                return true;
            }
        }

        // Columns check :
        for (int column = 0; column < board[0].length; column++) {
            if ( board[0][column] == playerSymbol && board[1][column] == playerSymbol && board[2][column] == playerSymbol ) {
                return true;
            }
        }

        // Diagonals check :
        if ( board[0][0] == playerSymbol && board[1][1] == playerSymbol && board[2][2] == playerSymbol ) {
            return true;
        }
        if ( board[0][2] == playerSymbol && board[1][1] == playerSymbol && board[2][0] == playerSymbol ) {
            return true;
        }

        return false;
    }

}
