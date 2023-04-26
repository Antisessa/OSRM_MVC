package ru.antisessa.mvctest.POJOtoJSON;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Intersection{
    int out;
    ArrayList<Boolean> entry;
    ArrayList<Integer> bearings;
    ArrayList<Double> location;
    int in;

    @JsonProperty("out") 
    public int getOut() { 
		 return this.out; } 
    public void setOut(int out) { 
		 this.out = out; } 

    @JsonProperty("entry") 
    public ArrayList<Boolean> getEntry() {
		 return this.entry; } 
    public void setEntry(ArrayList<Boolean> entry) {
		 this.entry = entry; } 

    @JsonProperty("bearings") 
    public ArrayList<Integer> getBearings() {
		 return this.bearings; } 
    public void setBearings(ArrayList<Integer> bearings) {
		 this.bearings = bearings; } 

    @JsonProperty("location") 
    public ArrayList<Double> getLocation() {
		 return this.location; }
    public void setLocation(ArrayList<Double> location) {
		 this.location = location;
    }

    @JsonProperty("in") 
    public int getIn() { 
		 return this.in; } 
    public void setIn(int in) { 
		 this.in = in; }
}
