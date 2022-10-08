package Tree;

public class PrintMethod {
  private static int TABsize = 2;

  public static void indent(int num) {
    int i = 0;
    while (i < num) {
      System.out.print(" ");
      i++;
    }
  }
  public static void terminate(int num) {
    if (num >= 0);
  }
  public static void printIdent(int num, String s) {
    indent(num);
    System.out.print(s);
    terminate(num);
  }


  // For printing the last line of the parsed tree
  public static void printTail(Node node, int num) {
    Node cdr = node.getCdr();
    if (cdr.isNull() || cdr.isPair()) {
        cdr.print(num, true);
    } else {
        if (num >= 0) {
          indent(num);
        } else {
          System.out.print(' ');
        }

        System.out.print(". ");
        cdr.print(-Math.abs(num), false);

        if (num >= 0) {
            System.out.println();
            indent(num - TABsize);
        }
        System.out.print(')');
        terminate(num);
    }
  }
  public static void printRegular(Node node, int num, boolean bool) {
    if (!bool) {
        indent(num);
        System.out.print('(');
        node.getCar().print(-(Math.abs(num) + TABsize), false);
        printTail(node, -(Math.abs(num) + TABsize));
        terminate(num);
    }
    else {
        if (num < 0) {
            System.out.print(' ');
        }
        node.getCar().print(num, false);
        printTail(node, num);
    }
}

  public static void printBoolLit(int num, boolean b) {
    indent(num);
    if (b) {
        System.out.print("#t");
    }
    else {
        System.out.print("#f");
    }
    terminate(num);
  }
  
}