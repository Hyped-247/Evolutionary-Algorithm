package Evolutionary;

import java.util.Collections;
import java.util.LinkedList;


/**
 * @author Mo
 * This class is going to create an id, genetic_makeup, and fitness_level for each Individual.
 **/
class Individual {
    private LinkedList<String> genetic_makeup_list = new LinkedList<>();
    private static int id_generator=0;
    private String genetic_makeup;
    private double fitness_level;
    private int individual_id;

    /**
     * This constructor is going to call all the methods that will create:
     * 1) id,
     * 2) genetic_makeup,
     * 3) fitness_level
     **/
    Individual(){
        set_getIndividual_id_per_individual();
        set_genetic_makeup_per_individual();
        setGenetic_makeup_list();
        set_fitness_level_per_individual();
    }
    /**
     * create an id
     **/
    private void  set_getIndividual_id_per_individual(){
        individual_id = id_generator++;
    }
    /**
     * create genetic_makeup
     **/
    // This method is going to create a random string that is 8 digits long of 0's and 1's.
    // Todo: the len is an argument.
    private String set_genetic_makeup_per_individual(){
        genetic_makeup =  Integer.toBinaryString(128 + (int) (127 * Math.random()));
        return genetic_makeup;
    }
    /**
     * create a fitness level
     **/
    // Todo: you might wanna fix the math.
    private double set_fitness_level_per_individual(){
        fitness_level =  Collections.frequency(getGenetic_makeup_list(), "1");
        return fitness_level / 8.0;
    }
    /**
     * turn the genetic_makeup string to an LinkedList in such each chat is an holds one index.
     **/
    private void setGenetic_makeup_list(){
        Collections.addAll(genetic_makeup_list, getGenetic_makeup_string().split(""));
    }
    double getFitness_level(){
        return fitness_level;
    }
    int getIndividual_id(){
        return individual_id;
    }
    String getGenetic_makeup_string(){
        return genetic_makeup;
    }
    LinkedList<String> getGenetic_makeup_list(){
        return genetic_makeup_list;
    }

}
