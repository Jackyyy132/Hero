import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.ArrayList;
public class Menu {
	static Scanner input = new Scanner(System.in);
	static ArrayList<Heroes> Heroes = new ArrayList<>();
	
	
	public static void MyMenu() {
		String UserChoice;
		String CreateHero = "C";
		String ViewHero = "V";
		String Exit = "E";
		
		do {
			System.out.println("----------------------------------------------------------------------");
			System.out.println("MAIN MENU");
			System.out.println("Please select an option:");
			System.out.println(CreateHero + ") Create a hero");
			System.out.println(ViewHero   + ") View a hero");
			System.out.println(Exit       + ") Exit program");
			System.out.println("----------------------------------------------------------------------");
			UserChoice = input.next().toUpperCase();
			
			if (UserChoice.equals("C")) {
				CreateHero();
			}
			else if (UserChoice.equals("V")) {
				if (Heroes.size() == 0) {
					System.out.println("Sorry, there are no heroes to view.");
				}
				else {
				ViewHero();
				}
			}
			
			
			
			}while(!UserChoice.equals("E"));	
		
		System.out.println("Thank you for playing! Have a good day. Byee! :)");
		
		
		
		}
	
	public static void CreateHero() {
		String Name;
		String HeroType;
		boolean LoopMore = true;
		boolean UniqueName = false;

		do {
			System.out.println("Please enter a name for your hero:");
			Name = input.next();
			if (Heroes.isEmpty()) {
				UniqueName = true;
			}
			for (int i = 0; i < Heroes.size(); i++) {
				if (!Name.toLowerCase().equals(Heroes.get(i).Name.toLowerCase())) {
					UniqueName = true;
					}
				else {
					System.out.println("Hey! '" + Name + "' has already been taken! Please choose another name...");
					UniqueName = false;
					break;
					}
				}
			}while(UniqueName == false);
		
		
		System.out.println("What kind of hero is '" + Name + "'?");
		System.out.println("Hero Types:");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Tank");
		System.out.println("Fighter");
		//System.out.println("Healer");
		//System.out.println("Mage");
		System.out.println("----------------------------------------------------------------------");
		HeroType = input.next().toLowerCase();
		while(LoopMore == true) {
			switch(HeroType.toLowerCase()) {
			case "tank":
				int TankAttackDamage = RandomStat(HeroType);
				int TankDefense = RandomStat(HeroType);
				int TankHitChance = RandomStat(HeroType);
				Tank tank = new Tank(Name, TankAttackDamage, TankDefense, TankHitChance);
				System.out.println("Creating your hero... Please wait...");
				Sleep(5);
				System.out.println("Welcome to the new world hero. \n" + tank);
				Heroes.add(tank);
				System.out.println("Your hero has been created successfully! \n");
				System.out.println("Returning to main menu...");
				Sleep(3);
				LoopMore = false;
				break;
			case "fighter":
				int FighterAttackDamage = RandomStat(HeroType);
				int FighterDefense = RandomStat(HeroType);
				int FighterHitChance = RandomStat(HeroType);
				Fighter fighter = new Fighter(Name, FighterAttackDamage, FighterDefense, FighterHitChance);
				System.out.println("Creating your hero... Please wait...");
				Sleep(5);
				System.out.println("Welcome to the new world hero. \n" + fighter);
				Heroes.add(fighter);
				System.out.println("Your hero has been created successfully! \n");
				System.out.println("Returning to main menu...");
				Sleep(3);
				LoopMore = false;
				break;
			default: 
				System.out.println("Hey! I do not recognise '" + HeroType + "'? Please try again! + \n");
				HeroType = input.next().toLowerCase();
				break;
				}
			}
		}
	
	
	public static void ViewHero() {
		for (int i = 0; i < Heroes.size(); i++) {
			System.out.println(Heroes.get(i));
		}
	}
	
	
	
	
	
	
	
	public static int RandomStat(String HeroType) {
		Random random = new Random();
		if (HeroType.equals("tank")) {
			return(random.nextInt(10) + 20);	
		}
		else if (HeroType.equals("fighter")) {
			return(random.nextInt(10) + 20);
		}
		
		
		return 0;
	}
	
	public static void Sleep(int Sleep) {
		try {
			TimeUnit.SECONDS.sleep(Sleep);
		} catch (InterruptedException e) {
			System.out.println("Nani?");
			e.printStackTrace();
		}
	}
	
	
	}
