public class SubClass extends SuperClass {
    private int a;
    private int b;
    public SubClass (int x, int y) {
        super (3,4);
        a = x;
        b = y;
    }
    public static void main(String[] args) {
        SubClass testSuper = new SubClass (1,2);
        
        System.out.println (testSuper.a);
        System.out.println (testSuper.b);
        System.out.println (testSuper.c);
        System.out.println (testSuper.d);
    }
}