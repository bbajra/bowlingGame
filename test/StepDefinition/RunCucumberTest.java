//Bijesh Bajracharya

package features;


//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;

import com.bowlingGame.BowlingGame;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RunCucumberTest{
    private BowlingGame bowlingGame;
    private boolean itsSpare;
    int addRoll;
    boolean validityCheck;

    @Given("Create a new Bowling Game")
    public void create_new_bowling_game() {
        // Write code here that turns the phrase above into concrete actions
        bowlingGame = new BowlingGame();

        //throw new io.cucumber.java.PendingException();
    }

    @When("All Strikes")
    public void allStrikes() {
        bowlingGame.setBowl(10);
        bowlingGame.setBowl(10);
        bowlingGame.setBowl(10);
        bowlingGame.setBowl(10);
        bowlingGame.setBowl(10);
        bowlingGame.setBowl(10);
        bowlingGame.setBowl(10);
        bowlingGame.setBowl(10);
        bowlingGame.setBowl(10);
        bowlingGame.setBowl(10);
        bowlingGame.setBowl(10);
        bowlingGame.setBowl(10);
    }

    @Then("Maximum Score is 300")
    public void maximumScore300() {
        assertEquals(300, bowlingGame.getTotalScore());
    }

    @When("Set Bowl")
    public void setBowlsTotal() {
        bowlingGame.setBowl(7);
        bowlingGame.setBowl(1);
        bowlingGame.setBowl(7);
        bowlingGame.setBowl(1);
//        bowlingGame.setBowl(7);
//        bowlingGame.setBowl(1);
//        bowlingGame.setBowl(7);
//        bowlingGame.setBowl(1);
//        bowlingGame.setBowl(7);
//        bowlingGame.setBowl(1);
//        bowlingGame.setBowl(7);
//        bowlingGame.setBowl(1);
//        bowlingGame.setBowl(7);
//        bowlingGame.setBowl(1);
//        bowlingGame.setBowl(7);
//        bowlingGame.setBowl(1);
//        bowlingGame.setBowl(7);
//        bowlingGame.setBowl(1);
//        bowlingGame.setBowl(7);
//        bowlingGame.setBowl(1);
    }

    @Then("Maximum Score is 16")
    public void maximumScore() {
        assertEquals(16, bowlingGame.getTotalScore());
    }
//    @Then("Maximum Score is {int}")
//    public void maximum_score_is(Integer int1) {
//        // Write code here that turns the phrase above into concrete actions
//        assertEquals(Optional.ofNullable(int1), bowlingGame.getTotalScore());
//        throw new io.cucumber.java.PendingException();
//    }

    @When("Add a bowl")
    public void add_a_roll() {
        bowlingGame.setBowl(4);
    }

    @Then("Roll added")
    public void roll_added() {
        assertEquals(4, bowlingGame.bowlingFrames[0].getBowlOne());
    }

    @When("First and Second bowl are {int}")
    public void first_and_second_bowl(Integer intOne){
        bowlingGame.bowlingFrames[0].setBowlOne(9);
        bowlingGame.bowlingFrames[0].setBowlTwo(1);
        itsSpare = bowlingGame.isSpare(0);
    }

    @Then("The Game is Spare")
    public void the_Game_is_Spare(){
        assertEquals(true, itsSpare);
    }

    @When("All bowl are Spare")
    public void all_bowl_are_spare(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
//        throw new io.cucumber.java.PendingException();
        final List<String> strings = dataTable.asList();
        bowlingGame = new BowlingGame();
        try {
            for (String str : strings) {
                bowlingGame.setBowl(Integer.parseInt(str));
            }
        } catch (Exception e) {
            System.out.println("Caught Exception");
        }
    }

    @Then("Total score is {int}")
    public void total_score_is(Integer score) {
        assertEquals(150, bowlingGame.getTotalScore());
    }

    @When("Invalid data entered")
    public void invalid_data_entered() {
        validityCheck = bowlingGame.isValid(5, 15);

    }
    @Then("throw error")
    public void throw_error() {
        assertEquals(false, validityCheck);
    }

    @When("All Spare")
    public void allSpare() {
        for(int i=0; i<=21; i++) {
            bowlingGame.setBowl(5);
        }

    }

    @Then("Maximum Score is 150")
    public void maximumScore150() {
        assertEquals(150, bowlingGame.getTotalScore());
    }

    @Given("player makes a pin")
    public void player_makes_a_pin() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("player makes pin for all {int} frames")
    public void player_makes_pin_for_all_frames(Integer int1, io.cucumber.datatable.DataTable dataTable) {
        final List<String> strings = dataTable.asList();
        bowlingGame = new BowlingGame();
        try {
            for (String str : strings) {
                bowlingGame.setBowl(Integer.parseInt(str));
            }
        } catch (Exception e) {
            System.out.println("Caught Exception");
        }
    }
    @Then("verify scratch score of the game {int}")
    public void verify_scratch_score_of_the_game(Integer num) {
        assertEquals(90, bowlingGame.getTotalScore());


    }
    @And("verify final score with handicap of {int}")
    public void verify_final_score_with_handicap_of(Integer int1, io.cucumber.datatable.DataTable dataTable) {
        bowlingGame.setHandicapScore(int1);
        assertEquals(110, bowlingGame.getTotalScore());

    }

    @When("All bowl are Strike")
    public void all_bowl_are_strike(io.cucumber.datatable.DataTable dataTable) {
        final List<String> strings = dataTable.asList();
        bowlingGame = new BowlingGame();
        try {
            for (String str : strings) {
                bowlingGame.setBowl(Integer.parseInt(str));
            }
        } catch (Exception e) {
            System.out.println("Caught Exception");
        }
    }

    @Then("Total score Strike is {int}")
    public void total_score_strike_is(Integer score) {
        assertEquals(300, bowlingGame.getTotalScore());
    }

}
