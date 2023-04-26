package ru.antisessa.mvctest.osrm;

import java.util.*;

public class RequestParamParser {
    String str;
    String[] strSplit;
    ArrayList<String> strings;
    public ArrayList<OsrmPoint> osrmPointList = new ArrayList<>();

    public void initialize() {
        this.strSplit = str.split(";");
        this.strings = new ArrayList<String>(
                Arrays.asList(strSplit));
        for (String string : strings) {
            this.osrmPointList.add(new OsrmPoint(string));
    }
    }

    public RequestParamParser(String str){
        this.str = str;
    }

    @Override // Example: "52.356,45.255;53.411,46.269;54.765,47.654"
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < osrmPointList.size(); i++) {
            sb.append(osrmPointList.get(i).toString());
            sb.append(";");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
