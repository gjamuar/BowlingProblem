package com.game.bowling;

public class BowlingGame {
	//array to store all the frames of a game 
	private Frame[] frames = null;
	
	//index to point to current frame in the game
	private int currentFrameIndex = 0;
	
	//each new game is initialize with 12 frames
	public BowlingGame(){
		frames = new Frame[12];
	}
	
	/**
	 * roll method rolls bowl in each frame 
	 * and build the linkedlist of frames if current frame get overs
	 * @param numOfPins
	 */
	public void roll(int numOfPins){
		
		//validation for num of pins in each roll
		if(numOfPins > 10 || numOfPins <0){
			System.out.println("Invalid number of pins in the play :" + numOfPins);
			return;
		}
		
		//validate maximum number of frames
		if(currentFrameIndex > 11){
			System.out.println("Invalid Roll, game is already over. Total frame played :"+ currentFrameIndex);
			return;
		}
		
		
		//build the linkedlist of frames for each roll
		Frame currentFrame = null;
		Frame previousFrame = null;
		
		if(currentFrameIndex > 0)
			previousFrame = frames[currentFrameIndex-1];
		
		if(frames[currentFrameIndex]==null){
			
			currentFrame = new Frame(numOfPins);
			frames[currentFrameIndex] = currentFrame;
			
			if(previousFrame!=null)
				previousFrame.setNextFrame(currentFrame);
			
			//if current frame is strike then move to next frame
			if(Frame.STRIKE.equalsIgnoreCase(currentFrame.getType()))
				currentFrameIndex++;
		}else{
			currentFrame = frames[currentFrameIndex];
			currentFrame.setSecondBowl(numOfPins);
			currentFrameIndex++;
		}
		
	}
	
	/**
	 * This method computes the total score of a game.
	 * It calls computeFrameScore on each frame to calculate score of each frame
	 *  and then sum all frame score
	 * @return total score of a game
	 */
	public int getScore(){
		int totalScore = 0;
		
		for(int i=0; i<10;i++){
			if(frames[i]!=null){
				totalScore += frames[i].computeFrameScore();
			}
		}
		return totalScore;
	}
	
	/**
	 * This method checks if a game is over. It considers all type of game scenario i.e. OPEN, SPARE and STRIKE
	 * @return true if game is finished
	 */
	public boolean isFinished(){
		if(currentFrameIndex < 10)
			return false;
		
		if(currentFrameIndex == 10 && Frame.OPEN.equalsIgnoreCase(frames[currentFrameIndex-1].getType()))
			return true;
		
		if(currentFrameIndex == 11 
				&&  Frame.STRIKE.equalsIgnoreCase(frames[currentFrameIndex-2].getType())
				&&  !Frame.STRIKE.equalsIgnoreCase(frames[currentFrameIndex-1].getType())
				&&  frames[currentFrameIndex-1].getSecondBowl()!=null)
			return true;
		
		if(currentFrameIndex == 12
				&&  Frame.STRIKE.equalsIgnoreCase(frames[currentFrameIndex-3].getType())
				&&  Frame.STRIKE.equalsIgnoreCase(frames[currentFrameIndex-2].getType())
				&&  Frame.STRIKE.equalsIgnoreCase(frames[currentFrameIndex-1].getType()))
			return true;
		
		if(currentFrameIndex == 10
				&&  Frame.SPARE.equalsIgnoreCase(frames[currentFrameIndex-1].getType())
				&&  frames[currentFrameIndex]!=null
				&&  frames[currentFrameIndex].getFirstBowl()!=null)
			return true;
		
		return false;
	}

	public Frame[] getFrames() {
		return frames;
	}
}
