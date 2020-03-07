import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame frame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	GamePanel gamepanel1;

	public LeagueInvaders() {
		
		frame = new JFrame();
		gamepanel1 = new GamePanel();
		
	}

	public static void main(String[] args) {
		
		LeagueInvaders leagueinvaders1 = new LeagueInvaders();
		leagueinvaders1.setup();
		
		}

	void setup() {
		
		frame.add(gamepanel1);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(gamepanel1);

	}
}
