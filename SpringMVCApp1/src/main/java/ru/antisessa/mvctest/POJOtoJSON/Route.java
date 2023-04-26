package ru.antisessa.mvctest.POJOtoJSON;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
public class Route{
    String geometry;
    ArrayList<Leg> legs;
    String weight_name;
    double weight;
    double duration;
    double distance;

    @JsonProperty("geometry") 
    public String getGeometry() { 
		 return this.geometry; } 
    public void setGeometry(String geometry) { 
		 this.geometry = geometry; } 

    @JsonProperty("legs") 
    public ArrayList<Leg> getLegs() {
		 return this.legs; } 
    public void setLegs(ArrayList<Leg> legs) { 
		 this.legs = legs; } 

    @JsonProperty("weight_name") 
    public String getWeight_name() { 
		 return this.weight_name; } 
    public void setWeight_name(String weight_name) { 
		 this.weight_name = weight_name; } 

    @JsonProperty("weight") 
    public double getWeight() { 
		 return this.weight; } 
    public void setWeight(double weight) { 
		 this.weight = weight; } 

    @JsonProperty("duration") 
    public double getDuration() { 
		 return this.duration; } 
    public void setDuration(double duration) { 
		 this.duration = duration; } 

    @JsonProperty("distance") 
    public double getDistance() { 
		 return this.distance; } 
    public void setDistance(double distance) { 
		 this.distance = distance; }
}
