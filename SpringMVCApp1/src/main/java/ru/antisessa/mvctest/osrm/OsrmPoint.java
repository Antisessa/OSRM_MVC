package ru.antisessa.mvctest.osrm;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
public class OsrmPoint {
    double lat;
    double lng;

    public OsrmPoint(String s){
        String[] LatLng = s.split(",");
        this.lat = Double.parseDouble(LatLng[0]);
        this.lng = Double.parseDouble(LatLng[1]);
    }
    @Override
    public String toString() {
        return lat + "," + lng;
    }

    }
