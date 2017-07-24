package com.personal.capital.utility;

/**
 * Created by ajesh on 7/23/17.
 * This class is utility Math class which has Static functions for calculating mean, median, Standard Deviation
 */
public class MathUtility {

    /**
     * Calculates and return mean from the given double Array numbers
     * @param numbers - double Array numbers
     * @return - return double number
     */

    public static double mean(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }

        if (numbers.length > 0) return sum / numbers.length;
        else return 0;
    }

    /**
     * Calculates and return median from the given double Array numbers
     * @param numbers - double Array numbers
     * @return - return double number
     */

    public static double median(double[] numbers) {
        double median;

        if(numbers.length>0){
            // For array size even length, median is average of n/2 + n/2 -1 position .
            if (numbers.length % 2 == 0) {
                median = (numbers[numbers.length / 2] + numbers[numbers.length / 2 - 1]) / 2;

            } else {
                median = numbers[numbers.length / 2]; // if array size is odd
            }
            return median;
        }
       else return  0.0;

    }

    /**
     * Calculates and return Standard Deviation from the given double Array numbers
     * @param numbers - double Array numbers
     * @return - return double number
     */

    public static double standardDeviation(double[] numbers) {
        double mean = mean(numbers); // Using mean function to calculate the mean of numbers.
        double squaredVariations[] = new double[numbers.length];
        // Calculate the squared variation of numbers to be used for calculating standard variation
        for (int i = 0; i < numbers.length; i++) {
            double var = mean - numbers[i];
            squaredVariations[i] = (Math.pow(var, 2));
        }
        double varMean = mean(squaredVariations);
        return Math.sqrt(varMean);
    }
}
