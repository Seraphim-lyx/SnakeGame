import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;


public class SnakeFrame extends JFrame{
	public SnakeFrame(){
		setSize(810,1070);
		setTitle("Snake");
		this.setLocation(360, 150);
		SnakePanel sp =new SnakePanel();
		sp.setBackground(Color.black);
		add(sp, BorderLayout.CENTER);
		
	}
}
