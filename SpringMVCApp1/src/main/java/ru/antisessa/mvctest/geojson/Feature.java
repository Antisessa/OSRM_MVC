package ru.antisessa.mvctest.geojson;

import lombok.Getter;
import lombok.Setter;
import ru.antisessa.mvctest.polyline.PolylinePoint;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Feature{
    public static int COUNT_NUMBER = 0;
    public String type;
    public int id;
    public Geometry geometry;
    public Properties properties;

    public Feature(String type, List<PolylinePoint> coords, String disc){
        this.id = COUNT_NUMBER++;
        this.type = type;
        this.geometry = new Geometry();
        this.geometry.coordinates = coords;
        this.properties = new Properties();
        this.properties.description = disc;
        this.properties.stroke = "#b51eff";
    }
}
