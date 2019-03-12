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
public class Route {
    private Arrival arrival;
    private Departure departure;
    
    public Route(Arrival arrival, Departure departure){
        setArrival(arrival);
        setDeparture(departure);
    }
    
    public void setArrival(Arrival arrival){
        this.arrival = arrival;
    }
    public Arrival getArrival(){
        return this.arrival;
    }
    public void setDeparture(Departure departure){
        this.departure = departure;
    }
    public Departure getDeparture(){
        return this.departure;
    }
}
