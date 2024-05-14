public class RoomTypeD  extends RoomTypeB{
public RoomTypeD(int maxCapacity, double pricePerPerson, double pricePerDay, double discountPerDay){
		super(maxCapacity, pricePerPerson, pricePerDay, discountPerDay);
	}
	

	//Ta domatatia typoy D ,exoyn megales thleoraseis.Ta domatia e3oplizontai me oses thleoraseis einai kai ta atoma pou 8a meinoyn sto ka8e domatio 
	//antistoixa,gia auto gia ka8e atomo yparxei mia epipleon xreosh 10 euro
	public double setPrice() {
		double cost = 0;
		for (int i = 0; i < availabilityArray.length; i++) {
			if (availabilityArray[i] != null) {
				cost += availabilityArray[i].getPeople() * (pricePerPerson+10);
			}
		}
		return cost;
	}
	
}