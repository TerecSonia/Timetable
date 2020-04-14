package Repository;

import Domain.Activity;
import Domain.Discipline;
import Domain.Entity;
import Domain.Teacher;

import java.io.*;

public class FileRepository<T extends Entity> extends Repository implements Serializable {
    private String fileName;

    public FileRepository(String fileName) {

        this.fileName = fileName;
        if (this.fileName.contains("discipline")) readDisciplines();
        else if (this.fileName.contains("teacher")) readTeachers();
        else if (this.fileName.contains("activities")) readActivities();

    }


    @Override
    public int addElement(Entity elem) {
        int ok = super.addElement(elem);
        if (ok == 1) {
            if (elem instanceof Discipline) writeDisciplines();
            else if (elem instanceof Teacher) writeTeachers();
            else if (elem instanceof Activity) writeActivities();
        }
        return ok;
    }

    @Override
    public int removeElement(Entity elem) {
        int ok = super.removeElement(elem);
        if (ok == 1) {
            if (elem instanceof Discipline) writeDisciplines();
            else if (elem instanceof Teacher) writeTeachers();
            else if (elem instanceof Activity) writeActivities();
        }
        return ok;
    }

    @Override
    public int updateElement(Entity elem1, Entity elem2) {
        int ok = super.updateElement(elem1, elem2);
        if (ok == 1)
            if (elem1 instanceof Discipline) writeDisciplines();
            else if (elem1 instanceof Teacher) writeTeachers();
            else if (elem1 instanceof Activity) writeActivities();

        return ok;
    }

    @Override
    public int findElement(Entity elem) {
        int ok = super.findElement(elem);
        if (ok != -1)
            if (elem instanceof Discipline) writeDisciplines();
            else if (elem instanceof Teacher) writeTeachers();
            else if (elem instanceof Activity) writeActivities();
        return ok;
    }


    void readDisciplines() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(this.fileName));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] elems = line.split("[|]");
                if (elems.length < 3)
                    continue;
                Discipline d = new Discipline(elems[0].strip(), Integer.parseInt(elems[1].strip()), Integer.parseInt(elems[2].strip()));
                this.elements.add(d);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error while closing the file " + e);
                }
        }
    }

    void writeDisciplines() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(this.fileName));
            for (Object d : elements) {
                if (d instanceof Discipline)
                    bw.write(((Discipline) d).getName() + "|" + ((Discipline) d).getId() + "|" + ((Discipline) d).getNrOfCredits());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    void readTeachers() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(this.fileName));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] elems = line.split("[|]");
                if (elems.length < 3)
                    continue;
                Teacher b = new Teacher(elems[0].strip(), Integer.parseInt(elems[1].strip()), elems[2].strip());
                this.elements.add(b);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error while closing the file " + e);
                }
        }
    }

    void writeTeachers() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(this.fileName));
            for (Object t : elements) {
                if (t instanceof Teacher)
                    bw.write(((Teacher) t).getName() + "|" + ((Teacher) t).getId() + "|" + ((Teacher) t).getRank());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void readActivities() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(this.fileName));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] elems = line.split("[|]");
                if (elems.length < 3)
                    continue;
                Activity a = new Activity(elems[0].strip(), Integer.parseInt(elems[1].strip()), Integer.parseInt(elems[2].strip()));
                this.elements.add(a);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error while closing the file " + e);
                }
        }
    }

    void writeActivities() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(this.fileName));
            for (Object a : elements) {
                if (a instanceof Activity)
                    bw.write(((Activity) a).getType() + "|" + ((Activity) a).getDiscipline()
                            + "|" + ((Activity) a).getTeacherId());

                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}