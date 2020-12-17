package com.github.quliq.itext.itext;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class ItextApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ItextApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        print("\n");
        print("Enter number of length: ");
        Scanner scanner = new Scanner(System.in);
        Long length = scanner.nextLong();
        print("Length is " + length);
        if (length > 0) {
            String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            Random random = new Random();
            try {
                String fileName = "random-text.txt";
                FileWriter myWriter = new FileWriter(fileName);
                for (long i = 0; i < length; i++) {
                    myWriter.write(String.valueOf(chars.charAt(random.nextInt(chars.length()))));
                }
                myWriter.close();
                print("Successfully wrote to the file " + fileName);
            } catch (IOException e) {
                print("An error occurred.");
                e.printStackTrace();
            }

        } else {
            print("the Number must be greater than 0");
        }
    }

    private void print(String words) {
        System.out.println(words);
    }
}
