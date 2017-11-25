package Evolutionary;

import org.junit.Before;
import org.junit.Test;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.Assert.assertEquals;

public class MainTest {
    private Domain domain = new Domain();
    private Main main = new Main();
    private ArrayList<Individual> initPop;


    @Before
    public void initialize() throws Exception {
        domain.initializeDomain(100,100,5,15,20,
                0.8,0.9);
    }

    @Before
    public void createInitPop() throws Exception {
        initPop = main.createInitPop(domain.getPopSize(), domain);
        assertEquals(initPop.size(), domain.getPopSize());
    }

    @Test
    public void whoLives() throws Exception {



    }

    @Test
    public void selectParticipants() throws Exception {




    }

    @Test
    public void selectWinner() throws Exception {



    }



    @Test
    public void mutate() throws Exception {


    }

    @Test
    public void reproduce() throws Exception {


    }

    @Test
    public void gitSplits() throws Exception {


    }

    @Test
    public void sliceAndDice() throws Exception {


    }

    @Test
    public void avgFitness() throws Exception {
        double sum = 0;
        for(int i = 0; i < initPop.size(); i++) {
            sum += initPop.get(i).getFitness();
        }
        Double ans = Double.parseDouble(new DecimalFormat("0.00").format(sum / initPop.size()));
        assertEquals(String.valueOf(main.avgFitness(initPop)) , String.valueOf(ans));
    }
    @Test
    public void maxFitness() throws Exception {
        Individual max = Collections.max(initPop, new IndividualComp());
        assertEquals(String.valueOf(max.getFitness()), String.valueOf(main.maxFitness(initPop)));
    }

    @Test
    public void minFitness() throws Exception {
        Individual min = Collections.min(initPop, new IndividualComp());
        assertEquals(String.valueOf(min.getFitness()) ,String.valueOf(main.minFitness(initPop)));
    }

    @Test
    public void runGen() throws Exception {

    }

    @Test
    public void main() throws Exception {



    }

}