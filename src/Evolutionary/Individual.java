package Evolutionary;

import java.util.Comparator;
import java.util.Random;


/**
 * This class is going to create an id, genetic_makeup, and fitness_level for each Individual.
 **/
class Individual {
    private static Random random = new Random();
    private static int idGenerator = 0;
    private String genMak = "";
    private Double fitness;
    private int id;

    /**
     * @param domain an object that extends AbstractDomain and is particular to the application of this algorithm
     *               for example you could input a KingRookKing object type
     */
    Individual(AbstractDomain domain) throws Exception {
        this(domain , createBitString(domain));
    }
    
    /**
     * This constructor is going to call all the methods that will create:
     * 1) id
     * 2) genMak,
     * @param domain an object that extends AbstractDomain and is particular to the application of this algorithm
     *               for example you could input a KingRookKing object type
     * @param s a String object to set the genetic makeup of the individual
     **/
    Individual(AbstractDomain domain, String s) throws Exception {
        setId();
        genMak = s;
        setFitness(domain);
    }

    /**
     * create an id
     **/
    private void setId() {
        id = idGenerator++;
    }
    
    /**
     * create Fitness
     * @param domain an object that extends AbstractDomain and is particular to the application of this algorithm
     *               for example you could input a KingRookKing object type
     **/
    private void setFitness(AbstractDomain domain) throws Exception {
        fitness =  domain.computeFitness(genMak);
    }
    
    /**
     * create a bit string that is bitLength long that can be used for setting the genetic makeup of a new individual
     * @param domain an object that extends AbstractDomain and is particular to the application of this algorithm
     *               for example you could input a KingRookKing object type
     * @return String a random string that represents the genetic makeup              
     */
     private static String createBitString(AbstractDomain domain){
         int bitLen = domain.getBitLength();
         String bitString = "";
         while (bitLen != 0) {
             bitString+=random.nextInt(2);
             bitLen--;
         }
         return bitString;
     }

    /**
     *  This is going to randomly flip one bit if it is chosen to be mutated
     *  @param domain an object that extends AbstractDomain and is particular to the application of this algorithm
     *               for example you could input a KingRookKing object type
     **/
    void flipBit(AbstractDomain domain) throws Exception {
        int pos = random.nextInt(domain.getBitLength());
        StringBuilder myName = new StringBuilder(this.genMak);
        if(myName.charAt(pos) == '0'){
            myName.setCharAt(pos, '1');
        }
        else{
            myName.setCharAt(pos, '0');
        }
        genMak = String.valueOf(myName);
        fitness = domain.computeFitness(genMak);

    }
    
    /**
     * getFitness() will return the fitness of the individual
     * @return the fitness of the individual represented as a double
     **/
    Double getFitness(){
        return fitness;
    }
    
    /**
     * getGenMak() returns the genetic makeup of the individual
     * @return the genetic makeup of the individual as a String
     */
    String getGenMak(){
        return genMak;
    }
    
    /**
     * getId() returns the ID number of the individual
     * @return the ID number as an int
     */
    int getId(){
        return id;
    }
}

/**
 * This class defines a comparison method that will take two individuals and compare their fitnesses
 */
class IndividualComp implements Comparator<Individual> {
    /**
     * The compare() method will take two individuals and compare their two fitnesses, returning a value that
     * represents how the fitness of the first individual is related to the fitness of the second individual
     * @param e1 the first individual to be compared
     * @param e2 the second individual to be compared
     * @return -1, 0, or 1, where -1 represents "less than", 0 represents "equal to" and 1 represents "greater than"
     */
    @Override
    public int compare(Individual e1, Individual e2) {
        return  e1.getFitness().compareTo(e2.getFitness());
    }
}




