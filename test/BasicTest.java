import org.junit.*;
import java.util.*;

import play.mvc.Router;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void aVeryImportantThingToTest() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void Test(){
    	Map<String,Object> map = new HashMap<String, Object>();
    	map.put("name", "eva");
    	map.put("url", "miscliches.free.fr");
    	String url = Router.reverse("JavaScript.insert", map).url;
    	System.out.println(url);
    }

}
