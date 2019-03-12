/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 * Program : FlightClass.java
 * Writer : Group 7
 * 
 */
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import java.sql.Time;
import java.time.Instant;
public class Flight extends JFrame 
{
    String[][] schedule;

    String[] header = {"Flight","From","To","Departure","Arrival " };
    
    /**
     *
     * @throws IOException
     */
    public Flight() throws IOException
    {
        super("Flight Schedule");
        

        Random gene = new Random();

        schedule = new String[40][5];
        JPanel myPanel = new JPanel(new GridLayout(6,2,4,4));
        myPanel.setFont(new Font("Serif",Font.BOLD,14));
        myPanel.add(new JLabel("Hello, Welcome to"));
        myPanel.add(new JLabel("Flight Schedulling System"));
        myPanel.add(new JLabel("Please enter OK to set the maximun number of flight per day"));
        
        int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Flight Schedulling System", JOptionPane.OK_CANCEL_OPTION);
        if(result == JOptionPane.OK_OPTION)
        {
         String noOfFlight = JOptionPane.showInputDialog(null,"Please Enter maximum number of flight for a day  ?");
         int convert = Integer.parseInt(noOfFlight);
    
         int index = 0 ;
         
         ArrayList<FlightClass>  list = new ArrayList<FlightClass>(convert);
         
         Scanner input = new Scanner(new File("flightNo.txt"));
         
         
         
        while( input.hasNext() && index <= convert)
                                    { 
                                             String Flight = input.nextLine();
                                            list.add(new FlightClass(Flight));
                                            index++;
                                    }
         
      
        for(int i = 0; i < list.size() - 1 ; i++) 
        {
             schedule[i][0] = list.get(i).getName();
             
            schedule[i][1]="Kuala Lumpur";//tetapkan value dari kuala lumpur
              int f=0;//initializa masa untuk pengiraan 
              int D=0;//initialize masa untuk pengiraan
           for(int k= 1; k < 2; k++){//looping untuk destinatipn
             
              switch (gene.nextInt(11)) //random untuk 11 penerbangan
              {
            case 0:
               schedule[i][k+1]  = "Kota Bharu";
                f=3600000;
                break;
            case 1:
                schedule[i][k+1] = "Johor Bharu";
                 f=3600000;
                break;
            case 2:
                schedule[i][k+1] = "Penang";
                 f=3600000;
                break;
                case 3:
               schedule[i][k+1]  = "Penang";
                f=3600000;
                break;
            case 4:
                schedule[i][k+1] = "Kuala Terengganu ";
                 f=3600000;
                break;
            case 5:
                schedule[i][k+1] = "Kuantan";
                 f=3600000;
                break;
                case 6:
               schedule[i][k+1]  = "Kuching";
                f=6000000;
                break;
            case 7:
                schedule[i][k+1] = "Kota Kinabalu ";
                 f=6000000;
                break;
            case 8:
                schedule[i][k+1] = "Miri";
                 f=6000000;
                break;
                case 9:
               schedule[i][k+1]  = "Labuan";
                f=6000000;
                break;
            case 10:
                schedule[i][k+1] = "Sandakan";
                 f=6000000;
                break;
            case 11:
                schedule[i][k+1] = "Miri";
                 f=6000000;
                break;
            default:
                break;
              }
              //departure 
               for( k= 2; k <3; k++)
               {
                  
                 final Random random = new Random();//objek
                 final int millisInDay = 24*60*60*1000;//random dlm milisecond
                 D =random.nextInt(millisInDay);//random 
                 
                 //int l=D+(60*60*1000);
                
                
                 
                
                 
                Time time = new Time((long)D);//tukar milisecond pada format time 
                
                //Time time2 = new Time((long)l);
                
                   schedule [i][k+1]=String.valueOf(time); //assign dalam arrival
               }
               for( k= 3; k <4; k++)
                {
                             
                       int l=D+f;//bedarsakan destination
                       Time time2 = new Time((long)l);//tukar kepada format masa
                       schedule [i][k+1]=String.valueOf(time2);//masukkan dalam arrival
                 
                     
                         
                }
               /*
                for (k=3;k<4;k++)
                {
                    
                
                for(int l= 0; l < list.size() - 1 ; l++)
                {
                 /*  if(schedule[l][2]=="Kuching"||schedule[l][2]=="Kota Kinabalu"||schedule[l][2]=="Miri"||schedule[l][2]=="Labuan"||schedule[l][2]=="Sandakan")
                   {
                       Instant t1 = Instant.now();
                        long hours = 1;
                        long minutes = 40;
                         Time times  =new Time( time.plus(hours, time.HOURS).plus(minutes,
                       ChronoUnit.MINUTES));   
               }
                   
                }
                schedule[i][k+1]=times
              
*/     
        }

        JTable g = new JTable(schedule, header);

        add(new JScrollPane(g));

        }
    }
        else
        {
            int exit = JOptionPane.showConfirmDialog(this, "Do you Really want to exit?");
            if (exit == JOptionPane.YES_OPTION)
            {
                System.exit(0);
 
            }
        }

}
   public static void main(String[] args) throws IOException
    {
         JFrame f;
        f = new Flight();

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        f.setSize(1500,1500);

        f.setVisible(true);
            
    }
}
