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
public class Lane {
    private String laneName;
    
    public Lane(String laneName){
        setLaneName(laneName);
    }
    
    public void setLaneName(String laneName){
        this.laneName = laneName;
    }
    
    public String getLaneName(){
        return this.laneName;
    }
    
    public String toString(){
        return String.format("\tLane : %s ",getLaneName());
    }
    
}
