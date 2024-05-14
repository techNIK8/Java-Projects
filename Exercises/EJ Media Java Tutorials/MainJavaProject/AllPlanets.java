public class AllPlanets {
    public static void main (String[] args) {
        Planet Earth = new Planet ();
        Earth.size = 25000;
        Earth.displaySize();
        
        Planet Jupiter = new Planet ();
        Jupiter.size = 40000;
        Jupiter.displaySize();
    }
}