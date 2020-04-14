package Domain;

import java.util.Objects;

public class Subgroup {
    private String name;

    public Subgroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subgroup subgroup = (Subgroup) o;
        return Objects.equals(name, subgroup.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
