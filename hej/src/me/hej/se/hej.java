package me.hej.se;
import java.util.Scanner;
// tobias krypto
	public class hej {

	static int sizeX, sizeY;
	static char nyckel[] = new char[29];

	public static void main(String[] args) {
	for(int i=0;i<29;i++){
	nyckel[i]= ' ';
	}
	System.out.println("Skriv in storleken på ditt korsord!");
	// Läs in antal rader i kryptot
	System.out.print("Rader: ");
	Scanner in = new Scanner(System.in);	
	sizeY = in.nextInt();
	System.out.print("Kolumner: ");
	sizeX = in.nextInt();
	// Skapa korsordet
	int[][] korsord = new int[sizeX][sizeY];
	// Stoppa in siffror i korsordet:
	System.out.println("Skriv in en rad med siffror, avsluta med ENTER");
	for (int y=0; y < sizeY; y++){
	for (int x=0; x < sizeX; x++){
	System.out.print("Skriv in siffra på rad "+y+":"+"plats"+x+":");
	korsord[x][y] = in.nextInt();
	}
	}
	// Håll på med detta till korsordet är löst, eller datorns batteri tar slut.
	while (true){
	// Skriv ut korsordet
	System.out.println("Korsordet ser ut så här:");
	for(int y=0; y < sizeY; y++){
	for(int x=0; x < sizeX; x++){
	if (nyckel[korsord[x][y]] != ' '){
	System.out.print(nyckel[korsord[x][y]]+" ");
	}
	else
	System.out.print(korsord[x][y]+ " ");
	}
	System.out.println();
	}
	// mata in siffra och bokstav att byta ut med.
	// Det är viktigt att ha ett mellanslag eller ett annat tecken mellan
	// siffra och bokstav.
	System.out.println("Skriv in siffra och bokstav att byta ut den med.");
	int bytut = in.nextInt();
	String bytuttill = in.nextLine();
	nyckel[bytut] = bytuttill.charAt(1);	
	}
	}
	}