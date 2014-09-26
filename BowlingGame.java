package bowling;


public class BowlingGame {
	

	public static void main(String[] args) {
		//player 몇명인지 입력 받고 

	
		System.out.println("볼링 게잉을 시작합니다!");
		int numOfPlayers=1;
		
		//player 숫자만큼 scoreBoard생성.
		scoreBoard[] bowlingGame = new scoreBoard[numOfPlayers];
		for(int j=0; j<numOfPlayers; j++){
			bowlingGame[j] = new scoreBoard();
		}
		
		//순서대로 player가 해당 roll의 점수 입력.
		//한번 입력 할때마다 해당 player의 scoreBoard출력.
		for(int i=0; i<10; i++){
			for(int j=0; j<numOfPlayers; j++){
				System.out.println("player"+ (j+1) );
				bowlingGame[j].shoot(i);
				bowlingGame[j].printScoreBoard(i);
				System.out.println(" ");
			}
		}

		//최종 점수 print
		System.out.println("최종결과!");
		for(int j=0; j<numOfPlayers; j++){
			bowlingGame[j].printScoreBoard();
		}
	}
}
