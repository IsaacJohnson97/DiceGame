package controller;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class UserInputHandler {

    protected String takeUserInput() {
        System.out.println("(Number of dice, number of sides on the dice, bonus points or penalty points: eg. 3d6+2 and click enter)\n type stop to end program\nEnter die parameters:");
        //user input's a string
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        System.out.println(userInput);

        return userInput;
    }



    protected Boolean validateUserInput(String userInput){
        Pattern p = Pattern.compile("^(?!\\d+$)(([1-9]\\d*)?[Dd]?[1-9]\\d*( ?[+-] ?)?)+$");
        Matcher m = p.matcher(userInput);
        boolean b = m.matches();

        return b;
    }

    protected String[] splitAllOnOperator(String input) {
        String[] splitInput;
        splitInput = input.split("(?=[+ -])");

        return splitInput;
    }

    //method to separate list to a list of only those that contain a d or D
    private List<String> refinedDiceList(String[] unrefinedList){
        List<String> refinedList = new ArrayList<String>();
        for (String listInstance: unrefinedList) {
            if(listInstance.contains("d")||listInstance.contains("D")) {
                refinedList.add(listInstance);
            }
        }
        return refinedList;
    }
    
    //method to separate those without the letter d or D
    private List<String> refinedBonusList(String[] unrefinedList){
        List<String> refinedList = new ArrayList<String>();
        for (String listInstance: unrefinedList){
            if(!listInstance.contains("d")||!listInstance.contains("D")){
                refinedList.add(listInstance);
            }
        }
        return refinedList;
    }


    //parse these to integer and return as int list
    public static <T, U> List<U>
    convertStringListToIntList(List<T> listOfString,
                               Function<T, U> function)
    {
        return listOfString.stream()
                .map(function)
                .collect(Collectors.toList());

    }




    //method that splits each string for a dice and creates a dice object and adds them back to a list of dice objects

    // method that rolls for each dice in the dice object list and add results to a int list

    //method that adds all of the integers in the list from objects and from bonus

    /* Splitting User Input for parsing */
    protected String[] splitUserInput(String userInput) {
        String[] splitUserInput = userInput.split("d");

        return splitUserInput;
    }


    /* Parsing number of dice from string to int and returning the value */
    protected int getNumberOfDiceRollsFromUserInput(String[] splitUserInput) {
        String noOfDiceString = splitUserInput[0];
        int noOfDiceInt = Integer.parseInt(noOfDiceString);

        return noOfDiceInt;
    }


    /* Parsing Number of sides on the dice from string to int and returning the value */
    protected int getNumberOfSidesOnDiceFromUserInput(String[] splitUserInput) {
        String noOfDiceSidesOriginalString = splitUserInput[1];
        String[] userInputBonusOrPenaltySplit = noOfDiceSidesOriginalString.split("[+ -]");
        String noOfDiceSideSplitString = userInputBonusOrPenaltySplit[0];
        int noOfDiceSideInt = Integer.parseInt(noOfDiceSideSplitString);

        return noOfDiceSideInt;
    }

    protected Integer getBonusAndPenaltyTotal(String[] splitUserInput) throws ScriptException {

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String diceSidesString = splitUserInput[1];
        StringBuilder bonusAndPenaltyString = new StringBuilder(diceSidesString);
        bonusAndPenaltyString.setCharAt(0, '0');
        Integer bonusAndPenaltyTotal = (Integer) engine.eval(bonusAndPenaltyString.toString());

        return bonusAndPenaltyTotal;
    }

    /* Parsing Bonus or Penalty from string to int and returning the value */
    protected int getBonusOrPenaltyValueInt(String[] splitUserInput) {
        String diceSidesString = splitUserInput[1];
        String[] diceSidesAndBonusOrPenalty = diceSidesString.split("[\\+ \\-]");
        String bonusOrPenaltyString = diceSidesAndBonusOrPenalty[1];
        int bonusOrPenaltyValueInt = Integer.parseInt(bonusOrPenaltyString);

        return bonusOrPenaltyValueInt;
    }
}

