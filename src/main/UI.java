package main;

import Domain.*;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class UI {
    private Controller ctrl;

    public UI(Controller ctrl) {
        this.ctrl = ctrl;
    }

    public Controller getCtrl() {
        return this.ctrl;
    }

    public void printMenu() {
        System.out.println("1 Add teacher");
        System.out.println("2 Delete teacher");
        System.out.println("3 Update teacher");
        System.out.println("4 View all teachers");
        System.out.println("5 Add discipline");
        System.out.println("6 Delete discipline");
        System.out.println("7 Update discipline");
        System.out.println("8 View all disciplines");
        System.out.println("9 Add activity");
        System.out.println("10 Delete activity");
        System.out.println("11 Update activity");
        System.out.println("12 View all activities");
        System.out.println("13 Add room");
        System.out.println("14 Delete room");
        System.out.println("15 Update room");
        System.out.println("16 View all rooms");
        System.out.println("17 View all teachers having a given rank,sorted alphabetically");
        System.out.println("18 View all activities taking place in a given room, sorted by time slot");
        System.out.println("19 Timetable for a given formation");
        System.out.println("0 Return");

    }

    public void addTeacherUI()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name=in.nextLine();
        System.out.println("Enter the rank: ");
        String rank=in.nextLine();
        System.out.println("Enter the id: ");
        int id=in.nextInt();
        in.nextLine();

        Teacher t=new Teacher(name,id,rank);
        int ok=this.ctrl.addTeacher(t);
        if (ok==1)
        {
            System.out.println("The teacher was succesfully added");
        }
        else
        {
            System.out.println("The teacher already exists.");
        }

    }

    public void deleteTeacherUI()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name=in.nextLine();
        System.out.println("Enter the rank: ");
        String rank=in.nextLine();
        System.out.println("Enter the id: ");
        int id=in.nextInt();
        in.nextLine();

        Teacher t=new Teacher(name,id,rank);
        int ok=this.ctrl.deleteTeacher(t);
        if (ok==1)
        {
            System.out.println("The teacher was succesfully deleted");
        }
        else
        {
            System.out.println("The teacher doesn't exist.");
        }
    }

    public void updateTeacherUI()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the information for the teacher to update: ");
        System.out.println("Enter the name: ");
        String name=in.nextLine();
        System.out.println("Enter the rank: ");
        String rank=in.nextLine();
        System.out.println("Enter the id: ");
        int id=in.nextInt();
        in.nextLine();

        Teacher t=new Teacher(name,id,rank);

        System.out.println("Enter the new information: ");
        System.out.println("Enter the name: ");
        String name1=in.nextLine();
        System.out.println("Enter the rank: ");
        String rank1=in.nextLine();
        System.out.println("Enter the id: ");
        int id1=in.nextInt();
        in.nextLine();

        Teacher t1=new Teacher(name1,id1,rank);
        int ok=this.ctrl.updateTeacher(t,t1);
        if (ok==1)
        {
            System.out.println("The teacher was succesfully updated");
        }
        else
        {
            System.out.println("The teacher doesn't exist.");
        }

    }

    public void printTeachers()
    {
        for (Teacher t:this.ctrl.getTeacherRepo().getAll())
        {
            System.out.println(t.toString());
        }


    }

    public void addDisciplineUI()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name=in.nextLine();
        System.out.println("Enter the id: ");
        int id=in.nextInt();
        in.nextLine();
        System.out.println("Enter the nr of credits: ");
        int nrOfCredits=in.nextInt();
        in.nextLine();

        Discipline d=new Discipline(name,id,nrOfCredits);
        int ok=this.ctrl.addDiscipline(d);
        if (ok==1)
        {
            System.out.println("The discipline was succesfully added");
        }
        else
        {
            System.out.println("The discipline already exists.");
        }

    }


    public void deleteDisciplineUI()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name=in.nextLine();
        System.out.println("Enter the id: ");
        int id=in.nextInt();
        in.nextLine();
        System.out.println("Enter the nr of credits: ");
        int nrOfCredits=in.nextInt();
        in.nextLine();

        Discipline d=new Discipline(name,id,nrOfCredits);
        int ok=this.ctrl.deleteDiscipline(d);
        if (ok==1)
        {
            System.out.println("The discipline was succesfully deleted");
        }
        else
        {
            System.out.println("The discipline doesn't exist.");
        }

    }

    public void updateDisciplineUI()
    {
        Scanner in=new Scanner(System.in);

        System.out.println("Enter the information for the discipline to update");
        System.out.println("Enter the name: ");
        String name=in.nextLine();
        System.out.println("Enter the id: ");
        int id=in.nextInt();
        in.nextLine();
        System.out.println("Enter the nr of credits: ");
        int nrOfCredits=in.nextInt();
        in.nextLine();

        Discipline d=new Discipline(name,id,nrOfCredits);

        System.out.println("Enter the information for the new discipline");
        System.out.println("Enter the name: ");
        String name1=in.nextLine();
        System.out.println("Enter the id: ");
        int id1=in.nextInt();
        in.nextLine();
        System.out.println("Enter the nr of credits: ");
        int nrOfCredits1=in.nextInt();
        in.nextLine();

        Discipline d1=new Discipline(name1,id1,nrOfCredits1);

        int ok=this.ctrl.updateDiscipline(d,d1);
        if (ok==1)
        {
            System.out.println("The discipline was succesfully updated");
        }
        else
        {
            System.out.println("The discipline doesn't exist.");
        }


    }

    public void printDisciplines()
    {
        for (Discipline d:this.ctrl.getDisciplineRepo().getAll())
        {
            System.out.println(d.toString());
        }
    }

    public void addActivityUI()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the activity type: ");
        String type=in.nextLine();
        System.out.println("Enter the discipline id: ");
        int dId=in.nextInt();
        in.nextLine();
        System.out.println("Enter the teacher id: ");
        int tId=in.nextInt();
        in.nextLine();

        Activity a=new Activity(type,dId,tId);

        int ok=this.ctrl.addActivity(a);
        if (ok==1)
        {
            System.out.println("The activity was succesfully added");
        }
        else
        {
            System.out.println("The activity already exists.");
        }

    }

    public void deleteActivityUI()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the activity type: ");
        String type=in.nextLine();
        System.out.println("Enter the id: ");
        int dId=in.nextInt();
        in.nextLine();
        System.out.println("Enter the teacher id: ");
        int tId=in.nextInt();
        in.nextLine();

        Activity a=new Activity(type,dId,tId);

        int ok=this.ctrl.deleteActivity(a);
        if (ok==1)
        {
            System.out.println("The activity was succesfully deleted");
        }
        else
        {
            System.out.println("The activity doesn't exist.");
        }
    }

    public void updateActivityUI()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the information for activity to update");
        System.out.println("Enter the activity type: ");
        String type=in.nextLine();
        System.out.println("Enter the id: ");
        int dId=in.nextInt();
        in.nextLine();
        System.out.println("Enter the teacher id: ");
        int tId=in.nextInt();
        in.nextLine();

        Activity a=new Activity(type,dId,tId);

        System.out.println("Enter the information for activity to update");
        System.out.println("Enter the activity type: ");
        String type1=in.nextLine();
        System.out.println("Enter the id: ");
        int dId1=in.nextInt();
        in.nextLine();
        System.out.println("Enter the teacher id: ");
        int tId1=in.nextInt();
        in.nextLine();

        Activity a1=new Activity(type1,dId1,tId1);

        int ok=this.ctrl.updateActivity(a,a1);
        if (ok==1)
        {
            System.out.println("The activity was succesfully updated");
        }
        else
        {
            System.out.println("The activity doesn't exist.");
        }
    }

    public void printActivities()
    {
        for (Activity a:this.ctrl.getActivityRepo().getAll())
        {
            System.out.println(a.toString());
        }
    }

    public void addRoomUI()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Give the number of the room: ");
        int nr=in.nextInt();
        in.nextLine();
        System.out.println("Give the building");
        String building=in.nextLine();
