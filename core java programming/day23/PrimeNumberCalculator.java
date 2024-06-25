package day23;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumberCalculator {


	 private static final String OUTPUT_FILE = "primes.txt";

	    public static void main(String[] args) {
	        int upperLimit = 100; // Calculate prime numbers up to this limit

	        // Calculate prime numbers using Java Streams and parallel streams
	        List<Integer> primes = IntStream.rangeClosed(2, upperLimit)
	                .parallel()
	                .filter(PrimeNumberCalculator::isPrime)
	                .boxed()
	                .collect(Collectors.toList());

	        // Asynchronously write the prime numbers to a file
	        CompletableFuture<Void> writeToFileFuture = CompletableFuture.runAsync(() -> {
	            writePrimesToFile(primes);
	        });

	        // Wait for the file write operation to complete
	        writeToFileFuture.thenRun(() -> {
	            System.out.println("Prime numbers calculation and file write completed.");
	        }).join(); // Wait for the CompletableFuture to complete
	    }

	    // Method to check if a number is prime
	    private static boolean isPrime(int num) {
	        if (num <= 1) {
	            return false;
	        }
	        for (int i = 2; i <= Math.sqrt(num); i++) {
	            if (num % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }

	    // Method to write prime numbers to file
	    private static void writePrimesToFile(List<Integer> primes) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
	            for (int prime : primes) {
	                writer.write(String.valueOf(prime));
	                writer.newLine();
	            }
	            System.out.println("Prime numbers written to file: " + OUTPUT_FILE);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}