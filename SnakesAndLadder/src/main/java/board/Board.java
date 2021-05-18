package board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static board.Move.MoveStatus.REACHED_JUMPER;

public class Board {

    int size;

    Map<Integer, BoardJumps> boardJumpsMap;

    public Board(int size) {
        this.size = size;
    }

    public Move getNextMove(int diceValue, int currentPosition) {
        int nextPosition = diceValue + currentPosition;
        Move.MoveStatus status = validateNextValue(nextPosition);
        if (status.equals(REACHED_JUMPER))
            nextPosition = getJumperMovePosition(nextPosition);
        return new Move(status, nextPosition);
    }

    private int getJumperMovePosition(int nextPosition) {
        return boardJumpsMap.get(nextPosition).getEndPosition();
    }

    public void setBoardJumps(List<BoardJumps> boardJumps) {
        boardJumpsMap = new HashMap<>();
        boardJumps.forEach(boardJump -> {
            boardJumpsMap.put(boardJump.getStartPosition(), boardJump);
        });
    }

    public Move.MoveStatus validateNextValue(int nextPosition) {
        if (nextPosition >= size - 1)
            return Move.MoveStatus.REACHED_END;
        else if (boardJumpsMap.containsKey(nextPosition))
            return Move.MoveStatus.REACHED_JUMPER;
        else
            return Move.MoveStatus.MOVE_NEXT;
    }
}
