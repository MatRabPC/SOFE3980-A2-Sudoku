import java.awt.Color;
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
    }
    
    

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
        

    }

    public final JComponent getGui() {
        return board;
    }

    
    private class BoardPanel extends JPanel implements KeyListener {

        Square[][] squares;

        public BoardPanel(final Square[][] squares) {

            this.squares = squares;

        }

        @Override
        public void paintComponent(final Graphics g) {

            super.paintComponent(g);

            int width = getWidth();
            int height = getHeight();
            

            
            for (int i = 0; i < squares.length; i++) {
                for (int j = 0; j < squares[i].length; j++) {

                    Square currentSquare = squares[i][j];
                    

                    //initialize text field for each square on the board
                    JTextField num = new JTextField(c1squares[i][j].val);
                    num.addKeyListener(this);
                	num.setSize(40,40);
                	num.setLocation(i * width / squares.length + 5, j * height / squares.length + 5);
                	board.add(num);

                	//draw each individual square with proper color
                    g.setColor(currentSquare.getBackground());
                    g.fillRect(i * width / squares.length, j * height / squares.length, width / squares.length,
                            height / squares.length);

                }
            }
            
            
        }

        //Key listener auto generated classes
        @Override
    	public void keyTyped(KeyEvent e) {
        	//calls outside method so references to the square array run properly
        	confirmNum(e); 
        }


        @Override
        public void keyPressed(KeyEvent e) {
        	//irrelevant function for these purposes, needed for KeyListener
        }



        @Override
        public void keyReleased(KeyEvent e) {
        	//irrelevant function for these purposes, needed for KeyListener
        }
        	
        
        
        private void confirmNum(KeyEvent e){
        	
        	//get input, field reference and position in the square array from interacted JTextField within the panel
        	char c = e.getKeyChar();
        	JTextField field = (JTextField) e.getSource();
        	int i = (field.getY() - 5) / 52;
        	int j = (field.getX() - 5) / 54; 
        	
        	//Clears text so only one character can be input
        	field.setText(""); 
        	
        	//Check if character is within the domain (numbers 1-9)
        	if (c == '1' || c == '2' ||c == '3' ||c == '4' ||c == '5' ||c == '6' ||c == '7' ||c == '8' ||c == '9' ){
        		//valid input
        		//testing statements, prints previous value, current character and co-ordinates
        		System.out.print("Original value is  " + squares[i][j].val + " \n");
        		System.out.print("Character " + c + " is valid\n");
        		System.out.print("Found at coords (" + field.getX() + ", " + field.getY() + ") or square[" + i +  "][" +  + j + "]\n\n" );
        		
        		//field.setEditable(false);
        		
        		//Store character in the value field 
        		squares[i][j].val = c; //save value to square
        		
        		//makes sure the value changes back to black if valid
        		field.setForeground(Color.BLACK);
        	}
        	else if (c == KeyEvent.VK_BACK_SPACE){
        		//lets users clear number if they want to change
        	}
        	else {
        	//invalid input
        	
        	System.out.print("Original value is  " + squares[i][j].val + " \n");
        	System.out.print("Character " + c + " is not valid\n");
        	System.out.print("Found at " + " square[" + i +  "][" +  + j + "]\n\n");
        	
        	field.setForeground(Color.RED);
        	}
        }
        
       
        
    }
    
    
//Constructor class for the squares, stores value and background colour
    private class Square {
    	
    	char val = '-';

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
    
}
