package model;

public class Dice {
    int numOfSides;
    int numOfDice;
    boolean isPositive;
    // variable isPositive for if dice is positive or negative

    public Dice(int numOfSides, int numOfDice) {
        this.numOfSides = numOfSides;
        this.numOfDice = numOfDice;
        this.isPositive = true;
        //make default for isPositive true for when you do not have a proceeding operator
    }

    public int getNumOfSides() {
        return numOfSides;
    }

    public void setNumOfSides(int numOfSides) {
        this.numOfSides = numOfSides;
    }


    public int getNumOfDice() { return numOfDice; }

    public void setNumOfDice(int numOfDice) { this.numOfDice = numOfDice; }

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive(boolean positive) {
        isPositive = positive;
    }
}
