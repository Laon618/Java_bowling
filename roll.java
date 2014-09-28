package bowling;

import java.util.Scanner;

public class roll {
	private int score;

	
	int shoot() throws wrongInputException{
		Scanner keyboard = new Scanner(System.in);
		score=Integer.parseInt(keyboard.nextLine());
		if(score>10|| score<0) throw new wrongInputException();
		return score;
	}
	
	
	int spareChance(int previousRoll) throws wrongInputException {
		System.out.println("스페어 시도!");
		
		Scanner keyboard = new Scanner(System.in);
		score=Integer.parseInt(keyboard.nextLine());
		
		if(previousRoll+score>10){
			throw new wrongInputException();
		}
		return score;	
	}
	
	
	int score(){
		return score;
	}
	
	void printScore(){
		if(score==10)System.out.print("X");
		else if(score==0)System.out.print("-");
		else System.out.print(score);
	}
}
