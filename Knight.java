/*This class contains the constructors for the KnightDriver
 * This class also sets all of the attributes and contains
 * the display function and battle function.
 */

import java.util.*;

public class Knight
{
	String knightName;
	String enemyName;
	String weaponType;
	String enemyWeapon;
	String knightWeapon;
	Random rand = new Random();
	Enemy enemy = null;
	
	int enemyWeap;
	int selWeapon;
	int knightHealthPts;
	int enemyHealthPts;
	int knightDamagePts;
	int enemyDamagePts;
	int healthPts;
	int autoNum;
	int charNum;
	
	//This is the constructor for the auto generator
	public Knight(String name, int weapon)
	{
		knightName = name;
		this.selWeapon = weapon;
		healthPts = 100;
	}
	
	//This is the constructor for the non auto generator
	public Knight(String name, int weapon, String oppName, int oppWeapon)
	{
		knightName = name;
		selWeapon = weapon;
		this.enemyName = oppName;
		this.enemyWeap = oppWeapon;
		healthPts = 100;
	}
	
	//This sets the knight info
	public void setKnight(String name, int weapon)
	{
		knightName = name;
		knightWeapon = selectWeapon(weapon);
		knightHealthPts = 100;
		knightDamagePts = selectDamage(knightWeapon);
	}
	
	//This function is the auto generator for the weapon
	public String autoGenWeapon()
	{
		Random rn = new Random();
		autoNum = 1 + rn.nextInt(4);
		enemyWeapon = selectWeapon(autoNum);
		return enemyWeapon;
	}
	
	//This function chooses the weapon
	public String selectWeapon(int weapon)
	{
		selWeapon = weapon;
		switch(selWeapon)
		{
			case 1:	
				weaponType = "Long Sword";
				break;
			case 2: 
				weaponType = "Battle Axe";
				break;
			case 3: 
				weaponType = "Spear";
				break;
			case 4: 
				weaponType = "Warhammer";
				break;
		}
		return weaponType;
	}
	
	//Dependent on the weapon will determine the hit damage
	public int selectDamage(String sWeapon)
	{
		int dPoints = 0;
		
		if(sWeapon.equals("Long Sword"))
		{
			dPoints = 10;
		}
		else if(sWeapon.equals("Battle Axe"))
		{
			dPoints = 20;
		}
		else if(sWeapon.equals("Spear"))
		{
			dPoints = 5;
		}
		else
		{
			dPoints = 25;
		}

		return dPoints;
	}
	
	public void setEnemy()
	{
		int r = 1 + rand.nextInt(3);
		enemy = Enemy.getRandomEnemy(r);
		
		enemyName = enemy.enemyName;
		enemyHealthPts = enemy.enemyHealth;
		enemyDamagePts = enemy.enemyDamagePts;
	}
	
	public String getKnightName()
	{
		return knightName;
	}
	
	public String getKnightWeapon()
	{
		return knightWeapon;
	}
	
	public int getKnightHealth()
	{
		return knightHealthPts;
	}
	
	public int getKDamagePts()
	{
		return knightDamagePts;
	}
	
	public String getEnemyName()
	{
		return enemyName;
	}
	
	public String getEnemyWeapon()
	{
		return enemyWeapon;
	}
	
	public int getEnemyHealth()
	{
		return enemyHealthPts;
	}
	
	public int getEnemyDamage()
	{
		return enemyDamagePts;
	}

	//This function displays the summary of the characters inputted
	public void displayCharacters()
	{
		System.out.printf("%-15s%15s%15s\n", "Character", knightName, enemyName);
		System.out.printf("%-15s%15s%15s\n","----------", "----------", "----------");
		System.out.printf("%-15s%15s%15s\n", "Weapon", knightWeapon, enemyWeapon);
		System.out.printf("%-15s%15d%15d\n", "Hit Points", knightDamagePts, enemyDamagePts);
	}
	
	//This function is the Battle!!
	public void knightBattle()
	{
		int kFighterHealth = 100;
		int eFighterHealth = 100;
		int battleRound = 1;
		
		while(kFighterHealth > 0 && eFighterHealth > 0)
		{
			Random rnd = new Random();
			charNum = rnd.nextInt(25);
			
			//This if statement determines whose turn it is.
			if(charNum%2 == 0)
			{
				//This is the knights turn.
				//eFighterHealth = eFighterHealth - knightDamagePts;
				try
				{
					checkException(eFighterHealth);
					eFighterHealth = enemy.takeDamage(knightDamagePts, eFighterHealth);
					if(eFighterHealth > 0)
					{
						System.out.printf("%s%d\n", "Round: ", battleRound);
						System.out.printf("%-15s%d %15s%d\n", "Knight's health: ", kFighterHealth, "Enemies health: ", eFighterHealth);
						battleRound++;
					}
				}
				catch(CustomException e)
				{
					System.out.println("Error: " + e.getError());
				}
			}
			else
			{
				//This is your enemies turn
				kFighterHealth = kFighterHealth - enemyDamagePts;
				if(kFighterHealth > 0)
				{
					System.out.printf("%s%d\n", "Round: ", battleRound);
					System.out.printf("%-15s%d %15s%d\n", "Knight's health: ", kFighterHealth, "Enemies health: ", eFighterHealth);
					battleRound++;
				}
			}
		}
		if(eFighterHealth > kFighterHealth)
		{
			System.out.printf("\nThe %s has won!\n", enemyName);
		}
		else
		{
			System.out.println("\nYou have been proclaimed the winner!");
		}
	}
	
	public static void checkException(int val) throws CustomException
	{
		if(val < 0)
		{
			throw new CustomException("Health value being passed is a negative value" + ".\n");
		}
	}
}
