package me.quest.se;

import java.util.Scanner;

public class quest {

	static String f�rnamn = "";
	static String efternamn = "";
	static String spelarnamn = "";
	static String fullname = "";
	static int �lder;
	static char riktning;
	static String kommando = "";
	static int posX = 0;
	static int posY = 0;
	static int pengar = 10;
	static float h�lsa = 100;

	static void gameStory() {
		System.out.println("1:st row");
		System.out.println("2:nd row");
	}

	static int probability() {
		return (int) (Math.random());
	}

	static int probability(int max) {
		return (int) (Math.random());
	}

	static void delay(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}

	public static void main(String[] args) {
		gameStory();

		Scanner hai = new Scanner(System.in);

		System.out.print("GivenName?");
		f�rnamn = hai.nextLine();
		System.out.print("FamilyName?");
		efternamn = hai.nextLine();
		System.out.print("Player Name?");
		spelarnamn = hai.nextLine();
		System.out.print("How old are you?");
		�lder = hai.nextInt();
		System.out.print("so you are the famous Adventurer! you are just "
				+ �lder + " years old?...");
		fullname = hai.nextLine();
		hai.nextLine();
		do {
			System.out.print("Vart?");
			kommando = hai.nextLine();
			h�lsa -= 0.1;

			riktning = kommando.charAt(0);
			switch (riktning) {
			case 'N':
			case 'n': {
				System.out.println("We head north!");
				posY += 1;
				break;
			}
			case 'S':
			case 's': {
				System.out.println("We head south!");
				posY -= 1;
				break;
			}
			case 'W':
			case 'w': {
				System.out.println("We head west!");
				posX -= 1;
				break;
			}
			case 'E':
			case 'e': {
				System.out.println("We head east!");
				posX += 1;
				break;
			}
			}
			System.out.println("You are at (" + posX + "," + posY + ") with health " + h�lsa);

			int action = probability();
			if (action == 0) { // Monster

			} else if (action <= 10) { // NPC

			} else if (action <= 15) { // Pengar

				int antalpengar = probability();
				if (antalpengar < 50)
					pengar += 1;
				else if (antalpengar < 80)
					pengar += 5;
				else
					pengar += 10;
			} else if (action <= 18) { // h�l

				int djup = probability(5) + 1;
				System.out.println("You fell into a hole and lost " + djup + " health.");
				h�lsa -= djup;
				System.out.println("Your new health is " + h�lsa);
			}

			delay(500);
		} while (!(kommando.equalsIgnoreCase("g�!")));
		System.out.println("Farewell!");

		hai.close();
	}
}