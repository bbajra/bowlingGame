package com.bowlingGame;

/**
 * @author Bijesh Bajracharya
 * Creating a single frame out of a bowling game
 */

public class BowlingFrame {
//    public static final int EMPTY = -1;
//    public static final int MAX_PIN_ROLLED = 10;

    private int bowlOne;
    private int bowlTwo;

    public int tempBowlTotal;
    public int bonusBowl;
    public int bowlTotal;
    public int frameNum;




    private boolean isStrike;
    private boolean isSpare;
    private int frameCount;

    public BowlingFrame() {

        this.bowlOne = BowlingGame.EMPTY;
        this.bowlTwo = BowlingGame.EMPTY;
//        this.extraBowlThree = EMPTY;
        this.bowlTotal = 0;
        this.tempBowlTotal = 0;
        this.bonusBowl = 0;
        this.isStrike = false;
        this.isSpare = false;
        this.frameNum = 0;

    }

    /**
     * check if it is a spare
     */
    public boolean isSpare() {
        return isSpare;
    }

    /**
     * setting a spare
     */
    public void setSpare(boolean spare) {
        isSpare = spare;
    }

    /**
     * setting a Strike
     */
    public void setStrike(boolean strike) {
        isStrike = strike;
    }

    /**
     * checking if it is a Strike
     */
    public boolean isStrike() {
        return isStrike;
    }

    /**
     * get temporary total
     */
    public int getTempBowlTotal() {
        return tempBowlTotal;
    }

    /**
     * set a temporary total
     */
    public void setTempBowlTotal(int tempBowlValue) {
        this.tempBowlTotal += tempBowlValue;
    }

    /**
     * set first bowl of a frame
     */
    public void setBowlOne(int bowlOne) {
        this.bowlOne = bowlOne;
    }

    /**
     * get first bowl from a frame
     */
    public int getBowlOne() {
        return bowlOne;
    }

    /**
     * set second bowl of a frame
     */
    public void setBowlTwo(int bowlTwo) {
        this.bowlTwo = bowlTwo;
    }

    /**
     * get second bowl of a frame
     */
    public int getBowlTwo() {
        return bowlTwo;
    }

    /**
     * get bonus bowl of a frame
     */
    public int getBonusBowl() {
        return bonusBowl;
    }

    /**
     * set bonus bowl of a frame
     */
    public void setBonusBowl(int bonusBowl) {
        this.bonusBowl = bonusBowl;
    }

    /**
     * decrease bonus bowl of a frame
     */
    public void decreaseBonusBowl() {
        this.bonusBowl--;
    }

    /**
     * get total bowl in a frame
     */
    public int getBowlTotal() {
        return bowlTotal;
    }

    /**
     * set total bowl in a frame
     */
    public void setBowlTotal(int bowlTotal) {
        this.bowlTotal = bowlTotal;
    }

    /**
     * set current frame count
     */
    public void setCurrentFrameCount(int frameAttempt) {
        this.frameCount = frameAttempt;
    }

    /**
     * get current frame count
     */
    public int getCurrentFrameCount() {
        return frameCount;
    }
}