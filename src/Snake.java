import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import java.awt.Graphics;

public class Snake {
	LinkedList<Node> list;
	SnakePanel sp;
	private int maxX;
	private int maxY;
	
	public static boolean run = true;
	public final static int up=-1;
	public final static int down=1;
	public final static int left=2;
	public final static int right=-2;
	public static int direc = left;
	public Snake(SnakePanel sp){
		this.sp = sp;
		list = new LinkedList<Node>();
		list.add(new Node(sp.len/40,sp.wid/40));
		
		this.maxX = sp.len/sp.rectx;
		this.maxY = sp.wid/sp.recty;
		
	}
	
	public void changeDirection(int direc){
		if(this.direc+direc!=0){
			this.direc=direc;
			System.out.print(direc);
		}
		else{
			System.out.println("opposite direction");
		}
	}
	
	public void move(){
		
		Node head = list.getFirst();
		int x=head.x;
		int y=head.y;
		if(direc==1){
			y++;
		}
		else if(direc==-1){
			y--;
		}
		else if(direc==-2){
			x++;
		}
		else if(direc==2){
			x--;
		}
		System.out.println(y);
		checkLive(x,y);
		checkEat(sp.food,x,y);
	}
	public void checkEat(Node food, int x, int y){
		if(food.x==x && food.y==y){
			list.addFirst(food);
			sp.food = createFood();
		}
		else{
			list.addFirst(new Node(x,y));
			list.removeLast();
//			System.out.println(list.size());
		}
	}
	
	public void checkLive(int x,int y){
		for(Node n:list){
			if(x == n.x && y == n.y ){
				JOptionPane.showMessageDialog(null, "You crash youself");
				System.exit(0);
			}
		}
		if(x==-1 || x== maxX || y==-1 || y==maxY){
			System.out.println(y);
			JOptionPane.showMessageDialog(null, "You crash edge");
			System.exit(0);
		}
	}
	public Node createFood(){
		Node food=null;
		Random r = new Random();
		int x = r.nextInt(maxX-1)+1;
		int y = r.nextInt(maxY-1)+1;
		for(Node n:list){
			if(n.x == x && n.y == y){
				food = createFood();
			}
			else{
				food = new Node(x,y);
			}
		}
		return food;
	}
	
	public List<Node> getSnake(){
		return list;
	}
	
}
