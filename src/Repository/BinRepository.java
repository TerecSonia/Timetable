package Repository;

import Domain.Entity;

import java.io.*;
import java.util.ArrayList;

public class BinRepository<T extends Entity> extends Repository implements Serializable {
    private String fileName;
    public BinRepository(String fileName)
    {
        this.fileName = fileName;

        deserializeList();
    }

    @Override
    public int findElement(Entity elem)
    {
        int ok = super.findElement(elem);
        return ok;
    }

    @Override
    public int addElement (Entity elem)
    {
        int ok = super.addElement(elem);
        if(ok==1)
            serializeList();
        return ok;

    }

    @Override
    public int removeElement (Entity elem)
    {
        int ok = super.removeElement(elem);
        if(ok==1)
            serializeList();
        return ok;
    }

    @Override
    public int updateElement(Entity elem1, Entity elem2)
    {
        int ok = super.updateElement(elem1, elem2);
        if(ok==1)
            serializeList();
        return ok;
    }


    public void serializeList() {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(this.fileName));
            out.writeObject(this.elements);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void deserializeList() {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(this.fileName));
            this.elements= (ArrayList<T>) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
