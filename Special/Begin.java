// Begin -- Parse tree node strategy for printing the special form begin
package Special;

import Tree.Node;

public class Begin extends Special {

  public Begin() {}
 
  public void print(Node node, int num, boolean bool) {

    for (int i = 0; i < num; i++){
        System.out.println(' ');
		}
    System.out.println("(begin");


		if (node.getCdr().isPair()){
		  node.getCdr().print(num + 2, bool);
    }
		else{
      System.err.println("There is a syntax error.");
    }
        
		for (int i = 0; i < num; i++){
      System.out.println(' ');
		}

    System.out.println(")");
	}
}
