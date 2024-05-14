
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<Employee>();
		
		list.add(new SalariedEmployee("Tzortzis","72340002",3000));
		
		list.add(new HourlyEmployee("Zina","8145821",210,20));
		
		for(Employee i : list){
			System.out.println(i);
		}
	}

}
