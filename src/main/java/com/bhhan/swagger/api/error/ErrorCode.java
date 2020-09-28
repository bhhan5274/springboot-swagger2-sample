package com.bhhan.swagger.api.error;

import lombok.Getter;

/**
 * Created by hbh5274@gmail.com on 2020-09-28
 * Github : http://github.com/bhhan5274
 */

@Getter
public enum ErrorCode {
    BAD_PARAMETER(400, "잘못된 인자를 입력했습니다.");

    private final int code;
    private final String message;

    ErrorCode(int code, String message){
        this.code = code;
        this.message = message;
    }
}
