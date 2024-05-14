import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//h klash App klhronomei to JFrame, gia na mporei na ginei kaluterh xrhsh ths bibliothikhs Swing
public class App extends JFrame{
	
	//parametroi gia thn leitourgia tou programmatos, h prwth einai gia ton upologismo twn atomwn pou tha einai sthn tuxai krathsh kai oi alles 2 gia th dhmiourgia tou onomatos autou pou kanei thn krathsh
	public static final int MAXPEOPLE = 5;
	public static final int RANDOMNAMELENGTH = 7;
	public static final int EXTRANAMELENGTH = 4;
	
	//to hotel einai to ksenodoxeio pou tha xrhsimopoihsoume sto programma
	Hotel hotel = new Hotel("King George Hotel");

	//autos einai enas dhmiourgos ths App, pou kalei me super enan dhmiourgo ths JFrame, pou exei monadiko orisma to onoma pou tou deinoume
	public App(String name){
		super(name);
	}
	
	//prosthetei mia tuxaia krathsh sto ksenodoxeio
	public static void randomReservation(Hotel hotel){
		Random r = new Random();
		int nameLength = r.nextInt(RANDOMNAMELENGTH) + EXTRANAMELENGTH;									//to onoma autou pou kanei thn krathsh einai tuxatio, dhladh exei tuxaio mhkos kai tuxaious xarakthres, to mhkos einai metaksu 5 kai 12 (ena perissotero apo to nameLength logw tou arxikou xarakthra)
		String name = Character.toString((char) (r.nextInt(26) + 'A'));		//to onoma arxizei me enan kefalaio xarakthra, autos dhmiourgeitai ws ekshs: arxika epilegetai tuxaia enas akeraios apo 0 ews 26, epeita se auton prosthuetai o xarakthras 'A', wste epeita na exoume enan akeraio pou otan metatrapei se xarakthra tha einai opoidhpote kefalaio latiniko gramma (A-Z)
		for(int i=0; i<nameLength; i++){									//sto onoma prostithentai xarakthres analoga me to mhkos tou onomatos (nameLength)
			char c = (char) (r.nextInt(26)+'a');							//me ton idio tropo oi xarakthres einai tuxaia latinika peza (a-z)
			name += c;
		}
		
		int arrival = r.nextInt(Room.DAYSOFMONTH)+1;										//upologizetai mia tuxaia mera krathshs apo 1 ews 30
		
		int days = 0;
		try{																//xrhsimopoieitai to try - catch, giati mporei h afiksh na ginetai stis 30 tou mhna kai etsi mesa sto nextInt na uparxei 0, auto omws dhmiourgei IllegalArgumentException, se auth thn periptwsh oi meres diamonhs ginontai 0
			days = r.nextInt(Room.DAYSOFMONTH-arrival)+1;									//upologizetai mia tuxaia diarkeia diamonhs me bash thn hmera krathshs, auth mporei na einai apo 0 meres mexri to telos tou mhna
		}
		catch(IllegalArgumentException e){									
			days = 1;
		}
		
		int people = r.nextInt(MAXPEOPLE)+1;										//upologismos atomwn krathshs, auta mporoun na einai apo 1 - 5
							
		Reservation res = new Reservation(name, arrival, people, days);		//dhmiourgia krathshs me auta ta xarakthristika
		hotel.addReservation(res);											//prosthikh ths krathshs sto ksenodoxeio
		//System.out.println(name + " " + res.getArrival() + " " + res.getDays() + " " + res.getPeople());
		if(hotel.cancelationPropability()){									//an h cancelationPropability() ths klashs Hotel epistrepsei true, akurwnetai tuxaia mia krathsh, h opoia epilegetai mesw ths tuxaias epiloghs kwdikou
			Random generator = new Random();
			int randomReservationCode = generator.nextInt(hotel.getReservationList().size());
			hotel.cancelReservation(hotel.getReservationList().get(randomReservationCode).getCode());
		}
	}
	
	
	public static void main(String[] args){
		final App myApp = new App("King George Hotel");		//dhmiourgia efarmoghs
		
		
		
		//dhmiourgountai 10 dwmatia pou ekproswpoun olous tous tupous dwmatiwn
		Room room = new Room(4, 10);
		Room roomA1 = new RoomTypeA(5, 15, 10);
		Room roomA2 = new RoomTypeA(4, 10, 15);
		Room roomB1 = new RoomTypeB(4, 20, 50, 10);  //capacity, pricePerPerson, pricePerDay, discountPerPerson
		Room roomB2 = new RoomTypeB(2, 25, 40, 15);
		Room roomC1 = new RoomTypeC(3, 10, 2, 3);  //... ... leastPeople, leastDays
		Room roomC2 = new RoomTypeC(5, 12, 3, 4);
		Room roomD1 = new RoomTypeD(4, 7, 10, 5);
		Room roomD2 = new RoomTypeD(3, 6, 8, 6);
		Room roomE1 = new RoomTypeE(4, 10, 50, 10);

		//auta ta dwmatia prostithentai sto ksenodoxeio
		myApp.hotel.addRoom(room);
		myApp.hotel.addRoom(roomA1);
		myApp.hotel.addRoom(roomA2);
		myApp.hotel.addRoom(roomB1);
		myApp.hotel.addRoom(roomB2);
		myApp.hotel.addRoom(roomC1);
		myApp.hotel.addRoom(roomC2);
		myApp.hotel.addRoom(roomD1);
		myApp.hotel.addRoom(roomD2);
		myApp.hotel.addRoom(roomE1);
		
		
		//dhmiourgia ths prwths tuxaias krathshs
		randomReservation(myApp.hotel);

		/* !!! SWING !!! */
		final Container contentPane = myApp.getContentPane();	//dhmiourgia container gia ta antikeimena ths Swing
		
		
		//dhmiourgia JTextField gia to onoma tou ksenodoxeiou
		JTextField title = new JTextField(myApp.hotel.getName() + "s Reservation Program");		//dhmiourgia tou JTextField
		title.setBounds(230, 0, 580, 40);														//orismos megethous kai theshs JTextField
		title.setEditable(false);																//den epitrepoume ston xrhsth na allaksei to periexomeno tou JTextField
		Font titleFont = new Font("Courier New", Font.BOLD, 25);								//dhmiourgia neou Font (grammatoseiras)
		title.setFont(titleFont);																//eisagwgh autou tou font sto JTextField
		title.setAlignmentX(CENTER_ALIGNMENT);													//orismos stoixhshs tou JTextField (epilegetai h stoixhsh sto kentro)
		contentPane.add(title);																	//eisagwgh tou JTextField sto contentPane
		
		//dhmiourgia koumpiwn gia to menou epiloghs kaith leitourgia tou programmatos
		final JButton[] choice = new JButton[8];
		choice[0] = new JButton("Click here for a random reservation");			//prosthikh tuxaias krathshs
		choice[1] = new JButton("Click here to add a reservation");			//prosthikh krathshs, ta stoixeia ths opoias dinei o xrhsths
		choice[2] = new JButton("Click here to cancel a reservation");			//akurwsh krathshs
		choice[3] = new JButton("Click here to view reservations");			//tupwsh olwn twn krathsewn kai merikwn stoixweiwn tous
		choice[4] = new JButton("Click here to print rooms");				//tupwsh olwn twn dwmatiwn kai merikwn stoixeiwn tous
		choice[5] = new JButton("Click here to print reservation plan");		//tupwsh planou krathsewn
		choice[6] = new JButton("Click here to print income");				//tupwsh esodwn ksenodoxeiou
		choice[7] = new JButton("Click here to close");	
		
		//topothethsh koumpiwn sto contentPaine kai dhmiourgia diastasewn gia auta
		for(int i=0; i<8; i++){
			if(i<4)
				choice[i].setBounds(250*i, 90,250, 70);
			else
				choice[i].setBounds(250*(i-3), 200, 250, 70);
			
				contentPane.add(choice[i]);
		}
		
		
		//dhmiourgia parathuroy gia thn efarmogh
		myApp.setSize(1265, 400);
		myApp.setLayout(null);
		myApp.setVisible(true);
		
		
		/**
		!!!!den douleuei!!!!
		//termatizei thn efarmogh otan paththei to X (panw deksia)
		WindowListener L = new WindowAdapter(){
			public void WindowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		myApp.addWindowListener(L);
		*/
		
		//NEXT RESERVATION
		ActionListener next = new ActionListener(){			//dhmiourgia neou ActionListener	
			public void actionPerformed(ActionEvent e){
				randomReservation(myApp.hotel);				//otan paththei to koumpi Next Reservation dhmiourgeitai mia nea tuxaia krathsh mesw ths randomReservaton ths klashs App
			}
		};
		choice[0].addActionListener(next);					//prosthikh autou tou ActionListener sto koumpi choice[0]
		
		
		//PRINT RESERVATIONS
		ActionListener printReservation = new ActionListener(){					//dhmiourgia neou ActionListener
			public void actionPerformed(ActionEvent e){
				String printReservation = new String("");							//dhmiourgeitai ena String sto opoio bazoume kathe fora ths plhroforie ths krathshs kathws sarwnetai h lista krathsewn
				for(int i=0; i<myApp.hotel.getReservationList().size(); i++){
					printReservation += "Reservation code: " + myApp.hotel.getReservationList().get(i).getCode() + ". Name: " + myApp.hotel.getReservationList().get(i).getName() + ". Room code: " + myApp.hotel.getReservationList().get(i).getRoom().getRoomCode() + ".\n";
				}
				Font font = new Font("Courier New", Font.PLAIN, 16);				//dhmiourgeitai mia nea grammatoseira, h font
				JTextArea reservationTextArea= new JTextArea(printReservation);		//to String auto prostithera sth JTextArea
				reservationTextArea.setFont(font);							
				reservationTextArea.setEditable(false);
				reservationTextArea.setLineWrap(true);
				reservationTextArea.setWrapStyleWord(true);
				
				JScrollPane sp = new JScrollPane(reservationTextArea);				//dhmiourgeitai ena JScrollPane sto opoio mpainei h JTextArea
				sp.setPreferredSize(new Dimension(600, 400));						//to JScrollPane auto exei diastaseis 600*400
				JOptionPane.showMessageDialog(null, sp);							//otan patietai to koumpi bgainei ena neo parathuro pou periexei to JScrollPane
			}
		};
		choice[3].addActionListener(printReservation);								//autos o ActionListener prostithetai sto koumpi choice[3]
		

		
		//PRINT ROOMS
		ActionListener printRoom = new ActionListener(){							//dhmiourgia neou ActionListener
			public void actionPerformed(ActionEvent e){
				String printRoom = new String("");									//dhmiourgeitai ena neo String sto opoio postithentai ta stoixeia twn dwmatiwn, kathws sarwnetai h lista dwmatiwn
				for(int i=0; i<myApp.hotel.getRoomList().size(); i++){
					printRoom += "Room code: " + myApp.hotel.getRoomList().get(i).getRoomCode() + ". Room fullness: " +  myApp.hotel.getRoomList().get(i).fullness() + "%. Room profit: " + myApp.hotel.calculateProfit(myApp.hotel.getRoomList().get(i).getRoomCode()) + ".\n";
				}
				Font font = new Font("Courier New", Font.PLAIN, 16);				//dhmiourgeitai mia nea grammatoseira, h font
				JTextArea roomTextArea= new JTextArea(printRoom);					//dhmiourgeitai mia nea JTextArea me to String
				roomTextArea.setFont(font);
				roomTextArea.setEditable(false);
				JOptionPane.showMessageDialog(null, roomTextArea);					//otan patietai to koumpi bgainei ena neo parathuro pou periexei th JTextArea
			}
		};
		choice[4].addActionListener(printRoom);										//autos o AcitonListener prostithetai sto koumpi choice[4]
		
		
		//PRINT INCOME
		ActionListener income = new ActionListener(){								//dhmiourgia neou ActionListener
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "Income: " + myApp.hotel.calculateProfit().toString());		//otan patietai to koumpi bgainei ena neo parathiro pou deixnei ta esoda tou ksenodoxeiou
			}
		};
		choice[6].addActionListener(income);										//autos o ActionListener prostithetai sto koumpi choice[6]
		
		
		//ADD RESERVATION
		ActionListener add = new ActionListener(){									//neos Actionistener
			public void actionPerformed(ActionEvent e){								
				String[] text = new String[5];										//dhmiourgia pinaka Strings gia thn apthhkeush twn dedomenwn pou tha dwsei o xrhsths
				text[0] = JOptionPane.showInputDialog(null, "Name:", "Random Hotel", JOptionPane.PLAIN_MESSAGE);		//eisagwgh onomatos
				try{																//elegxos gia to an dothhkan ola ta stoixeia h an paththhke cancel, to cancel dhmiourgei NullPointerException
					if(!text[0].equals("")){										//ola ta if exoun skopo na elegksoun an to prohgoumeno stoixeio dothhke apo ton xrhsth, an den dothhke tote to programma den proxoraei sta epomena if kathws den exei nohma na zhthsei ta upolipa stoixeia
						text[1] = JOptionPane.showInputDialog(null, "Arrival day:", "Random Hotel", JOptionPane.PLAIN_MESSAGE);
						if(!text[1].equals("")){
							text[2] = JOptionPane.showInputDialog(null, "Number of people:", "Random Hotel", JOptionPane.PLAIN_MESSAGE);
							if(!text[2].equals("")){
								text[3] = JOptionPane.showInputDialog(null, "Number of days:", "Random Hotel", JOptionPane.PLAIN_MESSAGE);
								if(!text[3].equals(""))
									text[4] = JOptionPane.showInputDialog(null, "Room code (optional):", "Random Hotel", JOptionPane.PLAIN_MESSAGE);
								
									try{																									//elegxei an o kwdikos dwmatiou einai akeraios
										try{																								//elegxei an paththhke to cancel	
											if(Integer.parseInt(text[1])>0 && Integer.parseInt(text[1])<Room.DAYSOFMONTH+1 && Integer.parseInt(text[2])>0 && Integer.parseInt(text[3])>0){			//elegxos gia thn orthothta twn timwn pou edwse o xrhsths
												Reservation res = new Reservation(text[0], Integer.parseInt(text[1])-1, Integer.parseInt(text[2]), Integer.parseInt(text[3]));						//bazoume to -1 sthn hmera krathshs epeidh oi meres einai apo 1 ews 30 enw o pinakas exei megethos apo 0 ews 29 kai me to -1 apothhkeuetai swsta h mera pou dinei o xrhsths
												if(text[4].equals("")){
													int checkReservation = myApp.hotel.addReservation(res);										//apothhkeush tou kwdikou dwmatiou, an sto checkReservation dwthei h timh 0 auto shmaine oti h krathsh den mporei na ginei, kathws kanena dwmatio den exei timh 0, se kathe periptwsh emfanizetai se neo parathuro katallhlo mhnuma
													if(checkReservation == 0)
														JOptionPane.showMessageDialog(null, "The reservation is not possible.");
													else
														JOptionPane.showMessageDialog(null, "The reservation was done succesfully in room with code " + res.getRoom().getRoomCode() + ".");
												}
												else{
													boolean checkReservation = myApp.hotel.addReservation(res, Integer.parseInt(text[4]));	//deixnei an mporei na ginei h krathsh se auto to dwmatio, pairnontas timh true an mporei kai false an den mporei, se kathe periptwsh emfanizetai se neo parathuro katallhlo mhnuma
													if(checkReservation)
														JOptionPane.showMessageDialog(null, "The reservation was done succesfully.");
													else
														JOptionPane.showMessageDialog(null, "The reservation is not possible.");
												}
											}
											else
												JOptionPane.showMessageDialog(null, "Error in data input.");
										}
										catch(NullPointerException nullException){

										}
									}
									catch(NumberFormatException numberException){
										JOptionPane.showMessageDialog(null, "Error in data input.");		/**SHOULD BE DESCRIBED BETTER*/
									}
							}
						}
					}
				}
				catch(NullPointerException nullException0){
					
				}
			}
		};
		choice[1].addActionListener(add);											//prosthhkh tou ActionListener sto koumpi choice[1]
		
		
		//CANCEL RESERRVATION
		ActionListener cancel = new ActionListener(){								//neos ActionListener
			public void actionPerformed(ActionEvent e){
				int result;															//tha apothikeusei to an egeine h diagrafh ths krathshs
				String code = JOptionPane.showInputDialog("Reservation code.");		//eisodos kwdikou krathshs apo ton xrhsth
				try{																//to try - catch xrhsimopoieitai gia na bebaiwthoume oti h eisodos einai akeraios arithmos, an den einai uparxei NumberFormatException
					result = myApp.hotel.cancelReservation(Integer.parseInt(code));	//apothikeush sto result thstimhs pou epostrefei h methodods cancelReservation() ths klashs Hotel
					if(result == 0)													//mesa stis sunthikes dhmiourgeitai ena neo parathuro gia thn enhmerwsh tou xrhsth sxetika me thn epituxia h thn apotuxia ths akurwshs ths krathshs
						JOptionPane.showMessageDialog(null, "The reservation was cancelled.");
					else if(result == 1)
						JOptionPane.showMessageDialog(null, "The reservation cannot be cancelled.");
					else if(result == 2)
						JOptionPane.showMessageDialog(null, "There is no reservation with this code.");
					else
						JOptionPane.showMessageDialog(null, "please try again, something unexpected happened.");
				}
				catch(NumberFormatException numberException){
					try{																	//elegxei an paththke to cancel, to opoio dhmiourgei NullPointerException
						if(!code.equals(""))												//elegxei an h mh akeraia timh pou dwthhke einai kapoio sumbolo ektos tou kenou
							JOptionPane.showMessageDialog(null, "An error occured due to invalid input");	//an einai kapoio sumbolo ektos tou kenou bgainei ne parathuro pou plhroforei gia thn lathos eisodo
					}
					catch(NullPointerException nullException){
						JOptionPane.showMessageDialog(null, "The cancelation stopped");																	//se periptwsh pou o xrhsths pathsei cancel den theloume na geinetai tipota
					}	
				}
			}
		};
		choice[2].addActionListener(cancel);											//o ActionListener prostithetai sto koumpi choice[2]
		
		
		//PRINT RESERVATION PLAN
		ActionListener plan = new ActionListener(){										//dhmiourgia neou ActionListener
			public void actionPerformed(ActionEvent e){
				
				String plan = "Room\t";													//dhmiourgeitai ena String sto opoio tha apothikeutei to plano krathsewn me tropo paromoio me auton pou tupwthike to plano krathsewn sth methodo ths Hotel
				
				for(int i=0; i<Room.DAYSOFMONTH; i++){												//arxika sto String apothikeuontai oles oi meres tou mhna
					if(i<9)
						plan += ("0" +(i+1) + " ");
					else
						plan += ((i+1) + " ");
				}
				plan += "\n";															//allagh grammhs sto String
				for(int j=0; j<myApp.hotel.getRoomList().size(); j++){						//gia kathe dwmatio apothikeuetai sto String * otan uparxei krathsh (AvailabilityArray[i] != null) sto dwmatio kai - otan sto dwmatio den uparxei krathsh (AvailabilityArray[i] == null)
					plan += (myApp.hotel.getRoomList().get(j).getRoomCode() + "\t");
					for(int k=0; k<Room.DAYSOFMONTH; k++){
						if(myApp.hotel.getRoomList().get(j).getAvailabilityArray()[k] == null)
							plan += " - ";
						else
							plan += " * ";
					}
					plan += "\n";														//allagh grammhs sto String
				}
				
				Font font = new Font("Courier New", Font.PLAIN, 16);
				
				JTextArea ta = new JTextArea(plan);										//to String apothileuetai se miakainouria JTextArea
				ta.setEditable(false);
				ta.setFont(font);				
				JOptionPane.showMessageDialog(null, ta);								//otan patietai to koumpi bgainei ena kainourio parathuro me thn JTextArea
			}
		};
		choice[5].addActionListener(plan);												//o ActionListener prostithetai sto koumpi choic[5]
		

		
		//CLOSE
		ActionListener close = new ActionListener(){									//dhmiourgia neos ActionListener
			public void actionPerformed(ActionEvent e){
				System.exit(0);															//kleinei thn efarmogh
			}
		};
		choice[7].addActionListener(close);												//o ActionListener prostithetai sto koumpi choice[7]
		/* !!! SWING !!! */

	} 
}


