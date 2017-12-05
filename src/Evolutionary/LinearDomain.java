package Evolutionary;

/**
 * @author 
 * @see Individual : in the Individual class is where everything is created.
 *
 * Model a linear function domain. Use the first half of the genome as the slope
 * with the second half as the y-intercept. The first bit of these respective halves
 * are a sign-bit, where 0 signifies positive and 1 negative
 **/
class LinearDomain extends AbstractDomain {

    private int SLOPE;
    private int INTERCEPT;
    private int NUMBER_OF_SAMPLES; // the number of samples to measure error

    /**
     * Construct an instance of this domain
     */
    public LinearDomain(int envSlope, int envIntercept){
        // set SLOPE and INTERCEPT to desired values for the environmental
    }

    /** 
     * Compute the error for the given individual's slope and intercept.
     * Decide if average error, absolute error, mean-squared error, or ...
     * based on NUMBER_OF_SAMPLES samples.
     * @param slope the slope encoded in the individual's genome
     * @param intercept the intercept encoded in the individual's genome
     * @return the error from a number of samples of the respective linear functions
     */
    private double measureError(int slope, int intercept){
    }

    /**
    * The method computeFitness will compute the fitness of an individual based on the errer
    * with respect to the specified environment.
    * @param gen
    * @return double - a number between 0 and 1, representing the fitness of the individual
    **/
    public double computeFitness(String genome){
        // extract the slope and intercept components from the genome
        // test the modeled function based on these components against the specified environment
        // convert the error found into a fitness measure (preferrably between 0 and 1)
        // return fitness
    }

}
