package notification;

import board.Move;
import player.Player;

public interface GameNotification {
    void print(String message);

    void display(Move nexMove, Player currentPlayer);
}
