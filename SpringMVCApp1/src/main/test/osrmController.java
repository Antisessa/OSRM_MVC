import org.junit.Test;
import ru.antisessa.mvctest.osrm.RequestParamParser;

import static org.junit.Assert.assertEquals;

//Test Controller methods
public class osrmController {
    //На контроллер приходит GET запрос вида /osrm/route?keyPoints=52.356,45.255;53.411,46.269;54.765,47.654
    String coords = "52.356,45.255;53.411,46.269;54.765,47.654";
    int amountPoints = 3;
    @Test
    public void SizeOfPointList(){
        RequestParamParser pp = new RequestParamParser(coords);
        pp.initialize();
        assertEquals(pp.osrmPointList.size(), 3);
    }
}
