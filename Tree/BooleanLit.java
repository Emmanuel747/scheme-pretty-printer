// BooleanLit -- Parse tree node class for representing boolean literals

package Tree;

public class BooleanLit extends Node {
    private boolean boolVal;

    private static BooleanLit trueInstance = new BooleanLit(true);
    private static BooleanLit falseInstance = new BooleanLit(false);

    private BooleanLit(boolean b) {
        boolVal = b;
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
    }
}