/**
 * @file Player.java
 * @brief Represents the player part in the game
 * @author Reda TARGAOUI
 * @version 1.0
 * @date 04/23/2023
 */

public class Player {
    // Attributes :
    private String playerName;
    private char symbol;

    // Constructor :
    /**
     * @fn Player()
     * @brief Initialise the object
     * @param playerName player's name
     * @param symbol the player's symbol
     */
    public Player(String playerName, char symbol) {
        setPlayerName(playerName);
        setSymbol(symbol);
    }

    /**
     * @fn getPlayerName()
     * @brief Access the player's name
     * @return String the player's name
     */
    public String getPlayerName() {
        return this.playerName;
    }

    /**
     * @fn getSymbol()
     * @brief Access the player's symbol
     * @return char the player's symbol
     */
    public char getSymbol() {
        return this.symbol;
    }

    /**
     * @fn setPlayerName()
     * @brief Set the player's name
     * @param playerName player's name
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * @fn setSymbol()
     * @brief Set the player's symbol
     * @param symbol player's symbol
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * @fn makeMove()
     * @brief Set the player's move
     * @param board GameBoard
     * @return boolean true in case of a made move, false otherwise
     */
    public boolean makeMove(char[][] board, int row, int column) {
        // Check if box is still available :
        if ( board[row][column] == 'X' || board[row][column] == 'O' ) {
            return false;
        }

        // Set player's move :
        board[row][column] = this.symbol;
        
        return true;
    }

}
