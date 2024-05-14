import java.util.ArrayList;
import java.util.Random;

public class Hotel {
	private String name = new String();			//onoma ksenodoxeiou

	private ArrayList<Room> roomList = new ArrayList<Room>();	//lista me dwmatia, xrhsimopoihthhke ArrayList giati theloume na einai metablhtou megethous, omoiws gia tis krathseis
	private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();	//lista me krathseis
	
	public static final float CANCELATIONPROPABILITY = 0.25f;		//pi8anothta akurwshs mesa sthn epanalhpsh ths main
	
	//dhmiourgos
	public Hotel(String name){
		this.name = name;
	}
	
	//prosthiki dwmatiou sth lista dwmatiwn
	public void addRoom(Room room){
		roomList.add(room);
	}
	
	//anakthsh dwmatiou apw kvdiko dwmatiou
	public Room getRoomFromCode(int roomCode){
		for(int i=0; i<roomList.size(); i++)		//elegxei kathe stoixeio ths listas kai blepei an o kwdikos dwmatiou tou einai idios me ton kwdiko pou dwthike, an einai idios epistrefei to dwmatio
			if(roomList.get(i).getRoomCode() == roomCode)
				return roomList.get(i);
		return null;
	}
	
	//anakthsh krathshs po kwdiko krathshs
	public Reservation getReservationFromCode(int reservationCode){
		for(int i=0; i<reservationList.size(); i++)		//elegxei kathe stoixeio ths listas krathsewn kai blepei an o kwdikos krathshs tou einai idios me ton kwdiko pou dwthike, an einai epistrefei thn krathsh
			if(reservationList.get(i).getCode() == reservationCode)
				return reservationList.get(i);
		return null;
	}
	
