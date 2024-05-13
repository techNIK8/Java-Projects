public class MarriedPerson extends Person {
    
    private int children;
    
    public MarriedPerson(String lastname, String firstname, int age, float salary, int sex, int children) {
        super(lastname, firstname, age, true, salary, sex);
        this.children = children;
    }
    
    public int getNoOfChildren() { 
        return children; 
    }
    
    public void setNoOfChildren(int children) { 
        this.children = children ; 
    }
    
    public void setMarried(boolean married) {
    }
    
    public void printInfo() {
        super.printInfo();
        System.out.print(" with "+((children>0)?children:"no")+" children");
    }
     
    public void setSalary(MarriedPerson spouse) {
        
        if(spouse.getSex() != this.getSex())
        {
            this.setSalary(this.getSalary()+spouse.getSalary());
        }
    }
}
