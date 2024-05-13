public class AdditionProgram {
    public static void main (String[] args) {
        Addition addobj = new Addition (79,21);
        Addition addobj1 = new Addition (100,21);
        System.out.print ("The addition equals" + addobj.getnumber());
        System.out.print ("The addition equals" + addobj1.getnumber());
    }
}