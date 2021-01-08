package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: ArnoFrost
 * @Date: 2021/1/8 12:13
 * @Version 1.0
 */
//不加入到class中
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE})
public @interface IsValidateInt {
}