//        System.out.println("Give the number of possible activities");
//        int nrActivities=in.nextInt();
//        in.nextLine();
//        System.out.println("Give the list of possible activities(lab,course,seminar)");
//        ArrayList<String> activities=new ArrayList<>();
//        String activity;
//        for (int i=0;i<nrActivities;i++)
//        {
//            activity=in.nextLine();
//            activities.add(activity);
//        }
        System.out.println("Give the activities");
        String activities=in.nextLine();

        Room r=new Room(nr,building,activities);
        int ok=this.ctrl.addRoom(r);
        if (ok==1)
        {
            System.out.println("The room was succesfully added");
        }
        else
        {
            System.out.println("The room already exists.");
        }
    }

    public void deleteRoomUI()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Give the number of the room: ");
        int nr=in.nextInt();
        in.nextLine();
        System.out.println("Give the building");
        String building=in.nextLine();
//        System.out.println("Give the number of possible activities");
//        int nrActivities=in.nextInt();
//        in.nextLine();
//        System.out.println("Give the list of possible activities(lab,course,seminar)");
//        ArrayList<String> activities=new ArrayList<>();
//        String activity;
//        for (int i=0;i<nrActivities;i++)
//        {
//            activity=in.nextLine();
//            activities.add(activity);
//        }
        System.out.println("Give the activities");
        String activities=in.nextLine();


        Room r=new Room(nr,building,activities);
        int ok=this.ctrl.deleteRoom(r);
        if (ok==1)
        {
            System.out.println("The room was succesfully deleted");
        }
        else
        {
            System.out.println("The room doesn't exist.");
        }
    }

    public void updateRoomUI()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Give the number of the old room: ");
        int nr=in.nextInt();
        in.nextLine();
        System.out.println("Give the old building");
        String building=in.nextLine();
