package com.bowlingGame;
/**
 * @author Bijesh Bajracharya
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BowlingGameJunitTest {
    BowlingGame bowlingGame;

    /**
     * set bowling game object
     */
    @BeforeEach
    void setUp() {
        bowlingGame = new BowlingGame();
    }

//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void setBowl() {
////        bowlingGame.setBowl(10);
////        assertEquals(10,bowlingGame.);
//    }

    /**
     * test validity of the pins and frame
     */
    @Test
    void isValid() {

        assertEquals(true,bowlingGame.isValid(9,0));
    }

    /**
     * test the false validity
     */
    @Test
    void isNotValid() {

        assertEquals(false,bowlingGame.isValid(11,0));
    }

    /**
     * test validity of pins
     */
    @Test
    void isNotValidPin() {
        assertEquals(false,bowlingGame.isValid(11,0));
    }

    /**
     * test validity of a frame
     */
    @Test
    void isNotValidFrame() {
        assertEquals(false, bowlingGame.isValid(8,15));
    }

    /**
     * test if the given bowl is a strike
     */
    @Test
    void isStrike() {
        bowlingGame.bowlingFrames[0].setBowlOne(10);
        assertEquals(true, bowlingGame.isStrike(0));
    }

    /**
     * test if the given bowl is a spare
     */
    @Test
    void isSpare() {
        bowlingGame.bowlingFrames[0].setBowlOne(9);
        bowlingGame.bowlingFrames[0].setBowlTwo(1);
        assertEquals(true, bowlingGame.isSpare(0));
    }

    /**
     * test if the given bowl is not a strike
     */
    @Test
    void isNotStrike() {
        bowlingGame.bowlingFrames[0].setBowlOne(9);
        assertEquals(false, bowlingGame.isStrike(0));
    }

    /**
     * test if the given bowl is not a spare
     */
    @Test
    void isNotSpare() {
        bowlingGame.bowlingFrames[0].setBowlOne(9);
        bowlingGame.bowlingFrames[0].setBowlTwo(0);
        assertEquals(false, bowlingGame.isSpare(0));
    }

    /**
     * test if the game is not over
     */
    @Test
    void isNotGameOver() {

        bowlingGame.setBowl(9);
        bowlingGame.setBowl(1);
        bowlingGame.setBowl(9);
        bowlingGame.setBowl(1);
        bowlingGame.setBowl(9);
        assertEquals(false, bowlingGame.isGameOver());

    }

    /**
     * test if the game is over
     */
    @Test
    void isGameOver() {

        for(int i=0; i<=12; i++) {
            bowlingGame.setBowl(10);
        }
        assertEquals(true, bowlingGame.isGameOver());

    }

    /**
     * test the total of the given bowl
     */
    @Test
    void getScoreOfBowlsTest(){
        bowlingGame.setBowl(4);
        bowlingGame.setBowl(1);
        bowlingGame.setBowl(4);
        bowlingGame.setBowl(5);
        assertEquals(bowlingGame.getTotalScore(), 14);
    }

    /**
     * test the valid spare if every bowl is a spare
     */
    @Test
    public void allSpareScoreValidTest() {
        for(int i=0; i<=21; i++) {
            bowlingGame.setBowl(5);
        }


        assertEquals(bowlingGame.getTotalScore(), 150);
    }

    /**
     * test the validity of the score if every bowl is a Strike
     */
    @Test
    public void allStrikeScoreValid(){
        for(int i=0; i<=12; i++) {
            bowlingGame.setBowl(10);
        }
        assertEquals(bowlingGame.getTotalScore(), 300);
    }

    /**
     * test the validity of a handicap score
     */

    @Test
    public void handicapScoreValidityTest(){
        bowlingGame.setHandicapScore(30);
        assertTrue(bowlingGame.isHandicapScore());
    }

    /**
     * test the validity of a given handicap score if its out of requirement between 1 and 30
     */
    @Test
    public void handicapFalseScoreValidityTest(){
        bowlingGame.setHandicapScore(-10);
        assertFalse(bowlingGame.isHandicapScore());
    }

    /**
     * test the current frame
     */
    @Test
    public void currentFrame(){
        bowlingGame.setBowl(6);
        bowlingGame.setBowl(2);
        bowlingGame.setBowl(6);
        bowlingGame.setBowl(2);
        assertEquals(2, bowlingGame.bowlingFrames[1].getCurrentFrameCount());
    }

    /**
     * test total score when handicap socre is entered
     */
    @Test
    public void scoreWithHandicap(){
        bowlingGame.setBowl(6);
        bowlingGame.setBowl(2);
        bowlingGame.setBowl(6);
        bowlingGame.setBowl(2);
        bowlingGame.setHandicapScore(20);
        assertEquals(36, bowlingGame.getTotalScore());
    }
}