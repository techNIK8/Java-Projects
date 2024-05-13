public class Scope {
   static int number = 7;
    public static void main (String[] args) {
         // int number = 7; // local variable - declaring it and initializing it
         System.out.println (number);
        }
        static void getNumber () {
            System.out.println (number);
        }
    }