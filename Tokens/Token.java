// Token -- Super class for Token objects.

package Tokens;

public class Token {
    private TokenType tt;

    public Token(TokenType t) {
        tt = t;
    }

    public final TokenType getType() {
        return tt;
    }

    public int getIntVal() {
        return 0;
    }

    public String getStrVal() {
        return "";
    }

    public String getName() {
        return "";
    }
}
