package com.lts.main.gulimall.product.Exception;

import com.lts.main.common.exception.BaseExceptionEnum;
import com.lts.main.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * springboot统一异常处理，将控制器中抛出的所有的异常进行集中处理
 * 打印日志
 */
//TODO: 异常处理类不知道为什么无法接管，但是JRE303生效了
@Slf4j
@RestControllerAdvice(basePackages = "com/lts/main/gulimall/product/controller")
public class gulimallActiveException {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handVaildException(MethodArgumentNotValidException e){
        log.error("异常信息{}，异常类型{}",e.getMessage(),e.getClass());
//        获取异常的处理类的信息
        BindingResult bindingResult=e.getBindingResult();

//        将一异常类型和异常信息存入map中
        Map<String,String> map=new HashMap<>();

        bindingResult.getFieldErrors().forEach((item)->{
//            获取异常信息
            String message=item.getDefaultMessage();
//            获取异常类型
            String field=item.getField();

            map.put(field,message);
        });

        return R.error(BaseExceptionEnum.VALID_EXCEPTION.getCode(),BaseExceptionEnum.VALID_EXCEPTION.getMsg()).put("data",map);
    }

//    全部异常处理
    @ExceptionHandler(value = Throwable.class)
    public R handVaildExceptions(){
        return R.error(BaseExceptionEnum.SYSTEM_EXCEPTION.getCode(),BaseExceptionEnum.VALID_EXCEPTION.getMsg());
    }

}
