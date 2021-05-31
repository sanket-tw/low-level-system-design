import java.util.Random;

public class Position {

    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position random() {
        Random random = new Random();
        return new Position(random.nextInt() % 3, random.nextInt() % 3);
    }
}
