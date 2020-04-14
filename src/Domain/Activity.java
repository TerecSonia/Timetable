package Domain;

import java.io.Serializable;
import java.util.Objects;

public class Activity extends Entity implements Serializable {
    private String type;
    private int disciplineID;
    private int teacherID;


    public Activity(String type, int disciplineId,int teacherID) {
        this.type = type;
        this.disciplineID = disciplineId;
        this.teacherID=teacherID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDiscipline() {
        return disciplineID;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineID=disciplineId;
    }

    public int getTeacherId() { return teacherID; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return disciplineID == activity.disciplineID &&
                teacherID == activity.teacherID &&
                Objects.equals(type, activity.type);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "type='" + type + '\'' +
                ", disciplineID=" + disciplineID +
                ", teacherID=" + teacherID +
                '}';
    }
}
