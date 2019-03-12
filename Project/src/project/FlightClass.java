/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * 
 */
public class FlightClass 
{ 
     private String Name; 
    public FlightClass(String Name)
    {
        setName( Name );
    }
    
    public void setName( String Name )
    {
        this.Name = Name;
    }
    public String getName()
    {
        return this.Name;
    }
}
