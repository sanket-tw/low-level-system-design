package board;

import lombok.Data;

@Data
public class Dice {

    int numberOfDice;

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int throwDice() {
        return ((int) (Math.random() * (6 * numberOfDice - numberOfDice))) + 1;
    }
}
