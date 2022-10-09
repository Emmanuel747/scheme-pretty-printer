// Regular -- Parse tree node stratagy for printing regular lists

package Special;

import Tree.Node;

public class Regular extends Special {
 
    public Regular(){}
    
    public void print(Node node, int num, boolean bool) {
        for (int i = 0; i < num; i++){
			System.out.println(' ');
        }

		if (!bool){
			System.out.println('(');
        }

		node.getCar().print(0);
		System.out.println(' ');
		node.getCdr().print(0, true);
    }
}