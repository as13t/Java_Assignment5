
public abstract class Enemy 
{
	protected String enemyName;
	protected int enemyHealth;
	protected int enemyDamagePts;
	private static Enemy enemyFight;
	
	public Enemy()
	{
		
	}
	
	public abstract int takeDamage(int kHealth, int eHealth);
	
	public static Enemy getRandomEnemy(int num)
	{
		switch(num)
		{
		case 1:
			enemyFight = new Ogre();
			return enemyFight;
		case 2:
			enemyFight = new Sorcerer();
			return enemyFight;
		case 3:
			enemyFight = new Troll();
			return enemyFight;
		default:
			enemyFight = new Ogre();
			return enemyFight;
		}

	}
}
