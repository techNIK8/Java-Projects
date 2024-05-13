public class MyBox extends Box{

    MyBox(double side){
        super(side, side, side);
        if(side<=0)
            System.out.println("Error, invalid input.");
    }
    
    public double calculate(){
        return 6*Math.pow(length,2);
    }
    
    public double newMethod(){
        return Math.pow(length,3);
    }
    
    public String toString(){
        return "Cube, Calculation: " + this.calculate() + ", Volume: " + this.newMethod() + ".";
    }
}