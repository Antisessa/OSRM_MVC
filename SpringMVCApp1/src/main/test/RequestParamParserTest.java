import org.junit.Before;
import org.junit.Test;
import ru.antisessa.mvctest.osrm.RequestParamParser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RequestParamParserTest {
    String str = "52.356,45.255;53.411,46.269;54.765,47.654";
    String strFirstPoint = "52.356,45.255";
    String strLastPoint = "54.765,47.654";
    RequestParamParser pp = new RequestParamParser(str);

    @Before
    public void initPP(){
        pp.initialize();
    }

    @Test
    public void EqualsString(){
        String str1 = pp.toString();
        assertEquals(str, str1);
    }

    @Test
    public void EqualsFirstPoint(){
        String strfp = pp.osrmPointList.get(0).toString();
        assertEquals(strFirstPoint, strfp);
    }

    @Test
    public void EqualsLastPoint(){
        String strlp = pp.osrmPointList.get(2).toString();
        assertEquals(strLastPoint, strlp);
    }
}
