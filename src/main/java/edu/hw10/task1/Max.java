package edu.hw10.task1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Max {
    int value() default Integer.MAX_VALUE;
}
