package Evolutionary;

import java.util.LinkedList;

public class trt {
    public static void main(String[] args) {
        /*
            LinkedList<Integer> integers = new LinkedList<>();
            integers.add(1);
            integers.add(3);
            String father = "1111";
            String mohter = "0000";
            String firstKid = "";
            Boolean allowfather = false;
            Boolean allowmother = false;
            int counter = integers.size();
            int genMakLen = father.length();
            int index = 0;
            while (counter >= -1){
                while ((!integers.contains(index) && (genMakLen != index)) ||  (allowfather && (genMakLen != index))){
                        firstKid += father.charAt(index);
                        allowfather = false;
                        allowmother = true;
                        index++;
                }
                counter--;
                while ((!integers.contains(index) && (genMakLen != index)) || (allowmother && (genMakLen != index))){
                        firstKid += mohter.charAt(index);
                        allowfather = true;
                        allowmother = false;
                        index++;
                }
                counter--;
            }
            System.out.println(firstKid);

        */
        String genMak = "10000001";
        String binaryString = "";
        for(int i = 0; i <= genMak.length() - 1; i++) {
            if(genMak.charAt(i) == '0') {
                binaryString += '1';
            } else {
                binaryString += '0';
            }
        }
        System.out.println(binaryString);
        }

    }
