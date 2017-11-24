package Evolutionary;
import org.apache.commons.lang3.StringUtils;

/**
 * @author 
 * @see Individual : in the Individual class is where everything is created.
 *
 **/
class Domain extends AbstractDomain {

    /**
    * The method computeFitness will compute the fitness of an individual based on the number of ones in the
    * bit string representing its genome.
    * @param gen
     * @return double - a number between 0 and 1, representing the fitness of the individual
    **/
    public double computeFitness(String gen){
       return (double) StringUtils.countMatches(gen, "1") / gen.length();
    }
}
