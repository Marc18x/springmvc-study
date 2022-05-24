import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author marc
 * @date 2022/5/24
 */
@RunWith(JUnit4.class)
public class MyTest {

    @Test
    public void test() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "2");
        System.out.printf(map.toString());
    }
}
