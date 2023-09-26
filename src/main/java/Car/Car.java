package Car;

import java.util.Objects;
//to use compare method do : implements Comparable<Car>
//public class Car implements Comparable<Car>{
public class Car {
    private  String brand;
    private int number;

    public Car(String brand, int number) {
        this.brand = brand;
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public int getNumber() {
        return number;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    //if you re override method equals do same for hashcode method too!
//    @Override
//    public boolean equals(Object object){
//        if (object instanceof Car ){
//            //check
//            Car car = (Car)object;
//            return car.brand.equals(this.brand) && car.number == this.number;
//        }else{
//            return false;
//        }
//    }
//
//    @Override
//    public int hashCode() {
//        return brand.hashCode() + number;
//    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return number == car.number && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, number);
    }
//method compare to
//    @Override
//    public int compareTo(Car car) {
//        //sort by number
//        if (number<car.number){
//            return -1;
//        }else if (number>car.number){
//            return 1;
//        }else{
//            return 0;
//        }
//        //use class compare from class string
//        //sort by name
//        //return brand.compareTo(car.brand);
//
//    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", number=" + number +
                '}';
    }
}
