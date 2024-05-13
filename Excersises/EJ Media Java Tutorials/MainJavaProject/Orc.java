public class Orc {
    private int height;
    public void setHeight (int height) {
      if (height < 10) {
      this.height = height;
      System.out.println("Orc met criteria");
    }
      else {
        System.out.println("Please enter a height under 10 feet");
    }
}
        
    public int getHeight () {
    return height;
    }
} 