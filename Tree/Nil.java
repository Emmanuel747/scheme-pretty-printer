// Nil -- Parse tree node class for representing the empty list

package Tree;

public class Nil extends Node {
    private static Nil instance = new Nil();

    private Nil() {
    }

    public static Nil getInstance() {
        return instance;
    }

    public void print(int n) {
        print(n, false);
    }

    public void print(int n, boolean p) {
        for (int i = 0; i < n; i++)
            System.out.print(" ");

        if (p) {
            System.out.println(")");
        } else {
            System.out.println("()");
        }
    }
}