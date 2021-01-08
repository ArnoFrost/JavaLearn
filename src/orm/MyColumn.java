package orm;

import java.lang.annotation.*;

/**
 * @Author: ArnoFrost
 * @Date: 2021/1/8 11:42
 * @Version 1.0
 */
//用在字段上
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyColumn {
    //指定字段名称
    String columnValue();
}
