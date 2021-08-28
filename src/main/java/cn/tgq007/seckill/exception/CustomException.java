package cn.tgq007.seckill.exception;

import cn.tgq007.seckill.entity.ResultCode;

public class CustomException extends RuntimeException {
    ResultCode resultCode;

    public CustomException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
