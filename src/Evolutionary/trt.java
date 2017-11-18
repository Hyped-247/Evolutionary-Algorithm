package Evolutionary;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.List;

/**
 * Created by mohammad on 11/14/17.
 */
public class trt {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        for (int i = 0; i < 1000000; i++) {
            int randomSplit = rand.nextInt( 5 - 1) + 1;
            if (randomSplit <= 0 || randomSplit == 5){
                System.out.println("Fail.. "+randomSplit);
            }
        }
        System.out.println("pass all");
    }
}
