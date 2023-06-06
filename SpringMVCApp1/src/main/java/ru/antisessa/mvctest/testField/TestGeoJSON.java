package ru.antisessa.mvctest.testField;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.client.RestTemplate;
import ru.antisessa.mvctest.POJOtoJSON.Root;
import ru.antisessa.mvctest.osrm.RequestParamParser;
import ru.antisessa.mvctest.osrm.URLBuilder;
import ru.antisessa.mvctest.polyline.PolylineDecoder;
import ru.antisessa.mvctest.polyline.PolylinePoint;
import ru.antisessa.mvctest.polyline.PolylineUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TestGeoJSON {
    public static void main(String[] args) throws IOException {

		//запись вида E(долгота lng), N(широта lat)
		String str12 = "51.719005,55.574972;50.987436,55.329526";

		String str2 = "52.167286,55.625559;52.181051,55.624045;51.415949,55.423258;50.623982,55.32448;50.131577,55.303604;50.113274,55.298426;49.412392,55.61236";
		String str3 = "-0.17508188536968763,51.51567612046976;-0.1045536717744013,51.52010421392138";
		//Создание и инициализация парсера параметров запроса
		RequestParamParser pp = new RequestParamParser(str12);
		pp.initialize();

		//Построение запроса к OSRM на основании keyPoints
		String url = URLBuilder.create(pp.toString());

		//Запрос к OSRM и получение Response в виде OSRM JSON
		final RestTemplate restTemplate = new RestTemplate();
		final String JSONResponse = restTemplate.getForObject(url, String.class);

		//Инициализация ObjectMapper для десериализации JSON в POJO
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		Root root = objectMapper.readValue(JSONResponse, Root.class);

		//декодирование googlePolyline в List<PolylinePoint>
		String encodedGeometry = root.getRoutes().get(0).getGeometry();
		PolylineDecoder polylineDecoder = new PolylineDecoder();
		List<PolylinePoint> decodedGeometry = polylineDecoder.decode(encodedGeometry);

		//Формирование JSON для 1C (Егору)
		ObjectNode JSON = objectMapper.createObjectNode();
		JSON.put("Google Polyline", encodedGeometry);
		JSON.put("Points", decodedGeometry.toString());
		System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(JSON));

		String GeoJSON = PolylineUtils.toStringForGeoJSON(decodedGeometry);

		File testGeoJSON = new File("D:\\Java Prod\\prod\\OSRM_MVC_build2604\\SpringMVCApp1\\src\\main\\resources\\testGeoJSON.json");
		try (FileWriter fileWriter = new FileWriter(testGeoJSON)) {
			fileWriter.write(GeoJSON);
		}
	}
}
