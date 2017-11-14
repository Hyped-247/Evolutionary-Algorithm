package Evolutionary;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;


public class trt {
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> splitsIndexes = new LinkedList<>();
        int splitNum = 3;
        String father = "1111";
        while (splitNum != 0){
            // generate a number from 1 to len of the father or the mother - 1
            int randomSplit = random(father.length() - 1);
            if (!splitsIndexes.contains(randomSplit)){
                splitsIndexes.add(randomSplit);
                splitNum--;
            }
        }
    }
    private static int random(int max) {
        return ThreadLocalRandom.current().nextInt(1, max + 1);
    }

    }
