
import java.awt.event.*;
import javax.swing.*;

public class Player extends JPanel implements ActionListener{
	private int playerNum;
	private int xPos=0;
	private int yPos=0;
	private boolean wasd = false;
	private int objCount = 0;
	
	private final Board board;

	public Player(Board board, int playerNum){
		this.board = board;
		this.playerNum = playerNum;
		if (playerNum == 1) {
			this.wasd = true;
			setStartPos(1, 1);
		}
		else {
			findStartPos();
		}
	}

	public void findStartPos() {
		int quad = board.getGoalPosQuad();
		if (quad == 1 || quad == 4) {
			setStartPos(1, 19);
		}
		if (quad == 2) {
			setStartPos(19, 19);
		}
		if (quad == 3) {
			setStartPos(19, 1);
		}
	}

	public void setStartPos(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	/**
	 * The method repaints the board.
	 */
	public void actionPerformed(ActionEvent e){
		repaint();
	}
	
	/* wasd and arrow keys */
	public class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			if (wasd) {
				if(e.getKeyChar() == 'a') 	moveLeft(board);
				if(e.getKeyChar() == 'w') 	moveUp(board);
				if(e.getKeyChar() == 'd')	moveRight(board);
				if(e.getKeyChar() == 's')	moveDown(board);
			}
			else {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_LEFT) moveLeft(board);
				if (keyCode == KeyEvent.VK_RIGHT) moveRight(board);
				if (keyCode == KeyEvent.VK_UP) moveUp(board);
				if (keyCode == KeyEvent.VK_DOWN) moveDown(board);
			}

		}
	}

	public void moveLeft(Board board){
		if((board.get(xPos-1, yPos) != '#') && (board.get(xPos-1, yPos) != '=')){
			board.set(xPos, yPos, 'O');
			if(board.get(xPos-=1, yPos) == '8')	Win();
			else if(board.get(xPos, yPos) == '+') {
				// obstacle
				Obstacle();
			}
			else 	board.set(xPos, yPos, 'X');
		}
	}

	public void moveRight(Board board){
		if((board.get(xPos+1, yPos) != '#') && (board.get(xPos+1, yPos) != '=')){
			board.set(xPos, yPos, 'O');
			if(board.get(xPos+=1, yPos) == '8')	Win();
			else if(board.get(xPos, yPos) == '+') Obstacle();
			else	board.set(xPos, yPos, 'X');
		}
	}

	public void moveUp(Board board){
		if((board.get(xPos, yPos-1) != '#') && (board.get(xPos, yPos-1) != '=')){
			board.set(xPos, yPos, 'O');
			if(board.get(xPos, yPos-=1) == '8')	Win();
			else if(board.get(xPos, yPos) == '+') Obstacle();
			else	board.set(xPos, yPos, 'X');
		}
	}

	public void moveDown(Board board){
		if((board.get(xPos, yPos+1) != '#') && (board.get(xPos, yPos+1) != '=')){
			board.set(xPos, yPos, 'O');
			if(board.get(xPos, yPos+=1) == '8') Win();
			else if(board.get(xPos, yPos) == '+') Obstacle();
			else	board.set(xPos, yPos, 'X');
		}
	}

	public void Win(){
        new MazeFrame(this);
	}

	public void Obstacle() {
		objCount++;
		board.set(xPos, yPos, 'O');
	}

	public int getPlayerNum() { return this.playerNum; }

	public int getPlayerCoins() { return this.objCount; }
}	
