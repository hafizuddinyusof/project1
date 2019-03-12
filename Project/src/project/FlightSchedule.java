/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author hafizuddinyusof
 */
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Scanner;
/**
 *
 * @author Dell
 */
public class FlightSchedule {
   
   static ArrayList <Arrival> arrivalObject = new ArrayList<Arrival>(); // ArrayList for arrivalObject are created for storing each arrival object in this array
   static ArrayList <Departure> departureObject = new ArrayList<Departure>(); //ArrayList for departureObject are created for storing each departure object into this array
    
   static class tableArrival extends JFrame{
    JTable flightArrive ; //JTable flight are created
    
    public tableArrival(){
        setLayout(new FlowLayout());
        
         
    String [] columnName = {"FROM","HOME STATION","AIRLINE","FLIGHT ID","STA","TIME","GATE"}; //header for JTable
    String[][] data = new String[arrivalObject.size()][7]; //Data for JTable
    int i=0;
    //each data in arrival object will be store in Data String 
    for(Arrival current:arrivalObject){
        data[i][0]=current.getPlace().toString();
        data[i][1]=current.getAirline().getHomestation();
        data[i][2]=current.getAirline().getAirlineName();
        data[i][3]=current.getAirline().getAirlineId();
        data[i][4]=current.getDate().toString();
        data[i][5]=current.getTime().toString();
        data[i][6]=current.getLaneName().toString();
        i++;
    }
   /* for(i=0;i<data.length;i++){
        for(int j=0;j<data[i].length;j++){
            System.out.println(data[i][j]);
        }
    }*/
    flightArrive = new JTable(data, columnName);
    JScrollPane scrollPane = new JScrollPane(flightArrive);
    scrollPane.setPreferredSize(new Dimension(500, 500));
    add(scrollPane);
    
    }
   }
    static class tableDeparture extends JFrame{
    JTable flightDepart;    //JTable for flight departure are created
    public tableDeparture(){
        setLayout(new FlowLayout());
    
    String [] columnName = {"DESTINATION","HOME STATION","AIRLINE","FLIGHT ID","STA","TIME","GATE"};
    String [][] data = new String[departureObject.size()][7];
    int i=0;
    for(Departure current : departureObject){
        data[i][0] = current.getPlace().toString();
        data[i][1] = current.getAirline().getHomestation();
        data[i][2] = current.getAirline().getAirlineName();
        data[i][3] = current.getAirline().getAirlineId();
        data[i][4] = current.getDate().toString();
        data[i][5] = current.getTime().toString();
        data[i][6] = current.getLaneName().toString();
        i++;
    }
    flightDepart = new JTable(data, columnName);
    JScrollPane scrollPane = new JScrollPane(flightDepart);
    scrollPane.setPreferredSize(new Dimension(500,500));
    add(scrollPane);
    }
    
    }


    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        // First data for arrival are created 
        Date date1 = new Date(5,18,2016);
        Time time1 = new Time(00,15,0);
        Place from1 = new Place("Kuala Terengganu");
        Airline airline1 = new Airline("MH 3310","MALAYSIA AIRLINES","MALAYSIA");
        Lane lane1 = new Lane("A01");
        
        Arrival arrival = new Arrival(from1,date1,time1,airline1,lane1);
        arrivalObject.add(arrival);
       
        //First data for departure are created
        Date departDate1 = new Date(5,18,2016);
        Time departTime1 = new Time(8,30,0);
        Place destination1 = new Place("Kuala Terengganu");
        Airline airlineDepart1 = new Airline("AA 9823","AIR ASIA AIRLINES","MALAYSIA");
        Lane laneDepart1 = new Lane("A01");
        
        Departure departure1 = new Departure(destination1,departDate1,departTime1,airlineDepart1,laneDepart1); 
        departureObject.add(departure1);
        
        //Second data for arrival are created
        Date date2 = new Date(5,18,2016);
        Time time2 = new Time(00,30,4);
        Place from2 = new Place("Kota Bahru");
        Airline airline2 = new Airline("AA 2345","AIR ASIA AIRLINES","MALAYSIA");
        Lane lane2 = new Lane("A02");
        
