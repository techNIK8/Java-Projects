 

public class Age
{
 public static void main(String args[])
{
 if (args.length == 0)
{
 System.out.print("You are " + args[0] + " years old.");
 }
else if (args.length == 1)
{
 System.out.println("You forgot to give your age.");
}
else
{
 System.out.print(args[1] + " is " + args[0] + " years old."); 
}  
}
}
