package main;

import Domain.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GUIController {
    private Controller controller;

    public GUIController(Controller controller)
    {
        this.controller = controller;
    }

    @FXML
    private TabPane tabPane;
    @FXML private TableView teacherTableView;
    @FXML private TableView disciplineTableView;
    @FXML private TableView activityTableView;
    @FXML private TableView roomTableView;
    @FXML private TableColumn<Teacher, String> teacherId;
    @FXML private TableColumn<Teacher, String> teacherName;
    @FXML private TableColumn<Teacher, String> teacherEmail;
    @FXML private TableColumn<Discipline, String> disciplineName;
    @FXML private TableColumn<Discipline, String> disciplineID1;
    @FXML private TableColumn<Discipline, String> disciplineNrOfCredits;
    @FXML private TableColumn<Activity, String> type;
    @FXML private TableColumn<Activity, String> disciplineIDA;
    @FXML private TableColumn<Activity, String> teacherIDA;
    @FXML private TableColumn<Room, String> numberRoom;
    @FXML private TableColumn<Room, String> building;
    @FXML private TableColumn<Room, String> activitiesType;


    @FXML private TextField teacherIDTextField;
    @FXML private TextField teacherNameTextField;
    @FXML private TextField teacherEmailTextField;
    @FXML private TextField newTName;
    @FXML private TextField newTEmail;
    @FXML private TextField newTID;
    @FXML private TextField dName;
    @FXML private TextField dID;
    @FXML private TextField dNrOfCredits;
    @FXML private TextField newDName;
    @FXML private TextField newDID;
    @FXML private TextField newDNrOfCredits;

    @FXML
    private ListView<String> dayList;

    @FXML
    private ListView<String> hourList;

    @FXML
    private ListView<String> subjectList;

    @FXML
    private ListView<Integer> roomList;

    @FXML
    private ListView<String> teacherList;

    @FXML
    private ListView<String> typeList;

    @FXML
    private ListView<Subgroup> groupList;

    @FXML
    private TextField teacherNameTimetable;

    @FXML
    private TextField teacherIdTimetable;

    @FXML
    private TextField teacherRankTimetable;

    @FXML
    private TextField disciplineNameTimetable;

    @FXML
    private TextField disciplineIdTimetable;

    @FXML
    private TextField disciplineNrOfCrTimetable;

    @FXML
    private TextField dayTimetable;

    @FXML
    private TextField startTimetable;

    @FXML
    private TextField endTimetable;

    @FXML
    private TextField roomNrTimetable;

    @FXML
    private TextField typeTimetable;

    @FXML
    private TextField subgroupTimetable;


    @FXML private Button addButtonHandler;
    @FXML private Button deleteButtonHandler;
    @FXML private Button updateButtonHandler;
    @FXML private Button getAddButtonHandlerD;
    @FXML private Button associationButtonHandler;
    @FXML private Button addToTimetableButton;




    @FXML
    void addButtonHandler(Event event)
    {
        String name = this.teacherNameTextField.getText();
        int id=Integer.parseInt(this.teacherIDTextField.getText());
        String rank =this.teacherEmailTextField.getText();
        Teacher t=new Teacher(name,id,rank);
        int ok=controller.addTeacher(t);
        if (ok==1)
        {
            System.out.println("The teacher was added.");
        }
        else
            System.out.println("The teacher already exists.");

        ArrayList<Teacher> teachers = (ArrayList<Teacher>) this.controller.getTeacherRepo().getAll();
        ObservableList<Teacher> obsTeachers = FXCollections.observableArrayList(teachers);
        this.teacherTableView.setItems(obsTeachers);
    }

    @FXML
    void addButtonHandlerD(Event event)
    {
        String name = this.dName.getText();
        int id=Integer.parseInt(this.dID.getText());
        int nrOfC=Integer.parseInt(this.dNrOfCredits.getText());
        Discipline d=new Discipline(name,id,nrOfC);
        int ok=controller.addDiscipline(d);
        if (ok==1)
        {
            System.out.println("The discipline was added.");
        }
        else
            System.out.println("The discipline already exists.");

        ArrayList<Discipline> disciplines = (ArrayList<Discipline>) this.controller.getDisciplineRepo().getAll();
        ObservableList<Discipline> obsDisciplines = FXCollections.observableArrayList(disciplines);
        this.disciplineTableView.setItems(obsDisciplines);
    }

    @FXML
    void deleteButtonHandler(Event event)
    {
        String name = this.teacherNameTextField.getText();
        int id=Integer.parseInt(this.teacherIDTextField.getText());
        String rank =this.teacherEmailTextField.getText();
        Teacher t=new Teacher(name,id,rank);
        int ok=controller.deleteTeacher(t);
        if (ok==1)
        {
            System.out.println("The teacher was deleted.");
        }
        else
            System.out.println("The teacher doesn't exist.");

        ArrayList<Teacher> teachers = (ArrayList<Teacher>) this.controller.getTeacherRepo().getAll();
        ObservableList<Teacher> obsTeachers = FXCollections.observableArrayList(teachers);
        this.teacherTableView.setItems(obsTeachers);
    }

    @FXML
    void deleteButtonHandlerD(Event event)
    {
        String name = this.dName.getText();
        int id=Integer.parseInt(this.dID.getText());
        int nrOfC=Integer.parseInt(this.dNrOfCredits.getText());
        Discipline d=new Discipline(name,id,nrOfC);
        int ok=controller.deleteDiscipline(d);
        if (ok==1)
        {
            System.out.println("The discipline was deleted.");
        }
        else
            System.out.println("The discipline doesn't exist.");

        ArrayList<Discipline> disciplines = (ArrayList<Discipline>) this.controller.getDisciplineRepo().getAll();
        ObservableList<Discipline> obsDisciplines = FXCollections.observableArrayList(disciplines);
        this.disciplineTableView.setItems(obsDisciplines);
    }

    @FXML
    void updateButtonHandler(Event event)
    {
        String name1 = this.teacherNameTextField.getText();
        int id1=Integer.parseInt(this.teacherIDTextField.getText());
        String rank1 =this.teacherEmailTextField.getText();
        Teacher t1=new Teacher(name1,id1,rank1);

        String name2 = this.newTName.getText();
        int id2=Integer.parseInt(this.newTID.getText());
        String rank2=this.newTEmail.getText();
        Teacher t2= new Teacher(name2,id2,rank2);

        int ok=controller.updateTeacher(t1,t2);
        if (ok==1)
        {
            System.out.println("The teacher was updated.");
        }
        else
            System.out.println("The teacher doesn't exist.");

        ArrayList<Teacher> teachers = (ArrayList<Teacher>) this.controller.getTeacherRepo().getAll();
        ObservableList<Teacher> obsTeachers = FXCollections.observableArrayList(teachers);
        this.teacherTableView.setItems(obsTeachers);
    }

    @FXML
    void updateButtonHandlerD(Event event)
    {
        String name1 = this.dName.getText();
        int id1=Integer.parseInt(this.dID.getText());
        int nrOfC1=Integer.parseInt(this.dNrOfCredits.getText());
        Discipline d1=new Discipline(name1,id1,nrOfC1);

        String name2 = this.newDName.getText();
        int id2=Integer.parseInt(this.newDID.getText());
        int nrOfC2=Integer.parseInt(this.newDNrOfCredits.getText());
        Discipline d2=new Discipline(name2,id2,nrOfC2);

        int ok=controller.updateDiscipline(d1,d2);
        if (ok==1)
        {
            System.out.println("The discipline was updated.");
        }
        else
            System.out.println("The discipline doesn't exist.");

        ArrayList<Discipline> disciplines = (ArrayList<Discipline>) this.controller.getDisciplineRepo().getAll();
        ObservableList<Discipline> obsDisciplines = FXCollections.observableArrayList(disciplines);
        this.disciplineTableView.setItems(obsDisciplines);

    }

    @FXML
    void associationButtonHandler(Event event)
    {

        Activity activity=(Activity) activityTableView.getSelectionModel().getSelectedItem();
        Room room=(Room) roomTableView.getSelectionModel().getSelectedItem();
        String activityType=activity.getType();
        String roomActivities=room.getActivities();
        int index=roomActivities.indexOf(activityType);
        if (index != -1 )
        {
            System.out.println(activity.toString());
            System.out.println(room.toString());
        }
        else
            System.out.println("No suitable room");

    }

    @FXML
    void timetableButtonHandler(Event event) {
        Subgroup subgroup =(Subgroup) groupList.getSelectionModel().getSelectedItem();
        ArrayList<Formation> formations=(ArrayList<Formation>) this.controller.getFormationRepo().getAll();

        ArrayList<String> days=new ArrayList<>();
        ArrayList<String> hours=new ArrayList<>();
        ArrayList<String> subjects=new ArrayList<>();
        ArrayList<String> teachers=new ArrayList<>();
        ArrayList<Integer> rooms=new ArrayList<>();
        ArrayList<String> types=new ArrayList<>();
        for (Formation f:formations)
        {
            if (subgroup.getName().equals(f.getSubgroup().getName()))
            {
                days.add(f.getTimeslot().getDay());
                String hour=f.getTimeslot().getStart()+"-"+f.getTimeslot().getEnd();
                hours.add(hour);
                int dId=f.getActivity().getDiscipline();
                Discipline d=this.controller.getDisciplineByID(dId);
                subjects.add(d.getName());
                int tId=f.getActivity().getTeacherId();
                Teacher t=this.controller.getTeacherByID(tId);
                teachers.add(t.getName());
                rooms.add(f.getRoomNr());
                types.add(f.getActivity().getType());

            }
        }
        ObservableList<String> obsDays=FXCollections.observableArrayList(days);
        this.dayList.setItems(obsDays);
        ObservableList<String> obsHours=FXCollections.observableArrayList(hours);
        this.hourList.setItems(obsHours);
        ObservableList<String> obsSubjects=FXCollections.observableArrayList(subjects);
        this.subjectList.setItems(obsSubjects);
        ObservableList<String> obsTeachers=FXCollections.observableArrayList(teachers);
        this.teacherList.setItems(obsTeachers);
        ObservableList<Integer> obsRooms=FXCollections.observableArrayList(rooms);
        this.roomList.setItems(obsRooms);
        ObservableList<String> obsTypes=FXCollections.observableArrayList(types);
        this.typeList.setItems(obsTypes);

    }

    @FXML
    void addToTimetableButton(Event event) {
        String tName=this.teacherNameTimetable.getText();
        int tId=Integer.parseInt(this.teacherIdTimetable.getText());
        String tRank=this.teacherRankTimetable.getText();
        System.out.println("aaa");

        String dName=this.disciplineNameTimetable.getText();
        int dId=Integer.parseInt(this.disciplineIdTimetable.getText());
        int dNrOfC=Integer.parseInt(this.disciplineNrOfCrTimetable.getText());

        String day=this.dayTimetable.getText();
        int start=Integer.parseInt(this.startTimetable.getText());
        int end=Integer.parseInt(this.endTimetable.getText());
        int room=Integer.parseInt(this.roomNrTimetable.getText());
        String type=this.typeTimetable.getText();
        String subgroup=this.subgroupTimetable.getText();

        ArrayList<Formation> formations=this.controller.getFormationRepo().getAll();

        int k=0;
        for (Formation f:formations)
        {
            if (f.getTimeslot().getStart()==start && f.getActivity().getTeacherId()==tId && f.getTimeslot().getDay().equals(day))
            {
                System.out.println("Teacher already has an activity.");
                k=1;
            }
            if (f.getTimeslot().getStart()==start && f.getSubgroup().getName().equals(subgroup) && f.getTimeslot().getDay().equals(day))
            {
                System.out.println("Formation already has an activity.");
                k=1;
            }
            if (f.getSubgroup().getName().equals(subgroup) && f.getActivity().getDiscipline()==dId && f.getActivity().getType().equals(type))
            {
                System.out.println("The activity already had place");
                k=1;
            }
            if (f.getRoomNr()==room && f.getTimeslot().getStart()==start && f.getTimeslot().getDay().equals(day))
            {
                System.out.println("Room occupied");
                k=1;
            }
        }
        if (k==0)
        {
            Teacher t=new Teacher(tName,tId,tRank);
            Discipline d=new Discipline(dName,dId,dNrOfC);
            Activity a=new Activity(type,dId,tId);
            Timeslot ts=new Timeslot(day,start,end);
            Subgroup s=new Subgroup(subgroup);
            Formation f=new Formation(ts,s,a,room);
            this.controller.addTeacher(t);
            this.controller.addDiscipline(d);
            this.controller.addActivity(a);
            this.controller.addFormation(f);
            System.out.println("Formation added");
        }

        ArrayList<Formation> formations1=(ArrayList<Formation>) this.controller.getFormationRepo().getAll();
        ArrayList<Subgroup> groups=new ArrayList<>();
        for (Formation f:formations1)
        {
            groups.add(f.getSubgroup());
        }
        Set<String> set=new HashSet<>(groups.size());
        groups.removeIf(p -> !set.add(p.getName()));
        ObservableList<Subgroup> obsGroups = FXCollections.observableArrayList(groups);
        this.groupList.setItems(obsGroups);


    }


    @FXML
    public void initialize() {
        // populate the table
        ArrayList<Teacher> teachers = (ArrayList<Teacher>) this.controller.getTeacherRepo().getAll();
        ObservableList<Teacher> obsTeachers = FXCollections.observableArrayList(teachers);
        teacherName.setCellValueFactory(new PropertyValueFactory<>("name"));
        teacherId.setCellValueFactory(new PropertyValueFactory<>("id"));
        teacherEmail.setCellValueFactory(new PropertyValueFactory<>("rank"));


        this.teacherTableView.setItems(obsTeachers);


        ArrayList<Discipline> disciplines = (ArrayList<Discipline>) this.controller.getDisciplineRepo().getAll();
        ObservableList<Discipline> obsDisciplines = FXCollections.observableArrayList(disciplines);
        disciplineName.setCellValueFactory(new PropertyValueFactory<>("name"));
        disciplineID1.setCellValueFactory(new PropertyValueFactory<>("id"));
        disciplineNrOfCredits.setCellValueFactory(new PropertyValueFactory<>("nrOfCredits"));


        this.disciplineTableView.setItems(obsDisciplines);

        ArrayList<Activity> activities = (ArrayList<Activity>) this.controller.getActivityRepo().getAll();
//        for (int i=0;i<activities.size();i++)
//            System.out.println(activities.get(i).toString());
        ObservableList<Activity> obsActivities = FXCollections.observableArrayList(activities);
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        //disciplineIDA.setCellValueFactory(new PropertyValueFactory<>("disciplineID"));
       // teacherIDA.setCellValueFactory(new PropertyValueFactory<>("teacherID"));


        this.activityTableView.setItems(obsActivities);


        ArrayList<Room> rooms = (ArrayList<Room>) this.controller.getRoomRepo().getAll();
        ObservableList<Room> obsRooms = FXCollections.observableArrayList(rooms);
        numberRoom.setCellValueFactory(new PropertyValueFactory<>("number"));
        building.setCellValueFactory(new PropertyValueFactory<>("building"));
        activitiesType.setCellValueFactory(new PropertyValueFactory<>("activities"));


        this.roomTableView.setItems(obsRooms);

        ArrayList<Formation> formations=(ArrayList<Formation>) this.controller.getFormationRepo().getAll();
        ArrayList<Subgroup> groups=new ArrayList<>();
        for (Formation f:formations)
        {
            groups.add(f.getSubgroup());
        }
        Set<String> set=new HashSet<>(groups.size());
        groups.removeIf(p -> !set.add(p.getName()));
        ObservableList<Subgroup> obsGroups = FXCollections.observableArrayList(groups);
        this.groupList.setItems(obsGroups);


    }


}
