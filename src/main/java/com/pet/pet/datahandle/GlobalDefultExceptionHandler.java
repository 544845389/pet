package com.pet.pet.datahandle;

import com.lorne.core.framework.exception.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalDefultExceptionHandler {


    //声明要捕获的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object defultExcepitonHandler(HttpServletRequest request, Exception e) {
        Msg m = new Msg();
        m.setCode(41000);
        m.setErrMsg(e.getMessage());
        m.setData(null);
        return m;
    }


}
