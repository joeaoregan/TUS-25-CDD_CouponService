/*
 * Joe O'Regan
 * A00258304
 * Assignment 1
 * 2/11/2025
 * 
 * Work.java
 * A thread that does some random CPU work for a set time
 */

package com.tus.coupon;

import java.io.IOException;

public class ApplyLoad extends Thread {

	private static int NUMBER_OF_MINUTES = 2; // Length of time in minutes to apply load
	private static long RUN_TIME = NUMBER_OF_MINUTES * 60 * 1000;

	private static long start = 0L;
	long last = 0L;
	int counter = 0;

	public void cpuStuff() throws IOException {
		start = last = System.nanoTime();

		while (true) {
			if (System.nanoTime() >= last + 1000) {
				last = System.nanoTime();
				System.out.println(++counter + " seconds, counting for the sake of it!");
			}

			if (System.nanoTime() > start + RUN_TIME) {
				System.out.println("I've wasted enough of my own time!");
				break;
			} else {
				Book book = new Book(start);
				book.read();
			}
		}
	}

	@Override
	public void run() {
		System.out.println("This code is running in a thread");
		try {
			cpuStuff();
		} catch (IOException e) {
			System.out.println("More than likely file not found!!!");
			e.printStackTrace();
		}
		System.out.println("Finshed random CPU test!");
	}
}