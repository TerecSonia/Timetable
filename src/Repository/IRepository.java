package Repository;

import Domain.Entity;

import java.util.ArrayList;
import java.util.List;

public interface IRepository<T extends Entity>
{
    int addElement(T elem);
    int removeElement(T elem);
    int updateElement(T elem1,T elem2);
    int findElement(T elem);
    ArrayList<T> getAll();
}
