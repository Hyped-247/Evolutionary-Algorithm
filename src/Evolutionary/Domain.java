package Evolutionary;

import java.util.Collections;

public class Domain extends AbstractDomain{
    /**
    * These are global variables that can be changed by the user of this program.
    **/
    public static int bitLength = 8; // The number of bits in the genome of each individual
    public static int popSize = 100; // The number of individuals in the population
    public static int crossNum = 3; // The number of crossover location to be used in reproduction
    public static int genNum = 100; // The number of generations the test should run for
    public static int tournamentSize = 5; // The number of individuals in each survival tournament
    
    public static double surRatio = 0.2; // The percentage of individuals who will survive to the next generation
    public static double mutRate = 0.02; // The percentage of individuals who will undergo a mutation between generations
    
    /**
     * getBitLength returns the length of the string representing the genome of an individual
     * @return int - the length of the bit string
     */
    public int getBitLength(){
        return bitLength;
    }
    
    /**
     * getPPopSize returns the size of the population
     * @return int - the size of population
     */
    public int getPopSize(){
        return popSize;
    }
    
    /**
     * getCrossNum returns the number of crossovers that should be used in reproduction
     * @return int - the number of crossovers
     */
    public int getCrossNum(){
        return crossNum;
    }
    
    /**
     * getGenNum return the number of generations to be run
     * @return int - the number of generations
     */
    public int getGenNum(){
        return genNum;
    }
    
    /**
     * getSurRatio returns the ratio of the population that will survive to the next generation
     * @return double - the percentage of the population that will survive
     **/
    public double getSurRatio(){
        return surRatio;
    }
    
    /**
     * getMutRate will return the percentage of people that will undergo mutations between generations
     * @return double - the percentage of the population that will undergo mutations
     */
    public double getMutRate(){
        return mutRate;
    }
    
    /**
     * initializeDomain will set all of the 
     */
    public void initializeDomain(int bitLength, int popSize, int crossNum, int genNum, int tournamentSize, double surRatio, double mutationRate){
        this.bitLength = bitLength;
        this.popSize = popSize;
        this.crossNum = crossNum;
        this.genNum = genNum;
        this.tournamentSize = tournamentSize;
        this.surRatio = surRatio;
        this.mutationRate = mutationRate;
        
    }
    
    /**
    * The method computeFitness will compute the fitness of an individual based on the number of ones in the
    * bit string representing its genome.
    * @param individual - the individual whose fitness is to be calculated
    * @return double - a number between 0 and 1, representing the fitness of the individual
    **/
    public double computeFitness(Individual i){
        String gen = i.getGenMak();
        int ones = gen.length() - gen.replaceAll("1", "").length();
        return ones / 8.0;
    }
}
