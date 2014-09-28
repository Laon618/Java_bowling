package bowling;

public class tenthFrame extends frame{
	private roll bonusRoll=new roll();
	
	 void shoot() {
		super.shoot();
		if(strikeBit>0){
			if(strikeBit ==2){
				System.out.println("보너스!");
				 while(true){
					 try{
						 rolls.get(1).shoot();
					 }catch(wrongInputException e){
						 continue;
					 }
					 break;
				 }
				frameTotal +=rolls.get(1).score();
			}
			System.out.println("마지막!");
			 while(true){
				 try{
					 bonusRoll.shoot();
				 }catch(wrongInputException e){
					 continue;
				 }
				 break;
			 }
			frameTotal+=bonusRoll.score();
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
