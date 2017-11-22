package Evolutionary;

import java.util.Comparator;
import java.util.Random;

/**
 * This class is going to create an id, genetic_makeup, and fitness_level for each Individual.
 **/
class Individual {
    private static int idGenerator = 0;
    private Random rand = new Random();
    private String genMak = "";
    private Double fitness;
    private int id;

    /**
     * This constructor is going to call all the methods that will create:
     * 1) id
     * 2) genMak,
     **/
    Individual(String s) {
        genMak = s;
        setId();

    }

    Individual(Domain domain) {
        setId();
        setGenMak(domain);
        setfitness
        computeFitness(genMak);
    }

    /**
     * create an id
     **/
    private void setId() {
        id = idGenerator++;
    }

    /**
     * create genMak
     **/
    // This method is going to create a random string that is 8 digits long of 0's and 1's.
    private void setGenMak(Domain domain) {
        int bitLen = domain.getBitLength();
        while (bitLen != 0) {
            genMak+=rand.nextInt(2);
            bitLen--;
        }
    }

    // This is going to randomly flip one bit if it is chosen to be mutated
    void flipBit(Domain domain){
        int pos = rand.nextInt(domain.getBitLength());
        String second = "0";
        if (genMak.charAt(pos) == '0'){
            second = "1";
        }
        String first = genMak.substring(0, pos - 1);
        String third = genMak.substring(pos + 1);
        genMak = first + second + third;
    }
    /**
     * getFitness return
     */
    Double getFitness(){
        return fitness;
    }
    int getId(){
        return id;
    }
    String getGenMak(){
        return genMak;
    }
}
class IndividualComp implements Comparator<Individual> {
    @Override
    public int compare(Individual e1, Individual e2) {
        return e1.getFitness().compareTo(e2.getFitness());
    }
}

