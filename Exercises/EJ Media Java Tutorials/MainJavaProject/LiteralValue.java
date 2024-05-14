public class LiteralValue {
    private int x;
    public LiteralValue () {
        x=50;
    }
        public int methodChildClass () {
            x = 15;
            return x;
        }
        public int methodChildClass1 (int placeholder) {
            this.x = this.x + placeholder;
            return x;
        }
        public static void main(String[] args) {
            LiteralValue testObj = new LiteralValue();
            System.out.println(testObj.methodChildClass());
            System.out.println(testObj.methodChildClass1(45));
            
        }
    }
       