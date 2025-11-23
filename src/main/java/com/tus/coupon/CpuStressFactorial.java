/*
 * @author Joe O'Regan
 * A00258304
 * Assignment 1
 * 
 * CpuStressFactorial.java
 * Adding CPU Stress via Factorial Calculation
 */
package com.tus.coupon;

import java.math.BigInteger;

public class CpuStressFactorial extends Thread {

	private static int RUN_TIME = 11 * 60 * 1000;

	long start = 0L;
	long last = 0L;

	public BigInteger factorialUsingRecursion(BigInteger n) {
		if (start + RUN_TIME > System.nanoTime()) { // Stop after 3 minutes, and return current n value
			return n;
		}
		if (n.intValue() <= 2) {
			return n;
		}
		return n.multiply(factorialUsingRecursion(n.subtract(new BigInteger("1"))));
	}

	@Override
	public void run() {
		start = last = System.nanoTime();
		
		System.out.println("Factorial of 1,000,000 CPU Stress Start...");
		factorialUsingRecursion(new BigInteger("1000000"));
		System.out.println("Factorial CPU Stress Finished!");
	}
}