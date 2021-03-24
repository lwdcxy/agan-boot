package com.agan.boot.exceptions;

import com.agan.boot.enums.ResultCode;
import com.agan.boot.response.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorResult handleThrowable(Throwable e, HttpServletRequest request){
        ErrorResult error = ErrorResult.fail(ResultCode.SYSTEM_ERROR, e);
        log.error("URL:{},系统异常", request.getRequestURI(),e);
        return error;
    }

    /**
     * 处理自定义异常
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public ErrorResult handelBusinessException(BusinessException e,HttpServletRequest request){
        ErrorResult error = ErrorResult.builder().status(e.code)
                .message(e.message)
                .exception(e.getClass().getName())
                .build();
        log.warn("URL:{},业务异常:{}",request.getRequestURI(),error);
        return error;
    }

    /**
     * validator 统一异常封装
     * @param e
     * @param request
     * @return
     */

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e,HttpServletRequest request){
        String msgs = this.handle(e.getBindingResult().getFieldErrors());
        ErrorResult error = ErrorResult.fail(ResultCode.PARAM_IS_INVALID, e, msgs);
        log.warn("URL:{},参数校验异常:{}",request.getRequestURI(),msgs);
        return error;

    }

    private String handle(List<FieldError> fieldErrors) {
        StringBuilder sb = new StringBuilder();
        for (FieldError obj : fieldErrors){
            sb.append(obj.getField());
            sb.append("=[");
            sb.append(obj.getDefaultMessage());
            sb.append("] ");
        }
        return sb.toString();
    }


    /**
     * Asset的统一封装
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalArgumentException(IllegalArgumentException e,HttpServletRequest request){
        ErrorResult error = ErrorResult.builder().status(4000)
                .message(e.getMessage())
                .exception(e.getClass().getName())
                .build();
        log.warn("URL:{},业务校验异常:{}",request.getRequestURI(),e);
        return error;
    }
}
