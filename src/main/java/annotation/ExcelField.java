package annotation;

import java.lang.annotation.*;

/**
 * Created by gongthomas on 2018/1/23.
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelField {

    int index();
}
