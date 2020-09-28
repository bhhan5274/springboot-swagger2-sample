package com.bhhan.swagger.api.error;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by hbh5274@gmail.com on 2020-09-28
 * Github : http://github.com/bhhan5274
 */

@Getter
@Setter
@NoArgsConstructor
public class Error {
    private int statusCode;
    private String message;
    private List<FieldError> fieldErrors = new ArrayList<>();

    @Builder
    public Error(List<org.springframework.validation.FieldError> fieldErrors, ErrorCode errorCode){
        for (org.springframework.validation.FieldError fieldError : fieldErrors) {
            this.fieldErrors.add(new FieldError(fieldError));
        }

        this.statusCode = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class FieldError {
        private String field;
        private String rejectedValue;
        private String message;

        FieldError(org.springframework.validation.FieldError fieldError){
            this.field = fieldError.getField();
            this.rejectedValue = Objects.nonNull(fieldError.getRejectedValue()) ? fieldError.getRejectedValue().toString() : "null";
            this.message = fieldError.getDefaultMessage();
        }
    }
}
