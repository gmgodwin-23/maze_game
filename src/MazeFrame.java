//Kru Shah & Darrel Jiang

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;


/**
 *	A class that encompasses the elements of the game board including
 *	the maze GUI and the buttons for movement.
 */
public class MazeFrame {
	
	static JFrame frame = new JFrame("Maze");
	JPanel p = new JPanel(new BorderLayout());
	JPanel p2 = new JPanel(new BorderLayout());
	
	/**
	 * Constructs the maze frame with a board and a player along with
	 * all the button listeners for movement.
	 * @param level
	 */
	public MazeFrame(int level){		
		
		final Board test = new Board(level,level,level);
		final Player player1 = new Player(test, 1);
		player1.setStartPos(1,1);
		final Player player2 = new Player(test, 2);
		player2.setStartPos(20,1);
		
		p.add(test, BorderLayout.CENTER);
		p.setFocusable(true);
		frame.add(p, BorderLayout.CENTER);				
		frame.add(p2, BorderLayout.SOUTH);
		
		JButton menu = new JButton("New Game");
		menu.setFocusable(false);
		p2.add(menu, BorderLayout.CENTER);
		menu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{	
				frame.dispose();
				new MainMenu();
			}
		});	
				
		p.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e){				
				int keyCode = e.getKeyCode();

				// player 1
				if(e.getKeyChar() == 'a') player1.moveLeft(test);
				if(e.getKeyChar() == 'd') player1.moveRight(test);
				if(e.getKeyChar() == 'w') player1.moveUp(test);
				if(e.getKeyChar() == 's') player1.moveDown(test);

				// player 2
				if (keyCode == KeyEvent.VK_LEFT) player2.moveLeft(test);
				if (keyCode == KeyEvent.VK_RIGHT) player2.moveRight(test);
				if (keyCode == KeyEvent.VK_UP) player2.moveUp(test);
				if (keyCode == KeyEvent.VK_DOWN) player2.moveDown(test);
			}
		});	
		
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBackground(Color.green);
		frame.setVisible(true);
	}

	/**
	 * Constructor for maze frame that displays the win frame.
	 * @param level The size of the Frame
	 * @param money The amount of coins collected by the player.
	 */
	public MazeFrame(int level, int money){
        
        frame.dispose();        
        JFrame frame2 = new JFrame();
        
        JLabel textLabel = new JLabel("<html>Congratulations!<br>You got " + money + " coin(s)!</html>", JLabel.CENTER);
        textLabel.setFont(new Font("Verdana", Font.BOLD, 32));
        
        frame2.setBackground(Color.green);
        frame2.add(textLabel, BorderLayout.CENTER);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(500,500);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
    }
}
