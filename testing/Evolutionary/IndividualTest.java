package Evolutionary;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mohammad on 10/27/17.
 */
public class IndividualTest {
    // we can test these but it does not make sense since they are all random.

    Population population = new Population(34);


    @Test
    public void getFitness_level() throws Exception {

    }

    @Test
    public void getIndividual_id() throws Exception {
        for (int i = 0; i < population.getIndividuals().size(); i++) {
            System.out.println( population.getIndividuals().get(i).getIndividual_id());
        }
        System.out.println("test pass");
    }

    @Test
    public void getGenetic_makeup_string() throws Exception {

    }

    @Test
    public void getGenetic_makeup_list() throws Exception {

    }

}