import board.BoardJumps;

import java.util.List;

public class PlayGame {

    public static void main(String[] args) {
        SnakesAndLadderGame snakesAndLadderGame = new SnakesAndLadderGame();
        snakesAndLadderGame.initializeGame(15, List.of(new BoardJumps(1, 2)), 1);

        snakesAndLadderGame.addPlayer("Sanket");
        snakesAndLadderGame.addPlayer("Sanket2");
        snakesAndLadderGame.addPlayer("Sanket3");

        snakesAndLadderGame.playGame();
    }

}
