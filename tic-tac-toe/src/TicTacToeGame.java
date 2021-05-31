public class TicTacToeGame {

    public static void main(String[] args) {
        Board gameBoard = new Board();
        gameBoard.initializeGame();

        int currentPlayer = 1;

        while (gameBoard.isGameRunning()) {
            boolean isMoveMade = gameBoard.makeMove(Position.random(), currentPlayer);
            if (isMoveMade)
                currentPlayer *= -1;
        }

        System.out.println("Game Finished");
    }
}
