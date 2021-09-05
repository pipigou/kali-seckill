package cn.tgq007.seckill.entity;

public enum ServiceCode implements ResultCode {
    SUCCESS(200, "成功"),
    VERIFICATION_CODE_ERROR(3, "验证码错误"),
    HAS_BEEN_REGISTER(4, "用户名或密码已经被注册了"),
    FAIL(-1, "失败"),
    BAD_REQUEST(400, "bad request"),
    PARAM_ERROR(300, "参数异常"),
    SERVER_ERROR(500, "服务异常"),
    USER_NOT_EXIST(20001, "用户不存在"),
    USER_LOGIN_FAILED(20002, "手机或密码错误")
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
