package Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisciplineTest {


    @Test
    void testEquals() {
        Discipline d1=new Discipline("OOP",4,5);
        Discipline d2=new Discipline("OOP",4,5);

        assert(d1.equals(d2));
    }

    @Test
    void getName() {
        Discipline d1=new Discipline("OOP",4,5);

        assert(d1.getName().equals("OOP"));
    }

    @Test
    void setName() {
        Discipline d1=new Discipline("OOP",4,5);
        d1.setName("Mate");

        assert (d1.getName().equals("Mate"));
    }

    @Test
    void getId() {
        Discipline d1=new Discipline("OOP",4,5);

        assert (d1.getId()==4);
    }

    @Test
    void setId() {
        Discipline d1=new Discipline("OOP",4,5);
        d1.setId(5);

        assert(d1.getId()==5);
    }

    @Test
    void getNrOfCredits() {
        Discipline d1=new Discipline("OOP",4,5);

        assert (d1.getNrOfCredits()==5);
    }

    @Test
    void setNrOfCredits() {
        Discipline d1=new Discipline("OOP",4,5);
        d1.setNrOfCredits(2);

        assert (d1.getNrOfCredits()==2);
    }
}