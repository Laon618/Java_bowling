package bowling;

import java.util.ArrayList;

public class frame {
	ArrayList<roll> rolls = new ArrayList<roll>();
	int frameTotal=0;
	int ballCount=0;
	int strikeBit= 0;//1이면 스페어 2이면 스트라이크 
	
	frame(){
		for(int i=0; i<2; i++){
			rolls.add(i, new roll());
		}
	}
	
	 void shoot() {
		frameTotal+=rolls.get(0).shoot();
		ballCount++;
		if(frameTotal<10){
			frameTotal +=rolls.get(1).spareChance(rolls.get(0).score());
			ballCount++;
		}
		Checker();
	}

	
	private void Checker() {
		if(frameTotal==10){
			if(ballCount==2){
				strikeBit=1;
			}
			else strikeBit=2;
		}
	}

	 void printRolls() {
		if(strikeBit==1){
			System.out.print(" ");
			rolls.get(0).printScore();
			System.out.print("|");
			System.out.print("/  ");
		}
		else {
			System.out.print(" ");
			rolls.get(0).printScore();
			System.out.print("|");
			rolls.get(1).printScore();
			System.out.print("  ");
		}
	}

	 int getFirstBallScore(){
		return rolls.get(0).score();
	}
	
	 int getSecondBallScore(){
		return rolls.get(1).score();
	}
	
	 int frameTotal(){
		return frameTotal;
	}
	
	void addToFrameTotal(int addScore){
		frameTotal += addScore;
	}

	boolean isSpare() {
		if(strikeBit==1)return true;
		return false;
	}
	
	boolean isStrike() {
		if(strikeBit==2)return true;
		return false;
	}

}
