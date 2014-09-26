package bowling;

import java.util.ArrayList;

public class scoreBoard {
	ArrayList<frame>frames= new ArrayList<frame>(10);
	
	
	scoreBoard(){
		for(int i=0; i<9; i++){
			frames.add(i,new frame());
		}
		frames.add(9, new tenthFrame());
	}
	
	
	void shoot(int i) {
		System.out.println((i+1) + " 번째 frame의 첫번째 공입니다!");
		frames.get(i).shoot();
		if(i>0)strikeChecker(i);
	}
	


//	private void strikeChecker(int currentFrame) {
//		frame previousFrame = frame.get(currentFrame-1);
//		if(frames.get(previousFrame).isSpare() || frames.get(previousFrame).isStrike()){
//			frames.get(previousFrame).addToFrameTotal(frames.get(previousFrame).getFirstBallScore());
//			if(frames.get(previousFrame).isStrike()){
//				frames.get(previousFrame).addToFrameTotal(frames.get(currentFrame).getSecondBallScore());
//				int prePreviousFrame = previousFrame -1;
//				if(currentFrame>1 && frames.get(i-2).isStrike()){
//					frames.get(i-2).addToFrameTotal(frames.get(currentFrame).getFirstBallScore());
//				}
//			}
//		}
//	}
	
	private void strikeChecker(int currentFrameIndex) {
		frame currentFrame=frames.get(currentFrameIndex);
		frame previousFrame = frames.get(currentFrameIndex-1);
		if(previousFrame.isSpare() || previousFrame.isStrike()){
			previousFrame.addToFrameTotal(currentFrame.getFirstBallScore());
			if(previousFrame.isStrike()){
				previousFrame.addToFrameTotal(currentFrame.getSecondBallScore());
				if(currentFrameIndex>1)prePreviousFrameStrikeChecker(currentFrameIndex);
			}
		}
	}

	
	private void prePreviousFrameStrikeChecker(int currentFrameIndex) {
		frame prePreviousFrame = frames.get(currentFrameIndex-2);
		frame currentFrame=frames.get(currentFrameIndex);
		if(currentFrameIndex>1 && prePreviousFrame.isStrike()){
			prePreviousFrame.addToFrameTotal(currentFrame.getFirstBallScore());
		}
	
}


	void printScoreBoard(int currentFrame) {
		System.out.println("  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10  ");
		for(int i=0;i<=currentFrame; i++){
			frames.get(i).printRolls();
		}
		System.out.println("");
		
		printEachFrame(currentFrame);

	}

	void printScoreBoard() {
		printScoreBoard(9);
	}

	private int totalUntil(int currentFrame){
		if((currentFrame+1)==10)return currentFrame;
		if(frames.get(currentFrame).isStrike() || frames.get(currentFrame).isSpare()){
			currentFrame--;
			if(currentFrame>-1 && frames.get(currentFrame).isStrike())currentFrame--;
		}
		return currentFrame;
		
	}
	
	private void printEachFrame(int currentFrame){
		int total=0;
		int printUntil= totalUntil(currentFrame);
		if(printUntil<0)return;
		for(int i=0;i<=printUntil; i++){
			total += frames.get(i).frameTotal();
			System.out.print(" " + total+"  ");
			
			if(total<100)System.out.print(" ");
			else if(total<10)System.out.print(" ");
		}
		System.out.println("");
	}
	
	

}
