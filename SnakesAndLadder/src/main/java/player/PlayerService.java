package player;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PlayerService {

    Queue<Player> playerQueue;
    Map<Player, Integer> playerCurrentPositionMap;

    public PlayerService() {
        playerQueue = new LinkedList<>();
        playerCurrentPositionMap = new HashMap<>();
    }

    public Player addPlayer(String name) {
        Player newPlayer = new Player(name);
        playerQueue.offer(newPlayer);
        return newPlayer;
    }

    public void setPosition(Player player, int position) {
        playerCurrentPositionMap.put(player, position);
    }

    public Player getCurrentPlayer() {
        return playerQueue.poll();
    }

    public int getCurrentPosition(Player currentPlayer) {
        return playerCurrentPositionMap.get(currentPlayer);
    }

    public void playerContinues(Player currentPlayer) {
        playerQueue.offer(currentPlayer);
    }

    public boolean gameContinues() {
        return playerQueue.size() > 1;
    }
}
