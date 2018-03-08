import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class BoardMaker {

	public static void main(final String[] args){
		String[]choices = {" ","1", "2", "3", "4", "5", "6", "7", "8", "9"};
		JComboBox<String> nums = new JComboBox<String>(choices);
		
		JFrame frame = new JFrame("Easy Sudoku");
		JPanel board = new JPanel(new GridLayout(0,9));		
		JComboBox vals[][] = new JComboBox[9][9];
		
			
			for (int i = 0; i < 9; i ++){
				for (int j = 0; j < 9; j++){
					vals[i][j] = new JComboBox<String>(choices);
					board.add(vals[i][j]);
			
			}
		}
		
			
		
		
			
		
		board.setMinimumSize(new Dimension(100, 100));
	    board.setPreferredSize(new Dimension(500, 500));
	    frame.add(board);
	    frame.setMinimumSize(new Dimension(100, 100));
	    frame.setLocation(50, 50);
	    frame.pack();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
		}
}
