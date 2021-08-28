package cn.tgq007.seckill.entity;

public enum ServiceCode implements ResultCode {
    SUCCESS(200, "成功"),
    FAIL(-1, "失败"),
    BAD_REQUEST(400, "bad request"),
    PARAM_ERROR(300, "参数异常"),
    SERVER_ERROR(500, "服务异常")
    ;

    int code;
    String message;

    ServiceCode(int code, String message) {
        this.code = code;
        this.message=message;
    }

    @Override
    public int code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }
}
