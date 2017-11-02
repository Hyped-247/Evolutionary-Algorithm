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
    
    public static double surRatio = 0.2; // The percentage of individuals who will survive to the next generation
    public static double mutRate = 0.02; // The percentage of individuals who will undergo a mutation between generations
    
    /**
     * getBitLength returns the length of the string representing the genome of an individual
     * @param 
     */
    public int getBitLength(int i){
        return bitLength;
    }
    
    public int getPopSize(int i){
        return popSize;
    }
    
    public int getCrossNum(int i){
        return crossNum;
    }
    
    public int getGenNum(int i){
        return genNum;
    }
    
    public double getSurRatio(double d){
        return surRatio;
    }
    
    public double getMutRate(double d){
        return mutRate;
    }
    
    public void initializeDomain(int bitLength, int popSize, int crossNum, int genNum, double surRatio, double mutationRate){
        this.bitLength = bitLength;
        this.popSize = popSize;
        this.crossNum = crossNum;
        this.genNum = genNum;
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
