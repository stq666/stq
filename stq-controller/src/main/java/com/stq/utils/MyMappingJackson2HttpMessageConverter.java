package com.stq.utils;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/3.
 */
public class MyMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
    public MyMappingJackson2HttpMessageConverter() {
        super();
        List<MediaType> list = new ArrayList<MediaType>();
        list.addAll(this.getSupportedMediaTypes());

        // for some binary request
        list.add(new MediaType("application", "octet-stream", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET));
        // for text/html
        list.add(new MediaType("text", "html", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET));

        this.setSupportedMediaTypes(list);
    }
}
