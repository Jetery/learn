package work3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class InputListener implements ActionListener {
	
	private work3.Sudoku sudoku;
	//Construction method
	public InputListener(work3.Sudoku s){
		if (s == null)
			throw new IllegalArgumentException("Sudoku obj should not be null.");
		this.sudoku = s;
	}
	   
   @Override
    public void actionPerformed(ActionEvent e) {

       // Get the source object that fired the event
	    /* [TODO 2]
	     * All the 9*9 JTextFields invoke this handler.
	     * 1.We need to determine which JTextField (which row and column) is the source for this invocation.
	     * 2.To check if user's input is correct.
	     * 3.To check if Game is over.
	     * Hint: please notice the member method defined in class Sudoku 
	     */

	   //JTextField cell = new JTextField();
	   //sudoku.findSelectedCell(cell);
	   sudoku.findSelectedCell();
    }

}
