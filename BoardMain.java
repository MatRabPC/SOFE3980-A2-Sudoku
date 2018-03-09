import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class BoardMain {
	
    public static void main(final String[] args) throws InterruptedException {

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
        
        botTest();
        
    }

public static void botTest() throws InterruptedException{
    	Random r = new Random();
    	Robot bot;
		try {
			bot = new Robot();
			
			//move to first open box on the board
			bot.keyPress(KeyEvent.VK_TAB);
			bot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(20);
			bot.keyPress(KeyEvent.VK_TAB);
			bot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(20);
			bot.keyPress(KeyEvent.VK_TAB);
			bot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(20);
			bot.keyPress(KeyEvent.VK_TAB);
			bot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(20);
			
			//either press a key or tab over
			//boolean check = botBoard.checkPuzzle();
			boolean check = true;
			
			while (check != true){
				int n = 1;
				if (n == 1){
					bot.keyPress(KeyEvent.VK_1);
					bot.keyRelease(KeyEvent.VK_1);
					Thread.sleep(200);
					bot.keyPress(KeyEvent.VK_TAB);
					bot.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(20);
				}
				else if (n == 2){
					bot.keyPress(KeyEvent.VK_2);
					bot.keyRelease(KeyEvent.VK_2);
					Thread.sleep(200);
					bot.keyPress(KeyEvent.VK_TAB);
					bot.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(20);
				}
				else if (n == 3){
					bot.keyPress(KeyEvent.VK_3);
					bot.keyRelease(KeyEvent.VK_3);
					Thread.sleep(200);
					bot.keyPress(KeyEvent.VK_TAB);
					bot.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(20);
				}
				else if (n == 4){
					bot.keyPress(KeyEvent.VK_4);
					bot.keyRelease(KeyEvent.VK_4);
					Thread.sleep(200);
					bot.keyPress(KeyEvent.VK_TAB);
					bot.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(20);
				}
				else if (n == 5){
					bot.keyPress(KeyEvent.VK_5);
					bot.keyRelease(KeyEvent.VK_5);
					Thread.sleep(200);
					bot.keyPress(KeyEvent.VK_TAB);
					bot.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(20);
				}
				else if (n == 6){
					bot.keyPress(KeyEvent.VK_6);
					bot.keyRelease(KeyEvent.VK_6);
					Thread.sleep(200);
					bot.keyPress(KeyEvent.VK_TAB);
					bot.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(20);
				}
				else if (n == 7){
					bot.keyPress(KeyEvent.VK_7);
					bot.keyRelease(KeyEvent.VK_7);
					Thread.sleep(200);
					bot.keyPress(KeyEvent.VK_TAB);
					bot.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(20);
				}
				else if (n == 8){
					bot.keyPress(KeyEvent.VK_8);
					bot.keyRelease(KeyEvent.VK_8);
					Thread.sleep(200);
					bot.keyPress(KeyEvent.VK_TAB);
					bot.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(20);
				}
				else if (n == 9){
					bot.keyPress(KeyEvent.VK_9);
					bot.keyRelease(KeyEvent.VK_9);
					Thread.sleep(200);
					bot.keyPress(KeyEvent.VK_TAB);
					bot.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(20);
				}
				else{
					bot.keyPress(KeyEvent.VK_PERIOD);
					bot.keyRelease(KeyEvent.VK_PERIOD);
					Thread.sleep(200);
					bot.keyPress(KeyEvent.VK_TAB);
					bot.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(20);
				}
			
			}
			
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
    }
}
