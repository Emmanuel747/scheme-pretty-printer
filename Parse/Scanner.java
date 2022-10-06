// Scanner -- The lexical analyzer for the Scheme printer and interpreter.

package Parse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

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
      while (ch > 0 && ch == 32 || ch == '\t') {
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

      //Operators
      else if (ch == '+')
        return new Token(TokenType.ADD);

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
          System.out.println(buf[i]);
          ch = in.read();
          i++;
        }
        String s = new String(buf);
        buf = new byte[BUFSIZE];
        System.out.println("Length is -> " + s.length());
				return new StrToken(s);
			}

			// Integer constants
			else if (ch >= '0' && ch <= '9') {
        // TODO: scan the number and convert it to an integer
				int i = ch - '0';
        ch = in.read();
				// Put the character after the integer back into the input
        if (!(ch >= '0' && ch <= '9'))
				  in.unread(ch);
				return new IntToken(i);
			}

			// Identifiers
			else if (ch >= 'A' && ch <= 'Z'
				/* or ch is some other valid first character for an identifier */) {
				// TODO: scan an identifier into the buffer variable buf
        String[] schemeIdentifiers = {
            "quote", "lambda", "if", "set!", "begin", "cond", "and", "or",
            "case", "let", "let*", "letrec", "do", "delay", "quasiquote"
        };
          for (int i = 0; i < schemeIdentifiers.length; i++) {
            char c = schemeIdentifiers[i].charAt(0);
            if (ch == c)
              while (ch != schemeIdentifiers[i].charAt(schemeIdentifiers[i].length()))
              buf[i] = (byte)c;
            }
            System.out.println(buf[i]);
            ch = in.read();
            i++;
          }
          String s = new String(buf);
        }


				// Put the character after the identifier back into the input
				// in.unread(ch);

				return new IdentToken(buf.toString());
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
