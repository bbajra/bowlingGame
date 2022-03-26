package com.bowlingGame;
/**
 * @author Bijesh Bajracharya
 *
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        BowlingGame game = new BowlingGame();

        System.out.println("Get total score Before the game: " + game.getTotalScore());
        System.out.println("Is the game over? " + game.isGameOver());

//        for (int i = 0; i < 12; i++) {
//            game.setBowl(9);
//        }
//        game.setBowl(9);
//        game.setBowl(1);
//        game.setBowl(9);
//        game.setBowl(1);
//        game.setBowl(9);
//        game.setBowl(1);
//        game.setBowl(9);
//        game.setBowl(1);
//        game.setBowl(10);
//        game.setBowl(10);
//        game.setBowl(10);
//        game.setBowl(10);


        //Valid Score without strike or spare
        game.setBowl(5);
        game.setBowl(4);
        game.setBowl(5);
        game.setBowl(4);
        game.setBowl(5);
        game.setBowl(4);
        game.setBowl(5);
        game.setBowl(4);
        game.setBowl(5);
        game.setBowl(4);
        game.setBowl(5);
        game.setBowl(4);
        game.setBowl(5);
        game.setBowl(4);
        game.setBowl(5);
        game.setBowl(4);
        game.setBowl(5);
        game.setBowl(4);
        game.setBowl(5);
        game.setBowl(4);

        // Setting Handicap Score
        game.setHandicapScore(30);

        System.out.println("getHandicapScore: " + game.getHandicapScore());



        // printing Score board
        for (int i = 0; i < game.bowlingFrames.length; i++) {

            System.out.print("Attempt "+ i + " - ");
            System.out.print("[" + game.bowlingFrames[i].getBowlOne() + " , ");

            if (game.bowlingFrames[i].isSpare())
                System.out.print("\\");
            else if (game.bowlingFrames[i].isStrike())
                System.out.print("X");
            else
                System.out.print(game.bowlingFrames[i].getBowlTwo());

//            System.out.print("GetTotalScore: " + game.getTotalScore());
            System.out.print("] , Temp: " + game.bowlingFrames[i].getTempBowlTotal());
            System.out.print(", Points: " + game.bowlingFrames[i].getBowlTotal());
            System.out.print(", Frame: " + game.bowlingFrames[i].getCurrentFrameCount());
            System.out.println();
        }
        System.out.println("Total Score of the Game including handicap score: " + game.getTotalScore());
        System.out.println("Is Game Over? " + game.isGameOver());
    }
}
