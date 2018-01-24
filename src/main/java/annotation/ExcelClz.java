package annotation;

import java.lang.annotation.*;

/**
 * Created by gongthomas on 2018/1/23.
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ExcelClz {

    int startRow();
}
