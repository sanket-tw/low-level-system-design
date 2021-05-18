package player;

import lombok.Data;

@Data
public class Player {

    int id;
    String playerName;
    Status playerStatus;

    public int getId() {
        return id;
    }

    public static Player createWithName(String playerName) {
        return new Player(playerName);
    }

    enum Status {
        PLAYING, WON, LOST, RESIGNED
    }

    public Player(String playerName) {
        this.id = (int) Math.random();
        this.playerName = playerName;
        this.playerStatus = Status.PLAYING;
    }
}
