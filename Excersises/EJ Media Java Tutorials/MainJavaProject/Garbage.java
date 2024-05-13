public class Garbage {
    private int x = 1;
    public void setNumber () {
        this.x = this.x + 2;
    }
    public int getNumber () {
        return x;
    }
    public static void main (String[] args) {
    Garbage obj1 = new Garbage();
    Garbage obj2 = new Garbage();
    obj1 = obj2;
    Garbage obj3 = new Garbage();
}
}