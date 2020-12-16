package com.github.quliq.itext.itext;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class ItextApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ItextApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number: ");
		int number = scanner.nextInt();
		System.out.println("Number is " + number);
		if (number > 0) {
			StringBuilder dataText = new StringBuilder();
			for (int i = 1; i <= number; i++) {
				dataText.append(i).append("\n");
			}
			try {
				String fileName = "number-" + number + ".txt";
				FileWriter myWriter = new FileWriter(fileName);
				myWriter.write(String.valueOf(dataText));
				myWriter.close();
				System.out.println("Successfully wrote to the file " + fileName);
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		} else {
			System.out.print("the Number must be greater than 0");
		}

	}
}
