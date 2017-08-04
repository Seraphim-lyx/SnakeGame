import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class SnakeGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnakeFrame sf = new SnakeFrame();
		sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sf.setResizable(false);
		sf.setVisible(true);
//		JOptionPane.showMessageDialog(null,"回车键开始\n上,下,左,右控制蛇的方向");
	}

}
