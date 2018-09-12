package krypto;

import java.util.Scanner;
import me.krypto.se.Framen;

    public class krypto {
    	
    
	//char [] key = new char [29];
    
public static void main(String args[]){
    	// inte missledande 
    	System.out.println("size dose matter");
	   	Scanner kryp = new Scanner (System.in);
    	int userinp = kryp.nextInt();
    	int userinp2 = kryp.nextInt();
    	
    	new Framen(userinp, userinp2);
  
   
		}
	}