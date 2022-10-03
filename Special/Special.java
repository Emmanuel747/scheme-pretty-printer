// Special -- Parse tree node strategy for printing special forms

package Special;

import Tree.Node;

// There are several different approaches for how to implement the Special
// hierarchy.  We'll discuss some of them in class.  The easiest solution
// is to not add any fields and to use empty constructors.

abstract public class Special {
    abstract public void print(Node t, int n, boolean p);
}