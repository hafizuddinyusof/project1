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
public class Airline {
    private String airlineId;
    private String airlineName;
    private String homestation;
    
    public Airline(String airlineId, String airlineName, String homestation){
        setAirlineId(airlineId);
        setAirlineName(airlineName);
        setHomestation(homestation);
    }
    
    public void setAirlineId(String airlineId){
        this.airlineId = airlineId;
    }
    public String getAirlineId(){
        return this.airlineId;
    }
    public void setAirlineName(String airlineName){
        this.airlineName = airlineName;
    }
    public String getAirlineName(){
        return this.airlineName;
    }
    public void setHomestation(String homestation){
        this.homestation = homestation;
    }
    public String getHomestation(){
        return this.homestation;
    }
    
    public String toString(){
        return String.format("\tHome Station : %s\t\tAirline Name : %s\tAirline ID : %s\t",getHomestation(),getAirlineName(),getAirlineId());
    }
}

