public class RunME{
    public static void main(String[] args){
		Box box1 = new Box(2.5, 3.0, 4.0);
		MyBox myBox1 = new MyBox(3.0);
		Spirtokouto Spirtokouto = new Spirtokouto(2.0, 4.0, 3.0, 10.0, "Blue");
		String boxInfo = box1.toString();
		String myBoxInfo = myBox1.toString();
		String spirtokoutoInfo = Spirtokouto.toString();
		System.out.println(boxInfo);
		System.out.println(myBoxInfo);
		System.out.println(spirtokoutoInfo);
    }  
}