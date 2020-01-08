package controller;
import model.Dice;
import service.DiceLogic;

import javax.script.ScriptException;
import java.util.Scanner;


public class BeatTheScoreMiniGame {

    DiceLogic diceLogic;
    UserInputHandler userInputHandler;



    public void startBeatTheScoreMiniGame() throws ScriptException {
        userInputHandler = new UserInputHandler();
        Integer scoreChoice = InputScoreToBeat();
        String userInput = userInputHandler.takeUserInput();
        Boolean valid = userInputHandler.validateUserInput(userInput);
        diceLogic = new DiceLogic();

        while (!userInput.equals("stop")) {
            if(valid) {
                UserInputHandler userInputHandler = new UserInputHandler();
                String[] splitUserInput = userInputHandler.splitUserInput(userInput);
                int noOfDice = userInputHandler.getNumberOfDiceRollsFromUserInput(splitUserInput);
                int noOfSides = userInputHandler.getNumberOfSidesOnDiceFromUserInput(splitUserInput);
                int bonusAndPenaltyTotal = userInputHandler.getBonusAndPenaltyTotal(splitUserInput);


                Dice dice = new Dice(noOfSides, noOfDice);
                int result = diceLogic.rollDice(dice, bonusAndPenaltyTotal);
                System.out.println("Your total roll for " + dice.getNumOfDice() + "D" + dice.getNumOfSides() + "+" + bonusAndPenaltyTotal + " is: " + result);
                String output = compareScoreToBeatWithUserResult(scoreChoice, result);
                System.out.println(output);
                userInput = userInputHandler.takeUserInput();
                valid = userInputHandler.validateUserInput(userInput);
                System.out.println(userInput);
            }
            else {
                System.out.println("Your Die must follow the previous parameters");
                userInput = userInputHandler.takeUserInput();
                valid = userInputHandler.validateUserInput(userInput);
            }}}


    public static Integer InputScoreToBeat(){
        System.out.println("Enter the Score you think you can beat!");
        Scanner scoreToBeat = new Scanner(System.in);
        int scoreChoice = scoreToBeat.nextInt();
        System.out.println(scoreChoice);
        return scoreChoice;
    }


    protected String compareScoreToBeatWithUserResult(int scoreChoice, int result){
        String output;
        if ( scoreChoice < result ){
            output = "You Won! :)";
        } else if ( scoreChoice > result){
            output = "You Lost! :(";
        } else {
            output = "You Drew! :/";
        }
        return output;
    }
}