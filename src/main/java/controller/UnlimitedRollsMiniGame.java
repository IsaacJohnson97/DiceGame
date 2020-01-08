package controller;
import model.Dice;
import service.DiceLogic;
import javax.script.ScriptException;
import java.util.Scanner;



public class UnlimitedRollsMiniGame {

    DiceLogic diceLogic;
    BeatTheScoreMiniGame beatTheScoreMiniGame;
    Boolean debugMode;
    UserInputHandler userInputHandler;



    public UnlimitedRollsMiniGame(Boolean debugMode) throws ScriptException {
        this.debugMode = debugMode;
        diceLogic = new DiceLogic();
        beatTheScoreMiniGame = new BeatTheScoreMiniGame();
        userInputHandler = new UserInputHandler();


        if(!debugMode) {
            selectGameMode();
        }
    }

    private String selectGameMode() throws ScriptException {
        System.out.println("What mode would you like to enter?\nEnter 1 for Unlimited Rolls\nEnter 2 for Beat the score mini-game");
        Scanner gameMode = new Scanner(System.in);
        int gameChoice = gameMode.nextInt();
        if (gameChoice == 1){
            System.out.println("Unlimited Mode");
            startUnlimitedRollsMiniGame();
            return "Unlimited"; }
        else if (gameChoice == 2){
            System.out.println("Mini-Game");
            beatTheScoreMiniGame.startBeatTheScoreMiniGame();

            return "Mini-game"; }
        else {
            System.out.println("choose a valid game mode"); }
        selectGameMode();
        return "Invalid";
    }

    public void startUnlimitedRollsMiniGame() throws ScriptException {
        String userInput = userInputHandler.takeUserInput();
        Boolean valid = userInputHandler.validateUserInput(userInput);

        while (!userInput.equals("stop")) {
            if(valid) {
                UserInputHandler userInputHandler = new UserInputHandler();

                userInputHandler.splitAllOnOperator(userInput);

                String[] splitUserInput = userInputHandler.splitUserInput(userInput);
                int noOfDice = userInputHandler.getNumberOfDiceRollsFromUserInput(splitUserInput);
                int noOfSides = userInputHandler.getNumberOfSidesOnDiceFromUserInput(splitUserInput);
                int bonusAndPenaltyTotal = userInputHandler.getBonusAndPenaltyTotal(splitUserInput);


                Dice dice = new Dice(noOfSides, noOfDice);
                int result = diceLogic.rollDice(dice, bonusAndPenaltyTotal);
                System.out.println("Your total roll for " + dice.getNumOfDice() + "D" + dice.getNumOfSides() + "+" + bonusAndPenaltyTotal + " is: " + result);
                userInput = userInputHandler.takeUserInput();
                valid = userInputHandler.validateUserInput(userInput);
                System.out.println(userInput);
            }
            else {
                System.out.println("Your Die must follow the previous parameters");
                userInput = userInputHandler.takeUserInput();
                valid = userInputHandler.validateUserInput(userInput);

            }}}
}