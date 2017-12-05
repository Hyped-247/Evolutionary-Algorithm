package Evolutionary;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class IndividualCompTest {
    private AbstractDomain domain = new Domain();
    private Main main = new Main();
    private ArrayList<Individual> initPop = main.createInitPop(domain.getPopSize(), domain);

    @Before
    public void initialize() throws Exception {
        domain.initializeDomain(100,10000,5,15,20,
                0.8,0.9);
    }
    @Test
    public void compare() throws Exception {




    }

}