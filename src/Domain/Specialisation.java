package Domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Specialisation extends Entity implements Serializable {
    private String name;
    private ArrayList<Group> groups=new ArrayList<>();
    private ArrayList<Activity> activities=new ArrayList<>();

    public Specialisation(String name, ArrayList<Group> groups, ArrayList<Activity> activities) {
        this.name = name;
        this.groups = groups;
        this.activities = activities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Specialisation{" +
                "name='" + name + '\'' +
                ", groups=" + groups +
                ", activities=" + activities +
                '}';
    }
}
