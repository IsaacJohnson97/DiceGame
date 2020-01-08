package controller;
import org.junit.Before;
import org.junit.Test;

import javax.script.ScriptException;

import static org.junit.Assert.assertEquals;

public class UserInputHandlerTest {

    private UserInputHandler userInputHandler;


    @Before
    public void setup() {
        userInputHandler = new UserInputHandler();
    }

    //GivenTheseConditionsWhenThatHappensThenThisShouldBeTheCase

    @Test
    public void givenValidUserInputWhenSplittingOnCharacterDThenReturnPrefixAndSuffixAsAnArray () {
        String splitUserInput[] = userInputHandler.splitUserInput("3d6+2");
        assertEquals("3", splitUserInput[0]);
        assertEquals("6+2", splitUserInput[1]);
    }

    @Test
    public void givenArrayOfStringsWhenFirstIndexIsNumericalValueThenReturnFirstIndexAsInteger(){
        String splitUserInput[] = new String[] {"3", "6+2"};
        int numOfRolls = userInputHandler.getNumberOfDiceRollsFromUserInput(splitUserInput);
        assertEquals(3, numOfRolls);
    }

    @Test
    public void givenArrayOfStringsWhenSecondIndexIsSplitThenReturnPrefixValueAsInteger(){
        String splitUserInput[] = new String[] {"3", "6+2"};
        int numOfSides = userInputHandler.getNumberOfSidesOnDiceFromUserInput(splitUserInput);
        assertEquals(6, numOfSides);
    }

    @Test
    public void givenArrayOfStringWhenSecondIndexIsSplitThenReturnSuffixValueAsInteger(){
        String splitUserInput[] = new String[] {"3", "6+2"};
        int bonusOrPenalty = userInputHandler.getBonusOrPenaltyValueInt(splitUserInput);
        assertEquals(2, bonusOrPenalty);

    }

//    @Test
//    public void givenTheSplitUserInputWhenMethodIsRunCalculateTotalOfAllBonusAndPenalties() throws ScriptException {
//        String diceSidesString[] = new String[]{"6+2+2-3"};
//        int bonusAndPenaltyTotal = userInputHandler.getBonusAndPenaltyTotal(diceSidesString);
//        assertEquals(1, bonusAndPenaltyTotal);
//    }

    @Test
    public void givenTheUserInputWhenTheStringHitsTheValidationThenReturnErrorIfNotValidStructure(){
        String userInput = new String("3d6+2");
        boolean validateUserInput = userInputHandler.validateUserInput(userInput);
        assertEquals(true, validateUserInput);
    }

}
