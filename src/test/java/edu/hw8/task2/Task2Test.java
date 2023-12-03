package edu.hw8.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task2Test {

    @Test
    @DisplayName("FixedThreadPool работает")
    void test1() {
        // Given
        FixedThreadPool fixedThreadPool = new FixedThreadPool(2);

        // Then
        fixedThreadPool.start();
        fixedThreadPool.execute(new FibonacciNumber(4));
        fixedThreadPool.execute(new FibonacciNumber(5));
        fixedThreadPool.execute(new FibonacciNumber(6));
        fixedThreadPool.execute(new FibonacciNumber(7));

        try {
            fixedThreadPool.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
