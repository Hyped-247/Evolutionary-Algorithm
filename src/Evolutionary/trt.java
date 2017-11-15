package Evolutionary;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mohammad on 11/14/17.
 */
public class trt {
    public static void main(String[] args) throws Exception {
        List<Integer> intList = Arrays.asList(1, 2, 2, 3, 1, 5);

        Double average = intList.stream().mapToInt(val -> val).average().getAsDouble();
        System.out.println(average);


    }
}
