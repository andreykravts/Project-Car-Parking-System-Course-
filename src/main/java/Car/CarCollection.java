package Car;

public interface CarCollection extends Iterable<Car> {
    //carset
    public boolean add(Car car);
    public boolean remove(Car car);
    public int size();
    public void clear();
    public boolean contain(Car car);

}
