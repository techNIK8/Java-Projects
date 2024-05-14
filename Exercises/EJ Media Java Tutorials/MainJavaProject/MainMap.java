public class MainMap {
    public static void main(String[] args) {
    MainMap World = new MainMap ();
    Orc Orc1 = new Orc ();
    Orc1.setHeight(9);
    System.out.println(Orc1.getHeight());
    Expansion NewMap = new Expansion();
    Orc Orc2 = new Orc ();
    Orc2.setHeight(15);
    System.out.println(Orc2.getHeight());
}
}