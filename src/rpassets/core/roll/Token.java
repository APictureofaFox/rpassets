package rpassets.core.roll;

class Token {
    final TokenType type;
    final int value;

    Token(TokenType type, int value) {
        this.type = type;
        this.value = value;
    }

    Token(TokenType type) {
        this(type, 0);
    }

    @Override
    public String toString() {
        return type + " " + value;
    }
}
