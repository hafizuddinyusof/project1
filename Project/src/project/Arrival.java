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
public class Arrival {
    private Place from;
    private Date date;
    private Time time;
    private Airline airline;
    private Lane laneName;
    
    public Arrival(Place from, Date date, Time time, Airline airline,Lane laneName){
        setPlace(from);
        setDate(date);
        setTime(time);
        setAirline(airline);
        setLaneName(laneName);
    }
    
    public void setPlace(Place from){
        this.from = from;
    }
    public Place getPlace(){
        return this.from;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate(){
        return this.date;
    }
    public void setTime(Time time){
        this.time = time;
    }
    public Time getTime(){
        return this.time;
    }
    public void setAirline(Airline airline){
        this.airline = airline;
    }
    public Airline getAirline(){
        return this.airline;
    }
    public void setLaneName(Lane laneName){
        this.laneName = laneName;
    }
    public Lane getLaneName(){
        return this.laneName;
    }
    
    public String toString(){
        return String.format("%s %s %s %s %s",getPlace(),getAirline(),getDate(),getTime(),getLaneName());
    }
}

