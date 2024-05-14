
public class RoomTypeA extends Room{
	private double pricePerDay;


	public RoomTypeA(int maxCapacity, double pricePerPerson, double pricePerDay){
		super(maxCapacity, pricePerPerson);
		this.pricePerDay = pricePerDay;
	}
	
	
	public double getPricePerDay(){
		return this.pricePerDay;
	}
	
    //Yperkalyptei ti methodo timologisis tis yperklasis kai prosthetei mia prokathorismeni kai aneksartiti, apo alles metablites, timi.
	public double setPrice(){
	    double cost=0;
	    for (int i=0; i< getAvailabilityArray().length; i++){
	        if (getAvailabilityArray()[i] != null)
	        	cost+=this.pricePerDay;
	    }
	    return cost;
	}
}
