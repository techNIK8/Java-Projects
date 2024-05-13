
public class HourlyEmployee extends Employee 
{

	private int hoursWorked=0;
	private int hourlyPayment=0;
 
 public HourlyEmployee(String name , String afm , int hoursWorked , int hourlyPayment)
 {
		super(name,afm);
		this.hoursWorked=hoursWorked;
		this.hourlyPayment=hourlyPayment;
		
	}
 
 public void setHoursWorked(int hoursWorked)
 {
     this.hoursWorked=hoursWorked;
 }
 

  public int getHoursWorked()
  {
      return(hoursWorked);
    }
    
    public void setHourlyPayment(int hourlyPayment)
    {
        this.hourlyPayment=hourlyPayment;
    }
    
    public int getHourlyPayment()
    {
        return(hourlyPayment);
    }
    
    @Override
    public int payment()
    {
        return hoursWorked*hourlyPayment;
    }
}
    
     
 
    