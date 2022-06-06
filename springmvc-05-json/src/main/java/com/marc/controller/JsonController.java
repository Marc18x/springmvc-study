package com.marc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.marc.entity.User;
import com.marc.utils.JsonUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author marc
 * @date 2022/6/6
 */
@RestController
public class JsonController {

    /**
     * 获取User信息，通过Lombok默认的toString方法输出String字符串
     *
     * @return
     */
    @RequestMapping("/j1")
    public String getUserAPI() {
        User user = new User();
        user.setName("marc");
        user.setId("A10001");
        user.setGender("male");
        user.setLastOperationDate(new Date());

        return user.toString();
    }

    /**
     * 通过ObjectMapper进行jsonString的输出
     * 可以通过@JsonIgnore定向限制某些字段不与输出
     * @return user(以JsonString格式输出)
     */
    @RequestMapping("/j2")
    public String getUserAPIforJsonString() {
        User user = new User();
        user.setName("marc");
        user.setId("A10001");
        user.setGender("male");
        user.setLastOperationDate(new Date());

        return JsonUtil.trans2JsonString(user);
    }

    /**
     * 测试获取时间--输出格式的控制
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/j3")
    public String getTime() throws JsonProcessingException {
        Date date = new Date();
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        mapper.setDateFormat(dateFormat);

        return mapper.writeValueAsString(date);
    }
}
