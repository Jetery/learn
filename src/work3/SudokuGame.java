package work3;

import javax.swing.*;

public class SudokuGame extends JFrame{
	public SudokuGame()
	{
		//add a sudoku
			this.add(new Sudoku());
		//exit program when click close
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//好像是设置了大小
			this.pack();
		//name
			this.setTitle("Sudoku");
		//can't be set bigger or smaller
			this.setResizable(false);
		//visible
			this.setVisible(true);
	}
	public static void main(String[] args) {
		
		/**
		 * [TODO 1]
		 * Check Swing program template on how to run the constructor
		 */
		//Just extends JFrame;
		new SudokuGame();
   }

}
