/**
 * @file Main.java
 * @brief The test file
 * @author Reda TARGAOUI
 * @version 1.0
 * @date 04/23/2023
 */

import javax.swing.*;
import java.awt.*;

public class Main {

    /**
     * @fn main()
     * @brief Principal function
     */
    public static void main(String[] args) {
        // Create the frame and set its properties :
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setSize(400, 400);
        // Set window's position :
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the x and y position to center the frame on the screen :
        int xPos = (screenSize.width - frame.getWidth()) / 2;
        int yPos = (screenSize.height - frame.getHeight()) / 2;
        // Set the location of the frame :
        frame.setLocation(xPos, yPos);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        // Creating Game board :
        GameBoard gameBoard = new GameBoard();

        // Creating players :
        Player player1 = new Player("Player1", 'X');
        Player player2 = new Player("Player2", 'O');

        // Create buttons and add them to a panel :
        int rows = gameBoard.board.length;
        int columns = gameBoard.board[0].length;
        JPanel buttonPanel = new JPanel(new GridLayout(rows, columns));
        JButton[][] buttons = new JButton[rows][columns];
        // Initialize buttons and add them to the panel :
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                JButton button = new JButton("");// Create button
                button.setFont(new Font("Arial", Font.BOLD, 50));
                button.setBackground(Color.WHITE);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                buttons[i][j] = button;
                buttonPanel.add(button);

                final int x = i;
                final int y = j;
                // Button click event :
                button.addActionListener(e -> {
                    // Get which player's turn is it and make the move :
                    if ( gameBoard.getTurn() == player1.getSymbol() ) {
                        if ( player1.makeMove(gameBoard.board, x, y) ) {
                            buttons[x][y].setText(String.valueOf(player1.getSymbol()));
                            gameBoard.switchTurn();
                        }
                    }
                    if ( gameBoard.getTurn() == player2.getSymbol() ) {
                        if ( player2.makeMove(gameBoard.board, x, y) ) {
                            buttons[x][y].setText(String.valueOf(player2.getSymbol()));
                            gameBoard.switchTurn();
                        }
                    }
                });
            }
        }

        // Add the button panel to the main frame :
        frame.add(buttonPanel, BorderLayout.CENTER);


        // To display the winner :
        JLabel winnerLabel = new JLabel("test");
        // Label's style :
        winnerLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        // Adding label to panel :
        JPanel labelPanel = new JPanel(new FlowLayout());
        labelPanel.add(winnerLabel);
        frame.add(labelPanel, BorderLayout.SOUTH);


        // Show the frame :
        frame.setVisible(true);


        // Game loop :
        while ( true ) {

            // Check if a player won or not :
            if ( gameBoard.checkWin(player1.getSymbol()) ) {
                winnerLabel.setText(player1.getPlayerName() + "(" + player1.getSymbol() + ") WINS");
                break;
            }
            if ( gameBoard.checkWin(player2.getSymbol()) ) {
                winnerLabel.setText(player2.getPlayerName() + "(" + player2.getSymbol() + ") WINS");
                break;
            }
            if ( gameBoard.fullBoard() ) {
                winnerLabel.setText("GAME ENDED : NO WINNER");
                break;
            }

        }

    }
}
