package rpassets.core.roll;

import java.util.Random;

/**
 * grammar:
 * <p>
 * expression
 * -- lowPrecedence
 * -- expression '+' lowPrecedence
 * -- expression '-' lowPrecedence
 * lowPrecedence
 * -- highPrecedence
 * -- lowPrecedence '*' highPrecedence
 * -- lowPrecedence '/' highPrecedence
 * highPrecedence
 * -- primary
 * -- primary 'd' primary
 * primary
 * -- number
 * -- '('expression')'
 * -- '+'primary
 * -- '-'primary
 * number
 * -- int literal
 */
class RollParser {
    private final String command;
    private RollScanner tokens;

    RollParser(String command) {
        this.command = command;
    }

    int roll() {
        this.tokens = new RollScanner(this.command);
        try {
            return expression();
        } catch (Exception e) {
            System.err.println("Error while rolling '" + command + "'\n" + e.getMessage());
            return 0;
        }
    }

    private int expression() throws Exception {
        int left = lowPrecedence();

        while (tokens.notEmpty()) {
            Token t = tokens.getToken();
            switch (t.type) {
                case PLUS:
                    left += lowPrecedence();
                    break;
                case MINUS:
                    left -= lowPrecedence();
                    break;
                default:
                    tokens.putBack(t);
                    return left;
            }
        }
        return left;
    }

    private int lowPrecedence() throws Exception {
        int left = highPrecedence();

        while (tokens.notEmpty()) {
            Token t = tokens.getToken();
            switch (t.type) {
                case STAR:
                    left *= highPrecedence();
                    break;
                case SLASH:
                    left /= highPrecedence();
                    break;
                default:
                    tokens.putBack(t);
                    return left;
            }
        }
        return left;
    }

    private int highPrecedence() throws Exception {
        int left = primary();
        if (tokens.notEmpty()) {
            Token t = tokens.getToken();
            if (t.type != TokenType.DICE) {
                tokens.putBack(t);
                return left;
            }
            int right = primary();
            return xdy(left, right);
        }
        return left;
    }

    private int primary() throws Exception {
        Token t = tokens.getToken();

        if (t == null) return 0;

        switch (t.type) {
            case LEFT_PAREN:
                int res = expression();
                if (tokens.getToken().type != TokenType.RIGHT_PAREN) {
                    throw new Exception(") expected");
                }
                return res;
            case NUMBER:
                return t.value;
            case PLUS:
                return primary();
            case MINUS:
                return -primary();
            default:
                throw new Exception("primary expected");
        }
    }

    private int xdy(int x, int y) {
        Random r = new Random();
        int sig;
        if (x < 0) {
            x *= -1;
            sig = -1;
        } else {
            sig = 1;
        }
        int res = 0;
        while (x-- > 0) {
            res += r.nextInt(y) + 1;
        }
        return sig * res;
    }
}
