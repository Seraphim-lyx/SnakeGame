import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
import javax.swing.*;



public class SnakePanel extends JPanel implements KeyListener{
	int len=800;
	int wid=1000;//面板大小
	int rectx=20;
	int recty=20;//倍数设置
	int count=1;
	Snake snake;
	Node food;

	
	
	public SnakePanel(){
		snake = new Snake(this);
		setBackground(Color.black);
		setSize(len,wid);
		setFocusable(true);
		
		addKeyListener(this);
		food = snake.createFood();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		for(Node n: snake.getSnake()){
			
			drawNode(g, n);
		}
		
		drawFood(g);
	}
	
	public void drawNode(Graphics g, Node node){
		g.fillRect(node.x*rectx, node.y*recty, rectx, recty);
	
	}
	
	public void drawFood(Graphics g){
		g.fillRect(food.x*rectx, food.y*recty, rectx, recty);
	}
	
	
	public void keyPressed(KeyEvent e) {//实现键盘事件接口
		int keycode = e.getKeyCode();
		if (keycode == KeyEvent.VK_ENTER) {
			begin();
			} else if (keycode == KeyEvent.VK_UP) {
			snake.changeDirection(Snake.up);
			} else if (keycode == KeyEvent.VK_DOWN) {
			snake.changeDirection(Snake.down);
			} else if (keycode == KeyEvent.VK_LEFT) {
			snake.changeDirection(Snake.left);
			} else if (keycode == KeyEvent.VK_RIGHT) {
			snake.changeDirection(Snake.right);
			} 
	}
	public void begin(){
			if(count==1){
			SnakeThread st = new SnakeThread(snake,this);
			st.start();
			count++;
			}
		
	}
	
	
	
	public void keyReleased(KeyEvent e) {
	}


	public void keyTyped(KeyEvent e) {
	}//上述两种方法不需要实现，但必须空处理

	
}
