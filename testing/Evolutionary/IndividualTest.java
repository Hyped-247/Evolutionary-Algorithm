package Evolutionary;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IndividualTest {
    private Domain domain = new Domain();
    private Individual individual;
    private String genMek = "010101";

    @Before
    public void initialize() throws Exception {
        domain.initializeDomain(100,10,5,15,20,
                0.8,0.9);
        individual = new Individual(domain, genMek);
    }


    @Test
    public void flipBit() throws Exception {




    }

    @Test
    public void getFitness() throws Exception {
            assertEquals(String.valueOf(0.5), String.valueOf(individual.getFitness()));
    }

    @Test
    public void getId() throws Exception {
        assertEquals( 1, individual.getId());
    }

    @Test
    public void getGenMak() throws Exception {
        assertEquals(genMek, individual.getGenMak());
    }

}