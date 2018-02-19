package rpassets.core.roll;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

class RollScanner {
    private final Deque<Token> tokens = new ArrayDeque<>();

    RollScanner(String source) {
        Stream.of(source
                .replaceAll("\\s+", "")
                .split("(?=[d+\\-()*/])|(?<=[d+\\-()*/])")
        ).forEachOrdered(this::scanToken);
    }

    Token getToken() throws Exception {
        Token t = tokens.pollFirst();
        if (t.type == TokenType.INVALID) {
            throw new Exception("invalid token");
        }
        return t;
    }

    void putBack(Token token) {
        tokens.addFirst(token);
    }

    boolean notEmpty() {
        return !tokens.isEmpty();
    }

    private void scanToken(String token) {
        if (token.matches("[\\d]+")) {
            tokens.addLast(new Token(TokenType.NUMBER, Integer.parseInt(token)));
            return;
        }

        switch (token) {
            case "(": tokens.addLast(new Token(TokenType.LEFT_PAREN)); break;
            case ")": tokens.addLast(new Token(TokenType.RIGHT_PAREN)); break;
            case "+": tokens.addLast(new Token(TokenType.PLUS)); break;
            case "-": tokens.addLast(new Token(TokenType.MINUS)); break;
            case "/": tokens.addLast(new Token(TokenType.SLASH)); break;
            case "*": tokens.addLast(new Token(TokenType.STAR)); break;
            case "d": tokens.addLast(new Token(TokenType.DICE)); break;
            default: tokens.addLast(new Token(TokenType.INVALID));
        }
    }
}
