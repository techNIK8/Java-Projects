public class Person {
    
    public static final int MALE = 0;
    public static final int FEMALE = 1;
    private int sex;
    private String lastname;
    private String firstname;
    private int age;
    private boolean married;
    private float salary;
    
    public Person (String lastname, String firstname, int age, boolean married, float salary, int sex) {
        this.lastname = new String(lastname);
        this.firstname = new String(firstname);
        this.age = age;
        this.married = married;
        this.salary = salary;
        this.sex = sex;
    }
    
    
    public String getLastName() { 
        return lastname;
    }
    
    
    public void setLastName(String lastname) { 
        this.lastname = new String(lastname);
    }
    
    
    public String getFirstName() {
        return firstname; 
    }
    
    
    public void setFirstName(String firstname) { 
        this.firstname = new String(firstname);
    }
    
    
    public int getAge() { 
        return age;
    }
    
    
    public void getAge(int age) { 
        this.age = age;
    }
    
       
    public boolean isMarried() {
       return married; 
    }
    
    
    public void setMarried(boolean married) {
       this.married = married;
    }
    
    
    public float getSalary() { 
        return salary; 
    }
    
    
    public void setSalary(float salary) { 
        this.salary = salary; 
    }
    
    
    public int getSex() {
        return sex;
    }
    
    public void printInfo() {
        
        System.out.print("\n"+firstname+" "+lastname+" is "+age+" years old "+((sex==0)?"male":"female")+", gets a "+salary+" Euros salary and is");
        System.out.print(((!married)?" not ":" ")+"married");
    }
    
    
}