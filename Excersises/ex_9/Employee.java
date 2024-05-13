public abstract class Employee
{
    private String name,afm;
    private long EmpID;
    private static long totalEmployees=0;
    
    public Employee (String name,String afm)
    {
        this.name=name;
        this.afm=afm;
        EmpID=++totalEmployees;
    }
    public void setName(String name)
    { 
        this.name=name;
    }
        
    public String getName()
    {
        return(name);
    }
    
    public void setAfm(String afm)
    {
        this.afm=afm;
    }
    
    public String getAfm()
    {
        return(afm);
    }
    
    public long getEmpID()
    {
        return(EmpID);
    }
    
    public abstract int payment();
    
    public String toString()
    {
		return "Employee ID: "+EmpID+ "\nEmployee Name: "+name+"\nEmployee AFM: "+afm+"\nEmployee Payment: "+payment()+"\n";
	}
}
        