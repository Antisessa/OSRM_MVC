package ru.antisessa.mvctest.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.antisessa.mvctest.POJOtoJSON.Root;
import ru.antisessa.mvctest.osrm.*;
import ru.antisessa.mvctest.polyline.PolylineDecoder;
import ru.antisessa.mvctest.polyline.PolylinePoint;

import java.util.Collections;
import java.util.List;

@RestController
public class osrmController {
    @RequestMapping(value = "/route", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getRoute(@RequestParam("keyPoints")String coords,
                           Model model) throws JsonProcessingException {
        /*
            example request to localhost
            /osrm/route?keyPoints=52.167286,55.625559;52.181051,55.62404&response=view
        */

        //Создание и инициализация пасрера параметров запроса
        RequestParamParser pp = new RequestParamParser(coords);
        pp.initialize();

        //Построение запроса к OSRM на основании keyPoints
        String url = URLBuilder.create(pp.toString());

        //Запрос к OSRM и получение Response в виде JSON
        final RestTemplate restTemplate = new RestTemplate();
        final String JSONResponse = restTemplate.getForObject(url, String.class);

        //Десериализация JSON к POJO (почему то не работает restTemplate)
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        Root root = objectMapper.readValue(JSONResponse, Root.class);

        //Декодирование google polyline в List<PolylinePoints>
        String encodedGeometry = root.getRoutes().get(0).getGeometry();
        PolylineDecoder polylineDecoder = new PolylineDecoder();
        List<PolylinePoint> decodedGeometry = polylineDecoder.decode(encodedGeometry);

        //Формирование JSON для 1C (Егору)
        ObjectNode JSON = objectMapper.createObjectNode();
        JSON.put("Google Polyline", encodedGeometry);
        JSON.put("Points", decodedGeometry.toString());
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(JSON);
    }
}
