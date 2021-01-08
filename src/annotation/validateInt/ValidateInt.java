package annotation.validateInt;

import java.lang.annotation.*;

/**
 * @Author: ArnoFrost
 * @Date: 2021/1/8 13:21
 * @Version 1.0
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ValidateInt {
    int maxValue();

    /**
     * 是否开启验证 默认开启
     *
     * @return
     */
    boolean isValidate() default true;
}
