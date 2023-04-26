package ru.antisessa.mvctest.geojson;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class GeoJson {
    public String type;
    public ArrayList<Feature> features;

    public GeoJson(){
        this.type = "FeatureCollection";
    }
}
