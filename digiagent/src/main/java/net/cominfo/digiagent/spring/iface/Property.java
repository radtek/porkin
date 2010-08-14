package net.cominfo.digiagent.spring.iface;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) 
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface Property {
    String key();
    String defaultValue() default "";
}