package com.github.wasimnoordin.lock;

import com.github.wasimnoordin.lock.IntervalDuration;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

class TestIntervalDurations {

    @IntervalDuration(duration = "10", timeUnit = TimeUnit.SECONDS)
    public void annotatedMethod() {
        // Method content is irrelevant for the annotation test
    }

    @Test
    void testAnnotationPresence() throws NoSuchMethodException {
        Method method = this.getClass().getDeclaredMethod("annotatedMethod");
        assertTrue(method.isAnnotationPresent(IntervalDuration.class), "Method is not annotated with IntervalDuration as expected.");
    }

    @Test
    void testAnnotationValues() throws NoSuchMethodException {
        Method method = this.getClass().getDeclaredMethod("annotatedMethod");
        IntervalDuration intervalDuration = method.getAnnotation(IntervalDuration.class);

        assertEquals("10", intervalDuration.duration(), "Duration value mismatch.");
        assertEquals(TimeUnit.SECONDS, intervalDuration.timeUnit(), "TimeUnit value mismatch.");
    }
}
