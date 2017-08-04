
public class SnakeThread extends Thread{
	private Snake s;
	private SnakePanel sp;
	public SnakeThread(Snake s,SnakePanel sp){
		this.s = s;
		this.sp = sp;
	}
	public void run(){
		while(true){
		try{
			
				s.move();
				sp.repaint();
				sleep(150);
			
			
		}
		catch(InterruptedException e){
			System.out.println(e);
		}
		}
	}
}
