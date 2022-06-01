package com.jay.getinline.controller.error;

import com.jay.getinline.DTO.APIErrorResponse;
import com.jay.getinline.constant.ErrorCode;
import com.jay.getinline.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler
    public ModelAndView errorHtml(GeneralException e) {
        ErrorCode errorCode = e.getErrorCode();
        HttpStatus status = errorCode.isClientSideError() ?
                HttpStatus.BAD_REQUEST :
                HttpStatus.INTERNAL_SERVER_ERROR;

        return new ModelAndView(
                "error",
                Map.of(
                        "statuscode", status.value(),
                        "errorCode", errorCode,
                        "message", errorCode.getMessage(e)
                ),
                status
        );
    }

    @ExceptionHandler
    public ModelAndView errorHtml(Exception e) {
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        return new ModelAndView(
                "error",
                Map.of(
                        "statuscode", status.value(),
                        "errorCode", errorCode,
                        "message", errorCode.getMessage(e)
                ),
                status
        );
    }



}
