import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
public class day12018 {
	
	public day12018(){
		
		
		FileReader file;
		int frequency = 0;
		try {
			file = new FileReader("src/2018day1.txt");
			BufferedReader br = new BufferedReader(file);
			String line = br.readLine();
			while(!( line == null)){
				frequency += Integer.parseInt(line);
				line = br.readLine();
			}
			System.out.println("part 1: Frequency " + frequency);
			
			
		} catch (FileNotFoundException e) {
			System.out.println("not found");
		} catch (IOException e) {
			System.out.println("error");

		}
		
		
	}

	
	public static void main(String[] args){
		new day12018();
	}
	
}
