package Car;
import java.util.Set;
public interface CarMap {
    void put(CarOwner key, Car value);
    Car get(CarOwner key);
    Set<CarOwner> keySet();

}

