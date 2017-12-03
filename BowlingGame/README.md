# BowlingProblem

Bowling
=======

API to simulate Bowling game. Each game is divided into 10 frames.The bowler is allowed 10 frames in which to knock down pins, with frames one (1) through nine (9) being composed of up to two rolls. The tenth frame is composed of up to three rolls: the bonus roll(s) following a strike or spare in the tenth.This API take care of OPEN(one or more missed pins still standing after the second ball), SPARE(all ten down by the second ball) and STRIKE(all ten down in the first ball) Frames and calcuate scores for each type of frame.  

BowlingGame API has following 3 methods:
* roll(numOfPins) - Rolls bowl in the frame and build the linkedlist of frames if current frame get overs
* getScore() - Return score for one Bowling game. This method computes the total score of a game.It calls computeFrameScore on each frame to calculate score of each frame and then sum all frame score. A strike earns ten pins plus the pins for the next two balls thrown.A spare earns ten pins plus the pins for the next ball thrown. Open frames count the value of the pinfall in that frame only.
* isFinished() - Returns true if game is finished. This method checks if a game is over. It considers all type of game scenario i.e. OPEN, SPARE and STRIKE

### Usage
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

#### How to install and test
```shell
C:\Users\Gunjan Jamuar\git\BowlingGame\BowlingGame>mvn clean install
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building BowlingGame 1.0
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ BowlingGame ---
[INFO] Deleting C:\Users\Gunjan Jamuar\git\BowlingGame\BowlingGame\target
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ BowlingGame ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\Gunjan Jamuar\git\BowlingGame\BowlingGame\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ BowlingGame ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to C:\Users\Gunjan Jamuar\git\BowlingGame\BowlingGame\target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ BowlingGame ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\Gunjan Jamuar\git\BowlingGame\BowlingGame\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ BowlingGame ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to C:\Users\Gunjan Jamuar\git\BowlingGame\BowlingGame\target\test-classes
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ BowlingGame ---
[INFO] Surefire report directory: C:\Users\Gunjan Jamuar\git\BowlingGame\BowlingGame\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.game.bowling.BowlingGameTest
Tests run: 20, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.116 sec

Results :

Tests run: 20, Failures: 0, Errors: 0, Skipped: 0

[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ BowlingGame ---
[INFO] Building jar: C:\Users\Gunjan Jamuar\git\BowlingGame\BowlingGame\target\BowlingGame-1.0.jar
[INFO]
[INFO] --- maven-install-plugin:2.4:install (default-install) @ BowlingGame ---
[INFO] Installing C:\Users\Gunjan Jamuar\git\BowlingGame\BowlingGame\target\BowlingGame-1.0.jar to C:\Users\Gunjan Jamuar\.m2\repository\BowlingGame\BowlingGame\1.0\BowlingGame-1.0.jar
[INFO] Installing C:\Users\Gunjan Jamuar\git\BowlingGame\BowlingGame\pom.xml to C:\Users\Gunjan Jamuar\.m2\repository\BowlingGame\BowlingGame\1.0\BowlingGame-1.0.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 14.809 s
[INFO] Finished at: 2017-12-03T17:53:21-05:00
[INFO] Final Memory: 14M/107M
[INFO] ------------------------------------------------------------------------

C:\Users\Gunjan Jamuar\git\BowlingGame\BowlingGame>

```

#### Developed By
* Gunjan Jamuar


#### License
    MIT
    Copyright 2017 Gunjan Jamuar
