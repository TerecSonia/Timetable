package Domain;

import java.util.Objects;

public class Timeslot {
    String day;
    int start;
    int end;

    public Timeslot(String day, int start, int end) {
        this.day = day;
        this.start = start;
        this.end = end;
    }

    public String getDay() {

        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Timeslot{" +
                "day='" + day + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timeslot timeslot = (Timeslot) o;
        return start == timeslot.start &&
                end == timeslot.end &&
                Objects.equals(day, timeslot.day);
    }

    public int compareTo(Object o) {
        Timeslot that = (Timeslot) o;
        if (this.day.equals(that.day)) {
            if (this.start < that.start) return -1;
            else return 1;
        } else if (this.day.equals("Monday")) return -1;
        else if (this.day.equals("Tuesday")) {
            if (that.day.equals("Monday")) return 1;
            else return -1;
        } else if (this.day.equals("Wednesday")) {
            if (that.day.equals("Monday") || that.day.equals("Tuesday")) return 1;
            else return -1;
        } else if (this.day.equals("Thursday")) {
            if (that.day.equals("Monday") || that.day.equals("Tuesday") || that.day.equals("Wednesday")) return 1;
            else return -1;
        } else if (this.day.equals("Friday")) return 1;
        return 0;
    }



}
