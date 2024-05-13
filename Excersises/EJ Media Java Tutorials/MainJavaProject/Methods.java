public class Methods {
    void numberTrees (int trees) {   //Fancy Term: Parameter 2. Local Variable
                                     //Also think of it as s placeholder for
                                     //value to passed in
    trees = trees + 1;
    int trees2 = 4;
    System.out.println(trees + trees2);
}
int returnNumber (int x) {
    x = x+1;
    return x;
}
public static void main(String[] args) {
    Methods testTree = new Methods ();
    testTree.numberTrees(7);       // Fancy term: Argument 2. Passing a value
    System.out.println(testTree.returnNumber(55));
}
}
  