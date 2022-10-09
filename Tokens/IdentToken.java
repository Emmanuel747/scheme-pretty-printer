// IdentToken -- Token object for representing identifiers.

package Tokens;

public class IdentToken extends Token {
    private String name;

    public IdentToken(String s) {
        super(TokenType.IDENT);
        name = s;
    }

    @Override
    public String getName() {
        return name;
    }
}
