package Domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Room extends Entity implements Serializable {
    private int number;
    private String building;
    private String activities;


    public Room(int number) {
        this.number = number;
    }

    public Room(int number, String building,String activities) {
        this.number = number;
        this.building = building;
        this.activities=activities;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String  getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", building='" + building + '\'' +
                ", activities=" + activities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return number == room.number &&
                Objects.equals(building, room.building) &&
                Objects.equals(activities, room.activities);
    }

}
