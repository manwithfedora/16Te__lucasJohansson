	package me.GuessNumber.se;
	import java.util.Scanner;
	 
	public class GuessNumber {
	      public static void main(String[] args) {
	            int secretNumber;
	            secretNumber = (int) (Math.random() * 999 + 1);           
	            Scanner tangentbord = new Scanner(System.in);
	            int guess;
	            int f�rs�k = +1;
	            do {
	                  System.out.print("Enter a guess (1-1000): ");
	                  guess = tangentbord.nextInt();
	            if (guess == secretNumber)
	                        System.out.println("gratz!" + f�rs�k);
	                  
	           else if (guess < secretNumber)
	                        System.out.println("st�rre kan du va");
	               
	           else if (guess > secretNumber)
	                        System.out.println("f�rstort noob!");
	                  
	         } while (guess != secretNumber); 
	            
	      }
	}
	      