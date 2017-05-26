package cn.dintama.common;

import org.springframework.stereotype.Component;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Dintama on 2017/5/25.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
@Documented
@Component
public @interface MybatisRepository {
    String value() default "";
}