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
public class Place {
    private String place;
    
    public Place(String place){
        setPlace(place);
    }
    public void setPlace(String place){
        this.place = place;
    }
    public String getPlace(){
        return this.place;
    }
    public String toString(){
        return String.format("%s", getPlace());
    }
}