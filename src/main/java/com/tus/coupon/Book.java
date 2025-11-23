/*
 * @author Joe O'Regan
 * A00258304
 * Assignment 1
 * 2/11/2025
 * 
 * Book.java
 * Reading a book from a text file and counting words, sentences, characters, paragraphs, and whitespaces
 */
package com.tus.coupon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Book {
	private static long start = 0L;
	private static int NUMBER_OF_MINUTES = 2; // Length of time in minutes to apply load
	private static long RUN_TIME = NUMBER_OF_MINUTES * 60 * 1000;
	
	public Book(long startTime) {
		Book.start = startTime;
	}
	
	/*
	 * Not enough stress on CPU, adding more with Factorials
	 */
	private BigInteger factorialStress() {
        // Factorial calculation is computationally expensive.
        final int FACTORIAL_NUMBER = 1000; 
        final int REPETITIONS = 10;
        BigInteger result = BigInteger.ONE;

        for (int j = 0; j < REPETITIONS; j++) {
            result = BigInteger.ONE;
            for (int i = 2; i <= FACTORIAL_NUMBER; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
        }
        return result; // Return to prevent the calculation from being optimized away
    }

//	private static int RUN_TIME = 11 * 60 * 1000;
//	long start = 0L;
//	long last = 0L;
//
//	public BigInteger factorialUsingRecursion(BigInteger n) {
//		if (start + RUN_TIME > System.nanoTime()) { // Stop after 3 minutes, and return current n value
//			return n;
//		}
//		if (n.intValue() <= 2) {
//			return n;
//		}
//		return n.multiply(factorialUsingRecursion(n.subtract(new BigInteger("1"))));
//	}

	public void read() throws IOException {
		for (int i = 0; i < 5000; i++) {
			// File file = new File("alice.txt");
			File file = new File("./alice.txt");
			FileInputStream fileInputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String line;
			int wordCount = 0;
			int characterCount = 0;
			int paraCount = 0;
			int whiteSpaceCount = 0;
			int sentenceCount = 0;
			
			try {
				while ((line = bufferedReader.readLine()) != null) {

					if (System.nanoTime() > start + RUN_TIME) {
						System.out.println("I've wasted enough of my own time!");
						break;
					}
					
					System.out.println(line);
					
					// Adding factorial every time a line is read from the file 
					factorialStress();
					
					// Pointless string operations to waste memory
					line.toUpperCase();
					line.toLowerCase();
					
					
					if (line.equals("")) {
						paraCount += 1;
					} else {
						characterCount += line.length();
						String words[] = line.split("\\s+");
						wordCount += words.length;
						whiteSpaceCount += wordCount - 1;
						String sentence[] = line.split("[!?.:]+");
						sentenceCount += sentence.length;
					}
				}

				if (sentenceCount >= 1) {
					paraCount++;
				}

				System.out.println("Total word count = " + wordCount);
				System.out.println("Total number of sentences = " + sentenceCount);
				System.out.println("Total number of characters = " + characterCount);
				System.out.println("Number of paragraphs = " + paraCount);
				System.out.println("Total number of whitespaces = " + whiteSpaceCount);
			} catch (FileNotFoundException ex) {
				System.out.println(ex);
				System.out.println("File alice.txt not found.");
			} catch (IOException ex) {
				System.out.println(ex);
			} finally {
				bufferedReader.close();
			}
		}
	}
}