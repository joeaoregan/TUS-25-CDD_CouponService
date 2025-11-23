/*
 * @author Joe O'Regan
 * A00258304
 * Assignment 1
 * 
 * CpuStressFactorial.java
 * Adding CPU Stress via Factorial Calculation
 */
package com.tus.coupon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CpuStressFibonacci {

    // Inefficient recursive implementation (hopefully)
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

//    public static void main(String[] args) throws InterruptedException {
    public void doit() throws InterruptedException {
        // Set a large number for calculation; 45 is a good start for a significant delay
        // Going much higher may cause a stack overflow
        final int fibNumber = 45;

        // Use all available CPU cores to maximize load
        int numCores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numCores);

        System.out.printf("Starting CPU stress test on %d cores. Calculating fibonacci (%d)...\n", numCores, fibNumber);

        // Submit tasks to each thread
        for (int i = 0; i < numCores; i++) {
            executor.submit(() -> {
                try {
                    long result = fibonacci(fibNumber);
                    System.out.printf("Thread %s completed. Result: %d\n", Thread.currentThread().getName(), result);
                } catch (StackOverflowError e) {
                    System.err.printf("Thread %s encountered a stack overflow. Consider a smaller input.\n", Thread.currentThread().getName());
                }
            });
        }

        // Shut down the executor and wait for tasks to complete
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("Stress test finished.");
    }
}
