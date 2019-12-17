package Annotation;

import java.lang.reflect.Field;

public class Annotation_Test {

    @MyAnno(value = "hahaha")
    String prefix = "sdsdf";

    String lalal = "df";

    public String intToStr(int a) {
        return prefix + String.valueOf(a);
    }

    public static void main(String[] args) {

        Annotation_Test obj = new Annotation_Test();

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(MyAnno.class)) {
                String val = field.getAnnotation(MyAnno.class).value();
                String valM = field.getAnnotation(MyAnno.class).m();
                try {
                    field.set(obj, val);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                System.out.println(field.getName() + " -> " + val);
                System.out.println(field.getName() + " -> " + valM);
                System.out.println(obj.prefix);
            } else {
                System.out.println("don't have annotation");
            }
        }
    }
}
