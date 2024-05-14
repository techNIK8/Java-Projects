public class SalariedEmployee extends Employee
{
    private int salary=0;
    
    public SalariedEmployee(String name,String afm,int salary)
    {
        super(name,afm);
        this.salary=salary;
    }
    
    public void setsalary(int salary)
        {
            this.salary=salary;
        }
        
        @Override 
        public int payment()
        {
            return salary;
        }
    }
            
