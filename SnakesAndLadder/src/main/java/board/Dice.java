package board;

public class Dice {

    private int diceCount;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        return (int) (Math.random()*(6*diceCount-diceCount)+1);
    }
}
