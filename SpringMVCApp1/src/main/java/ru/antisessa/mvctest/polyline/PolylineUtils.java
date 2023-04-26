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

	public static String toMarkers(List<PolylinePoint> polyline) {
		String str = "";
		for( PolylinePoint p : polyline) {
			str += "|" + p.getLat()+","+p.getLng();
		}
		return str.substring(1, str.length());
	}

}
