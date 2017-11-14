package Evolutionary;

import java.util.*;

public class trt {
    public static void main(String[] args) throws Exception {
        List<Empy> emps = new ArrayList<Empy>();
        emps.add(new Empy(10, "Raghu", 25000.0));
        emps.add(new Empy(120, "Krish", 45000.0));
        emps.add(new Empy(210, "John", 14000.0));
        emps.add(new Empy(150, "Kishore", 24000.0));
        Empy maxSal = Collections.min(emps, new EmpyComp());
        System.out.println("Employee with max salary: "+maxSal);
    }


    }
