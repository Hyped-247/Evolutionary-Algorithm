package Evolutionary;

import java.util.Comparator;

class EmpyComp implements Comparator<Empy> {

    @Override
    public int compare(Empy e1, Empy e2) {
        return e1.getSalary().compareTo(e2.getSalary());
    }
}
class Empy{

    private int id;
    private String name;
    private Double salary;

    public Empy(int id, String name, Double sal){
        this.id = id;
        this.name = name;
        this.salary = sal;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public String toString(){
        return id+"  "+name+"   "+salary;
    }
}
