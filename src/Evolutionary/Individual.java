package Evolutionary;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * This class is going to create an id, genetic_makeup, and fitness_level for each Individual.
 **/
class Individual {
    private static int idGenerator = 0;
    private String genMak;
    private double fitness = 0.0;
    private static int id;
    private Domain mo = new Domain(); 

    /**
     * This constructor is going to call all the methods that will create:
     * 1) id
     * 2) genMak,
     **/
    Individual(String s){
        genMak = s;
        setId();
    }
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
        String s = "";
        x = Random();
        for(mo.getBitLength()){
            float y = x.nextFloat();
            if(y > 0.5){
                s = s + "0";
            }
            else{
                s = s + "1";
            }
        }
    }

    /**
     * create a fitness level
     **/
    private setFitness(double d){
        fitness = d;
    }
    
    /**
     * getFitness return 
     */
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
