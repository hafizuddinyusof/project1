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
public class Time {
    private int hour;
    private int minute;
    private int second;
    
   
    
    public Time(int hour , int minute, int second){
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }
    
    public void setHour(int hour){
        this.hour = hour;
    }
    
    public int getHour(){
        return this.hour;
    }
    public void setMinute(int minute){
        this.minute = minute;
    }
    public int getMinute(){
        return this.minute;
    }
    
    public void setSecond(int second){
        this.second = second;
    }
    public int getSecond(){
        return this.second;
    }
    
    public String toString(){
        return String.format("%d:%d:%d\t",getHour(),getMinute(),getSecond());
    }
}
