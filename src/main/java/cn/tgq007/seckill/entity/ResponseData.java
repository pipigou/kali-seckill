package cn.tgq007.seckill.entity;

public class ResponseData<T> {

    private int code;
    private String message;
    private T data;

    public ResponseData() {
    }

    public ResponseData(ServiceCode serviceCode, T data) {
        this.code = serviceCode.code();
        this.message = serviceCode.message();
        this.data = data;
    }

    public ResponseData(ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public ResponseData(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T>ResponseData<T> success(T data) {
        return new ResponseData<>(ServiceCode.SUCCESS, data);
    }

    public static <T>ResponseData<T> fail(T data) {
        return new ResponseData<>(ServiceCode.FAIL, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
