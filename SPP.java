// SPP -- The main program of the Scheme pretty printer.

import Parse.Scanner;
import Parse.Parser;
import Tokens.Token;
import Tokens.TokenType;
import Tree.Node;

public class SPP {
	public static void main(String argv[]) {

		// Create scanner that reads from standard input
		Scanner scanner = new Scanner(System.in);

		if (argv.length > 1 ||
		    (argv.length == 1 && ! argv[0].equals("-d"))) {
			System.err.println("Usage: java SPP [-d]");
			System.exit(1);
		}

		// If command line option -d is provided, debug the scanner
		if (argv.length == 1 && argv[0].equals("-d")) {
			
			Token tok = scanner.getNextToken();
			while (tok != null) {
				TokenType tt = tok.getType();

				System.out.print(tt.name());
				if (tt == TokenType.INT)
					System.out.println(", intVal = " + tok.getIntVal());
				else if (tt == TokenType.STRING)
					System.out.println(", strVal = " + tok.getStrVal());
				else if (tt == TokenType.IDENT)
					System.out.println(", name = " + tok.getName());
				else
					System.out.println();

				tok = scanner.getNextToken();
			}
			System.exit(0);
		}

		// Create parser
		Parser parser = new Parser(scanner);
		Node root;

		// Parse and pretty-print each input expression

		root = parser.parseExp();
		while (root != null) {
			root.print(0);
			root = parser.parseExp();
		}
		System.exit(0);
	}
}
