package me.Test2.se;
import java.util.Scanner;
public class Test2 {
private static Scanner bucky;

public static void main (String args[]){
	bucky = new Scanner(System.in);
	System.out.println(bucky.nextLine());
	double fnum, snum, answer;
    System.out.println("enter first num: ");
    fnum = bucky.nextDouble();
    System.out.println("enter arithmetic");
     //if = (*, -, +,/)
     System.out.println("enter second num: ");
     snum = bucky.nextDouble();
     answer = fnum + snum;
     System.out.println(answer);
	}
}
