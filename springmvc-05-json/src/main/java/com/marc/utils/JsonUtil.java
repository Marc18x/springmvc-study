package com.marc.utils;

/**
 * @author marc
 * @date 2022/6/6
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * Json工具类
 */
public class JsonUtil {

    /**
     * 常规转换，日期类按照yyyy-MM-dd HH:mm:ss进行输出
     * @param object
     * @return
     */
    public static String trans2JsonString(Object object){
        return trans2JsonString(object,"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 指定日期定向转换格式
     * @param object
     * @param dateFormat
     * @return
     */
    public static String trans2JsonString(Object object,String dateFormat){
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        mapper.setDateFormat(simpleDateFormat);

        try{
            return mapper.writeValueAsString(object);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }
}
