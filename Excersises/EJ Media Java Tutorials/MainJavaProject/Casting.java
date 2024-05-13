public class Casting {
    public static void main (String[] args) {
    double source = 150.9999999999; //variable to variable cast
    int destination = (int) source;
    
    int I = 125;        //int range is from -2 billion to 2 billion
    byte B = (byte) I;   //byte range is -127 to 127 == this is an explicit cast
    
    Integer wholeNumber = new Integer (400);   //this is an object
    int dest = wholeNumber.intValue();         //variable
    
    String val = "47";                         //this is variable
    int intObject = Integer.parseInt(val);     //object
    
    int x = 47;
    double y = 3.5;
    double xy = x + y;
    
    
    System.out.print (xy);
}
}
        
        
        
        