import java.util.Random;

public class Sorcerer extends Enemy
{
	public Sorcerer()
	{
		enemyName = "Sorcerer";
		enemyHealth = 100;
		
		Random rand = new Random();
		int r = 1 + rand.nextInt(25);
		
		enemyDamagePts = r;
	}

	@Override
	public int takeDamage(int kDamage, int eHealth) {
		// TODO Auto-generated method stub
		int eHealthpts;
		int knightDmg = kDamage;
		int enemyHealth = eHealth;
		
		eHealthpts = enemyHealth - knightDmg;
		
		return eHealthpts;
	}
}
