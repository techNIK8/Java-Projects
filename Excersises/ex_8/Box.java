public class Box{
    protected double length;
    protected double width;
    protected double  height;
    
    Box(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    Box(double side){
        this.width = side;
        this.height = side;
        this.length = side;
    }
    
    public double calculate(){
        return 2*(width*height + width*length + height*length);
    }
    
    public double newMethod(){
        return (width*height*length);
    }
    
    public String toString(){
        return "Calculation: " + this.calculate() + ", Volume: " + this.newMethod();
    }
}