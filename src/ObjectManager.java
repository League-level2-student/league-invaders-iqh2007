import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	Rocketship rocketship2;

	public ObjectManager(Rocketship x) {
		rocketship2 = x;
	}

	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();

	Random random = new Random();

	void addProjectile(Projectile x) {

		projectiles.add(x);

	}

	void addAilen() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}

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

		for(int i = 0; i < aliens.size(); i++) {
			if(aliens.get(i).isActive==false) {
				aliens.remove(i);
			}
		}
		
		for(int i = 0; i < projectiles.size(); i++) {
			if(projectiles.get(i).isActive==false) {
				projectiles.remove(i);
			}
		}

		
	}
}
