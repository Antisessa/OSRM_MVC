package ru.antisessa.mvctest.osrm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.client.RestTemplate;
import ru.antisessa.mvctest.POJOtoJSON.Root;
import ru.antisessa.mvctest.geojson.Feature;
import ru.antisessa.mvctest.geojson.GeoJson;
import ru.antisessa.mvctest.polyline.PolylinePoint;
import ru.antisessa.mvctest.polyline.PolylineDecoder;

import java.util.ArrayList;
import java.util.List;

import static ru.antisessa.mvctest.polyline.PolylinePoint.toGeoJSON;

public class Test {
    public static void main(String[] args) throws JsonProcessingException {
            String str1 = "52.167286,55.625559;52.181051,55.62404";
            String str2 = "52.167286,55.625559;52.181051,55.624045;51.415949,55.423258;50.623982,55.32448;50.131577,55.303604;50.113274,55.298426;49.412392,55.61236";
            //Создание и инициализация пасрера параметров запроса
            RequestParamParser pp = new RequestParamParser(str2);
            pp.initialize();

            //Построение запроса к OSRM на основании keyPoints
            String url = URLBuilder.create(pp.toString());

            //Запрос к OSRM и получение Response в виде JSON
            final RestTemplate restTemplate = new RestTemplate();
            final String JSONResponse = restTemplate.getForObject(url, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            Root root = objectMapper.readValue(JSONResponse, Root.class);

            String encodedGeometry = root.getRoutes().get(0).getGeometry();
            PolylineDecoder polylineDecoder = new PolylineDecoder();
            List<PolylinePoint> decodedGeometry = polylineDecoder.decode(encodedGeometry);

            ObjectNode JSON = objectMapper.createObjectNode();
            JSON.put("Google Polyline", encodedGeometry);
            JSON.put("Points", decodedGeometry.toString());

            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(JSON);
//            System.out.println(json);
//            System.out.println(decodedGeometry.size());

        GeoJson gj = new GeoJson();
        gj.features = new ArrayList<>();
        gj.features.add(new Feature("LineString", decodedGeometry, "some disc"));
        System.out.println(objectMapper.
                writerWithDefaultPrettyPrinter().
                writeValueAsString(gj));
    }
}
