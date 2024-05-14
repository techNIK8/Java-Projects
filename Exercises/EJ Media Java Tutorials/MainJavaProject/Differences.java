public class Differences {
    String b = "Object/Instance Variable B";
    String c = "Object/Instance Variable C";
    public Differences () {        // DEFAULT CONSTRUCTOR - NO VOID/RETURN
                                   // PUBLIC AND ACCESS MODIFIERS OK TO ALL
        String a = "Local Variable A";
        System.out.println(a + " Printed from Constructor Method");
    }
    public void printString () {   // NO RETURN METHOD
        System.out.println(b + " Printed from printString Method");
    }
    public String returnValue () { // RETURN VALUE METHOD
        return c;
    }
    public static void main(String[] args) {
        Differences testObj = new Differences ();
        testObj.printString();
        System.out.println(testObj.returnValue() + " Printed From returnValue Method");
    }
}