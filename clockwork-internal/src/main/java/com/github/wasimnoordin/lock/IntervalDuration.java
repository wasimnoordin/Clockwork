package com.github.wasimnoordin.lock;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;;

/**
 * Defines the interval for lock refresh or expiration.
 * Allows setting the interval duration and its time unit.
*/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IntervalDuration {
    
    /**
     * Specifies the interval duration.
     * Supports dynamic values through property placeholders, i.e. {@code ${islocked.intervalduration}}.
     */

    String duration();

   /**
   * The interval is defined using the {@link TimeUnit}, 
   * with the value obtained from the {@link #duration() method}.
   */

    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;
}
