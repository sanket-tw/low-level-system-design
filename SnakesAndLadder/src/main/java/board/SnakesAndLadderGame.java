package board;

import java.util.*;

public class SnakesAndLadderGame {

    Board board;
    GameNotification gameNotification;
    PlayerService playerService;
    Dice dice;

    public static void main(String[] args) {
        SnakesAndLadderGame snakesAndLadderGame = new SnakesAndLadderGame();
        snakesAndLadderGame.initializeGame(15, List.of(new BoardJumps(1, 2)), 1);

        snakesAndLadderGame.addPlayer("Sanket");
        snakesAndLadderGame.addPlayer("Sanket2");
        snakesAndLadderGame.addPlayer("Sanket3");

        snakesAndLadderGame.playGame();
    }

    void initializeGame(int boardSize, List<BoardJumps> boardJumps, int diceCount) {
        board = new Board(boardSize);
        board.setBoardJumps(boardJumps);
        dice = new Dice(diceCount);
        gameNotification = new GameNotification();
        playerService = new PlayerService();
    }

    void addPlayer(String name) {
        Player player = playerService.addPlayer(name);
        playerService.setPosition(player, 1);
    }

    void playGame() {
        while (playerService.gameContinues()) {
            Player currentPlayer = playerService.getCurrentPlayer();
            int currentPosition = playerService.getCurrentPosition(currentPlayer);
            int diceValue = dice.rollDice();

            var move = board.getNextMove(diceValue, currentPosition);
            playerService.setPosition(currentPlayer, move.getPosition());

            processNextMove(currentPlayer, move);
        }
        gameNotification.print("Game Finished");
    }

    private void processNextMove(Player currentPlayer, Move nexMove) {
        if (!nexMove.isLastMove())
            playerService.playerContinues(currentPlayer);
        gameNotification.display(nexMove, currentPlayer);
    }
}
