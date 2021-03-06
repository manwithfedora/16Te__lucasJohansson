import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class day12015 {

	
	public static void main(String[]agrs){
		
		String lift = new String();
		try{
			FileReader file = new FileReader("src/2015day1.txt");
			BufferedReader br = new BufferedReader(file);
			lift = br.readLine();
			System.out.println("file found...");
			System.out.println(lift);
			
		}
		catch(FileNotFoundException ex){
			System.err.println("file not found");
		}
		catch(IOException ex){
			System.err.println("error");
		}
		
		
		int floor = 0;
		int basementButtonIndex = 0;
		for(int currentbuttonnumber =0;currentbuttonnumber < lift.length();currentbuttonnumber++){
			if(lift.charAt(currentbuttonnumber)=='(')
				floor++;
				if(lift.charAt(currentbuttonnumber)==')')
					floor--;
				if((floor== -1)&& basementButtonIndex == 0)
					basementButtonIndex = currentbuttonnumber;
				
		}
		System.out.println("part 1:we are at floor:" + floor);
		System.out.println("part 2:we are at floor:" + (basementButtonIndex +1));

	}
}
