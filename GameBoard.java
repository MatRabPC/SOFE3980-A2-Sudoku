

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class GameBoard  {

    JPanel board;
    private final Square[][] c1squares = new Square[9][9];

    GameBoard() {
        initializeGui();
    }
    
    

    public final void initializeGui() {

        for (int i = 0; i < c1squares.length; i++) {
            for (int j = 0; j < c1squares[i].length; j++) {

                Square square = new Square();
                
                //loop to set background colours blue or white, drawn on the board later
                if ( (j <= 2 || j >= 6) && (i <= 2 || i >= 6) || (j>=3 && j <= 5 && i >= 3 && i <= 5)) {
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

            //paint individual squares onto the board and initialize a text field for each
            for (int i = 0; i < squares.length; i++) {
                for (int j = 0; j < squares[i].length; j++) {

                    Square currentSquare = squares[i][j];

                    JTextField num = new JTextField(squares[i][j].val);
                    num.addKeyListener(this);
                	num.setSize(40,40);
                	num.setLocation(i * width / squares.length + 5, j * height / squares.length + 5);
                	board.add(num);

                    g.setColor(currentSquare.getBackground());
                    g.fillRect(i * width / squares.length, j * height / squares.length, width / squares.length,
                            height / squares.length);

                }
            }
            
        }

        @Override
    	public void keyTyped(KeyEvent e) {
        	confirmNum(e);
        }


        @Override
        public void keyPressed(KeyEvent e) {
        	
        }



        @Override
        public void keyReleased(KeyEvent e) {
        	
        	
        }
        	
        
        
        private void confirmNum(KeyEvent e){
        	
        	//get info from interacted Textbox
        	char c = e.getKeyChar();
        	JTextField field = (JTextField) e.getSource();
        	
        	
        	field.setText(""); //Clears text so only one character can be input
        	
        	//Check if character is within the domain (numbers 1-9)
        	if (c == '1' || c == '2' ||c == '3' ||c == '4' ||c == '5' ||c == '6' ||c == '7' ||c == '8' ||c == '9' ){
        		//testing purposes, makes sure number is read properly and recorded in the correct place
        		System.out.print("Orig value is  " + squares[((field.getY() - 5) /52)][((field.getX() -5) / 54 )].val + " \n");
        		System.out.print("Character " + c + " is valid\n");
        		System.out.print("Found at coords " + field.getX() + ", " + field.getY() + "or square[" + ((field.getY() - 5) /52) +  "][" +  +((field.getX() -5) / 54 ) + "]\n\n" );
        		
        		//System.out.print("The number below is " +  );
        		//field.setText(Character.toString(c));
        		//field.setEditable(false);
        		
        		//calculate which square the text field represents 
        		squares[((field.getY() - 5) / 52)][((field.getX() - 5) / 54 )].val = c; //save value to square
        	}
        	else {
        	System.out.print("character " + c + " is not valid\n");
        	}
        }
        
       
        
    }
    
    
//Constructor class for the squares, deals with background colour as well as stores the value for the individual board space
    private class Square {
    	
    	char val;

        boolean isSelected;
        Color background;

        public boolean isSelected() {
            return isSelected;
        }
        
        public void setEditable(boolean b) {
			// TODO Auto-generated method stub
			
		}

		public char getVal(){
        	return val;
        }

        public void addKeyListener(){
        	this.addKeyListener();
        }

		public void setSelected(final boolean isSelected) {
            this.isSelected = isSelected;
        }

        public Color getBackground() {
            return background;
        }

        public void setBackground(final Color background) {
            this.background = background;
        }

    }



	

}