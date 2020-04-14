package Domain;

import java.util.Objects;

public class Formation extends Entity {
    private Timeslot timeslot;
    private Subgroup subgroup;
    private Activity activity;
    private int roomNr;

    public Formation( Timeslot timeslot, Subgroup subgroup, Activity activity, int roomNr) {
        this.timeslot = timeslot;
        this.subgroup = subgroup;
        this.activity = activity;
        this.roomNr = roomNr;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Subgroup getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(Subgroup subgroup) {
        this.subgroup = subgroup;
    }

    public Activity getActivity() {
        return activity;
    }

    public int getRoomNr() {
        return roomNr;
    }

    public void setRoomNr(int roomNr) {
        this.roomNr = roomNr;
    }

    @Override
    public String toString() {
        return "Subject{" +
                timeslot +
                ", subgroup=" + subgroup +
                ", activity=" + activity +
                ", roomId=" + roomNr +
                '}';
    }


}

