// BooleanLit -- Parse tree node class for representing boolean literals

package Tree;

public class BooleanLit extends Node {
    private boolean boolVal;

    private static BooleanLit trueInstance = new BooleanLit(true);
    private static BooleanLit falseInstance = new BooleanLit(false);

    public BooleanLit(boolean b) {
        boolVal = b;
    }

    public static BooleanLit getInstance(boolean val) {
        if (val)
            return trueInstance;
        else
            return falseInstance;
    }

    @Override
    public boolean isBoolean() {
      return true;
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

    public static void printBoolLit(int n) {
      indent(n);
      if (boolVal) {
          System.out.print("#t");
      }
      else {
          System.out.print("#f");
      }
      terminate(n);
  }
}