package com.bowlingGame;

/**
 * @author Bijesh Bajracharya
 * Creating a Bowling Game combining a frame
 */
public class BowlingGame {
    public static final int maxFrame = 12;
    public static final int EMPTY = -1;
    public static final int lastFrame = 10;
    public static final int extraFrame1 = 11;
    public static final int extraFrame2 = 12;
    public static final int maxPin = 10;
    public static final int finalStrikeBowl = 2;
    public static final int finalSpareBowl = 1;

    private int frameAttempt;
    private int handicapScore;

    public BowlingFrame[] bowlingFrames;

    /**
     * Creating a game combination of frames. Total frame is given in the variable above which is 10 with extra 11th and 12th frame
     */
    public BowlingGame() {
        this.frameAttempt = 0;
        this.handicapScore = 0;

        this.bowlingFrames = new BowlingFrame[maxFrame];

        for (int i = 0; i < bowlingFrames.length; i++) {

            this.bowlingFrames[i] = new BowlingFrame();

        }
    }

    /**
     * Setting the bowl of the frame. It takes the bowl and calculates the bowl one and bowl two in a frame. It also calculates if the bowls are strike or spare
     * Input: pins (integer)
    * */
    public void setBowl(int pins){
        if(!isGameOver()){
            if(pins <= maxPin){
                if(isValid(pins, frameAttempt)){
                    //Setting Current Frame Number
                    bowlingFrames[frameAttempt].setCurrentFrameCount(frameAttempt+1);
                    // Generic sum
                    if(frameAttempt <= lastFrame - 1){
                        bowlingFrames[frameAttempt].setTempBowlTotal(pins);
                    }

//                     last 2 extra frames
                    if(frameAttempt - 2 >=0 && bowlingFrames[frameAttempt-2].getBonusBowl() > 0){
                        bowlingFrames[frameAttempt-2].setTempBowlTotal(pins);

                        bowlingFrames[frameAttempt-2].decreaseBonusBowl();

                        if(bowlingFrames[frameAttempt-2].getBonusBowl() == 0){
                            if(frameAttempt-3 >=0){
                                bowlingFrames[frameAttempt-2].setBowlTotal(bowlingFrames[frameAttempt-3].getBowlTotal() + bowlingFrames[frameAttempt-2].getTempBowlTotal());
                            }
                            else{
                                bowlingFrames[frameAttempt-2].setBowlTotal(bowlingFrames[frameAttempt-2].getTempBowlTotal());
                            }
                        }
                    }

                    // last 1 extra frames
                    if(frameAttempt-1>=0 && bowlingFrames[frameAttempt-1].getBonusBowl()>0){
                        bowlingFrames[frameAttempt-1].setTempBowlTotal(pins);

                        bowlingFrames[frameAttempt-1].decreaseBonusBowl();

                        if(bowlingFrames[frameAttempt-1].getBonusBowl() == 0){
                            if(frameAttempt-2 >=0){
                                bowlingFrames[frameAttempt-1].setBowlTotal(bowlingFrames[frameAttempt-2].getBowlTotal() + bowlingFrames[frameAttempt-1].getTempBowlTotal());
                            }
                            else{
                                bowlingFrames[frameAttempt-1].setBowlTotal(bowlingFrames[frameAttempt-1].getTempBowlTotal());
                            }
                        }
                    }

                    //normal condition
                    // First bowl in a frame
                    if(bowlingFrames[frameAttempt].getBowlOne() == EMPTY){
                        bowlingFrames[frameAttempt].setBowlOne(pins);

                        //strike
                        if(isStrike(frameAttempt)){
                            bowlingFrames[frameAttempt].setBonusBowl(finalStrikeBowl);
                            bowlingFrames[frameAttempt].setStrike(true);

                            frameAttempt++;
                            return;
                        }

                        if(frameAttempt == extraFrame1 -1 && isSpare(lastFrame-1)){
                            frameAttempt++;
                            return;
                        }

                        if(frameAttempt == extraFrame2-1 && isStrike(lastFrame-1) && isStrike(extraFrame1-1)){
                            frameAttempt++;
                        }
                    }
                    //second bowl in a frame
                    else {
                        bowlingFrames[frameAttempt].setBowlTwo(pins);

                        //spare
                        if(isSpare(frameAttempt)){
                            bowlingFrames[frameAttempt].setBonusBowl(finalSpareBowl);
                            bowlingFrames[frameAttempt].setSpare(true);
                        }
                        //open frame attempt
                        else{
                            if(frameAttempt-1>=0){
                                bowlingFrames[frameAttempt].setBowlTotal(bowlingFrames[frameAttempt-1].getBowlTotal() + bowlingFrames[frameAttempt].getTempBowlTotal());
                            }
                            //first frame
                            else{
                                bowlingFrames[frameAttempt].setBowlTotal(bowlingFrames[frameAttempt].getTempBowlTotal());
                            }
                        }

                        frameAttempt++;
                        return;
                    }

                }else{
                    System.out.println("Invalid Bowl");
                }
            }else{
                System.out.println("INVALID BOWL: Pins cannot exceed 10 pins");
            }
        }else{
            System.out.println("It's Game Over");
        }
    }

