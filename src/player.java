//Kru Shah & Darrel Jiang

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A class that creates all the elements necessary for a player
 * to traverse the maze.
 */
public class Player extends JPanel implements ActionListener{
	private int playerNum;
	private int xPos=0;
	private int yPos=0;
	private boolean wasd = false;
	
	private final Board board;
	
	/**
	 * Constructor for the player that will be set on the specified
	 * board.
	 * @param board The board the player will play on.
	 */
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
	
	/**
	 * Inner class that allows for the keyboard input of
	 * {w,a,s,d} to move up, left, down, right.
	 */
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
	
	/**
	 * Allows the player to move left, checking for if the player's next
	 * move hits a win cell or a coin cell.
	 * @param board The board the player will move on.
	 */
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
	
	/**
	 * Allows the player to move right, checking for if the player's next
	 * move hits a win cell or a coin cell.
	 * @param board The board the player will move on.
	 */
	public void moveRight(Board board){
		if((board.get(xPos+1, yPos) != '#') && (board.get(xPos+1, yPos) != '=')){
			board.set(xPos, yPos, 'O');
			if(board.get(xPos+=1, yPos) == '8')	Win();
			else if(board.get(xPos, yPos) == '+') Obstacle();
			else	board.set(xPos, yPos, 'X');
		}
	}
	
	/**
	 * Allows the player to move up, checking for if the player's next
	 * move hits a win cell or a coin cell.
	 * @param board The board the player will move on.
	 */
	public void moveUp(Board board){
		if((board.get(xPos, yPos-1) != '#') && (board.get(xPos, yPos-1) != '=')){
			board.set(xPos, yPos, 'O');
			if(board.get(xPos, yPos-=1) == '8')	Win();
			else if(board.get(xPos, yPos) == '+') Obstacle();
			else	board.set(xPos, yPos, 'X');
		}
	}
	
	/**
	 * Allows the player to move down, checking for if the player's next
	 * move hits a win cell or a coin cell.
	 * @param board The board the player will move on.
	 */
	public void moveDown(Board board){
		if((board.get(xPos, yPos+1) != '#') && (board.get(xPos, yPos+1) != '=')){
			board.set(xPos, yPos, 'O');
			if(board.get(xPos, yPos+=1) == '8') Win();
			else if(board.get(xPos, yPos) == '+') Obstacle();
			else	board.set(xPos, yPos, 'X');
		}
	}
	
	/**
	 * A win method that will display the number of coins obtained.
	 */
	public void Win(){
        new MazeFrame(20, this.playerNum);
	}

	public void Obstacle() {
		JFrame frame = new JFrame("mini game");
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(200, 200);
		Label textLabel = new Label("mini game");

		frame.getContentPane().add(textLabel, BorderLayout.CENTER);

		Button button = new Button("click me to resume maze solving");

		frame.add(button);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}
}	
