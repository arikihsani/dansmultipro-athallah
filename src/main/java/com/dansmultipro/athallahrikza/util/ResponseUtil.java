package com.dansmultipro.athallahrikza.util;

import com.dansmultipro.athallahrikza.dto.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    // reduce boilerplate code by creating response template
    public static ResponseEntity<Object> okResponse(Object data, String message) {
        BaseResponse result = new BaseResponse();
        result.setCode(HttpStatus.OK.value());
        result.setStatus(HttpStatus.OK.name());
        result.setData(data);
        result.setMessage(message);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<Object> failResponse( String message) {
        BaseResponse result = new BaseResponse();
        result.setCode(HttpStatus.EXPECTATION_FAILED.value());
        result.setStatus(HttpStatus.EXPECTATION_FAILED.name());
        result.setData(null);
        result.setMessage(message);
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(result);
    }
}