        Arrival arrival2 = new Arrival(from2,date2,time2,airline2,lane2);
        arrivalObject.add(arrival2);
        
        //Second data for departure are created
        Date departDate2 = new Date(5,18,2016);
        Time departTime2 = new Time(9,30,0);
        Place destination2 = new Place("Kuala Kubu");
        Airline airlineDepart2 = new Airline("MH 4562","MALAYSIA AIRLINES","MALAYSIA");
        Lane laneDepart2 = new Lane("B01");
        
        Departure departure2 = new Departure(destination2,departDate2,departTime2,airlineDepart2,laneDepart2); 
        departureObject.add(departure2);
        
        //Third data for arrival are created
        Date date3 = new Date(5,18,2016);
        Time time3 = new Time(01,00,00);
        Place from3 = new Place("Kota Kinabalu");
        Airline airline3 = new Airline("FY 7651","FireFly AIRLINES","MALAYSIA");
        Lane lane3 = new Lane("B01");
        Arrival arrival3 = new Arrival(from3,date3,time3,airline3,lane3);
        arrivalObject.add(arrival3);
        
        //Third data for departure are created
        Date departDate3 = new Date(5,18,2016);
        Time departTime3 = new Time(10,30,0);
        Place destination3 = new Place("Kuala Sungai Baru");
        Airline airlineDepart3 = new Airline("ML 4212","MARLINDO AIRLINES","THAILAND");
        Lane laneDepart3 = new Lane("D02");
        
        Departure departure3 = new Departure(destination3,departDate3,departTime3,airlineDepart3,laneDepart3); 
        departureObject.add(departure3);
        
        //Forth data for arrival are created
        Date date4 = new Date(5,18,2016);
        Time time4 = new Time(02,00,00);
        Place from4 = new Place("Perlis");
        Airline airline4 = new Airline("ML 3251","Marlindo AIRLINES","THAILAND");
        Lane lane4 = new Lane("B03");
        Arrival arrival4 = new Arrival(from4,date4,time4,airline4,lane4);
        arrivalObject.add(arrival4);
        
        //Forth data for departure are created
        Date departDate4 = new Date(5,18,2016);
        Time departTime4 = new Time(11,30,0);
        Place destination4 = new Place("Langkawi");
        Airline airlineDepart4 = new Airline("MH 1245","MALAYSIA AIRLINES","MALAYSIA");
        Lane laneDepart4 = new Lane("E02");
        
        Departure departure4 = new Departure(destination4,departDate4,departTime4,airlineDepart4,laneDepart4); 
        departureObject.add(departure4);
        
        //Fifth data for arrival are created
        Date date5 = new Date(5,18,2016);
        Time time5 = new Time(04,00,00);
        Place from5 = new Place("Melaka");
        Airline airline5 = new Airline("ML 7461","Marlindo AIRLINES","THAILAND");
        Lane lane5 = new Lane("C01");
        Arrival arrival5 = new Arrival(from5,date5,time5,airline5,lane5);
        arrivalObject.add(arrival5);
        
        //Fifth data for departure are created
        Date departDate5 = new Date(5,18,2016);
        Time departTime5 = new Time(12,30,0);
        Place destination5 = new Place("Pulau Pangkor");
        Airline airlineDepart5 = new Airline("AA 8923","AIR ASIA AIRLINES","MALAYSIA");
        Lane laneDepart5 = new Lane("A02");
        
        Departure departure5 = new Departure(destination5,departDate5,departTime5,airlineDepart5,laneDepart5); 
        departureObject.add(departure5);
        
        System.out.println("Enter 1 for view Arrival Table and enter 2 for view Departure Table ");
        int a = in.nextInt();//get input from user
        
        if(a==1){
        tableArrival gui = new tableArrival();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(500,500);
        gui.setVisible(true);
        gui.setTitle("Arrival Table");
        }
        else if(a==2){
        tableDeparture gui2 = new tableDeparture();
        gui2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui2.setSize(500,500);
        gui2.setVisible(true);
        gui2.setTitle("Departure Table");
        }
        else
            System.out.println("Not in option");
    }
    
}
