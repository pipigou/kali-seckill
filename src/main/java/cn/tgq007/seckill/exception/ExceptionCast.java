package cn.tgq007.seckill.exception;

import cn.tgq007.seckill.entity.ResultCode;

public class ExceptionCast {

    public static void cast(ResultCode resultCode) {
        throw new CustomException(resultCode);
    }
}
