import java.io.*;

public class Math
{
    static BufferedReader keyboard = 
    new BufferedReader (new InputStreamReader(System.in));
    
    public static void main (String[] args)
    {
        
        int x,y,z;
        
        x=readInt();
        y=readInt();
        z=readInt();
        
        try{
            System.out.println("To apotelesma einai: " + (3*(x-1)*y)/(x-(2*z)));
            
        }
        catch(ArithmeticException e)
        {
            System.out.println("O paranomasths einai 0");
        }
    }
    
    
    public static int readInt()
    {
        String s="";
		int x=0;
		  
		  try
	      {
	        System.out.print ("Dwse enan akeraio : ") ;
	        s        = keyboard.readLine() ;
	        x = Integer.parseInt (s) ; 
	       }
	       
	        catch (NumberFormatException nfe)
	      {	    	
	        System.out.println ("Sorry, " + s + " is an invalid int.") ;	        
	      }
	      
	      catch (Exception e)
	      {	    	
	        System.out.println ("Some other exception occurred: " + e) ; 
	      }
	      
	      return x;
	      
	   }
	   
	   	   
}