package board;

import board.elements.Ladder;
import board.elements.Snake;
import player.Player;

import java.util.Map;

public class Board {

    Map<Integer, Square> squareMap;

    Map<Integer, Snake> snakeMap;

    Map<Integer, Ladder> ladderMap;

    public Square getPosition(int positionValue) {
        return squareMap.get(positionValue);
    }

    public Square getFirstPosition() {
        return squareMap.get(1);
    }

    public Square getLastPosition() {
        return squareMap.get(100);
    }

    public Square moveByPositions(int diceValue, Square currentPosition, BoardNotificationService boardNotificationService) {
        int currentValue = currentPosition.getSquarePosition();
        int nextPosition = currentValue + diceValue;

        if (nextPosition > getLastPosition().getSquarePosition()) {
            boardNotificationService.notify("not allowed as exceeding last position");
        } else if (nextPosition == getLastPosition().getSquarePosition()) {
            boardNotificationService.notify("won by token here");
            return getLastPosition();
        } else if (snakeMap.containsKey(nextPosition)) {
            Snake snake = snakeMap.get(nextPosition);
            boardNotificationService.notify("got a snake");
            return snake.getEnd();
        } else if (ladderMap.containsKey(nextPosition)) {
            boardNotificationService.notify("got a ladder");
            Ladder ladder = ladderMap.get(nextPosition);
            return ladder.getEnd();
        }
    }

    private boolean isGameFinished(Square nextPosition, Board board) {
        return nextPosition.isLastPosition();
    }

    private boolean canMoveFromFirstPosition(Square currentPosition, int diceValue) {
        return currentPosition.getSquarePosition() == 1 && diceValue == 6;
    }

    public void validatePosition(Square finalPosition, Board board, Player currentPlayer) {

    }
}
