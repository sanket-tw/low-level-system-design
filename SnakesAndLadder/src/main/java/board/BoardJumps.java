package board;

import lombok.Data;

@Data
public class BoardJumps {

    int startPosition;
    int endPosition;
    Type type;

    public BoardJumps(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.type = startPosition > endPosition ? Type.LADDER : Type.SNAKE;
    }

    enum Type {
        SNAKE, LADDER
    }
}
