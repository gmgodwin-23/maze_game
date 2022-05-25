

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu {
	
	JFrame frame = new JFrame("Maze");

	public MainMenu(){
		
		BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

		Label label = new Label("One Totally Awesome Maze");
		label.setFont(new Font("Verdana", Font.BOLD, 36));
		label.setAlignment(label.CENTER);
		
		Button play = new Button("Play");
		play.setFont(new Font("Verdana", Font.BOLD, 25));
		
		Button instruction = new Button("Instructions");
		instruction.setFont(new Font("Verdana", Font.BOLD, 25));

		frame.add(label);
		frame.add(play); 
		frame.add(instruction);

		frame.setLayout(boxLayout);
		frame.setSize(800,800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(true);		
		
		play.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{	
				frame.dispose();
				new MazeFrame(15);
			}
		});
		
		instruction.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{	
				JFrame frame = new JFrame("Instructions");
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				
				JLabel textLabel = new JLabel("" +"<html>" +
						"Play as one of the cyan players and be " +
						"the first to get to reach the green square in the maze </html>");
				frame.getContentPane().add(textLabel, BorderLayout.CENTER);
				
				frame.setLocationRelativeTo(null);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
}
