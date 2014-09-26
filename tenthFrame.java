package bowling;

public class tenthFrame extends frame{
	private roll bonusRoll=new roll();
	
	 void shoot() {
		super.shoot();
		if(strikeBit>0){
			if(strikeBit ==2){
				System.out.println("보너스!");
				frameTotal+=rolls.get(1).shoot();
			}
			System.out.println("마지막!");
			frameTotal+=bonusRoll.shoot();
		}
	}
	
	void printRolls() {
		
		if(strikeBit==1){
			System.out.print(" ");
			rolls.get(0).printScore();
			System.out.print("|/");
			System.out.print("|");
			bonusRoll.printScore();
		}
		else {
			System.out.print(" ");
			rolls.get(0).printScore();
			System.out.print("|");
			rolls.get(1).printScore();
			System.out.print("|");
			bonusRoll.printScore();
		}
	}
	

}
