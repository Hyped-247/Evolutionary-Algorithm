package Evolutionary;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class DomainTest {
    private Domain domain = new Domain();
    private Main main = new Main();

    @Before
    public void initialize() throws Exception {
        domain.initializeDomain(100,10000,5,15,20,
                0.8,0.9);
    }

    @Test
    public void computeFitness() throws Exception {
        /*
        ArrayList<Individual> initPop = main.createInitPop(domain.getPopSize(), domain);
        for (int i = 0; i < initPop.size() - 1 ; i++) {
            String gen = initPop.get(i).getGenMak();
            Double ans = (double) StringUtils.countMatches(gen, "1") / gen.length();
            assertEquals(String.valueOf(ans), String.valueOf(initPop.get(i).getFitness()));
        }
        */
    }
}