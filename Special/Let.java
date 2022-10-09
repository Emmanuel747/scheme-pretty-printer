// Let -- Parse tree node strategy for printing the special form let

package Special;

import Tree.Node;

public class Let extends Special {
 

    public Let(){}

    public void print(Node node, int num, boolean bool) {
        for (int i = 0; i < num; i++){
		    System.out.println(' ');
        }

		System.out.println("(let ");

		Node temp = node.getCdr().getCar();
		if (temp.isPair()){
			temp.print(0, false);
        }
		else{
		    System.err.println("There is a syntax error.");
        }

		System.out.println();

		Node temp2 = node.getCdr().getCdr();
		if (temp2.isPair()){
			temp2.print(num + 2, true);
        }
		else{
            System.err.println("There is a syntax error.");
        }

		System.out.println();

		for (int i = 0; i < num; i++){
			System.out.println(' ');
        }

		System.out.println("/LET");
    }
}