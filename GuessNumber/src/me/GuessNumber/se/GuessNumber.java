	package me.GuessNumber.se;
	import java.util.Scanner;
	 
	public class GuessNumber {
	      public static void main(String[] args) {
	            int secretNumber;
	            secretNumber = (int) (Math.random() * 999 + 1);           
	            Scanner keyboard = new Scanner(System.in);
	            int guess;
	            do {
	                  System.out.print("Enter a guess (1-1000): ");
	                  guess = keyboard.nextInt();
	                  if (guess == secretNumber)
	                        System.out.println("cratz!");
	                  else if (guess < secretNumber)
	                        System.out
	                                   .println("större kan du va");
	                  else if (guess > secretNumber)
	                        System.out
	                                   .println("förstort noob!");
	            } while (guess != secretNumber);
	      }
				}
	      