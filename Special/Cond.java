// Cond -- Parse tree node strategy for printing the special form cond

package Special;

import Tree.Node;

public class Cond extends Special {

    public Cond(){}
 
    public void print(Node node, int num, boolean bool) {

        for (int i = 0; i < num; i++){
			System.out.println(' ');
		}

		System.out.println("(cond");

		Node temp = node.getCdr();
		if(temp.isPair()){
			temp.print(num + 2, true);
		}
		else{
			System.err.println("There is a syntax error.");
		}
    }
}