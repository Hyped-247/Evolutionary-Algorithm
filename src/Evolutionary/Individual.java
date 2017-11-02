package Evolutionary;

import java.util.Collections;
import java.util.LinkedList;


/**
 * This class is going to create an id, genetic_makeup, and fitness_level for each Individual.
 **/
class Individual {
    private static int idGenerator = 0;
    private String genMak;
    private double fitness = 0.0;
    private static int id;

    /**
     * This constructor is going to call all the methods that will create:
     * 1) id
     * 2) genMak,
     **/
    Individual(){
        setId();
        setGenMak();
    }
    
    /**
     * create an id
     **/
    private void  setId(){
        id = idGenerator++;
    }
    
    /**
     * create genMak
     **/
    // This method is going to create a random string that is 8 digits long of 0's and 1's.
    private void setGenMak(){
        genMak =  Integer.toBinaryString(128 + (int) (127 * Math.random()));
    }

    /**
     * create a fitness level
     **/
    private setFitness(double d){
        fitness = d;
    
    double getFitness(){
        return fitness;
    }
    int getId(){
        return id;
    }
    String getGenMak(){
        return genMak;
    }

}
