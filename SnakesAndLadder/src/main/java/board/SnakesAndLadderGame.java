package board;

import java.util.*;

public class SnakesAndLadderGame {

    Board board;
    GameNotification gameNotification;
    Dice dice;
    Queue<Player> playerQueue;
    Map<Player, Integer> playerCurrentPositionMap;

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
        playerQueue = new LinkedList<>();
        playerCurrentPositionMap = new HashMap<>();
        gameNotification = new GameNotification();
    }

    void addPlayer(String name) {
        Player newPlayer = new Player(name);
        playerQueue.offer(newPlayer);
        playerCurrentPositionMap.put(newPlayer, 1);
    }

    void playGame() {
        while (playersLeftToCompleteGame()) {

            Player currentPlayer = playerQueue.poll();
            int currentPosition = playerCurrentPositionMap.get(currentPlayer);
            int diceValue = dice.rollDice();
            int nextPosition = currentPosition + diceValue;

            var nextMoveStatus = board.validateNextValue(nextPosition);
            processNextMove(currentPlayer, nextPosition, nextMoveStatus);
        }
    }

    private void processNextMove(Player currentPlayer, int nextPosition, Board.MoveStatus nextMoveStatus) {
        if (nextMoveStatus.equals(Board.MoveStatus.REACHED_END))
            gameNotification.print("Game Ended");
        else if (nextMoveStatus.equals(Board.MoveStatus.MOVE_NEXT)) {
            playerCurrentPositionMap.put(currentPlayer, nextPosition);
            playerQueue.offer(currentPlayer);
            gameNotification.print(currentPlayer + " moves postion " + nextPosition);
        } else if (nextMoveStatus.equals(Board.MoveStatus.REACHED_JUMPER)) {
            nextPosition = board.getNextPosition(nextPosition);
            playerCurrentPositionMap.put(currentPlayer, nextPosition);
            playerQueue.offer(currentPlayer);
            gameNotification.print(currentPlayer + " encounters snakes and ladder at postion " + nextPosition);
        }
    }

    private boolean playersLeftToCompleteGame() {
        return playerQueue.size() > 1;
    }

}
