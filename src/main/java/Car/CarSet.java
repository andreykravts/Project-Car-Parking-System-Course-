package Car;

public interface CarSet extends CarCollection{
    public boolean add(Car car);
    public boolean contain(Car car);
    public boolean remove(Car car);

    public int size();

    public void clear();

}
