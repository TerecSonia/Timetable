//package main;
//
//import Domain.*;
//import Repository.Repository;
//import Repository.FileRepository;
//import Repository.BinRepository;
//import Repository.DBRepository;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.layout.HBox;
//import javafx.stage.Stage;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import static javafx.application.Application.launch;
//
//public class main extends Application {
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//        Properties properties;
//        properties = new Properties();
//        try {
//            properties.load(new FileInputStream("src/streams/settings.properties"));
//
//        } catch (IOException e) {
//            Logger.getLogger(main.class.getName()).log(Level.SEVERE, e.getMessage(), e);
//        }
//
//        Repository<Teacher> teacherRepo = new Repository<Teacher>();
//        Teacher t1=new Teacher("Iuliana Bocicor",1,"lecturer");
//        Teacher t2=new Teacher("Crivei Septimiu",2,"professor");
//        Teacher t3=new Teacher("Enescu Alina",3,"doctorand");
//        Teacher t4=new Teacher("Surdu Sabina",4,"lecturer");
//        Teacher t5=new Teacher("Emilia Pop",5,"doctorand");
//        teacherRepo.addElement(t1);
//        teacherRepo.addElement(t2);
//        teacherRepo.addElement(t3);
//        teacherRepo.addElement(t4);
//        teacherRepo.addElement(t5);
//
//        Repository<Discipline> disciplineRepo = new Repository<Discipline>();
//        Discipline d1=new Discipline("OOP",2,5);
//        Discipline d2=new Discipline("Criptography",4,4);
//        Discipline d3=new Discipline("DataBases",1,6);
//        Discipline d4=new Discipline("MAP",7,6);
//        Discipline d5=new Discipline("Algebra",8,5);
//        disciplineRepo.addElement(d1);
//        disciplineRepo.addElement(d2);
//        disciplineRepo.addElement(d3);
//        disciplineRepo.addElement(d4);
//        disciplineRepo.addElement(d5);
//
//
//        Repository<Activity> activityRepo = new Repository<Activity>();
//        Activity a1=new Activity("lab",2,3);
//        Activity a2=new Activity("course",4,2);
//        Activity a3=new Activity("course",1,4);
//        Activity a4=new Activity("seminar",7,1);
//        Activity a5=new Activity("lab",1,5);
//        activityRepo.addElement(a1);
//        activityRepo.addElement(a2);
//        activityRepo.addElement(a3);
//        activityRepo.addElement(a4);
//        activityRepo.addElement(a5);
//
//        Subgroup sg1 = new Subgroup("821/1");
//        Subgroup sg2 = new Subgroup("821/2");
//        ArrayList<Subgroup> asg1 = new ArrayList<>();
//        asg1.add(sg1);
//        asg1.add(sg2);
//        Group g1 = new Group("821", asg1);
//
//        Subgroup sg3 = new Subgroup("912/1");
//        Subgroup sg4 = new Subgroup("912/2");
//        Subgroup sg5 = new Subgroup("912/3");
//        ArrayList<Subgroup> asg2 = new ArrayList<>();
//        asg2.add(sg3);
//        asg2.add(sg4);
//        asg2.add(sg5);
//        Group g2 = new Group("912", asg2);
//
//        ArrayList<Group> ag1 = new ArrayList<>();
//        ag1.add(g1);
//        ag1.add(g2);
//
//        ArrayList<Activity> actList=new ArrayList<>();
//        actList.add(a1);
//        actList.add(a3);
//        Specialisation s1 = new Specialisation("MIE1",ag1,actList);
//
//        Repository<Specialisation> specialisationRepo = new Repository<Specialisation>();
//        specialisationRepo.addElement(s1);
//
//        Repository<Room> roomRepo = new Repository<Room>();
//        Room r1=new Room(331,"FSEGA","seminar,course");
//        Room r2=new Room (7,"Central","seminar,course");
//        Room r3=new Room(318,"FSEGA","lab,seminar,course");
//        Room r4=new Room(312,"Law","seminar");
//        Room r5=new Room(5,"Central","course,seminar");
//        roomRepo.addElement(r1);
//        roomRepo.addElement(r2);
//        roomRepo.addElement(r3);
//        roomRepo.addElement(r4);
//        roomRepo.addElement(r5);
//
//        Repository<Formation> formationRepository = new Repository<Formation>();
//        Timeslot ts1=new Timeslot("Monday",8,10);
//        Timeslot ts2=new Timeslot("Wednesday",10,12);
//        Timeslot ts3=new Timeslot("Tuesday",8,10);
//        Timeslot ts4=new Timeslot("Monday",14,16);
//        Timeslot ts5=new Timeslot("Friday",16,18);
//
//
//        Formation f1=new Formation(ts1,sg1,a2,318);
//        Formation f2=new Formation(ts2,sg3,a2,318);
//        Formation f3=new Formation(ts3,sg1,a3,7);
//        Formation f4=new Formation(ts5,sg3,a1,318);
//        Formation f5=new Formation(ts1,sg2,a4,312);
//
//        formationRepository.addElement(f2);
//        formationRepository.addElement(f1);
//        formationRepository.addElement(f3);
//        formationRepository.addElement(f4);
//        formationRepository.addElement(f5);
//
//        String repositoryType = properties.getProperty("Repository");
//        if (repositoryType.equals("txt")) {
//            activityRepo = new FileRepository<Activity>(properties.getProperty("ActivitiesTxt"));
//            disciplineRepo = new FileRepository<Discipline>(properties.getProperty("DisciplinesTxt"));
//            teacherRepo = new FileRepository<Discipline>(properties.getProperty("TeachersTxt"));
//
//        } else if (repositoryType.equals("bin")) {
//            activityRepo = new BinRepository<Activity>(properties.getProperty("ActivitiesBin"));
//            disciplineRepo = new BinRepository<Discipline>(properties.getProperty("DisciplinesBin"));
//            teacherRepo = new BinRepository<Discipline>(properties.getProperty("TeachersBin"));
//
//        }
//        else if (repositoryType.equals("db")) {
//            teacherRepo = new DBRepository();
//            disciplineRepo = new DBRepository();
//        }
//
//        Controller ctrl = new Controller(teacherRepo, disciplineRepo, activityRepo, roomRepo, specialisationRepo,formationRepository);
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("gui.fxml"));
//        GUIController controller = new GUIController(ctrl);
//        loader.setController(controller);
//        Parent root = (Parent) loader.load();
//
//        primaryStage.setTitle("Teachers");
//        primaryStage.setScene(new Scene(root, 700, 550));
//        primaryStage.show();
//
//    }
//    public static void main(String[] args) { launch(args);
//    }
//
//}
//
package main;

