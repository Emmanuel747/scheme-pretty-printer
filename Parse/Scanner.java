// Scanner -- The lexical analyzer for the Scheme printer and interpreter.

package Parse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import Tokens.Token;
import Tokens.TokenType;
import Tokens.IdentToken;
import Tokens.IntToken;
import Tokens.StrToken;

public class Scanner {
	private PushbackInputStream in;

	// Maximum length of strings and identifers
	private int BUFSIZE = 1000;
	private byte[] buf = new byte[BUFSIZE];

	public Scanner(InputStream i) {
		in = new PushbackInputStream(i);
	}

	public Token getNextToken() {
		int ch;

		try {
			// It would be more efficient if we'd maintain our own
			// input buffer and read characters out of that
			// buffer, but reading individual characters from the
			// input stream is easier.
			ch = in.read();

			// TODO: Skip white space and comments
      // Working state ~eman
      while (ch > 0 && ch == 32 || ch == '9') {
        ch = in.read();
      }
      if (ch == ';' ) {
        while ( ch != 10 || ch > 0) {
          ch = in.read();
        }
      }
      if (ch == 10)
        ch = in.read();

			// Return null on EOF
			if (ch == -1)
				return null;

			// Special characters
			else if (ch == '\'')
				return new Token(TokenType.QUOTE);
			else if (ch == '(')
				return new Token(TokenType.LPAREN);
			else if (ch == ')')
				return new Token(TokenType.RPAREN);
			else if (ch == '.')
				// We ignore the special identifier `...'.
				return new Token(TokenType.DOT);

			// Boolean constants
			else if (ch == '#') {
				ch = in.read();

				if (ch == 't')
					return new Token(TokenType.TRUE);
				else if (ch == 'f')
					return new Token(TokenType.FALSE);
				else if (ch == -1) {
					System.err.println("Unexpected EOF following #");
					return null;
				} else {
					System.err.println("Illegal character '" +
							(char)ch + "' following #");
					return getNextToken();
				}
			}

			// String constants
			else if (ch == '"') {
				// TODO: Scan a string into the buffer variable buf
        int i = 1;
        ch = in.read();
        while (ch != '"') {
          buf[i]=(byte)ch;
          ch = in.read();
          i++;
        }
        String s = new String(buf);
        buf = new byte[BUFSIZE];
				return new StrToken(s);
			}

			// Integer constants
			else if (ch >= '0' && ch <= '9') {
        // TODO: scan the number and convert it to an integer
        int i = 0;
        do {
          buf[i] = (byte)ch;
          ch = in.read();
          i++;
        } while (ch >= '0' && ch <= '9');
        // Put the character after the integer back into the input
        in.unread(ch);
        String s = new String(buf).trim().toLowerCase();
        buf = new byte[BUFSIZE];
        return new IntToken(Integer.parseInt(s));
			}

      // Identifiers
			else if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') 
              || ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '>' || ch == '<' 
              || ch == '=' || ch == ':' || ch == '@' || ch == '&' || ch == '%' || ch == '?' 
              || ch == '~' || ch == '^' || ch == '_') 
      {
				// TODO: scan an identifier into the buffer variable buf
        buf = new byte[BUFSIZE];
        buf[0] = (byte)ch;
        ch = in.read();
        int i = 1;
        while ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') 
              || ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '>' || ch == '<' 
              || ch == '=' || ch == ':' || ch == '@' || ch == '&' || ch == '%' || ch == '?' 
              || ch == '~' || ch == '^' || ch == '_') 
        {
          buf[i] = (byte)ch;
          ch = in.read();
          i++;
        }
				// Put the character after the identifier back into the input
				in.unread(ch);
        String please = new String(buf);
        return new IdentToken(please);
			}

			// Illegal character
			else {
				System.err.println("Illegal input character '" + (char)ch + '\'');
				return getNextToken();
			}
		} catch (IOException e) {
			System.err.println("IOException: " + e.getMessage());
			return null;
		}
	}
}
