package Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    @Test
    void testEquals() {
        Teacher t=new Teacher("Pop",12,"p@");
        Teacher t1=new Teacher("Pop",12,"p@");
        assert (t.equals(t1));
    }

    @Test
    void getName() {
        Teacher t=new Teacher("Pop",12,"p@");

        assert (t.getName().equals("Pop"));
    }

    @Test
    void getId() {
        Teacher t=new Teacher("Pop",12,"p@");

        assert (t.getId()==12);
    }

    @Test
    void getEmail() {
        Teacher t=new Teacher("Pop",12,"p@");

        assert (t.getEmail().equals("p@"));
    }

    @Test
    void setName() {
        Teacher t=new Teacher("Pop",12,"p@");
        t.setName("Ana");
        assert (t.getName().equals("Ana"));
    }

    @Test
    void setId() {
        Teacher t=new Teacher("Pop",12,"p@");
        t.setId(10);
        assert (t.getId()==10);
    }

    @Test
    void setEmail() {
        Teacher t=new Teacher("Pop",12,"p@");
        t.setEmail("aaa");
        assert (t.getEmail().equals("aaa"));
    }
}