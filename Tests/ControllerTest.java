import Domain.*;
import Repository.Repository;
import org.junit.jupiter.api.Test;
import main.Controller;

class ControllerTest {

    @Test
    void getDisciplineRepo() {
        Repository<Teacher> teacherRepo=new Repository<Teacher>();
        Repository<Discipline> disciplineRepo=new Repository<Discipline>();
        Repository<Activity> activityRepo=new Repository<Activity>();
        Repository<Room> roomRepo=new Repository<Room>();
        Repository<Specialisation> specialisationRepo=new Repository<Specialisation>();

        Controller ctrl=new Controller(teacherRepo,disciplineRepo,activityRepo,roomRepo,specialisationRepo);
        assert (ctrl.getDisciplineRepo().getAll().size()==0);

    }

    @Test
    void addDiscipline() {
        Repository<Teacher> teacherRepo=new Repository<Teacher>();
        Repository<Discipline> disciplineRepo=new Repository<Discipline>();
        Repository<Activity> activityRepo=new Repository<Activity>();
        Repository<Room> roomRepo=new Repository<Room>();
        Repository<Specialisation> specialisationRepo=new Repository<Specialisation>();

        Controller ctrl=new Controller(teacherRepo,disciplineRepo,activityRepo,roomRepo,specialisationRepo);
        Discipline d=new Discipline("Mate",1,3);
        ctrl.addDiscipline(d);

        assert (ctrl.getDisciplineRepo().getAll().size()==1);
    }

    @Test
    void deleteDiscipline() {
        Repository<Teacher> teacherRepo=new Repository<Teacher>();
        Repository<Discipline> disciplineRepo=new Repository<Discipline>();
        Repository<Activity> activityRepo=new Repository<Activity>();
        Repository<Room> roomRepo=new Repository<Room>();
        Repository<Specialisation> specialisationRepo=new Repository<Specialisation>();

        Controller ctrl=new Controller(teacherRepo,disciplineRepo,activityRepo,roomRepo,specialisationRepo);
        Discipline d=new Discipline("Mate",1,3);
        ctrl.addDiscipline(d);
        ctrl.deleteDiscipline(d);

        assert (ctrl.getDisciplineRepo().getAll().size()==0);
    }

    @Test
    void updateDiscipline() {
        Repository<Teacher> teacherRepo=new Repository<Teacher>();
        Repository<Discipline> disciplineRepo=new Repository<Discipline>();
        Repository<Activity> activityRepo=new Repository<Activity>();
        Repository<Room> roomRepo=new Repository<Room>();
        Repository<Specialisation> specialisationRepo=new Repository<Specialisation>();

        Controller ctrl=new Controller(teacherRepo,disciplineRepo,activityRepo,roomRepo,specialisationRepo);
        Discipline d=new Discipline("Mate",1,3);
        ctrl.addDiscipline(d);
        Discipline d1=new Discipline("Mate",3,3);
        ctrl.updateDiscipline(d,d1);

        assert (ctrl.getDisciplineRepo().getAll().get(0).getId()==3);
    }
}