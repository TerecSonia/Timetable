package Repository;

import Domain.Entity;

import java.util.ArrayList;
import java.util.List;

public class Repository<T extends Entity>  implements  IRepository<T>{

    protected ArrayList<T> elements=new ArrayList<>();

    @Override
    public int addElement(T elem) {
        int idx=findElement(elem);
        if (idx==-1)
        {
            elements.add(elem);
            return 1;
        }
        return 0;
    }

    @Override
    public int removeElement(T elem) {
        int idx=findElement(elem);
        if (idx!=-1)
        {
            elements.remove(idx);
            return 1;
        }
        return 0;

    }

    @Override
    public int updateElement(T elem1, T elem2) {
        int idx = findElement(elem1);
        if(idx!=-1)
        {
            this.elements.set(idx, elem2);
            return 1;
        }
        return 0;

    }

    @Override
    public int findElement(T elem)
    {
        for(int i=0; i < this.elements.size(); i++)
        {
            if(this.elements.get(i).equals(elem))
            {
                return i;
            }

        }
        return -1;
    }

    @Override
    public ArrayList<T> getAll() {
        return elements;
    }
}