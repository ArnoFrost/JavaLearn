package java.annotation;

import java.lang.annotation.*;

/**
 * @author arno
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyAnnotation {

    public String name() default "Arno";
}