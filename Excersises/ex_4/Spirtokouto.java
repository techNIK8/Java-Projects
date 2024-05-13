public class Spirtokouto extends Box{
    private double weight;
    private String color = new String();
    
    public Spirtokouto(double length, double width, double height, double weight){
        super(length, width, height);
        this.weight = weight;
        this.color = "No color";
    }
    
    public Spirtokouto(double length, double width, double height, double weight, String color){
        super(length, width, height);
        this.weight = weight;
        this.color = color;
    }
    
    public String toString(){
        return "Spirtokouto calculation: " + this.calculate() + ", Volume: " + this.newMethod() + ", Weight: " + this.weight + ", Color: " + this.color + ".";
    }
}