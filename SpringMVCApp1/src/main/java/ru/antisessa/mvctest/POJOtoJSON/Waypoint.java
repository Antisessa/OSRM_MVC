package ru.antisessa.mvctest.POJOtoJSON;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Waypoint{
    String hint;
    double distance;
    String name;
    ArrayList<Double> location;

    @JsonProperty("hint") 
    public String getHint() { 
		 return this.hint; } 
    public void setHint(String hint) { 
		 this.hint = hint; } 

    @JsonProperty("distance") 
    public double getDistance() { 
		 return this.distance; } 
    public void setDistance(double distance) { 
		 this.distance = distance; } 

    @JsonProperty("name") 
    public String getName() { 
		 return this.name; } 
    public void setName(String name) { 
		 this.name = name; } 

    @JsonProperty("location") 
    public ArrayList<Double> getLocation() {
		 return this.location; } 
    public void setLocation(ArrayList<Double> location) {
		 this.location = location; }
}
