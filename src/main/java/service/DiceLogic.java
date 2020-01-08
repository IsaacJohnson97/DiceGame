package service;
import controller.UserInputHandler;
import model.Dice;
import java.util.Random;


public class DiceLogic {

    public int rollDice(Dice dice, Integer bonusAndPenaltyTotal) {
        int numOfSides = dice.getNumOfSides();
        int numOfDice = dice.getNumOfDice();
        int result = 0;
        int roll = 0;

        if (numOfSides >= 4) {
            for (int i = 0; i < numOfDice; i++) {
                roll = getRandomNumber(numOfSides);
                System.out.println("You rolled: " + roll);
                result = result + roll;
            }
        } else {
            System.out.println("Your die must have at least 4 sides");
        }
        return result + bonusAndPenaltyTotal;
    }

    public int getRandomNumber(int numOfSides) {
        Random r = new Random();
        return r.nextInt(numOfSides) + 1;
    }

}