//        System.out.println("Give the number of possible old activities");
//        int nrActivities=in.nextInt();
//        in.nextLine();
//        System.out.println("Give the list of possible old activities(lab,course,seminar)");
//        ArrayList<String> activities=new ArrayList<>();
//        String activity;
//        for (int i=0;i<nrActivities;i++)
//        {
//            activity=in.nextLine();
//            activities.add(activity);
//        }
        System.out.println("Give the activities");
        String activities=in.nextLine();

        Room r1=new Room(nr,building,activities);

        System.out.println("Give the number of the new room: ");
        int nr2=in.nextInt();
        in.nextLine();
        System.out.println("Give the new building");
        String building2=in.nextLine();
//        System.out.println("Give the number of possible new activities");
//        int nrActivities2=in.nextInt();
//        in.nextLine();
//        System.out.println("Give the list of possible new activities(lab,course,seminar)");
//        ArrayList<String> activities2=new ArrayList<>();
//        String activity2;
//        for (int i=0;i<nrActivities2;i++)
//        {
//            activity2=in.nextLine();
//            activities2.add(activity2);
//        }
        System.out.println("Give the activities");
        String activities2=in.nextLine();

        Room r2=new Room(nr2,building2,activities2);
        int ok=this.ctrl.updateRoom(r1,r2);
        if (ok==1)
        {
            System.out.println("The room was succesfully updated");
        }
        else
        {
            System.out.println("The room doesn't exist.");
        }
    }

    public void printRooms()
    {
        for (Room r:this.ctrl.getRoomRepo().getAll())
        {
            System.out.println(r.toString());
        }
    }

    public void filterTeachers()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Give rank ");
        String rank=in.nextLine();
        ArrayList<Teacher> teachers = this.getCtrl().getTeacherRepo().getAll();
        Stream<ArrayList<Teacher>> stream = Stream.of(teachers);
        stream.forEach(tc->tc.stream()
                .filter(teacher -> teacher.getRank().equals(rank))
                .sorted((tc1,tc2)->tc1.getName().compareTo(tc2.getName()))
                .forEach(tr-> System.out.println(tr.toString())));
    }

    public void activitiesFilteredByRoomSortedByTimeSlot()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Give room ");
        int roomNr=in.nextInt();
        in.nextLine();
        ArrayList<Formation> formations = this.getCtrl().getFormationRepo().getAll();
        Stream<ArrayList<Formation>> stream1 = Stream.of(formations);
        stream1.forEach(sj->sj.stream()
                        .filter(formation -> formation.getRoomNr()==roomNr)
                        .sorted((sj1,sj2)->sj1.getTimeslot().compareTo(sj2.getTimeslot()))
                        .forEach(sbj-> System.out.println(sbj.toString()))
        );
    }

    public void timetableForFormation()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Give subgroup");
        String name = in.nextLine();
        Stream<ArrayList<Formation>> stream1 = Stream.of(this.getCtrl().getFormationRepo().getAll());
        stream1.forEach(subj->subj.stream()
                        .filter(subject -> subject.getSubgroup().getName().equals(name))
                        .sorted((sj1,sj2)->sj1.getTimeslot().compareTo(sj2.getTimeslot()))
                        .forEach(sbj-> System.out.println(sbj.toString()))
        );

    }

    public void run()
    {
        Scanner in=new Scanner(System.in);
        while(true)
        {
            printMenu();
            int command=0;
            System.out.println("Input the command: ");
            command=in.nextInt();
            in.nextLine();
            if (command==0)
            {
                break;
            }
            switch (command)
            {
                case 1:
                    this.addTeacherUI();
                    break;
                case 2:
                    this.deleteTeacherUI();
                    break;
                case 3:
                    this.updateTeacherUI();
                    break;
                case 4:
                    this.printTeachers();
                    break;
                case 5:
                    this.addDisciplineUI();
                    break;
                case 6:
                    this.deleteDisciplineUI();
                    break;
                case 7:
                    this.updateDisciplineUI();
                    break;
                case 8:
                    this.printDisciplines();
                    break;
                case 9:
                    this.addActivityUI();
                    break;
                case 10:
                    this.deleteActivityUI();
                    break;
                case 11:
                    this.updateActivityUI();
                    break;
                case 12:
                    this.printActivities();
                    break;
                case 13:
                    this.addRoomUI();
                    break;
                case 14:
                    this.deleteRoomUI();
                    break;
                case 15:
                    this.updateRoomUI();
                    break;
                case 16:
                    this.printRooms();
                    break;
                case 17:
                    this.filterTeachers();
                    break;
                case 18:
                    this.activitiesFilteredByRoomSortedByTimeSlot();
                    break;
                case 19:
                    this.timetableForFormation();
                    break;
            }

        }
    }
}
