public class Room {
	
	public static final int DAYSOFMONTH = 30;		//o arithmos twn hmerwn tou mhna
	
	private int roomCode;
	private int maxCapacity;
	protected double pricePerPerson;
	private static int codeCounter = 1;

	//Pinakas me anafores se objects typou Reservation 
	protected Reservation[] availabilityArray = new Reservation[DAYSOFMONTH];


	// protimoume oi methodoi na exoun prosdioristei public, giati an bazame
	// protected pali tha htan wrates se olo to paketo
	public Room(int maxCapacity, double pricePerPerson) {
		roomCode = codeCounter++;
		this.maxCapacity = maxCapacity;
		this.pricePerPerson = pricePerPerson;
		for (int i = 0; i < availabilityArray.length; i++)
			availabilityArray[i] = null;
	}

	/* Prospelaunei to pinaka diathesimotitas elegxontas an oi meres, pou apaitountai gia ti kratisi (apo ti mera afiksis eos ti mera eksodou, diladi mera afiksis + meres diamonis), exoun timi null. An auti i synthiki einai alithis, diladi en telei
	 freeDays = res.getDays (se syndyasmo me ti proigoumeni synthki elegxei an oi eleutheres meres antistoixoun stis imeres kratisis) tote elegxei KAI an ta atoma tis kratisis einai ligotera apo ti metabliti maxCapacity. Ean epalitheutoun oi synthikes,
	 tote h boolean metabliti ginetai true kai anathetei gia tis katalliles meres sth metabliti domatio tis klasis Reservation to stigmiotypo tou sygkekrimenou domatiou.*/
	public boolean addReservation(Reservation res) {
		boolean state = false;
		int freeDays = 0;
		for (int i = 0; i < availabilityArray.length; i++) {
			if ((i >= res.getArrival()) && (i < (res.getArrival() + res.getDays())) && (availabilityArray[i] == null)) {
				freeDays++;
			}
			if ((freeDays == res.getDays()) && (res.getPeople() <= this.maxCapacity)) {
				state = true;
				for (int j = res.getArrival(); j < (res.getDays() + res.getArrival()); j++) {
					availabilityArray[j] = res;
				}
				res.setRoom(this);
			} else {
				state = false;
			}
		}
		return state;
	}

	//Prospelaunei to pinaka diathesimotitas tou domatiou kai analogow th katastasi ths imeras (kateilimmeno i oxi) prosthetei kai to katallilo kostos, to opoio exei arxikopoihthei me th timh 0.
	public double setPrice() {
		double cost = 0;
		for (int i = 0; i < availabilityArray.length; i++) {
			if (availabilityArray[i] != null) {
				cost += availabilityArray[i].getPeople() * pricePerPerson;
			}
		}
		return cost;
	}

	//eksasfalizetai sthn klash App oti to input einai integer
	/*Gia na akyrosoume mia kratisi prospelaunoume to pinaka diathesimotitas, o opoios apoteleitai 
apo anafores se objects tis klasis Kratisi. An h metabliti "kodikos kratisis" ( meso tis getCode ) tou 
sygkekrimenou stoixeiou tou pinaka ( array ) tautizetai
	me ti metabliti input, pou mas dinei o xristis, tote anathetoume sto stoixeio ayto timi null.*/
	public boolean cancel(int input) {
		for (int i = 0; i < availabilityArray.length; i++) {
			if (availabilityArray[i] != null) {
				if (availabilityArray[i].getCode() == input) {
					availabilityArray[i] = null;
				}
			}
		}
		return true;
	}

	//Gia na doume poses hmeres to domatio einai kateilimmeno prospelaunoume to pinaka diathesimotitas kai auksanoume kata 1 mia metabliti, otan o pinakas deixnei se ena object typou Reservation. Epeita kanoume tis aparaitites prakseis.
	public double fullness() {
		float j = 0;
		for (int i = 0; i < availabilityArray.length; i++) {
			if (availabilityArray[i] != null){
				j++;
			}
		}
		return (j / 30) * 100;
	}

	//setters, getters gia tis metablhtes ths klashs Room
	public int getMaxCapacity() {
		return this.maxCapacity;
	}

	public void setMaxCapacity(int i) {
		this.maxCapacity = i;
	}

	public int getRoomCode() {
		return this.roomCode;
	}

	public double getPricePerPerson() {
		return this.pricePerPerson;
	}

	public void setPricePerPerson(double i) {
		this.pricePerPerson = i;
	}

	// getter gia ton pinaka diathesimothtas, epistrefei olo ton pinaka availabilityArray kai grafoume "getAvailabilityArray()[i]" gia na prospelasoume to stoixeio i
	public Reservation[] getAvailabilityArray() {
		return availabilityArray;
	}


	// setter gia ton pinaka diathesimothtas, pairnei ws orisma th thesh tou pinaka sthn opoia tha ginei h krathsh kai to antikeimeno krathsh pou tha prostethei
	public void setAvailabilityArray(int i, Reservation res) {
		availabilityArray[i] = res;
	}
}


