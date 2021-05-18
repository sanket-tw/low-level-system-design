package player;

import lombok.Data;

@Data
public class Player {
    private int id;
    private String playerName; //could be a class, more data

    public Player(String playerName) {
        this.playerName = playerName;
        this.id = (int) (Math.random() * 100);
    }
}
