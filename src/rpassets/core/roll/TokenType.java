package rpassets.core.roll;

enum TokenType {
    LEFT_PAREN("("), RIGHT_PAREN(")"),
    MINUS("-"), PLUS("+"),
    SLASH("/"), STAR("*"),
    DICE("d"),
    NUMBER("NUM"),
    INVALID("WTF");

    TokenType(String symbol) {
        this.symbol = symbol;
    }

    private final String symbol;

    @Override
    public String toString() {
        return symbol;
    }
}
