package main;

import Domain.*;
import Repository.*;

import java.util.ArrayList;

public class Controller {
    private Repository<Teacher> teacherRepo;
    private Repository<Discipline> disciplineRepo;
    private Repository<Activity> activityRepo;
    private Repository<Room> roomRepo;
    private Repository<Specialisation> specialisationRepo;
    private Repository<Formation> formationRepo;

    public Controller(Repository<Teacher> teacherRepo, Repository<Discipline> disciplineRepo,Repository<Activity> activityRepo, Repository<Room> roomRepo, Repository<Specialisation> specialisationRepo, Repository<Formation> formationRepo) {
        this.teacherRepo = teacherRepo;
        this.disciplineRepo = disciplineRepo;
        this.activityRepo = activityRepo;
        this.roomRepo = roomRepo;
        this.specialisationRepo = specialisationRepo;
        this.formationRepo=formationRepo;
    }

    public Repository<Teacher> getTeacherRepo() {
        return teacherRepo;
    }

    public Repository<Discipline> getDisciplineRepo() {
        return disciplineRepo;
    }

    public Repository<Activity> getActivityRepo() {
        return activityRepo;
    }

    public Repository<Room> getRoomRepo() {
        return roomRepo;
    }

    public Repository<Specialisation> getSpecialisationRepo() {
        return specialisationRepo;
    }

    public Repository<Formation> getFormationRepo() {
        return formationRepo;
    }

    public int addTeacher(Teacher t)
    {
        return this.teacherRepo.addElement(t);
    }

    public int addDiscipline(Discipline d)
    {
        return this.disciplineRepo.addElement(d);
    }

    public int addActivity(Activity a)
    {
        return this.activityRepo.addElement(a);
    }

    public int addRoom(Room r) { return this.roomRepo.addElement(r);}

    public int addSpecialisation(Specialisation s) { return this.specialisationRepo.addElement(s);}

    public int addFormation(Formation f) { return this.formationRepo.addElement(f);}


    public  int deleteTeacher(Teacher t) {return this.teacherRepo.removeElement(t);}

    public  int deleteDiscipline(Discipline d)
    {
        return this.disciplineRepo.removeElement(d);
    }

    public int  deleteActivity(Activity a)
    {
        return this.activityRepo.removeElement(a);
    }

    public int deleteRoom(Room r) { return this.roomRepo.removeElement(r);}

    public int deleteSpecialisation(Specialisation s) { return this.specialisationRepo.removeElement(s);}

    public int deleteFormation(Formation f) { return this.formationRepo.removeElement(f);}


    public int updateTeacher(Teacher t1,Teacher t2) { return this.teacherRepo.updateElement(t1,t2);}

    public int updateDiscipline(Discipline d1,Discipline d2)
    {
        return this.disciplineRepo.updateElement(d1,d2);
    }

    public int updateActivity(Activity a1,Activity a2) { return this.activityRepo.updateElement(a1,a2);}

    public int updateRoom(Room r1,Room r2) { return this.roomRepo.updateElement(r1,r2);}

    public int updateFormation(Formation f1, Formation f2) { return this.formationRepo.updateElement(f1,f2);}

    public Discipline getDisciplineByID(int id)
    {
//        for (int i=0;i<disciplineRepo.getAll().size();i++)
//        {
//            if (disciplineRepo.getAll().get(i).getId()==id)
//                return disciplineRepo.getAll().get(i);
//        }
        ArrayList<Discipline> disciplines=this.disciplineRepo.getAll();
        for (Discipline d:disciplines)
        {
            if (d.getId()==id)
                return d;
        }
        return null;
    }
    public Teacher getTeacherByID(int id)
    {
        for (int i=0;i<teacherRepo.getAll().size();i++)
        {
            if (teacherRepo.getAll().get(i).getId()==id)
                return teacherRepo.getAll().get(i);
        }
        return null;
    }


}
