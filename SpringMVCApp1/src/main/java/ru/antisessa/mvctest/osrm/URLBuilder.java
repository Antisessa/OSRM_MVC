package ru.antisessa.mvctest.osrm;

public class URLBuilder {
    static public String create(String coords){
        StringBuilder sb = new StringBuilder();
        sb.append("https://router.project-osrm.org/route/v1/driving/");
        sb.append(coords);
        sb.append("?steps=true&overview=full&continue_straight=true&geometries=polyline6");
        String url = sb.toString();
        return url;
    }
}