import Domain.*;
import Repository.Repository;
import Repository.FileRepository;
import Repository.BinRepository;
import Repository.DBRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;



public class main  {
    public static void main(String[] args) throws IOException {

        Properties properties;
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/streams/settings.properties"));

        } catch (IOException e) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        Repository<Teacher> teacherRepo = new Repository<Teacher>();
        Teacher t1=new Teacher("Iuliana Bocicor",1,"lecturer");
        Teacher t2=new Teacher("Crivei Septimiu",2,"professor");
        Teacher t3=new Teacher("Enescu Alina",3,"doctorand");
        Teacher t4=new Teacher("Surdu Sabina",4,"lecturer");
        Teacher t5=new Teacher("Emilia Pop",5,"doctorand");
        teacherRepo.addElement(t1);
        teacherRepo.addElement(t2);
        teacherRepo.addElement(t3);
        teacherRepo.addElement(t4);
        teacherRepo.addElement(t5);

        Repository<Discipline> disciplineRepo = new Repository<Discipline>();
        Discipline d1=new Discipline("OOP",2,5);
        Discipline d2=new Discipline("Criptography",4,4);
        Discipline d3=new Discipline("DataBases",1,6);
        Discipline d4=new Discipline("MAP",7,6);
        Discipline d5=new Discipline("Algebra",8,5);
        disciplineRepo.addElement(d1);
        disciplineRepo.addElement(d2);
        disciplineRepo.addElement(d3);
        disciplineRepo.addElement(d4);
        disciplineRepo.addElement(d5);