    /**
    * isValid method checks the validity of the pins and the frame
     * input: pins and framenumber
    */
    public boolean isValid(int pins, int frameAttempt){
//        System.out.println("frameAttempt: "+frameAttempt + " pin: "+ pins);
        try {
        if(bowlingFrames[frameAttempt].getBowlOne() == EMPTY){
//            System.out.println(bowlingFrames[frameAttempt].getBowlOne());
            if(pins <= maxPin)
                return true;
            else
                return false;
        }else{

//            System.out.println("Else: "+bowlingFrames[frameAttempt].getBowlOne() + pins);

                if (bowlingFrames[frameAttempt].getBowlOne() + pins <= maxPin) {
                    return true;
                } else {

                    return false;
                }
            }
            }catch(IndexOutOfBoundsException e){

                System.out.println("Array Index Out of Bounds");
                return false;
            }


    }

    /**
     * isStrike checks if the bowl is a strike
     */
    public boolean isStrike(int frameAttempt){
        return bowlingFrames[frameAttempt].getBowlOne() == 10;
    }

    /**
     * isStrike checks if the bowl is a spare
     */
    public boolean isSpare(int frameAttempt){
        return (bowlingFrames[frameAttempt].getBowlOne() + bowlingFrames[frameAttempt].getBowlTwo()) == 10;
    }

    /**
     * isGameover checks if the game is over after reaching the last frame
     */
    public boolean isGameOver(){
        if(frameAttempt <= lastFrame-1){
            return false;
        }
        // Last ball for extra frame 1 is a strike or spare
        else if (frameAttempt == extraFrame1 -1){
            if (isStrike(lastFrame-1) || isSpare(lastFrame-1)){
                return false;
            }
            // End of game
            else{
                return true;
            }

        }
        // Last ball for extra frame 2 is a strike or spare
        else if (frameAttempt == extraFrame2 -1){
            // It's strike
            if (isStrike(lastFrame-1) && bowlingFrames[lastFrame-1].getBonusBowl()>0){
                return false;
            }
            // It's spare
            else{
                return true;
            }
        }else{
            return true;
        }

    }

    /**
     * getTotalScore calculates the total score from the frames and the Handicap Score
     */
    public int getTotalScore(){
        int pointer = EMPTY;

        for (int i = bowlingFrames.length - 1; i>=0; i--){
//            System.out.println("**** Frame Length: " + i + "  ****");
//            System.out.println("**** Frame get Points: "+ bowlingFrames[i].getBowlTotal() + "  ****");
            if(bowlingFrames[i].getBowlTotal() > 0){
                pointer = i;
                break;
            }
        }

        if(pointer == EMPTY)
            return 0;
        else
//            System.out.println(" **** Pointer: " + pointer + "  ****");
            if(isHandicapScore()) {
                return bowlingFrames[pointer].getBowlTotal() + getHandicapScore();
            }else{
                return bowlingFrames[pointer].getBowlTotal();
            }
    }

    /**
     * isHandicapScore returns true if there is a handicapScore
     */
    public boolean isHandicapScore() {
        if(handicapScore <= 30 && handicapScore >= 1){
            return true;
        }
        return false;
    }

    /**
     * setting a HandicapScore
     */
    public void setHandicapScore(int score) {
        this.handicapScore = score;
    }

    /**
     * getting a HandicapScore
     */
    public int getHandicapScore(){
        return handicapScore;
    }

}
