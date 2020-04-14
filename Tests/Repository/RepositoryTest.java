package Repository;

import Domain.Teacher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    void addElement() {
        Repository<Teacher> teachers=new Repository<Teacher>();
        Teacher t=new Teacher("Sonia",1,"a");
        teachers.addElement(t);

        assert (teachers.getAll().size()==1);
    }

    @Test
    void removeElement() {
        Repository<Teacher> teachers=new Repository<Teacher>();
        Teacher t=new Teacher("Sonia",1,"a");
        teachers.addElement(t);
        teachers.removeElement(t);

        assert (teachers.getAll().size()==0);
    }

    @Test
    void updateElement() {
        Repository<Teacher> teachers=new Repository<Teacher>();
        Teacher t=new Teacher("Sonia",1,"a");
        teachers.addElement(t);
        Teacher t1=new Teacher("aa",2,"a");
        teachers.updateElement(t,t1);

        assert (teachers.getAll().get(0).getId()==2);

    }

    @Test
    void getAll() {
        Repository<Teacher> teachers=new Repository<Teacher>();
        Teacher t=new Teacher("Sonia",1,"a");
        teachers.addElement(t);
        Teacher t1=new Teacher("aa",2,"a");
        teachers.addElement(t1);

        assert (teachers.getAll().size()==2);

    }
}