import board.Board;
import board.BoardNotificationService;
import board.Square;
import board.Dice;
import player.Player;
import player.PlayerService;
import token.Token;
import token.TokenManager;

import java.util.Map;

public class GameService {
    Board board;
    BoardNotificationService boardNotificationService;
    TokenManager tokenManager;
    PlayerService playerService;

    Map<Player, Token> playerTokenMap;

    Status status;
    Dice dice;


    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.initializeGame();
        gameService.addPlayer("p1", "red");
        gameService.addPlayer("p1", "green");
        gameService.addPlayer("p1", "yellow");
        gameService.addPlayer("p1", "blue");

        while (true) {
            int value = gameService.rollDice();
            gameService.moveCurrentPlayer(value);
            gameService.moveToNextPlayer();
        }

        gameService.declareWinner();
    }

    private void declareWinner() {

    }

    void initializeGame() {
        this.board = new Board();
        this.status = Status.STARTED;
        this.tokenManager = new TokenManager();
        this.playerService = new PlayerService();
    }

    enum Status {
        STARTED, FINISHED, ABRUPTED;
    }

    void addPlayer(String name, String tokenColor) {
        Token token = tokenManager.getToken(tokenColor);
        Player player = playerService.addPlayer(name);
        playerTokenMap.put(player, token);
        tokenManager.setTokenToPosition(token, board.getFirstPosition());
    }

    int rollDice() {
        return dice.throwDice();
    }

    void moveCurrentPlayer(int diceValue) {
        Player currentPlayer = playerService.getCurrentPlayer();
        Token token = playerTokenMap.get(currentPlayer);

        Square currentPosition = tokenManager.getTokenCurrentPosition(token);
        Square finalPosition = board.moveByPositions(diceValue, currentPosition, boardNotificationService);
        tokenManager.setTokenToPosition(token, finalPosition);
    }

    void moveToNextPlayer() {
        playerService.moveToNextPlayer();
    }

}
