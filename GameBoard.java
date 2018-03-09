import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class GameBoard  {

	//Globally initialize the board panel and array of fields to be stored in
    JPanel board;
    private final Square[][] c1squares = new Square[9][9];

    GameBoard() {
        initializeGui();
    }//end GameBoard()
    

    public final void initializeGui() {

        for (int i = 0; i < c1squares.length; i++) {
            for (int j = 0; j < c1squares[i].length; j++) {

            	//initialize each space a number can be in
                Square square = new Square();
                
                //loop to set background colors blue or white, drawn on the board later
                if ( (j <= 2 || j >= 6) && (i <= 2 || i >= 6) || (j >=3 && j <= 5 && i >= 3 && i <= 5)) {
                    square.setBackground(Color.BLUE);
                } else {
                    square.setBackground(Color.WHITE);
                }

                c1squares[i][j] = square;
            }
        }

        //board initialization 
        board = new BoardPanel(c1squares);
        board.setFocusable(true);        
        board.setBorder(new EmptyBorder(5,5,5,5));
        

    }//end initializeGui()

    public final JComponent getGui() {
        return board;
    }//end getGui()

    
    private class BoardPanel extends JPanel implements KeyListener {

        Square[][] squares;

        public BoardPanel(final Square[][] squares) {

            this.squares = squares;

        }//end BoardPanel

        @Override
        public void paintComponent(final Graphics g) {

            super.paintComponent(g);

            int width = getWidth();
            int height = getHeight();
            initPuzzle();

            
            for (int i = 0; i < squares.length; i++) {
                for (int j = 0; j < squares[i].length; j++) {

                    Square currentSquare = squares[i][j];
                    
                    //initialize text field for each square on the board
                    JTextField num = new JTextField(c1squares[i][j].val);
                    num.addKeyListener(this);
                	num.setSize(40,40);
                	num.setLocation(i * width / squares.length + 5, j * height / squares.length + 5);
                	board.add(num);
                	num.setText(Character.toString(currentSquare.val));
                	
                	
                	if (currentSquare.val != ' '){
                		//if there is an assigned value from initPuzzle() make the field uneditable and bold so the player knows it is correct
                		num.setEditable(false);
                		num.setFont(num.getFont().deriveFont(Font.BOLD));
                	}
                	
                	//draw each individual square with proper color
                    g.setColor(currentSquare.getBackground());
                    g.fillRect(i * width / squares.length, j * height / squares.length, width / squares.length,
                            height / squares.length);

                }
            }
     
            
        	}//end paintComponent()

        	//Key listener auto generated classes
        	@Override
        	public void keyTyped(KeyEvent e) {
        		//calls outside method so references to the square array run properly
        		confirmNum(e); 
        	}//end keyTyped()


        	@Override
        	public void keyPressed(KeyEvent e) {
        		//irrelevant function for these purposes, needed for KeyListener
        	}//end keyPressed()



        	@Override
        	public void keyReleased(KeyEvent e) {
        		//irrelevant function for these purposes, needed for KeyListener
        	}//end keyReleased()
        	
        
        
        	private void confirmNum(KeyEvent e){
        		//confirm the input is a number between 1-9, manages text boxes to keep them clean
        		//get input, field reference and position in the square array from interacted JTextField within the panel
        		char c = e.getKeyChar();
        		JTextField field = (JTextField) e.getSource();
        		int i = (field.getY() - 5) / 52;
        		int j = (field.getX() - 5) / 54; 
        	
        		//Clears text so only one character can be input
        		field.setText(""); 
        	
        		//Check if character is within the domain (numbers 1-9)
        		if (c == '1' || c == '2' ||c == '3' ||c == '4' ||c == '5' ||c == '6' ||c == '7' ||c == '8' ||c == '9' ){
        			//Case 1: valid input
        			//testing statements, prints previous value, current character and co-ordinates
        			System.out.print("Original value is  " + squares[i][j].val + " \n");
        			System.out.print("Character " + c + " is valid\n");
        			System.out.print("Found at coords (" + field.getX() + ", " + field.getY() + ") or square[" + i +  "][" +  + j + "]\n\n" );
        		
        			//makes sure the value changes back to black if valid
        			field.setForeground(checkSol(c,i,j));
        		
        			if (field.getForeground() == Color.BLACK){
        				//Store character in the value field 
        				squares[j][i].val = c; //save value to square
        			}
        		}
        		else if (c == KeyEvent.VK_BACK_SPACE){
        			//Case 2: backspace
        			//lets users clear number if they want to change
        			squares[j][i].val = ' '; //empties the square's value
        		}
        		else {
        			//Case 3: invalid input
        			System.out.print("Original value is  " + squares[i][j].val + " \n");
        			System.out.print("Character " + c + " is not valid\n");
        			System.out.print("Found at " + " square[" + i +  "][" +  + j + "]\n\n");
        	
        			field.setForeground(Color.RED);
        		}
        	} //end confirmNum()  
        
        
        
        	public Color checkSol(char c, int i, int j){
        		//checks the row, column and box a number belongs to, returns RED text if wrong, returns BLACK if correct
        		System.out.print("square[" + i + "][" + j + "] = " + c + "\n");
        	
        		//check row
        		for (int k = 0; k < 9; k++){
        			if (k != i && squares[k][i].val == c && squares[k][i].val != ' '){
        				System.out.print("Value " + squares[k][i].val + " at location " + k + " in row " + i + " is invalid\n");
        				return Color.RED;
        			}
        			System.out.print("Value " + squares[k][i].val + " in row " + i + " is valid\n");
        		}
        	
    		
        		//check column
        		for (int k = 0; k < 9; k++){
        			if (k != j && squares[j][k].val == c && squares[j][k].val != ' '){
        				System.out.print("Value " + squares[j][k].val + " at location " + k + " in column " + i + " is invalid\n");
        				return Color.RED;
        			}
        			System.out.print("Value " + squares[j][k].val + " in column " + i + " is valid\n");
        		}
        	
        		int boxj = (i / 3) * 3;
        		int boxi = (j / 3) * 3;
        		//check box
        		for (int l = 0; l < 3; l++){
        			for (int k = 0; k < 3; k++){
        				if (l != j && squares[ boxi + k][ boxj + l].val == c && squares[ boxi + k][ boxj + l].val != ' '){
        					System.out.print("Value " + squares[ boxi + k][ boxj + l].val + " at box position " + (k+l) + " is invalid\n" );
        					return Color.RED;
        				}
        				System.out.print("Value " + squares[ boxi + k][ boxj + l].val + " at box position " + (k + l) + " is valid\n" );
        			}
        			
        		}
        	
        		System.out.print("\n");
        		return Color.BLACK;
        	}//end checkSol()
        
    }//end BoardPanel
    
    
    
//Constructor class for the squares, stores value and background colour
    private class Square {
    	
    	char val = ' ';

        Color background;

        public Color getBackground() {
            return background;
        }

        public void setBackground(final Color background) {
            this.background = background;
        }

    }


    public char printSquares(int i, int j){
    	//function that will help test classes read the values of the squares
    	return c1squares[i][j].val;
    	
    	
    }
    
    private void initPuzzle(){
    	//initialize puzzle values, blocks split by rows so it was easier to implement
    	c1squares[0][0].val = '5';
    	c1squares[1][0].val = '4';
    	c1squares[2][0].val = '3';
    	c1squares[4][0].val = '2';
    	c1squares[6][0].val = '8';
    	c1squares[8][0].val = '6';
    	
    	c1squares[1][1].val = '1';
    	c1squares[2][1].val = '9';
    	c1squares[4][1].val = '8';
    	c1squares[5][1].val = '7';
    	c1squares[6][1].val = '5';
    	c1squares[8][1].val = '3';
    	
    	c1squares[0][2].val = '8';
    	c1squares[2][2].val = '6';
    	c1squares[3][2].val = '3';
    	c1squares[6][2].val = '2';
    	c1squares[7][2].val = '1';
    	
    	c1squares[0][3].val = '9';
    	c1squares[3][3].val = '4';
    	c1squares[5][3].val = '5';
    	c1squares[7][3].val = '2';
    	c1squares[8][3].val = '1';
    	
    	c1squares[0][4].val = '3';
    	c1squares[2][4].val = '1';
    	c1squares[4][4].val = '9';
    	c1squares[6][4].val = '6';
    	c1squares[8][4].val = '4';
    	
    	c1squares[0][5].val = '6';
    	c1squares[2][5].val = '4';
    	c1squares[4][5].val = '3';
    	c1squares[5][5].val = '2';
    	c1squares[7][5].val = '8';
    	
    	c1squares[1][6].val = '6';
    	c1squares[3][6].val = '2';
    	c1squares[5][6].val = '3';
    	c1squares[6][6].val = '1';
    	c1squares[7][6].val = '9';
    	
    	c1squares[0][7].val = '4';
    	c1squares[2][7].val = '2';
    	c1squares[3][7].val = '8';
    	c1squares[5][7].val = '9';
    	c1squares[6][7].val = '7';
    	c1squares[8][7].val = '5';
    	
    	c1squares[1][8].val = '9';
    	c1squares[2][8].val = '8';
    	c1squares[4][8].val = '7';
    	c1squares[5][8].val = '6';
    	c1squares[6][8].val = '4';
    	c1squares[8][8].val = '2';
 
    }
    
    
}
