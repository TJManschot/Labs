package nl.belastingdienst.h12.opgave4;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface NestedClass {
    String value() default "My goodness, do we really need to nest?";
}
