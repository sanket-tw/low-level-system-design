package board;

public class GameNotification {
    void print(String game_status) {
        System.out.println(game_status);
    }

    public void display(Move nexMove, Player currentPlayer) {
        if (nexMove.isLastMove())
            System.out.println("reach end for " + currentPlayer);
        else if (nexMove.isNextMove()) {
            System.out.println(currentPlayer + " moves postion " + nexMove.getPosition());
        } else if (nexMove.reachedJumper()) {
            System.out.println(currentPlayer + " encounters snakes and ladder at postion " + nexMove.getPosition());
        }
    }

}
