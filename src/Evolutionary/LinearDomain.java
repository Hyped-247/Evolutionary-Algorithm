package Evolutionary;

import java.util.Random;

/**
 * @author 
 * @see Individual : in the Individual class is where everything is created.
 *
 * Model a linear function domain. Use the first half of the genome as the slope
 * with the second half as the y-intercept. The first bit of these respective halves
 * are a sign-bit, where 0 signifies positive and 1 negative
 * 
 * As of right now we are assuming that the bit string is length 16
 **/
class LinearDomain extends AbstractDomain {

    private int SLOPE;
    private int INTERCEPT;
    private int NUMBER_OF_SAMPLES = 100; // the number of samples to measure error
    Random rand = new Random();
    private int totalError;
    double fitness;
    double MAX_ERROR = (255.0 * 99.0 + 255.0) * 100.0; //max slope = 255, max intercept = 255, max rand int = 99, run 100 times

    /**
     * Construct an instance of this domain
     */
    public LinearDomain(int envSlope, int envIntercept){
        // set SLOPE and INTERCEPT to desired values for the environmental
    	INTERCEPT = envIntercept;
    	SLOPE = envSlope;
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
    	totalError = 0;
    	for(int i = 0; i < NUMBER_OF_SAMPLES; i++){
    		int x = rand.nextInt(100);
    		int yGenome = (slope * x) + intercept;
    		
    		int yActual = (SLOPE*x) + INTERCEPT;
    		
    		totalError += Math.abs(yActual - yGenome);
    		
    		
    	}
    	
    	return (double)totalError;
    	
    }

    /**
    * The method computeFitness will compute the fitness of an individual based on the error
    * with respect to the specified environment.
    * @param gen
    * @return double - a number between 0 and 1, representing the fitness of the individual
    **/
    public double computeFitness(String genome){
        // extract the slope and intercept components from the genome
        // test the modeled function based on these components against the specified environment
        // convert the error found into a fitness measure (preferrably between 0 and 1)
        // return fitness
    	int genomeSlope = Integer.parseInt(genome.substring(0, (genome.length() / 2)), 2);
    	int genomeIntercept = Integer.parseInt(genome.substring((genome.length() / 2)), 2);
    	double individualError = measureError(genomeSlope, genomeIntercept);
    	
        
        
        	
        fitness = individualError/MAX_ERROR;
        
    	
    	return fitness;
    	
    }

}
