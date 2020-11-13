package com.nzhao.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class JsonUtil {
    //为了使方法适应不同参数，我们需要重载，而研究别人的代码发现，
    // 重写方法不是复制粘贴，而是调用其他写好的方法，然后参数传默认值
    public static String getJson(Object object){
        return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }


    public static String getJson(Object object, String dateFormat){
        ObjectMapper mapper = new ObjectMapper();

        //不使用时间戳的方式2
        //设置不使用时间戳
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        //制定日期格式
        mapper.setDateFormat(sdf);

        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
