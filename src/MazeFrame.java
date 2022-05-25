
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class MazeFrame {
	
	static JFrame frame = new JFrame("Maze");
	JPanel p = new JPanel(new BorderLayout());
	JPanel p2 = new JPanel(new BorderLayout());

	public MazeFrame(int level){
		final Board test = new Board(level,level,level);
		final Player player1 = new Player(test, 1);
		final Player player2 = new Player(test, 2);
		
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
				new MazeFrame(15);
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
		
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBackground(Color.green);
		frame.setVisible(true);
	}

	public MazeFrame(Player player){
        frame.dispose();        
        JFrame frame2 = new JFrame();
		JPanel p1 = new JPanel(new BorderLayout());
		JPanel p2 = new JPanel(new BorderLayout());

		frame2.add(p1, BorderLayout.CENTER);
		frame2.add(p2, BorderLayout.SOUTH);
        
        JLabel textLabel = new JLabel("<html>Congratulations Player #" + player.getPlayerNum() + "!<br>You won with " + player.getPlayerCoins() + " coins collected!</html>", JLabel.CENTER);
        textLabel.setFont(new Font("Verdana", Font.BOLD, 32));

		JButton newgame = new JButton("New Game");

		p1.setBackground(Color.pink);
        p1.add(textLabel, BorderLayout.CENTER);
		p2.add(newgame, BorderLayout.CENTER);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(800,800);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);

		newgame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new MazeFrame(15);
			}
		});
    }
}
