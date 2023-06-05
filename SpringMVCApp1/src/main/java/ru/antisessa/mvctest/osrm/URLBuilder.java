package ru.antisessa.mvctest.osrm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class URLBuilder {
    static public String create(String coords) {
        File requestPropertiesFile = new
                File("D:\\Java Prod\\prod\\OSRM_MVC_build2604\\SpringMVCApp1\\src\\main\\resources\\request.properties");
        StringBuilder sb = null;
        try (InputStream inputStreamProperties = new FileInputStream(requestPropertiesFile)) {
            Properties prop = new Properties();
            prop.load(inputStreamProperties);

            sb = new StringBuilder();
            sb.append(prop.get("url"));
            sb.append(coords).append("?");
            sb.append("steps=").append(prop.get("steps")).append("&");
            sb.append("overview=").append(prop.get("overview")).append("&");
            sb.append("continue_straight=").append(prop.get("continue_straight")).append("&");
            sb.append("geometries=").append(prop.get("geometries"));
            // url/coors?steps=true&overview=full&continue_straight=true&geometries=polyline6

        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = sb.toString();
        return url;
    }
}
