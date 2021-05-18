package board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    int size;
    Map<Integer, BoardJumps> boardJumpsMap;

    public Board(int size) {
        this.size = size;
    }

    enum MoveStatus {
        REACHED_END,
        REACHED_JUMPER,
        MOVE_NEXT;
    }

    public int getNextPosition(int nextPosition) {
        return boardJumpsMap.get(nextPosition).getEndPosition();
    }

    public void setBoardJumps(List<BoardJumps> boardJumps) {
        boardJumpsMap = new HashMap<>();
        boardJumps.forEach(boardJump -> {
            boardJumpsMap.put(boardJump.getStartPosition(), boardJump);
        });
    }

    public MoveStatus validateNextValue(int nextPosition) {
        if (nextPosition >= size - 1)
            return MoveStatus.REACHED_END;
        else if (boardJumpsMap.containsKey(nextPosition))
            return MoveStatus.REACHED_JUMPER;
        else
            return MoveStatus.MOVE_NEXT;
    }
}
