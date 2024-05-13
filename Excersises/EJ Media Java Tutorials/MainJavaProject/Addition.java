public class Addition {
    int firstNumber;
    int secondNumber;
    public int getnumber () {
        return (firstNumber + secondNumber);
    }
    Addition () {
        firstNumber = 10;
        secondNumber = 20;
    }
    Addition (int X, int Y) {
    firstNumber = X;
    secondNumber = Y;
}
}