package Domain;

import java.io.Serializable;
import java.util.Objects;

public class Teacher extends Entity implements Serializable {
    private String name;
    private int id;
    private String rank;

    public Teacher() {
    }

    public Teacher(int id) {
        this.id = id;
    }

    public Teacher(String n, int id, String r)
    {
        this.name=n;
        this.id=id;
        this.rank=r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id ;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getRank() {
        return rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Domain.Teacher{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", email='" + rank + '\'' +
                '}';
    }

}
