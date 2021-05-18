package token;

import java.util.Objects;

public class Token {

    COLOR color;

    public Token(COLOR color) {
        this.color = color;
    }

    public enum COLOR {
        YELLOW, BLUE, GREEN, RED
    }

    public COLOR getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return color.equals(token.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
