package work3;

import java.awt.*;
import javax.swing.*;

/**
 * The Sudoku game. To solve the number puzzle, each row, each column, and each
 * of the nine sub-grids shall contain all the digits from 1 to 9
 */

public class Sudoku extends JPanel {
	// Name-constants for the game properties
	public static final int GRID_SIZE = 9; // Size of the board
	public static final int SUBGRID_SIZE = 3; // Size of the sub-grid

	// Name-constants for UI control (sizes, colors and fonts)
	public static final int CELL_SIZE = 60; // Cell width/height in pixels(像素)
	public static final int CANVAS_WIDTH = CELL_SIZE * GRID_SIZE;
	public static final int CANVAS_HEIGHT = CELL_SIZE * GRID_SIZE; // Board width/height in pixels
	public static final Color OPEN_CELL_COLOR = Color.YELLOW;
	public static final Color CLOSED_CELL_COLOR = new Color(240, 240, 240);
	public static final Color CLOSED_CELL_TEXT = Color.BLACK;
	public static final Font FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 20);

	// The game board composes of 9x9 JTextFields,
	// each containing String "1" to "9", or empty String
	private JTextField[][] tfCells = new JTextField[GRID_SIZE][GRID_SIZE];

	// Puzzle to be solved and the mask (which can be used to control the difficulty level).
	// Hardcoded here. Extra credit for automatic puzzle generation with various difficulty levels.
	
	private int[][] puzzle = { 
	        { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, 
			{ 6, 7, 2, 1, 9, 5, 3, 4, 8 },
			{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, 
			{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, 
			{ 4, 2, 6, 8, 5, 3, 7, 9, 1 },
			{ 7, 1, 3, 9, 2, 4, 8, 5, 6 }, 
			{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, 
			{ 2, 8, 7, 4, 1, 9, 6, 3, 5 },
			{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } 
			};

	// For testing, open only 8 cells.
	private boolean[][] masks = { 
			{ false, false, false, false, false, true, false, false, false },
			{ false, false, false, false, false, false, false, false, true },
			{ false, false, false, true, false, false, false, false, false },
			{ true, false, false, false, false, false, true, false, false },
			{ false, false, false, false, false, false, false, false, false },
			{ false, false, true, false, false, false, false, true, false },
			{ false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false },
			{ false, true, false, false, false, true, false, false, false } 
			};

	// Record the location of the cell selected by user
	private int rowSelected = -1;
	private int colSelected = -1;

	/**
	 * Constructor to set up the game and the UI Components
	 */

	public Sudoku() {

		this.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE)); // 9x9 GridLayout

		/**
		 * [TODO 3] 
		 * Allocate a common listener as the ActionEvent listener for all the JTextFields
		 */

		// Construct 9x9 JTextFields and add to the content-pane
		for (int row = 0; row < GRID_SIZE; ++row) {
			for (int col = 0; col < GRID_SIZE; ++col) {
				tfCells[row][col] = new JTextField();      // Allocate element of array
				this.add(tfCells[row][col]);               // ContentPane adds JTextField
				if (masks[row][col]) {
					tfCells[row][col].setText("");         // set to empty string
					tfCells[row][col].setEditable(true);
					tfCells[row][col].setBackground(OPEN_CELL_COLOR);

					/**
					 * [TODO 4] 
					 * Add ActionEvent listener to process the input
					 */


					
				} else {
					tfCells[row][col].setText(puzzle[row][col] + "");
					tfCells[row][col].setEditable(false);
					tfCells[row][col].setBackground(CLOSED_CELL_COLOR);
					tfCells[row][col].setForeground(CLOSED_CELL_TEXT);
				}
				// Beautify all the cells
				tfCells[row][col].setHorizontalAlignment(JTextField.CENTER);
				tfCells[row][col].setFont(FONT_NUMBERS);
			}
		}

		// Set the size of the content-pane and pack all the components under this container.
		this.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

	}

	public void findSelectedCell(JTextField cell) {
		// Scan JTextFields for all rows and columns, and match with the source  object
		this.rowSelected = -1;
		this.colSelected = -1;

		found: for (int row = 0; row < Sudoku.GRID_SIZE; ++row) {
			for (int col = 0; col < Sudoku.GRID_SIZE; ++col) {
				if (tfCells[row][col] == cell) {
					this.rowSelected = row;
					this.colSelected = col;
					break found;
				}
			}
		}
	}

	public void isSelectedCellInputCorrect() {
		if (this.rowSelected == -1 || this.colSelected == -1)
			return;
		/*
		 * [TODO 5] 
		 * 1. Get the input String via tfCells[rowSelected][colSelected].getText() 
		 * 2. Convert the String to int via Integer.parseInt(). 
		 * 3. Assume that the solution is unique.  Compare the input number with 
		 *    the number in the  puzzle[rowSelected][colSelected]. If they are the same, 
		 *    set the background to green (Color.GREEN); otherwise, set to red (Color.RED).
		 */
	}

	public void isGameOver() {
		/*
		 * [TODO 6] 
		 * Check if the player has solved the puzzle after each move.
		 * You can use the following static method to pop up a dialog box with a message:
		 * JOptionPane.showMessageDialog(null, "Congratulation!");
		 */
	}
}