/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.annotation.notnull;

import javalearn.annotation.ValidateResult;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @author wwh
 * @create: 2019-01-16 14:25
 **/
public class MyAnnotation {

    /**
     * 检验是否为空
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> List<ValidateResult> validate(T t) {
        List<ValidateResult> validateResults = new ArrayList<>();
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                Object value = null;
                try {
                    value = field.get(t);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (value == null) {
                    NotNull notNull = field.getAnnotation(NotNull.class);
                    ValidateResult validateResult = new ValidateResult();
                    validateResult.setMessage(notNull.fileName() + "不能为空");
                    validateResults.add(validateResult);
                }
            }

        }

        //内部实现判断
        StringBuilder str = new StringBuilder();
        for (ValidateResult va : validateResults) {
            if (!va.isValid()) {
                str.append(va.getMessage()).append(",");
            }
        }
        System.err.println(str.toString());

        return validateResults;
    }
}
