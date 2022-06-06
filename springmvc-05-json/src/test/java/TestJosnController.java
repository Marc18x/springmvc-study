import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.marc.controller.JsonController;
import com.marc.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

@RunWith(JUnit4.class)
public class TestJosnController {

    /**
     * 测试json格式转换是否如预期
     */
    @Test
    public void testJsonOutput(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
        JsonController jsonController = applicationContext.getBean("jsonController", JsonController.class);
        String userJsonString = jsonController.getUserAPIforJsonString();
        System.out.println(userJsonString);
        User user = null;

        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(simpleDateFormat);

        try {
            user =mapper.readValue(userJsonString,User.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals("marc",user.getName());
        Assert.assertEquals("A10001",user.getId());
        Assert.assertEquals("male",user.getGender());
    }
}
