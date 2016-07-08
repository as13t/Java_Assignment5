/*This is the driver class that contains the main function.
 * This will call the Knight class to set and get items
 * for the Knight battle.
 */

import java.util.*;

public class KnightDriver 
{
	Enemy enemy;
	public static void main(String[] args) 
	{
		String knightName;
		String enemyName;
		String oppWeapon;
		String autoGen;
		String battleAns;
		String ans;
		
		int selWeapon = 0;
		int enemySelWeapon = 0;
		
		Scanner input = new Scanner(System.in);
		Scanner inputNum = new Scanner(System.in);
		Scanner inputAuto = new Scanner(System.in);
		Scanner inputBattle = new Scanner(System.in);
		Scanner inputCont = new Scanner(System.in);
		
		System.out.println("Welcome to Knightfight!\n");
		
		do
		{
			System.out.println("Enter the name of your Knight: ");
			knightName = input.nextLine();

			System.out.println("Now select your weapon! (Choose a number)");
			System.out.println("1) Long Sword\n2) Battle Axe\n3) Spear\n4) Warhammer");
			System.out.println("Your choice my liege? : ");
			try
			{
				selWeapon = inputNum.nextInt();
			}
			catch(InputMismatchException inputMismatch)
			{
				System.err.printf("\nException: %s\n", inputMismatch);
				System.out.println("Please enter an integer value.\n");
			}
			
			Knight aKnight = new Knight(knightName, selWeapon);
			aKnight.setKnight(knightName, selWeapon);
			//enemyName = "Computer";
			aKnight.setEnemy();
			oppWeapon = aKnight.autoGenWeapon();
			aKnight.displayCharacters();

			System.out.println("\nWould you like to begin the battle? (y|n)");
			
			battleAns = inputBattle.nextLine();
			if(battleAns.equals("y"))
			{
				aKnight.knightBattle();
			}

			System.out.println("\nWould you like to play again? (y|n)");
			ans = inputCont.nextLine();
			
		}while(ans.equals("y"));
	}
	


}
