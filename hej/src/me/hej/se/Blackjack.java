package me.hej.se;

import java.util.Scanner;

public class Blackjack {

static String f�rnamn ="";
static String efternamn = "";
static String spelarnamn ="";
static int �lder ;
static char riktning ;
static String kommando = "";
static int posX = 0;
static int posY = 0;
static float h�lsa = 100;

static void gameStory(){
System.out.println("This is a quest to find life or death!");
System.out.println("You will probably die!");
}

// Metod som pausar spelet i millis millisekunder.
static void delay(int millis){
try {
Thread.sleep(millis);
} catch (InterruptedException e) {
}
}

public static void main(String[] args) {
// Skriv ut bakgrunddshistirien
gameStory();

// Skapa c�r tangentbordsskanner
Scanner sc = new Scanner(System.in);

// L�s in spelarnamn mm.

System.out.print("What is thy given name, peasant? ");
f�rnamn = sc.nextLine();
System.out.print("and thy family name? ");
efternamn = sc.nextLine();
System.out.print("With what name shalt we call thee? ");
spelarnamn = sc.nextLine();
//	System.out.print("Darest you tell us thy age, please. ");
//	�lder = sc.nextInt();
do {
System.out.print("What to do? ");
kommando = sc.nextLine();

// Ta ut riktning vi ska g�.
riktning = kommando.charAt(0);
switch (riktning) {
case 'N':
case 'n': {
System.out.println("We head north!");
break;
}
case 'S':
case 's':{
System.out.println("We head south!");
break;
}
case 'W':
case 'w':{
System.out.println("We head west!");
break;
}
case 'E':
case 'e':{
System.out.println("We head east!");
break;
}
}
delay(1000);
} while (!(kommando.equalsIgnoreCase("Patrask!")));
System.out.println("Farewell!");

sc.close();
}
}