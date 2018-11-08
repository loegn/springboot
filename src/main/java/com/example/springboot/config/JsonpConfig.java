package com.example.springboot.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

import java.util.Objects;

/**
 * @date : 2018/10/27 11:12
 * @author: liangenmao
 */
@ControllerAdvice(basePackages = CommonConstants.CONTROLLER_SCAN)
//TODO 该方法过时了
public class JsonpConfig extends AbstractJsonpResponseBodyAdvice {
    public JsonpConfig() {
        super("jsonp", "callBack");
    }

    @Override
    protected void beforeBodyWriteInternal(MappingJacksonValue bodyContainer, MediaType contentType, MethodParameter returnType, ServerHttpRequest request, ServerHttpResponse response) {
        if (request.getHeaders() != null)
            if (request.getHeaders().get("host") != null)
                for (String origin : Objects.requireNonNull(request.getHeaders().get("host")))
                    if (origin.equals("127.0.0.1:8081"))
                        super.beforeBodyWriteInternal(bodyContainer, contentType, returnType, request, response);
    }
}
