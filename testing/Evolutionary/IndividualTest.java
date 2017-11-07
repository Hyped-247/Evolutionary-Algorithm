package Evolutionary;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mohammad on 10/27/17.
 */
public class IndividualTest {
    // we can test these but it does not make sense since they are all random.
    @Test
    public void getFitness_level() throws Exception {

    }

    @Test
    public void getIndividual_id() throws Exception {

    }

    @Test
    public void getGenetic_makeup_string() throws Exception {
      Random rand = new Random();
      for (int i=0; i<100; i++) {
        String bitString = new String ((String.valueOf(rand.nextInt(2))) +
                                       (String.valueOf(rand.nextInt(2))) +
                                       (String.valueOf(rand.nextInt(2))) +
                                       (String.valueOf(rand.nextInt(2))) +
                                       (String.valueOf(rand.nextInt(2))) +
                                       (String.valueOf(rand.nextInt(2))) +
                                       (String.valueOf(rand.nextInt(2))) +
                                       (String.valueOf(rand.nextInt(2))));
        Individual indi = new Individual(bitString);
        assertEquals(indi.getGenMak(), bitString);
      }
    }


}
