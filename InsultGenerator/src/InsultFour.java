import java.util.Random;

public class InsultFour {
	
	public InsultFour(){
		
		Random r = new Random();
		
		String[] first = {"artless " , "bawdy "};
		int choice1 = r.nextInt(first.length);
		String response1 = first[choice1];
		
		String[] secound = {"base-court " , "bat-fowling "};
		int choice2 = r.nextInt(first.length);
		String response2 = secound[choice2];
		
		String[] third = {"apple-john" , "baggage"};
		int choice3 = r.nextInt(first.length);
		String response3 = third[choice3];
		
		System.out.println("Thou " + response1 + response2 + response3 + "!");
	}
	
	public static void main(String[] args){
		
		InsultFour insult = new InsultFour();
	}

}
