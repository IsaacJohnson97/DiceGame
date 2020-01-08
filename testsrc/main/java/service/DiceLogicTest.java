package service;

import model.Dice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DiceLogicTest {

    private DiceLogic diceLogic;
    private DiceLogic spyDiceLogic;

    private Dice dice;

    @Before
    public void setup() {
        diceLogic = new DiceLogic();
        spyDiceLogic = Mockito.spy(diceLogic);
        when(spyDiceLogic.getRandomNumber(4)).thenReturn(3);
        dice = new Dice(4,4);
    }


    @Test
    public void givenDiceIsFedSpecificValuesThenItWillTotalTheInputAndReturnTheExpectedResult() {
        int result = spyDiceLogic.rollDice(dice,0);
        assertEquals(16, result);
    }
}
