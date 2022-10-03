// StrToken -- Token object for representing string constants.

package Tokens;

public class StrToken extends Token {
    private String strVal;

    public StrToken(String s) {
        super(TokenType.STRING);
        strVal = s;
    }

    public String getStrVal() {
        return strVal;
    }
}
