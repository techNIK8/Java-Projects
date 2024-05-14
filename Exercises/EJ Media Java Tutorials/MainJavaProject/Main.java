public class Main {
    public static void main (String[] args) {
        //5 days later ....
        Registration newuser1 = new Registration ("Mary");
        System.out.println(newuser1.putUsernameDatabase() + " username created and entered into database");
        //1 hour later ....
        Registration newuser2 = new Registration ("Larry");
        System.out.println(newuser2.putUsernameDatabase() + " username created and entered into database");
        //Next day
        System.out.println(Registration.getUsernameCount());
        //2 years later ....
        Registration newuser3 = new Registration ("Sam");
        System.out.println(newuser3.putUsernameDatabase() + " username created and entered into database");
        //Next day
        System.out.println(Registration.getUsernameCount());
    }
}