
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BoardMain {

    public static void main(final String[] args) {

        GameBoard gb = new GameBoard();
        JFrame frame = new JFrame("Easy Sudoku");
        JComponent board = gb.getGui();
       
        
        board.setMinimumSize(new Dimension(500, 500));
        board.setPreferredSize(new Dimension(500, 500));
        
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));
        frame.setResizable(false);
        frame.setLocation(50, 50);

		
        frame.add(board);
        frame.pack();
        frame.setVisible(true);
        
        

    }

}
