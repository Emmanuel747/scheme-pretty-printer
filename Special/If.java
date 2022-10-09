// If -- Parse tree node strategy for printing the special form if

package Special;

import Tree.Node;

public class If extends Special {

    public If(){}

    public void print(Node node, int num, boolean bool) {
        for (int i = 0; i < num; i++){
		    System.out.println(' ');
        }
		System.out.println("(if ");

		Node temp = node.getCdr().getCar();
		if (temp.isPair()){
			temp.print(0, bool);
        }
		else{
		    System.err.println("There is a syntax error.");
        }

		System.out.println();

		Node thenStmt = node.getCdr().getCdr().getCar();
		if (!thenStmt.isNull()){
		    thenStmt.print(num + 2, bool);
        }
		else{
		    System.err.println("There is a syntax error.");
        }

		System.out.println();

		Node elseStmt = node.getCdr().getCdr().getCdr().getCar();
		if (!elseStmt.isNull()){
			elseStmt.print(num + 2, bool);
        }
		else{
		    System.err.println("There is a syntax error.");
        }

		for (int i = 0; i < num; i++){
			System.out.println(' ');
        }

		System.out.println(')');
	} 
}