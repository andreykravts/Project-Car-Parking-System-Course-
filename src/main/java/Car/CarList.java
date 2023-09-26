package Car;

public interface CarList extends CarCollection{
    //found car by index
    Car get(int index);
    //add car
    boolean add(Car car);
    boolean add(Car car, int index);
    //remove car
    boolean remove(Car car);
    //remove car by index
    boolean removeAt(int index);
    //return size of the list
    int size();
    //clear the list
    void clear();

    boolean contain(Car car);
}