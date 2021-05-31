import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private int[][] state;

    private Map<Integer, List<Integer>> positionLinesMap;

    private int[] lines;

    private int totalMovesLeft;

    public void initializeGame() {
        state = new int[3][3];
        lines = new int[8];
        totalMovesLeft = 9;
        initializePositionLinesMap();
    }

    private void initializePositionLinesMap() {
        positionLinesMap = new HashMap<>();
        positionLinesMap.put(0, List.of(0, 3, 6));
        positionLinesMap.put(1, List.of(0, 4));
        positionLinesMap.put(2, List.of(0, 5, 7));
        positionLinesMap.put(3, List.of(1, 3));
        positionLinesMap.put(4, List.of(1, 4, 6, 7));
        positionLinesMap.put(5, List.of(1, 5));
        positionLinesMap.put(6, List.of(2, 3, 7));
        positionLinesMap.put(7, List.of(2, 4));
        positionLinesMap.put(8, List.of(2, 5, 6));
    }

    public boolean makeMove(Position position, int token) throws RuntimeException {
        if (!validMove(position)) {
//            System.out.println("Not a valid position");
            return false;
//            throw new InvalidMoveException("Not a valid position");
        }
        if (isPositionFilled(position)) {
//            System.out.println("cannot write over already filled space");
            return false;
//            throw new PositionAlreadyFilledException("cannot write over already filled space");
        }

        printMove(position, token);
        updateBoard(position, token);

        int key = position.x * 3 + position.y;
        for (int i : positionLinesMap.get(key)) {
            lines[i] = lines[i] + token;
            if (lines[i] == 3) {
                System.out.println("Player X wins");
                totalMovesLeft = 0;
                return true;
            }
            if (lines[i] == -3) {
                System.out.println("Player O wins");
                totalMovesLeft = 0;
                return true;
            }
        }
        if (totalMovesLeft == 0)
            System.out.println("Game Draw");
        return true;
    }

    private void printMove(Position position, int token) {
        System.out.println((10 - totalMovesLeft) + " Player " + token + " moves to position " + position.x + " " + position.y);
    }

    private void updateBoard(Position position, int token) {
        state[position.x][position.y] = token;
        totalMovesLeft--;
    }

    private boolean isPositionFilled(Position position) {
        return state[position.x][position.y] != 0;
    }

    private boolean validMove(Position position) {
        return position.x >= 0 && position.y >= 0 && position.x < 3 && position.y < 3;
    }

    public boolean isGameRunning() {
        return totalMovesLeft != 0;
    }
}
