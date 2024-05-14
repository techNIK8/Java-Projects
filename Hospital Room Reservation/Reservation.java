public class Reservation {
	private String name;					//onoma atomou pou knaei krathsh
	private int reservationCode;			//kwdikos krathshs
	private int arrival;					//mera afi3hs
	private int days;						//meres diamonhs
	private int people;						//arithmos atomwn
	private static int codeCounter = 1;		//gia thn automath dhmiourgia kwdikwn krathshs
	private Room room;						//dwmatio krathshs
	

	
	//dhmiourgos
	public Reservation(String name, int arrival, int people, int days){
		this.name = name;
		this.arrival = arrival;
		this.people = people;
		this.days = days;
		reservationCode = codeCounter++;
		room = null;
	}
	
	
	//getters, setters
	public Room getRoom(){
		return room;
	}
	
	public void setRoom (Room room){
		this.room = room;
	}
	
	public String getName(){
		return name;
	}
	
	public int getCode(){
		return reservationCode;
	}
	
	public int getArrival(){
		return arrival;
	}
	
	public int getDays(){
		return days;
	}
	
	public int getPeople(){
		return people;
	}
}
