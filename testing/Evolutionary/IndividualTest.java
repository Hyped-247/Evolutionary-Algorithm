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
    public void getGenMak() throws Exception {
        assertEquals(genMek, individual.getGenMak());
    }

    @Test
    public void FirstIndividualTest() throws Exception {
        try{
            individual = new Individual(domain, "1010m10"); // There is an "m"
            fail("Exception not thrown");
        }catch(Exception e){
            System.out.println("The string can only be 0's and 1's");
        }
    }
    @Test
    public void SecondIndividualTest() throws Exception {
        individual = new Individual(domain, null);
    }
    @Test
    public void ThirdIndividualTest() throws Exception {
        try{
            individual = new Individual(domain, "?????????");
            fail("Exception not thrown");
        }catch(Exception e){
            System.out.println("The string can only be 0's and 1's");
        }
    }
    @Test
    public void ForthIndividualTest() throws Exception {
        try{
            individual = new Individual(domain, "101012010"); // There is an "2"
            fail("Exception not thrown");
        }catch(Exception e){
            System.out.println("The string can only be 0's and 1's");
        }
    }
    @Test
    public void FifthIndividualTest() throws Exception {
        try{
            individual = new Individual(domain, "1010 10");  // There should be no spaces.
            fail("Exception not thrown");
        }catch(Exception e){
            System.out.println("The string can only be 0's and 1's");
        }
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
}
