// BooleanLit -- Parse tree node class for representing boolean literals

package Tree;

import Tree.PrintMethod;

public class BooleanLit extends Node {
    private boolean boolVal;
    private static BooleanLit trueInstance = new BooleanLit(true);
    private static BooleanLit falseInstance = new BooleanLit(false);

    private BooleanLit(boolean val) {
        boolVal = val;
    }

    public static BooleanLit getInstance(boolean val) {
      if (val)
          return trueInstance;
      else
          return falseInstance;
    }

    public void print(int n) {
        // There got to be a more efficient way to print n spaces.
        for (int i = 0; i < n; i++)
            System.out.print(" ");

        if (boolVal) {
            System.out.println("#t");
        } else {
            System.out.println("#f");
        }
        //makes a new line at the end of the printout for testcases
        if (n >= 0) {
          System.out.println();
        }
    }

    public void printBoolLit(int n) {
      PrintMethod.indent(n);
      if (boolVal) {
          System.out.print("#t");
      }
      else {
          System.out.print("#f");
      }
      PrintMethod.terminate(n);
  }
}