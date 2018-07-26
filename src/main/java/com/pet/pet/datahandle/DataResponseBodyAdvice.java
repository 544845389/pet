package com.pet.pet.datahandle;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class DataResponseBodyAdvice implements ResponseBodyAdvice {


    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        String swaggerClass = returnType.getMethod().getDeclaringClass().getName();
        if( swaggerClass.equals("springfox.documentation.swagger.web.ApiResourceController") ||
                swaggerClass.equals("springfox.documentation.swagger2.web.Swagger2Controller") ){
            return  body;
        }
        /**
         * 文档
         */
        if(returnType.getMethod().getName().equals("swaggerResources")){
            return  body;
        }

        Msg m = new Msg();
        m.setCode(40000);
        m.setErrMsg("");
        m.setData(body);
        return  m;
    }
}
