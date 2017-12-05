package Evolutionary;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class DomainTest {
    private AbstractDomain domain = new AbstractDomain();
    private Main main = new Main();

    @Before
    public void initialize() throws Exception {
        domain.initializeDomain(100,10000,5,15,20,
                0.8,0.9);
    }

    @Test
    public void FirstComputeFitnessTest() throws Exception {
        ArrayList<Individual> initPop = main.createInitPop(domain.getPopSize(), domain);
        for (int i = 0; i < initPop.size() - 1 ; i++) {
            String gen = initPop.get(i).getGenMak();
            int ones = gen.length() - gen.replaceAll("1", "").length();
            assertEquals(String.valueOf(domain.computeFitness(gen)),
                    String.valueOf(((double)ones) / gen.length()));
        }
    }
    @Test
    public void SecondComputeFitnessTest() throws Exception {
            domain.computeFitness(null);
        }
    @Test
    public void ThirdComputeFitnessTest() throws Exception {
        try{
            domain.computeFitness("?????????");
            fail("Exception not thrown");
        }catch(Exception e){
            System.out.println("The string can only be 0's and 1's");
        }
    }
    @Test
    public void ForthComputeFitnessTest() throws Exception {
        try{
            domain.computeFitness("101012010"); // There is an "2"
            fail("Exception not thrown");
        }catch(Exception e){
            System.out.println("The string can only be 0's and 1's");
        }
    }
    @Test
    public void FifthComputeFitnessTest() throws Exception {
        try{
            domain.computeFitness("1010m10"); // There is an "m"
            fail("Exception not thrown");
        }catch(Exception e){
            System.out.println("The string can only be 0's and 1's");
        }
    }
    @Test
    public void SixthComputeFitnessTest() throws Exception {
        try{
            domain.computeFitness("1010 10"); // There should be no spaces.
            fail("Exception not thrown");
        }catch(Exception e){
            System.out.println("The string can only be 0's and 1's");
        }
    }
}