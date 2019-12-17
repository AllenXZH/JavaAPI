package Annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface MyAnno {
    String value() default "hello world";

    String m() default "dfdafdsafdsf";
}
