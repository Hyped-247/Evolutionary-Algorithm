package Evolutionary;

import org.junit.Before;
import org.junit.Test;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.Assert.assertEquals;

public class MainTest {
    private ArrayList<Integer> splits = new ArrayList<>();
    private Domain domain = new Domain();
    private Main main = new Main();
    private ArrayList<Individual> initPop;
    private String father = "";
    private String mother = "";
    private String firstKid = "";
    private String secondtKid = "";



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

        // First sliceAndDice test..
        splits.add(0);splits.add(2);splits.add(3);splits.add(4);splits.add(6); // splits 2, 3, 4
        // Father : 101010
        father = "111111";
        // Mother : 101110
        mother = "000000";
        // first kid should be 110100
        firstKid = "110100";
        // second kid should be 001011
        secondtKid = "001011";
        assertEquals(firstKid,  main.sliceAndDice(domain, splits, father, mother).get(0).getGenMak()); // get first kid
        assertEquals(secondtKid,  main.sliceAndDice(domain, splits, father, mother).get(1).getGenMak()); // get first kid
        splits.clear();

        // Second sliceAndDice test..
        splits.add(0);splits.add(2);splits.add(3);splits.add(4); // splits 2, 3
        // Father : 0001
        father = "0001";
        // Mother : 1110
        mother = "1110";
        // first kid should be 0011
        firstKid = "0011";
        // second kid should be 1100
        secondtKid = "1100";
        assertEquals(firstKid,  main.sliceAndDice(domain, splits, father, mother).get(0).getGenMak()); // get first kid
        assertEquals(secondtKid,  main.sliceAndDice(domain, splits, father, mother).get(1).getGenMak()); // get first kid
        splits.clear();

        // Third sliceAndDice test..
        splits.add(0);splits.add(2);splits.add(3);splits.add(7); // splits 2, 3
        // Father : 1011010
        father = "1011010";
        // Mother : 0101101
        mother = "0101101";
        // first kid should be 1001010
        firstKid = "1001010";
        // second kid should be 0111101
        secondtKid = "0111101";
        assertEquals(firstKid,  main.sliceAndDice(domain, splits, father, mother).get(0).getGenMak()); // get first kid
        assertEquals(secondtKid,  main.sliceAndDice(domain, splits, father, mother).get(1).getGenMak()); // get first kid
        splits.clear();






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