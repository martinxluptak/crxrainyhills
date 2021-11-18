package com.luptak.crxrainyhills;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Runs CrxrainyhillsApplication as a command line only application.
 */
@Component
@ConditionalOnNotWebApplication
public class RainyHillsCommandLineRunner implements CommandLineRunner {

    RainCalculator rainCalculator = new RainCalculatorImpl();

    /**
     * Run the RainCalculator algorithm by accepting command line arguments.
     *
     * @param args Command line argument strings.
     */
    @Override
    public void run(String... args) {
        if (args.length != 1) {
            System.out.println("Please input a comma-separated integer list as a command line argument.");
            return;
        }

        int[] numberArray;
        try {
            // Convert comma-separated string argument to an array of integers
            numberArray = Arrays.stream(args[0].split(",")).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException e) {
            System.out.println("Please do not include strings in the comma-separated integer list argument.");
            return;
        }

        int result = rainCalculator.getMaxWater(numberArray);

        // Print the result to stdout.
        System.out.println(result);
    }
}