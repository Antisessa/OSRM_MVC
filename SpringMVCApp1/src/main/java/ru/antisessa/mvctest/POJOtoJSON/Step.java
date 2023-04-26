package ru.antisessa.mvctest.POJOtoJSON;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;
public class Step{
    String geometry;
    Maneuver maneuver;
    String mode;
    String driving_side;
    String name;
    ArrayList<Intersection> intersections;
    double weight;
    double duration;
    double distance;
    String ref;

    @JsonProperty("geometry") 
    public String getGeometry() { 
		 return this.geometry; } 
    public void setGeometry(String geometry) { 
		 this.geometry = geometry; } 

    @JsonProperty("maneuver") 
    public Maneuver getManeuver() {
		 return this.maneuver; } 
    public void setManeuver(Maneuver maneuver) { 
		 this.maneuver = maneuver; } 

    @JsonProperty("mode") 
    public String getMode() { 
		 return this.mode; } 
    public void setMode(String mode) { 
		 this.mode = mode; } 

    @JsonProperty("driving_side") 
    public String getDriving_side() { 
		 return this.driving_side; } 
    public void setDriving_side(String driving_side) { 
		 this.driving_side = driving_side; } 

    @JsonProperty("name") 
    public String getName() { 
		 return this.name; } 
    public void setName(String name) { 
		 this.name = name; } 

    @JsonProperty("intersections") 
    public ArrayList<Intersection> getIntersections() { 
		 return this.intersections; } 
    public void setIntersections(ArrayList<Intersection> intersections) { 
		 this.intersections = intersections; } 

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

    @JsonProperty("ref") 
    public String getRef() { 
		 return this.ref; } 
    public void setRef(String ref) { 
		 this.ref = ref; }
}