	//prosthikh krathshs se dwmatio
	public boolean addReservation(Reservation reservation, int roomCode){
		Room room = getRoomFromCode(roomCode);
		boolean checkReservation = room.addReservation(reservation);		//elegxei an ginetai h krathsh mesw ths me8odou addReservation ths Room
		if(checkReservation){												//an h krathsh ginetai thn pros8etei sthn listta krathsewn
			System.out.println("The reservation is possible.");
			reservationList.add(reservation);
		}
		else
			System.out.println("The reservation is not possible.");
		return checkReservation;											//epistrefei an ginetai h krathsh
	}
	
	
	//prosthiki krathshs se opoidhpote dwmatio
	public int addReservation(Reservation reservation){
		for(int i=0; i<roomList.size(); i++){
			if(roomList.get(i).addReservation(reservation)){			//elegxei an ginetai h krathsh sto dwmatio pou einai sthn thesh i ths listas dwmatiwn
				reservationList.add(reservation);
				System.out.println("The reservation was done succesfully in the room with code " + roomList.get(i).getRoomCode());
				return roomList.get(i).getRoomCode();					//an ginetai epistrefei ton kwdiko tou dwmatiou, etsi h methodos (ara kai h epanalhpsh) termatizetai
			}
		}
		System.out.println("The reservation was insuccesfull.");
		return 0;														//an h krathsh den mporei na ginei epistreffetai 0, autos o kwdikos den antistoixei se kanena dwmatio, afou oi kwdikoi dwmatiwn arxizoun apo to 1
	}
	
	
	//akurwsh krathshs
	//getReservationFromCode looks useless, check if .equals() is needed, check the reservation.getCode() == reervationList.get(i).getCode()
	public int cancelReservation(int reservationCode){							//epistrefei int, 0 = h krathsh akurwthike, 1 = h krathsh den mporei na akurwthei, 2 = h krathsh den brethike (den uparxei)
		Reservation reservation = getReservationFromCode(reservationCode);
		boolean checkIf = false;												//deixnei an brethike h krathsh sth lista krathsewn, dhladh an uparxei krathsh me auton ton kwdiko
		int k = -1;																//deixnei thn thesh tou dwmatiou (sthn lista dwmatiown) sto opoio exei ginei h krathsh pou prepei na akurwthei
		int result = 0;
		for(int i=0; i< roomList.size();i++){									//gia kathe dwmatio ths listas dwmatiwn, elegxei an se kapoia thesh tou pinaka krathsewn ths klashs dwmatio uparxei h krathsh pou theloume na akurwsoume 
			if(k == -1){
				for(int j=0; j<roomList.get(i).getAvailabilityArray().length;j++){
					if(roomList.get(i).getAvailabilityArray()[j] != null){			//gia na kalesoume thn methodo getCode() ths klashs reservation prepei h thesh tou pinaka krathsewn na mhn einai kenh
						if(roomList.get(i).getAvailabilityArray()[j].getCode() == reservationCode)
							k = i;
					}
				}
			}
		}
		if(k != -1){															//elegxei an brethike h krathsh
			if(roomList.get(k).cancel(reservationCode)){						//elegxei an mporei na akuwthei h krathsh
				for(int i=0; i<reservationList.size(); i++){					//psaxnei na brei thn krathsh sthn lista krathsewn
					if(reservation.getCode() == reservationList.get(i).getCode()){
						reservationList.remove(i);								//afairei thn krathsh apo thn lista kratsewn
						checkIf = true;											//deixnei an h krathsh akurwthike					
						}
				}
			}
			if(checkIf){														//elegxei an h krathsh akurwthike
				result = 0;														//to 0 shmainei oti h krathsh akurwthike
				System.out.println("The reservation was cancelled.");
			}
			else{																//h krathsh den mporese na akurwthei
				result = 1;														//to 1 shmainei oti h krathsh den mporei na akurwthei
				System.out.println("The reservation cannot be cancelled.");
			}
		}
		else{																	//h krathsh den brethike
			result = 2;															//to 2 shmainei oti h krathsh den brethike
			System.out.println("There is no reservation with this code.");
		}
		
		return result;															//epistrefei an h krathsh brethike kai akurwthike, brethike kai den mporei na akurwthei h den brethike
	}
	
	
	//upologismos esodwn, gia ena dwmatio
	public Double calculateProfit(int roomCode){
		Room room = getRoomFromCode(roomCode);
		return room.setPrice();						//epistrefei ta esoda tou dwmatiou xrhsimopoiontas thn setPrice() ths klashs Room
	}
	
	
	//upologismos esodwn, gia olo to ksenodoxeio
	public Double calculateProfit(){
		Double totalProfit = 0.0;
		for(int i=0; i<roomList.size(); i++){				//gia kathe dwmatio ths listas dwmatiwn, prosthetei sta olika esoda ta esoda tou dwmatiou, mesw ths methodou setPrice ths Room
			totalProfit += roomList.get(i).setPrice();
		}
		return totalProfit;									//epistrefei ta sunolika esoda
	}
	
	
	//tupwnei to plano krathsewn
	public void reservationPlan(){
		System.out.print("Room\t");
		for(int k=0; k<Room.DAYSOFMONTH; k++){										//tupwnei oles tis meres tou mhna
			if(k<9)
				System.out.print("0" + (k+1) + " ");
			else
				System.out.print((k+1) + " ");
		}
		System.out.println();											//allagh grammhs
		for(int i=0; i<roomList.size(); i++){							//gia kathe dwmatio ths listas dwmatiwn tupwnetai o kwdikos tou dwmatiou
			System.out.print(roomList.get(i).getRoomCode() + "\t");	
			for(int j=0; j<Room.DAYSOFMONTH; j++){									//gia kathe mera tou mhna tupwntai *, an sto dwmatio uparxei krathsh (dhladh an availabilityArray[i] != null) kai -, an sto dwmatio den uparxei krathsh (dhladh an availabilityArray[i] == null)
				if(roomList.get(i).getAvailabilityArray()[j] == null)
					System.out.print(" - ");
				else
					System.out.print(" * ");
			}
			System.out.println();										//allagh grammhs
		}
	}
	
	
	//deixnei an tha akurwthei mia krathsh, to an tha akurwthei mia krathsh h oxi upologizetai tuxaia, alla uparxei pithanothta ish me CANCELATIONPROPABILITY na akurwthei h krathsh
	public boolean cancelationPropability(){
		Random r = new Random();
		boolean state;							//deixnei an tha ginei akurwsh h oxi
		float chance = r.nextFloat();			/*to chance einai enas float metaksu 0 kai 1*/ /**h 0 kai 0.99???*/
		if(chance<=CANCELATIONPROPABILITY)		//an to chance einai mikrotero tou CANCELATIONPROPABILITY epistrefetai true, alliws false
			state = true;
		else
			state = false;
		return state;
	}
	
	
	//getter gia to onoma tou ksenodoxeiou
	public String getName(){
		return name;
	}
	
	//getters gia ta ArrayList
	public ArrayList<Room> getRoomList(){
		return roomList;
	}
	
	public ArrayList<Reservation> getReservationList(){
		return reservationList;
	}
}
