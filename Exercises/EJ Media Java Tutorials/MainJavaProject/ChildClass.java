public class ChildClass extends BaseClass {  //also called subclass
    //super keyword METHOD EXAMPLE
    public void printSomething () {
        super.printSomething();
        //System.out.println("This was printed from Childclass");
    }
    public static void main (String[] args) {
        ChildClass testSuper = new ChildClass ();
        testSuper.printSomething();
    }
}