// Set -- Parse tree node strategy for printing the special form set!

package Special;

import Tree.Node;

public class Set extends Special {
 
    public Set(){}

    public void print(Node node, int num, boolean bool) {
        if (bool != true){
		    System.out.println("(");
        }

		if (node.getCar().isPair()){
			node.getCar().print(0, false);
        }
		else{
		    node.getCar().print(0, true);
        }

		System.out.println(" ");
		Node temp = node.getCdr();
		if (temp == null){
			System.out.println(")");
        }
		else{
			temp.print(0, true);
        }
    }
}