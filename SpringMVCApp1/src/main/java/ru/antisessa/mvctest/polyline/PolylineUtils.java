package ru.antisessa.mvctest.polyline;

import java.util.List;

public class PolylineUtils {

	public static String toString(List<PolylinePoint> polyline) {
		String str = "[ ";
		for( PolylinePoint p : polyline) {
			str += p;
		}
		return str + " ]";
	}

	public static String toStringForGeoJSON(List<PolylinePoint> polyline) {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		sb.append("\"type\": \"FeatureCollection\",\n");
		sb.append("\"features\": [ \n");
		sb.append("{\n");
		sb.append("\"type\": \"Feature\", \n");
		sb.append("\"id\": 0, \n");
		sb.append("\"geometry\": { \n");
		sb.append("\"type\": \"LineString\", \n");
		sb.append("\"coordinates\":[\n");

		for (int i = 0; i < polyline.size(); i++) {
			sb.append("[");
			sb.append(polyline.get(i).getLng());
			sb.append(",");
			sb.append(polyline.get(i).getLat());
			sb.append("],\n");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append("]\n");

		sb.append("},\n");
		sb.append("\"properties\": {\n");
		sb.append("\"description\": \"«Метрополитен рейлуэй»\",\n");
		sb.append("\"stroke\": \"#b51eff\",\n");
		sb.append("\"stroke-width\": \"8\",\n");
		sb.append("\"stroke-opacity\": 0.4\n");
		sb.append("}\n");
		sb.append("}\n");
		sb.append("]\n");
		sb.append("}\n");
		return sb.toString();
	}

	public static String toMarkers(List<PolylinePoint> polyline) {
		String str = "";
		for( PolylinePoint p : polyline) {
			str += "|" + p.getLat()+","+p.getLng();
		}
		return str.substring(1, str.length());
	}

}
