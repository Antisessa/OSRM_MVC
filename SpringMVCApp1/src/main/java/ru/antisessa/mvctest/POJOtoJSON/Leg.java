package ru.antisessa.mvctest.POJOtoJSON;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
public class Leg{
    ArrayList<Step> steps;
    String summary;
    double weight;
    double duration;
    double distance;

    @JsonProperty("steps") 
    public ArrayList<Step> getSteps() {
		 return this.steps; } 
    public void setSteps(ArrayList<Step> steps) { 
		 this.steps = steps; } 

    @JsonProperty("summary") 
    public String getSummary() { 
		 return this.summary; } 
    public void setSummary(String summary) { 
		 this.summary = summary; } 

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
