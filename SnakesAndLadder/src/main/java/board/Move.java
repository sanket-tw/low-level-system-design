package board;

import lombok.Data;

@Data
public class Move {
    MoveStatus moveStatus;
    int position;


    public enum MoveStatus {
        REACHED_END,
        REACHED_JUMPER,
        MOVE_NEXT;


    }
    public Move(MoveStatus moveStatus, int position) {
        this.moveStatus = moveStatus;
        this.position = position;
    }

    public boolean reachedJumper() {
        return this.moveStatus.equals(MoveStatus.REACHED_JUMPER);
    }

    public boolean isNextMove() {
        return this.moveStatus.equals(MoveStatus.MOVE_NEXT);
    }

    public boolean isLastMove() {
        return this.moveStatus.equals(Move.MoveStatus.REACHED_END);
    }
}
