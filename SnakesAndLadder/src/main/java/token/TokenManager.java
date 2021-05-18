package token;

import board.Board;
import board.Square;
import token.exception.NoTokenAvailableException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

public class TokenManager {

    List<Token> availableToken;

    Map<Token, Square> tokenAndCurrentPosition;

    public TokenManager() {
        this.availableToken = List.of(new Token(Token.COLOR.RED), new Token(Token.COLOR.BLUE), new Token(Token.COLOR.GREEN),
                new Token(Token.COLOR.YELLOW));
        tokenAndCurrentPosition = new HashMap<>();
    }

    public Token getToken(String color) {
        Token askedToken = availableToken.stream().filter(token -> token.getColor().name().equals(color)).findFirst().orElse(null);
        if (isNull(askedToken))
            throw new NoTokenAvailableException();
        availableToken.remove(askedToken);
        return askedToken;
    }

    public Square getTokenCurrentPosition(Token token) {
        return tokenAndCurrentPosition.get(token);
    }

    public void setTokenToPosition(Token token, Square firstPosition) {
        tokenAndCurrentPosition.put(token, firstPosition);
    }
}
