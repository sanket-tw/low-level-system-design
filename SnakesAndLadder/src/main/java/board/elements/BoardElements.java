package board.elements;

import board.Square;
import lombok.Data;

import static board.elements.BoardElements.Type.SNAKE;

@Data
public abstract class BoardElements {

    public BoardElements(Square start, Square end) {
        this.start = start;
        this.end = end;
        this.type = deriveBoardType(start, end);
    }

    private Type deriveBoardType(Square start, Square end) {
        return start.getSquarePosition() > end.getSquarePosition() ? SNAKE : Type.LADDER;
    }

    private Square start;
    private Square end;
    private Type type;

    enum Type {
        SNAKE, LADDER
    }
}
