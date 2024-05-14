public class InheritanceProgram {
    //THIS IS THE ACTUAL PROGRAM
    public static void main (String[] args) {
        Gumdrops Red = new Gumdrops();
        Gumdrops Green = new Gumdrops();
        
        Red.givemeCinnamon();
        Red.SugarAmount = 10;
        Red.displaySugarAmount();
        
        Green.givemeSpearmint();
        Green.SugarAmount = 9;
        Green.displaySugarAmount(); 
    }
}