        Repository<Activity> activityRepo = new Repository<Activity>();
        Activity a1=new Activity("lab",2,3);
        Activity a2=new Activity("course",4,2);
        Activity a3=new Activity("course",1,4);
        Activity a4=new Activity("seminar",7,1);
        Activity a5=new Activity("lab",1,5);
        activityRepo.addElement(a1);
        activityRepo.addElement(a2);
        activityRepo.addElement(a3);
        activityRepo.addElement(a4);
        activityRepo.addElement(a5);

        Subgroup sg1 = new Subgroup("821/1");
        Subgroup sg2 = new Subgroup("821/2");
        ArrayList<Subgroup> asg1 = new ArrayList<>();
        asg1.add(sg1);
        asg1.add(sg2);
        Group g1 = new Group("821", asg1);

        Subgroup sg3 = new Subgroup("912/1");
        Subgroup sg4 = new Subgroup("912/2");
        Subgroup sg5 = new Subgroup("912/3");
        ArrayList<Subgroup> asg2 = new ArrayList<>();
        asg2.add(sg3);
        asg2.add(sg4);
        asg2.add(sg5);
        Group g2 = new Group("912", asg2);

        ArrayList<Group> ag1 = new ArrayList<>();
        ag1.add(g1);
        ag1.add(g2);

        ArrayList<Activity> actList=new ArrayList<>();
        actList.add(a1);
        actList.add(a3);
        Specialisation s1 = new Specialisation("MIE1",ag1,actList);

        Repository<Specialisation> specialisationRepo = new Repository<Specialisation>();
        specialisationRepo.addElement(s1);

        Repository<Room> roomRepo = new Repository<Room>();
        Room r1=new Room(331,"FSEGA","seminar,course");
        Room r2=new Room (7,"Central","seminar,course");
        Room r3=new Room(318,"FSEGA","lab,seminar,course");
        Room r4=new Room(312,"Law","seminar");
        Room r5=new Room(5,"Central","course,seminar");
        roomRepo.addElement(r1);
        roomRepo.addElement(r2);
        roomRepo.addElement(r3);
        roomRepo.addElement(r4);
        roomRepo.addElement(r5);

        Repository<Formation> formationRepository = new Repository<Formation>();
        Timeslot ts1=new Timeslot("Monday",8,10);
        Timeslot ts2=new Timeslot("Wednesday",10,12);
        Timeslot ts3=new Timeslot("Tuesday",8,10);
        Timeslot ts4=new Timeslot("Monday",14,16);
        Timeslot ts5=new Timeslot("Friday",16,18);


        Formation f1=new Formation(ts1,sg1,a1,318);
        Formation f2=new Formation(ts2,sg3,a2,318);
        Formation f3=new Formation(ts3,sg1,a3,7);

        formationRepository.addElement(f2);
        formationRepository.addElement(f1);
        formationRepository.addElement(f3);

        String repositoryType = properties.getProperty("Repository");
        if (repositoryType.equals("txt")) {
            activityRepo = new FileRepository<Activity>(properties.getProperty("ActivitiesTxt"));
            disciplineRepo = new FileRepository<Discipline>(properties.getProperty("DisciplinesTxt"));
            teacherRepo = new FileRepository<Discipline>(properties.getProperty("TeachersTxt"));

        } else if (repositoryType.equals("bin")) {
            activityRepo = new BinRepository<Activity>(properties.getProperty("ActivitiesBin"));
            disciplineRepo = new BinRepository<Discipline>(properties.getProperty("DisciplinesBin"));
            teacherRepo = new BinRepository<Discipline>(properties.getProperty("TeachersBin"));

        }
        else if (repositoryType.equals("db")) {
           teacherRepo = new DBRepository();
            disciplineRepo = new DBRepository();
        }

        Controller ctrl = new Controller(teacherRepo, disciplineRepo, activityRepo, roomRepo, specialisationRepo,formationRepository);
        UI ui=new UI(ctrl);
        ui.run();

    }

}

