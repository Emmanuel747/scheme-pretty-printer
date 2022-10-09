// Define -- Parse tree node strategy for printing the special form define

package Special;

import Tree.Node;

public class Define extends Special {

    public Define(){}
 
    public void print(Node node, int num, boolean bool) {
	    for (int i = 0; i < num; i++){
			System.out.println(' ');
		}
		System.out.println("(define ");

		Node temp = node.getCdr().getCar();
		if (temp.isSymbol()){
		    temp.print(0, false);
        }
		else{
			System.err.println("There is a syntax error.");
        }

		System.out.println(" ");

		Node anotherNode = node.getCdr().getCdr().getCar();
		if (!anotherNode.isNull()){
				anotherNode.print(0, true);
        }
		else{
            System.err.println("There is a syntax error.");
        }

		System.out.println(")");
    }
}