import board.Board;
import board.BoardJumps;
import board.Dice;
import board.Move;
import notification.ConsoleNotification;
import notification.GameNotification;
import player.Player;
import player.PlayerService;

import java.util.*;

public class SnakesAndLadderGame {

    Board board;
    GameNotification gameNotification;
    PlayerService playerService;
    Dice dice;

    public void initializeGame(int boardSize, List<BoardJumps> boardJumps, int diceCount) {
        board = new Board(boardSize);
        board.setBoardJumps(boardJumps);
        dice = new Dice(diceCount);
        gameNotification = new ConsoleNotification();
        playerService = new PlayerService();
    }

    public void addPlayer(String name) {
        Player player = playerService.addPlayer(name);
        playerService.setPosition(player, 1);
    }

    public void playGame() {
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
