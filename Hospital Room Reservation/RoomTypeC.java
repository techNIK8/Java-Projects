
public class RoomTypeC extends Room{
	int leastPeople, leastDays;
	
	//public RoomTypeC(){
		//super();
	//}
	
	public RoomTypeC(int maxCapacity, double pricePerPerson, int leastPeople, int leastDays){
		super(maxCapacity, pricePerPerson);
		this.leastPeople = leastPeople;
		this.leastDays = leastDays;
	}
	
	
	// Kanei tin idia akrivos douleia me tin methodo tis yperklasis, mono pou edo exoume prosthesei 2 parapano synthikes.
	public boolean addReservation (Reservation res){
		boolean state = false;
		int freeDays=0;
		for(int i = 0; i < getAvailabilityArray().length; i++){
			if ((i>=res.getArrival()) && (i<(res.getArrival()+res.getDays())) && (getAvailabilityArray()[i]== null)){                  
				freeDays++;
			}    
			if ((freeDays==res.getDays()) && (res.getPeople() <= getMaxCapacity() && (res.getPeople()>=leastPeople) && (res.getDays()>=leastDays)) ){
				state= true;
				for (int j = res.getArrival(); j < (res.getDays() + res.getArrival() ); j++){
					setAvailabilityArray(j, res);
				}
				res.setRoom(this);
			}
			else{
				state=false;
			}
		}

		return state;
	}
	
}
    
