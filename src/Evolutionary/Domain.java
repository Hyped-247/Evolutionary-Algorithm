package Evolutionary;


/**
 * @author 
 * @see Individual : in the Individual class is where everything is created.
 *
 **/
class Domain extends AbstractDomain {

    /**
    * The method computeFitness will compute the fitness of an individual based on the number of ones in the
    * bit string representing its genome.
    * @param individual - the individual whose fitness is to be calculated
    * @return double - a number between 0 and 1, representing the fitness of the individual
    **/
    @Override
    public double computeFitness(Individual i){
        String gen = i.getGenMak();
        int ones = gen.length() - gen.replaceAll("1", "").length();
        return ones / 8.0;

    }
}
