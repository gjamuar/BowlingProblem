Bowling
=======

API to simulate Bowling game. Each game is divided into 10 frames.The bowler is allowed 10 frames in which to knock down pins, with frames one (1) through nine (9) being composed of up to two rolls. The tenth frame is composed of up to three rolls: the bonus roll(s) following a strike or spare in the tenth.This API take care of OPEN(one or more missed pins still standing after the second ball), SPARE(all ten down by the second ball) and STRIKE(all ten down in the first ball) Frames and calcuate scores for each type of frame.  

BowlingGame API has following 3 methods:
* roll(numOfPins) - Rolls bowl in the frame and build the linkedlist of frames if current frame get overs
* getScore() - Return score for one Bowling game. This method computes the total score of a game.It calls computeFrameScore on each frame to calculate score of each frame and then sum all frame score. A strike earns ten pins plus the pins for the next two balls thrown.A spare earns ten pins plus the pins for the next ball thrown. Open frames count the value of the pinfall in that frame only.
* isFinished() - Returns true if game is finished. This method checks if a game is over. It considers all type of game scenario i.e. OPEN, SPARE and STRIKE


####Usage
```java
BowlingGame game = new BowlingGame();
System.out.println(game.getScore());
System.out.println(game.isFinished());
for (int i = 0; i < 12; i++) {
	game.roll(10);
} 
System.out.println(game.getScore());
System.out.println(game.isFinished());
```



Developed By
------------
* Gunjan Jamuar


License
-------
    Copyright 2017 Gunjan Jamuar