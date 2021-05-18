package player;

import player.exception.BoardPlayerFullException;

import java.util.Map;

public class PlayerService {

    int currentPlayerId;

    Map<Integer, Player> playerList;

    public void moveToNextPlayer() {
        this.currentPlayerId = (currentPlayerId + 1) % playerList.size() + 1;
    }

    public Player getCurrentPlayer() {
        return playerList.get(currentPlayerId);
    }

    public Player addPlayer(String name) {
        Player player = Player.createWithName(name);
        if (playerList.size() >= 4)
            try {
                throw new BoardPlayerFullException("no more players can be added");
            } catch (BoardPlayerFullException e) {
                System.out.println("no more players can be added");
            }
        playerList.put(player.getId(), player);
        return player;
    }

}
