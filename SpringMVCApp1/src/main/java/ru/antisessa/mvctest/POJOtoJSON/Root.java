package ru.antisessa.mvctest.POJOtoJSON;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
public class Root{
    String code;
    ArrayList<Route> routes;
    ArrayList<Waypoint> waypoints;
    @JsonProperty("code") 
    public String getCode() { 
		 return this.code; } 
    public void setCode(String code) { 
		 this.code = code; } 

    @JsonProperty("routes") 
    public ArrayList<Route> getRoutes() {
		 return this.routes; } 
    public void setRoutes(ArrayList<Route> routes) { 
		 this.routes = routes; } 

    @JsonProperty("waypoints") 
    public ArrayList<Waypoint> getWaypoints() { 
		 return this.waypoints; } 
    public void setWaypoints(ArrayList<Waypoint> waypoints) { 
		 this.waypoints = waypoints; }
}
