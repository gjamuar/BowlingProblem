package com.game.bowling;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {
	BowlingGame bowlingGame;
	
	@Before
	public void setUp() throws Exception{
		bowlingGame = new BowlingGame();
	}
	@Test
	public final void testBowlingGame() {
		assertEquals(12, bowlingGame.getFrames().length);
	}

	@Test
	public final void testZeroRoll() {
		for(int i=0;i <20; i++){
			bowlingGame.roll(0);
		}
		assertEquals(0, bowlingGame.getScore());
	}
	
	@Test
	public final void testAllFourRoll() {
		for(int i=0;i <20; i++){
			bowlingGame.roll(4);
		}
		assertEquals(80, bowlingGame.getScore());
	}

	@Test
	public final void testAllStrikeRoll() {
		for(int i=0;i <12; i++){
			bowlingGame.roll(10);
		}
		assertEquals(300, bowlingGame.getScore());
	}
	
	@Test
	public final void testGetScore1() {
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		for(int i=3;i <17; i++){
			bowlingGame.roll(0);
		}
		assertEquals(60, bowlingGame.getScore());
	}
	
	@Test
	public final void testGetScore6() {
		bowlingGame.roll(9);
		bowlingGame.roll(1);
		bowlingGame.roll(9);
		for(int i=3;i <20; i++){
			bowlingGame.roll(0);
		}
		assertEquals(28, bowlingGame.getScore());
	}

	
	@Test
	public final void testGetScore7() {
		bowlingGame.roll(10);
		bowlingGame.roll(9);
		for(int i=2;i <19; i++){
			bowlingGame.roll(0);
		}
		assertEquals(28, bowlingGame.getScore());
	}
	
	@Test
	public final void testGetScore8() {
		bowlingGame.roll(9);
		bowlingGame.roll(1);
		bowlingGame.roll(10);
		bowlingGame.roll(9);
		for(int i=4;i <19; i++){
			bowlingGame.roll(0);
		}
		assertEquals(48, bowlingGame.getScore());
	}

	@Test
	public final void testGetScore9() {
		bowlingGame.roll(10);
		bowlingGame.roll(9);
		bowlingGame.roll(1);
		bowlingGame.roll(9);
		for(int i=4;i <19; i++){
			bowlingGame.roll(0);
		}
		assertEquals(48, bowlingGame.getScore());
	}

	@Test
	public final void testGetScore10() {
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		bowlingGame.roll(9);
		for(int i=3;i <18; i++){
			bowlingGame.roll(0);
		}
		assertEquals(57, bowlingGame.getScore());
	}

	@Test
	public final void testGetScore11() {
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		bowlingGame.roll(10);
		for(int i=3;i <17; i++){
			bowlingGame.roll(0);
		}
		assertEquals(60, bowlingGame.getScore());
	}
	
	@Test
	public final void testGetScore2() {
		
		for(int i=0;i <17; i++){
			bowlingGame.roll(0);
		}
		bowlingGame.roll(9);
		bowlingGame.roll(1);
		bowlingGame.roll(9);
		assertEquals(19, bowlingGame.getScore());
	}

	@Test
	public final void testGetScore3() {
		
		for(int i=0;i <18; i++){
			bowlingGame.roll(0);
		}
		bowlingGame.roll(10);
		bowlingGame.roll(8);
		bowlingGame.roll(1);
		assertEquals(19, bowlingGame.getScore());
	}

	@Test
	public final void testGetScore4() {
		
		for(int i=0;i <18; i++){
			bowlingGame.roll(0);
		}
		bowlingGame.roll(10);
		bowlingGame.roll(9);
		bowlingGame.roll(1);
		assertEquals(20, bowlingGame.getScore());
	}
	
	@Test	
	public final void testGetScore5() {
		
		for(int i=0;i <17; i++){
			bowlingGame.roll(0);
		}
		bowlingGame.roll(9);
		bowlingGame.roll(1);
		bowlingGame.roll(10);
		assertEquals(20, bowlingGame.getScore());
	}
	
	@Test
	public final void testGetScore() {
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testIsAllStrikeFinished() {
		for(int i=0;i <12; i++){
			bowlingGame.roll(10);
			if(i<11){
				assertEquals(false,bowlingGame.isFinished());
			}else{
				//System.out.println("All strike Game Over");
				assertEquals(true,bowlingGame.isFinished());
			}
		}
		assertEquals(300, bowlingGame.getScore());
	}

	@Test
	public final void testIsAllStrikeWithLastSpareFinished() {
		for(int i=0;i <12; i++){
			
			if(i<10){
				bowlingGame.roll(10);
				assertEquals(false,bowlingGame.isFinished());
			}
			else if(i==10){
				bowlingGame.roll(5);
				//System.out.println("Game Not yet over");
				assertEquals(false,bowlingGame.isFinished());
			}
			else{
				bowlingGame.roll(5);
				//System.out.println("All strike Game Over");
				assertEquals(true,bowlingGame.isFinished());
			}
		}
	}
	
	@Test
	public final void testIsLastSpareFinished() {
		for(int i=0;i <12; i++){
			
			if(i<9){
				bowlingGame.roll(10);
				assertEquals(false,bowlingGame.isFinished());
			}
			else if(i==9 || i==10){
				bowlingGame.roll(5);
				//System.out.println("Last Spare Game Not yet over");
				assertEquals(false,bowlingGame.isFinished());
			}
			else{
				bowlingGame.roll(5);
				//System.out.println("Last spare Game Over");
				assertEquals(true,bowlingGame.isFinished());
			}
		}
	}
	
	@Test
	public final void testIsOpenFinished() {
		for(int i=0;i <20; i++){
			bowlingGame.roll(4);
			if(i<19){
				assertEquals(false,bowlingGame.isFinished());
			}else{
				//System.out.println("Open Game Over");
				assertEquals(true,bowlingGame.isFinished());
			}
		}
	}
}
