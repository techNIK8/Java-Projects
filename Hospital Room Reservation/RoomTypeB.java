public class RoomTypeB extends RoomTypeA {
	private double discountPerDay;

	
	public RoomTypeB(int maxCapacity, double pricePerPerson, double pricePerDay, double discountPerDay){
		super(maxCapacity, pricePerPerson, pricePerDay);
		this.discountPerDay = discountPerDay;
	}
	
	public double getDiscountPerDay(){
		return this.discountPerDay;
	}

	
	public double setPrice() throws ArrayIndexOutOfBoundsException{
		double totalPrice = 0, pricePerDay = this.getPricePerDay();
		Reservation k = null;

		//prospelaunoume ton pinaka diathesimothtas kai gia to prwto stoixeio pou den einai null
		for(int i=0; i<getAvailabilityArray().length; i++){				
			if(getAvailabilityArray()[i] != null){
				k = getAvailabilityArray()[i];						//bazoume sto k thn timh mias krathshs
				try{												//se periptwsh pou to i ginei megalutero apo to 29 uparxei ArrayIndexOutOfBoundsException
					while(k.equals(getAvailabilityArray()[i])){		//oso uparxei h idia krathsh ston pinaka ekteleitai to while loop
						totalPrice += pricePerDay;					//h timh upologizetai me thn ekptwsh
						//System.out.println(totalPrice);
						pricePerDay -= discountPerDay;
						if(pricePerDay<this.getPricePerDay()/2)		//an h timh ths meras einai katw apo to orio, tote anathetoume thn oriakh timh
							pricePerDay = this.getPricePerDay()/2;
						i++;										//to i allazei mesa sto while gia na prospelasoume ta epomena stoixeia tou pinaka me thn idia krathsh, xwris na allazei to k
					}
				}
				catch(ArrayIndexOutOfBoundsException e){

				}
				pricePerDay = this.getPricePerDay();
			}
		}
		return totalPrice;			
	}
	
	
	public boolean cancel(int input){
		return false;
	}
	
}