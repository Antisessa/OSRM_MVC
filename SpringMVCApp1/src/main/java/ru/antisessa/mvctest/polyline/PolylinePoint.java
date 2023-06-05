package ru.antisessa.mvctest.polyline;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * Simple geographical point represented by a couple of doubles. Google's GeoPoint is a couple of micro-degrees
 * represented by integers.
 */
public class PolylinePoint implements Serializable {
    private static final long serialVersionUID = 1L;
    private final double lat;
    private final double lng;

//    public Point(double lat, double lng) {
//        this.lat = lat;
//        this.lng = lng;
//    }
    @JsonCreator
    public PolylinePoint(@JsonProperty("lat") double lat, @JsonProperty("lng") double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    @Override
    public String toString() {
        return "(" + lat + ", " + lng + ")";
    }

    /**
     * Utility method to export coordinates for use with GeoJSON. This standard requires longitude first. See
     * http://geojson.org/geojson-spec.html#positions
     */
    public static String toGeoJSON(List<PolylinePoint> polylinePoints) {
        StringBuilder buff = new StringBuilder("[");
        Iterator<PolylinePoint> itr = polylinePoints.iterator();
        while (itr.hasNext()) {
            buff.append(toGeoJSON(itr.next()));
            if (itr.hasNext()) {
                buff.append(",");
            }
        }
        buff.append("]");
        return buff.toString();
    }

    public static String toGeoJSON(PolylinePoint polylinePoint) {
        return "[" + polylinePoint.getLat() + "," + polylinePoint.getLng() + "]";
    }

    /**
     * We consider that two point are equals if both latitude and longitude are "nearly" the same. With a precision of
     * 1e-3 degree
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PolylinePoint)) {
            return false;
        }
        PolylinePoint that = (PolylinePoint) o;
        if (Math.abs(that.getLat() - lat) > 0.001) {
            return false;
        }
        return Math.abs(that.getLng() - lng) <= 0.001;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.lat) ^ (Double.doubleToLongBits(this.lat) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.lng) ^ (Double.doubleToLongBits(this.lng) >>> 32));
        return hash;
    }

}
