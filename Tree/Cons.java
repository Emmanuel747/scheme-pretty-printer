// Cons -- Parse tree node class for representing a Cons node

package Tree;

import Special.*;

public class Cons extends Node {
    private Node car;
    private Node cdr;
    private Special form;

    public Cons(Node a, Node d) {
        car = a;
        cdr = d;
        parseList();
    }

    // parseList() `parses' special forms, constructs an appropriate
    // object of a subclass of Special, and stores a pointer to that
    // object in variable form. It would be possible to fully parse
    // special forms at this point. Since this causes complications
    // when using (incorrect) programs as data, it is easiest to let
    // parseList only look at the car for selecting the appropriate
    // object from the Special hierarchy and to leave the rest of
    // parsing up to the interpreter.

    void parseList() {
        String obj = new String("");
        if(car.isSymbol()){
            obj = car.getName();
            if (obj.equalsIgnoreCase("begin")){
                form = new Begin();
            }
            else if (obj.equalsIgnoreCase("define")){
                form = new Define();
            }
            else if (obj.equalsIgnoreCase("quote")){
                form = new Quote();
            }
            else if (obj.equalsIgnoreCase("cond")){
                form = new Cond();
            }
            else if (obj.equalsIgnoreCase("if")){
                form = new If();
            }
            else if (obj.equalsIgnoreCase("lambda")){
                form = new Lambda();
            }
            else if (obj.equalsIgnoreCase("let")){
                form = new Let();
            }
            else if (obj.equalsIgnoreCase("set!")){
                form = new Set();
            }
            else {
                form = new Regular();
            }
        }
        else {
            form = new Regular();
        }
    }

    // TODO: Add any helper functions for parseList
    // to the class hierarchy as needed.
    public boolean isPair() {
        return true;
    }
    public void setCar(Node car){
        this.car = car;
        parseList();
    }

    public Node getCar(){
        return this.car;
    }

    public Node getCdr(){
        return this.cdr;
    }

    public void print(int n) {
    }

    public void print(int n, boolean p) {
    }

}