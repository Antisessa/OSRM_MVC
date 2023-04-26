package ru.antisessa.mvctest.POJOtoJSON;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Maneuver{
    int bearing_after;
    int bearing_before;
    ArrayList<Double> location;
    String type;
    String modifier;

    @JsonProperty("bearing_after") 
    public int getBearing_after() { 
		 return this.bearing_after; } 
    public void setBearing_after(int bearing_after) { 
		 this.bearing_after = bearing_after; } 

    @JsonProperty("bearing_before") 
    public int getBearing_before() { 
		 return this.bearing_before; } 
    public void setBearing_before(int bearing_before) { 
		 this.bearing_before = bearing_before; } 

    @JsonProperty("location") 
    public ArrayList<Double> getLocation() {
		 return this.location; } 
    public void setLocation(ArrayList<Double> location) {
		 this.location = location; } 

    @JsonProperty("type") 
    public String getType() { 
		 return this.type; } 
    public void setType(String type) { 
		 this.type = type; } 

    @JsonProperty("modifier") 
    public String getModifier() { 
		 return this.modifier; } 
    public void setModifier(String modifier) { 
		 this.modifier = modifier; }
}
