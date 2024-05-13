public class Overloading {
    public int multiply (int a, int b) {
        return a * b;
    }
    public double multiply (double a, double b, double c) {
        return a * b * c;
    }

public static void main(String[] args) {
    Overloading testObj = new Overloading ();
    System.out.println(testObj.multiply(12.2, 12.3, 12.2));
}
}