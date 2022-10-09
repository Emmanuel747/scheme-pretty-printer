// IntToken -- Token object for representing integer constants.

package Tokens;

public class IntToken extends Token {
    private int intVal;

    public IntToken(int i) {
        super(TokenType.INT);
        intVal = i;
    }

    @Override
    public int getIntVal() {
        return intVal;
    }
}
