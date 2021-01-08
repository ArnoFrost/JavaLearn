package orm;

import java.lang.annotation.*;

/**
 * @Author: ArnoFrost
 * @Date: 2021/1/8 11:39
 * @Version 1.0
 */
//用在类上
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyTable {
    //指定表名
    String tableName();
}
