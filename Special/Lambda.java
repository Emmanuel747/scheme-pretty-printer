// Lambda -- Parse tree node strategy for printing the special form lambda

package Special;

import Tree.Node;

public class Lambda extends Special {

    public Lambda(){}
 
    public void print(Node node, int num, boolean bool) {
	    for (int i = 0; i < num; i++){
            System.out.println(' ');
        }
        System.out.println("(lambda ");

        Node temp = node.getCdr().getCar();
        if (temp.isPair()){
            temp.print(0, false);
        }
        else{
            System.err.println("There is a syntax error.");
        }

        System.out.println();

        Node anotherNode = node.getCdr().getCdr().getCar();
        if (anotherNode.isPair()){
            anotherNode.print(num + 2, false);
        }
        else{
            System.err.println("There is a syntax error.");
        }

        System.out.println();
        
        for (int i = 0; i < num; i++){
            System.out.println("");
        }

        System.out.println("");

  
    }
}