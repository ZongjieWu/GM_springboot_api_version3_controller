package com.example.springbootmybatisplus.config.apiversionconfig;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
public class WebRequestMappingConfig implements WebMvcRegistrations {

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();
        handlerMapping.setOrder(0);
        return handlerMapping;
    }

}
