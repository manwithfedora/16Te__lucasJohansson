import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class InsultFive {
	private ArrayList<String> partOne = new ArrayList<>();
	private ArrayList<String> partTwo = new ArrayList<>();
	private ArrayList<String> partThree = new ArrayList<>();
	private Random r = new Random();
	
	public InsultFive() throws FileNotFoundException {
	
		partOne = readFile("src/Firstrow.txt");
		partTwo = readFile("src/Secoundrow.txt");
		partThree = readFile("src/thirdrow.txt");
	}	 
	
private ArrayList<String> readFile(String fileName) throws FileNotFoundException {
		ArrayList<String> lines = new ArrayList<>();
		lines.clear();
		FileReader file = new FileReader(fileName);
		BufferedReader br = new BufferedReader(file);
	try {
		String line = br.readLine();
		while(!( line == null)){
			lines.add(line);
			line = br.readLine();
		}
		
		
	} catch (IOException e) {
		System.out.println("IO error");

	}
	
	return lines;
	}
	
private String insultpart(ArrayList<String> part){
			int insultNumber = r.nextInt(part.size());
			return part.get(insultNumber);
	
	}
	
public String insultMe(){
		
		String Insult = "Thou " + insultpart(partOne) + " "+ insultpart(partTwo) +" " + insultpart(partThree) + "!";
	
		return Insult;
	}

public static void mian(String[]args){
		try {
		InsultFive insults = new InsultFive();
		}
		catch (FileNotFoundException e) {
			System.out.println("not found");
		}
	}

}