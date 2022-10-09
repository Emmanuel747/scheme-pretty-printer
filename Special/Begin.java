// Begin -- Parse tree node strategy for printing the special form begin
package Special;

import Tree.Node;
import Tree.PrintMethod;

public class Begin extends Special {

    public Begin() {}
 
  public void print(Node node, int num, boolean bool) {

    if (!bool) {
        PrintMethod.indent(num);
        System.out.println("(begin");
        PrintMethod.printTail(node, Math.abs(num) + 2);
    }
    else {
      PrintMethod.printRegular(node, num, bool);
    }
  }
}