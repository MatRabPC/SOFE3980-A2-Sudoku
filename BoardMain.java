import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;


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
        
        //botTest();
        
    }

public static void botTest(){
    	
    	//simulate input from a user
    	Robot bot;
		try {
			bot = new Robot();
			int mask = InputEvent.BUTTON1_MASK;
			//click on the first box on the panel
			bot.mouseMove(90, 102);
			Thread.sleep(20);
			bot.mousePress(mask);
			bot.mouseRelease(mask);
			Thread.sleep(100);
			
			//square[0][0]: valid number
			bot.keyPress(KeyEvent.VK_3);
			bot.keyRelease(KeyEvent.VK_3);
			Thread.sleep(20);
			bot.keyPress(KeyEvent.VK_TAB);
			bot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(20);
			
			
			//square[1][0]: invalid letter
			bot.keyPress(KeyEvent.VK_A);
			bot.keyRelease(KeyEvent.VK_A);
			Thread.sleep(20);
			bot.keyPress(KeyEvent.VK_TAB);
			bot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(20);
			
			//square[2][0]: valid number
			bot.keyPress(KeyEvent.VK_NUMPAD9);
			bot.keyRelease(KeyEvent.VK_NUMPAD9);
			Thread.sleep(20);
			bot.keyPress(KeyEvent.VK_TAB);
			bot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(20);
			
			//square[3][0]: special key
			bot.keyPress(KeyEvent.VK_ENTER);
			bot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(20);
			bot.keyPress(KeyEvent.VK_TAB);
			bot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(20);
			
			//square[4][0]: valid number to be replaced next step
			bot.keyPress(KeyEvent.VK_5);
			bot.keyRelease(KeyEvent.VK_5);
			Thread.sleep(20);
			bot.keyPress(KeyEvent.VK_TAB);
			bot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(20);
			
			//square[4][0]: replace valid number
			bot.keyPress(KeyEvent.VK_SHIFT);
			bot.keyPress(KeyEvent.VK_TAB);
			bot.keyRelease(KeyEvent.VK_TAB);
			bot.keyRelease(KeyEvent.VK_SHIFT);
			Thread.sleep(20);
			bot.keyPress(KeyEvent.VK_9);
			bot.keyRelease(KeyEvent.VK_9);
			Thread.sleep(20);
			
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
    }
}
