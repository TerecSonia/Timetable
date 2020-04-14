package Domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Group extends Entity implements Serializable {
    private String name;
    private ArrayList<Subgroup> subgroups=new ArrayList<>();
    private Timeslot t;

    public Group(String name, ArrayList<Subgroup> subgroups) {
        this.name = name;
        this.subgroups = subgroups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Subgroup> getSubgroups() {
        return subgroups;
    }

    public void setSubgroups(ArrayList<Subgroup> subgroups) {
        this.subgroups = subgroups;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", subgroups=" + subgroups +
                '}';
    }
}
