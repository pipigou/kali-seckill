package cn.tgq007.seckill.exception;

import cn.tgq007.seckill.entity.ResponseData;
import cn.tgq007.seckill.entity.ResultCode;
import cn.tgq007.seckill.entity.ServiceCode;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@ControllerAdvice
public class ExceptionCatch {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

    // 定义map，配置异常类型所对应的错误代码
    private static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS;
    //定义map的builder对象，去构建ImmutableMap
    protected static ImmutableMap.Builder<Class<? extends Throwable>, ResultCode> builder = ImmutableMap.builder();

    //捕获CustomException此类异常
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseData<Object> customException(CustomException customException) {
        //记录日志
        LOGGER.error("catch exception:", customException);
        LOGGER.error("code and message :{} {}", customException.getResultCode(), customException.getMessage());
        ResultCode resultCode = customException.getResultCode();
        return new ResponseData<>(resultCode);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseData<Object> paramValid(MethodArgumentNotValidException exception) {
        LOGGER.error("catch exception:", exception);
        String defaultMessage = Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage();
        return new ResponseData<>(ServiceCode.PARAM_ERROR.code(), defaultMessage, null);
    }

    //捕获Exception此类异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseData<Object> exception(Exception exception) {
        //记录日志
        LOGGER.error("catch exception:", exception);
        if (EXCEPTIONS == null) {
            EXCEPTIONS = builder.build();
        }
        //从EXCEPTIONS中找异常类型所对应的错误代码，如果找到了将错误代码响应给用户，如果找不到给用户响应3异常
        ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        if (resultCode != null) {
            return new ResponseData<>(resultCode);
        } else {
            //默认的服务异常
            return new ResponseData<>(ServiceCode.SERVER_ERROR);
        }
    }

    static {
        //定义异常类型所对应的错误代码
        builder.put(HttpMessageNotReadableException.class, ServiceCode.PARAM_ERROR);
    }
}
