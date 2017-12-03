package com.game.bowling;

/**
 * Frame class represent a bowling Frame in a game. It store all information for a frame.
 * It represent a single node in the LinkedList of frames, and keep pointer for nextFrame
 * @author Gunjan Jamuar
 *
 */
public class Frame {
	
	//Constant for frame type
	public static final String STRIKE ="STRIKE";
	public static final String SPARE ="SPARE";
	public static final String OPEN ="OPEN";
	
	//Store number of pins for first and second rolls
	private Integer firstBowl;
	private Integer secondBowl;
	
	//Pointer of next frame in the linkedlist
	private Frame nextFrame;
	
	//Type of Frame i.e. Strike, Spare or Open
	private String type;
	
	//stores each frame score
	private int frameScore;
	
	//initialize the frame at first roll 
	//and update the frame type
	public Frame(Integer firstBowl) {
		super();
		this.firstBowl = firstBowl;
		this.secondBowl =null;
		this.frameScore = 0;
		this.updateFrameType();
	}
	
	/**
	 * This method decide the frame type based on first or second roll
	 */
	private void updateFrameType() {
		
		if(this.firstBowl==10){
			this.type = STRIKE;
			return;
		}
		
		if(this.secondBowl!=null 
				&&(this.firstBowl +this.secondBowl == 10)){
			this.type = SPARE;
			return;
		}
		
		this.type = OPEN;
	}

	/**
	 * This method computes score for each type of frame
	 * @return score for this frame
	 */
	public int computeFrameScore(){
		switch(this.type){
		case OPEN:
			if(this.firstBowl!=null && this.secondBowl!=null)
				this.frameScore = this.firstBowl + this.secondBowl;
			break;
		case STRIKE:
			
			//strike score is computed by adding this frame score and next two roll scores
			if(this.nextFrame!=null && this.nextFrame.firstBowl!=null){
				if(STRIKE.equalsIgnoreCase(this.nextFrame.type)
						&& this.nextFrame.nextFrame!=null)
					this.frameScore = this.firstBowl + this.nextFrame.firstBowl+ this.nextFrame.nextFrame.firstBowl;
				else if (this.nextFrame.secondBowl!=null)
					this.frameScore = this.firstBowl + this.nextFrame.firstBowl + this.nextFrame.secondBowl;
			}
			break;
		case SPARE:
			//spare score is calulated by adding this frame score and next one roll score
			if(this.firstBowl!=null && this.secondBowl!=null){
				if(this.nextFrame!=null){
					this.frameScore = this.firstBowl + this.secondBowl + this.nextFrame.firstBowl;
				}else{
					this.frameScore = this.firstBowl + this.secondBowl;
				}
			}
			break;
		default:
					
		}
		return this.frameScore;
	}
	
	public Integer getFirstBowl() {
		return firstBowl;
	}
	public void setFirstBowl(Integer firstBowl) {
		this.firstBowl = firstBowl;
	}
	public Integer getSecondBowl() {
		return secondBowl;
	}
	
	/**
	 * set the second bowl roll and update frame type 
	 * @param secondBowl
	 */
	public void setSecondBowl(Integer secondBowl) {
		this.secondBowl = secondBowl;
		this.updateFrameType();
	}
	public Frame getNextFrame() {
		return nextFrame;
	}
	public void setNextFrame(Frame nextFrame) {
		this.nextFrame = nextFrame;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getFrameScore() {
		return frameScore;
	}
	
	

}
