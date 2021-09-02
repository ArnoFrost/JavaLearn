package java.annotation.validateInt;

import com.sun.javafx.binding.StringFormatter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Author: ArnoFrost
 * @Date: 2021/1/8 13:23
 * @Version 1.0
 */
public class ValidateHandler {
    private static ValidateHandler mInstance;

    public static ValidateHandler getInstance() {
        if (mInstance == null) {
            mInstance = new ValidateHandler();
        }
        return mInstance;
    }

    /**
     * 检验成员变量是否满足条件
     *
     * @param t
     * @param <T>
     * @return
     */
    public <T> boolean isValidateField(T t) {
        boolean isValidate = true;
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ValidateInt.class)
            ) {
                field.setAccessible(true);
                Object value = null;
                try {
                    value = field.get(t);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (value instanceof Integer) {
                    ValidateInt annotation = field.getAnnotation(ValidateInt.class);
                    if (annotation != null) {
                        //开启验证才去校验
                        if (annotation.isValidate() && (Integer) value > annotation.maxValue()) {
                            isValidate = false;
                            System.err.println(t.hashCode() + "->字段:" + field.getName() + "," + value + " 不能大于预期 :" + annotation.maxValue());
                        }
                    }


                }
            }
        }
        if (isValidate) {
            System.out.println(t.hashCode() + "->校验通过");
        }
        return isValidate;
    }

    public <T> boolean isValidateParameters(T t) {
        boolean isValidate = true;
//        List<ValidateResult> validateResults = new ArrayList<>();
//        //获得声明的所有方法
        Method[] declaredMethods = t.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Parameter[] parameters = declaredMethod.getParameters();
            for (Parameter parameter : parameters) {
                if (parameter.isAnnotationPresent(ValidateInt.class)) {
                    Object value = null;
                    String name = parameter.getName();

                    if (value instanceof Integer) {
                        ValidateInt annotation = parameter.getAnnotation(ValidateInt.class);
                        //开启验证才去校验
                        if (annotation.isValidate() && (Integer) value > annotation.maxValue()) {
                            isValidate = false;
                            System.err.println(StringFormatter.format("字段:%s,%d 不能大于预期 %d", parameter.getName(), value, annotation.maxValue()));
                        }
                    }
                }
            }
        }


        return isValidate;
    }

}
