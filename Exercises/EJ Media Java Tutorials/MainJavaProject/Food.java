public class Food {
    private String foodA;
    public Food (String A) {
        foodA = A;
    }
    public String getFood () {
        return foodA; //use return when a value is returned
    }
    void systemPrint () {
        System.out.println(foodA);
    }
}