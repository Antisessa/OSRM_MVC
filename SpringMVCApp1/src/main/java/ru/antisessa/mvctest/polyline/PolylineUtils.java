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
		String part1 =  """
				{
				"type": "FeatureCollection",
				  "features": [
				{
				"type": "Feature",
				      "id": 0,
				      "geometry": {
				        "type": "LineString",
				        "coordinates":
				""";
		sb.append(part1).append("[\n");

		for (int i = 0; i < polyline.size(); i++) {
			sb.append("[");
			sb.append(polyline.get(i).getLng());
			sb.append(",");
			sb.append(polyline.get(i).getLat());
			sb.append("],\n");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append("]\n");

		String part3 = """
				},
				"properties": {
				"description": "«Метрополитен рейлуэй»",
				"stroke": "#b51eff",
				"stroke-width": "8",
				"stroke-opacity": 0.4
								}
						}
					]
				}
				""";
		sb.append(part3);
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
