package Evolutionary;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractDomainTest {
    private Domain domain = new Domain();

    @Before
    public void initializeDomain() throws Exception {
        domain.initializeDomain(100,10000,5,15,20,
                0.8,0.9);
    }

    @Test
    public void getBitLength() throws Exception {
        assertEquals(domain.getBitLength(), 100);
    }

    @Test
    public void getPopSize() throws Exception {
        assertEquals(domain.getPopSize(), 10000);
    }

    @Test
    public void getCrossNum() throws Exception {
        assertEquals(domain.getCrossNum(), 5);

    }

    @Test
    public void getGenNum() throws Exception {
        assertEquals(domain.getGenNum(), 15);
    }

    @Test
    public void getTSize() throws Exception {
        assertEquals(domain.getTSize(), 20);
    }

    @Test
    public void getSurRatio() throws Exception {
        assertEquals(String.valueOf(domain.getSurRatio()), String.valueOf(0.8));

    }

    @Test
    public void getMutationRate() throws Exception {
        assertEquals(String.valueOf(domain.getMutationRate()), String.valueOf(0.9));

    }

}