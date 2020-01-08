package controller;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class BeatTheScoreMiniGameTest {

        private BeatTheScoreMiniGame beatTheScoreMiniGame;

    @Before
    public void setup() {
        beatTheScoreMiniGame = new BeatTheScoreMiniGame();
    }


    @Test
    public void givenUserScoreIsHigherThanScoreChoiceWhenComparedReturnWinString(){
       String returnString = beatTheScoreMiniGame.compareScoreToBeatWithUserResult(14,20);
       assertEquals("You Won! :)",returnString);
    }

    @Test
    public void givenUserScoreIsLowerThanScoreChoiceWhenComparedReturnLoseString(){
        String returnString = beatTheScoreMiniGame.compareScoreToBeatWithUserResult(20,14);
        assertEquals("You Lost! :(",returnString);
    }

    @Test
    public void givenUserScoreIsTheSameAsScoreChoiceWhenComparedReturnDrawString(){
        String returnString = beatTheScoreMiniGame.compareScoreToBeatWithUserResult(20,20);
        assertEquals("You Drew! :/",returnString);
    }
}
