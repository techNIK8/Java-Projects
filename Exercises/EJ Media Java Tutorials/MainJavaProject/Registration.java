public class Registration {
    private String usernameA; // Object or Instance variable
    private static int usernameCount = 0; // Static variable
    public Registration (String A) {
        usernameA = A;
        usernameCount++;
    }
    public String putUsernameDatabase () { //Return Method
        return usernameA;         
        //code that puts that username into our db
    }
    public static int getUsernameCount () { //Static Method
        return usernameCount;
    }
}