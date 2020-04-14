package Domain;

import java.io.Serializable;
import java.util.Objects;

public class Discipline extends Entity implements Serializable {
    String name;
    int id;
    int nrOfCredits;


    public Discipline(String n, int id, int nr)
    {
        this.name=n;
        this.id=id;
        this.nrOfCredits=nr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discipline that = (Discipline) o;
        return id == that.id ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNrOfCredits() {
        return nrOfCredits;
    }

    public void setNrOfCredits(int nrOfCredits) {
        this.nrOfCredits = nrOfCredits;
    }

    @Override
    public String toString() {
        return "Domain.Discipline{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", nrOfCredits=" + nrOfCredits +
                '}';
    }
}
