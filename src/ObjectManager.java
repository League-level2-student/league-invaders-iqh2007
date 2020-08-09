import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {

	Rocketship rocketship2;
	
	int score = 0;

	public ObjectManager(Rocketship x) {
		rocketship2 = x;
	}
	
	public int getScore() {
	    return score;
	    
	  }

	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();

	Random random = new Random();

	void addProjectile(Projectile x) {

		projectiles.add(x); 

	}
	
	

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}

		checkCollision();
		purgeObjects();

	}

	void draw(Graphics g) {
		rocketship2.draw(g);

		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}

	}

	void purgeObjects() {

		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}

		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}
		}

	}

	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if (rocketship2.collisionBox.intersects(aliens.get(i).collisionBox)) {
				rocketship2.isActive = false;
			}
		}

		for (int i = 0; i < projectiles.size(); i++) {
			for (int i2 = 0; i2 < aliens.size(); i2++) {
				if (aliens.get(i2).collisionBox.intersects(projectiles.get(i).collisionBox)) {
					aliens.get(i2).isActive = false;
				}
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		addAlien(); 
		

	}
}
