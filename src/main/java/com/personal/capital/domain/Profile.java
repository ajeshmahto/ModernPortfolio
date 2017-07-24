package com.personal.capital.domain;

/**
 * Created by ajesh on 7/23/17.
 * Pojo class to represent  type of Profile for Investment
 */
public class Profile {

    private double mean;
    private double sd;

    /**
     * Get the Mean of this profile
     * @return this profile's mean (average)
     */
    public double getMean() {
        return mean;
    }

    /**
     * Sets the mean of this profile
     * @param mean - mean of the profile
     */
    public void setMean(double mean) {
        this.mean = mean;
    }

    /**
     * Get the Standard Deviation of profile
     * @return this profile's Standard Deviation
     */
    public double getSd() {
        return sd;
    }

    /**
     * Sets the Standard Deviation of profile
     * @param sd  standard deviation of this profile
     */
    public void setSd(double sd) {
        this.sd = sd;
    }
}

