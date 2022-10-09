// Quote -- Parse tree node strategy for printing the special form quote

package Special;

import Tree.Node;

public class Quote extends Special {
 
    public Quote(){}

    public void print(Node node, int num, boolean bool) {
        System.out.println("I RAN");
		if (node.getCdr() == null){
			System.out.println("'");
   }
		else{
		    node.getCdr().print(0, false);
        }
    }
}