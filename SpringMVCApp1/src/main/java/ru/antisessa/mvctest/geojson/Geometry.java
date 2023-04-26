package ru.antisessa.mvctest.geojson;

import lombok.Getter;
import lombok.Setter;
import ru.antisessa.mvctest.polyline.PolylinePoint;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Geometry{
    public String type;
    public List<PolylinePoint> coordinates;
}