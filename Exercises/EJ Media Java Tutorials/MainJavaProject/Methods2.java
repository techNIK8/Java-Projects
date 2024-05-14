public class Methods2 {
    void callIt () {
        Methods2 newObj = new Methods2 ();
        newObj.doIt (13,14);
    }
    void doIt (int a, int b) {
        int multiply = a * b;
        System.out.println ("Number we get is " + multiply);
    }
    void callItAgain () {
        Methods2 newObj = new Methods2 ();
        int xx = 13;
        int bb = 14;
        newObj.doItAgain(xx,bb);
    }
    void doItAgain (int a, int b) {
        int multiply = a * b;
    }
}