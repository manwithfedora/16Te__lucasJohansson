package me.DA.se;
import java.util.Random;
import java.util.Scanner;

public class DA {
	private User user;
	private Computer computer;
	private int userScore;
	private int computerScore;
	private int numberofGames;

	private enum Move{
		sten, sax, p�se
		
		public int compareMoves(Move otherMove){
			if(this == otherMove)
				return 0;
			
			swtich (this) {
				case sten:
					return(otherMove == sax ? 1 : -1);
				case p�se:
					return(otherMove == sten ? 1 : -1);
				case sax:
					return(otherMove == p�se ? 1 : -1);
			}
			return 0;
		}
	}
 
	private class User{
		private Scanner inputScanner;
		
		public User() {
			inputScanner = new Scanner(System.in);
		}
		public Move getmove() {
			System.out.println("sten, sax, p�se");
			String userInput =inputScanner.nextLine();
			userInput = userInput.toUpperCase();
			char firstLetter = userInput.charAt(0);
			if (firstLetter == 'R' || firstLetter == 'P' firstLetter == 'S');
			switch (firstLetter){
			case 'R':
			return Move.sten;
			case 'P':
				return move.p�se;
			case 'S':
				return move.sax;
				
			}
		
		
		return getMove();
		
		}
	
    public boolean playAgain() {
        System.out.print("Do you want to play again? ");
        String userInput = inputScanner.nextLine();
        userInput = userInput.toUpperCase();
        return userInput.charAt(0) == 'Y';
	}
}
private class Computer {
    public Move getMove() {
        Move[] moves = Move.values();
        Random random = new Random();
        int index = random.nextInt(moves.length);
        return moves[index];
    }
}
 	public da(){