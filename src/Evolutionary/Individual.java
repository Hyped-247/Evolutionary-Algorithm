package Evolutionary;

import java.util.Comparator;
import java.util.Random;


/**
 * This class is going to create an id, genetic_makeup, and fitness_level for each Individual.
 **/
class Individual {
    private Random rand = new Random();
    private static int idGenerator = 0;
    private String genMak = "";
    private Double fitness;
    private int id;

    /**
     * This constructor is going to call all the methods that will create:
     * 1) id
     * 2) genMak,
     * @param domain an object that extends AbstractDomain and is particular to the application of this algorithm
     *               for example you could input a KingRookKing object type
     * @param s a String object to set the genetic makeup of the individual
     **/
    Individual(AbstractDomain domain, String s) {
        setId();
        genMak = s;
        setFitness(domain);
    }
    /**
     * @param domain an object that extends AbstractDomain and is particular to the application of this algorithm
     *               for example you could input a KingRookKing object type
     */
    Individual(AbstractDomain domain) {
        setId();
        setGenMak(domain);
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
    private void setFitness(AbstractDomain domain) {
        fitness =  domain.computeFitness(genMak);
    }
    /**
     * create genMak
     * @param domain an object that extends AbstractDomain and is particular to the application of this algorithm
     *               for example you could input a KingRookKing object type
     **/

    private void setGenMak(AbstractDomain domain) {
        int bitLen = domain.getBitLength();
        while (bitLen != 0) {
            genMak+=rand.nextInt(2);
            bitLen--;

        }
    }
    /**
     *  This is going to randomly flip one bit if it is chosen to be mutated
     *  @param domain an object that extends AbstractDomain and is particular to the application of this algorithm
     *               for example you could input a KingRookKing object type
     **/
    void flipBit(AbstractDomain domain){
        int pos = rand.nextInt(domain.getBitLength());
        StringBuilder myName = new StringBuilder(this.genMak);
        myName.setCharAt(pos, '1');
        genMak = String.valueOf(myName);
        fitness = domain.computeFitness(genMak);

    }
    Double getFitness(){
        return fitness;
    }
    String getGenMak(){
        return genMak;
    }
    int getId(){
        return id;
    }
}
class IndividualComp implements Comparator<Individual> {
    @Override
    public int compare(Individual e1, Individual e2) {
        return  e1.getFitness().compareTo(e2.getFitness());
    }
}

