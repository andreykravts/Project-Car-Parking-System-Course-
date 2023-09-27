package Main;

import Car.CarOwner;
import Car.Car;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //hash map may lose element if key is changeable object and after this element was added to collection his key was changed
        //because his hashcode is depended on key
        //conclusion: DONOT USE CHANGEABLE OBJECTS AS A KEY!!!
        //use strings,numbers and etc
        HashMap<CarOwner,Car> map = new HashMap<CarOwner, Car>();
        CarOwner key = new CarOwner(1,"name","lastName");
        map.put(key,new Car("Brand1",1));
        key.setId(8);
        for(CarOwner carOwner : map.keySet()){
            //id changed!
            System.out.println(carOwner.getId());
        }
        //car will be null
        //because when we changed key to 8 we change hashcode
        //collection is didnt know about changes of hashcode
        //so we cant find anything into collection
//        Car car = map.get(key);
//        System.out.println(car.getBrand());






        //TREESET
        //Set<Integer> numbers = new TreeSet<>();
        // we need realisation method compare to from interface comparable
        // create realisation into class  car
//        Set<Car> cars = new TreeSet<>();
//        for(int i=0; i<100;i++){
//            cars.add(new Car("brand"+i,i));
//        }
//        for(Car car : cars){
//            // ordering is automated
//            System.out.println(car);
//        }

        //create object of anonymous class comparator
        //with comparator we can say how to compare our objects

//        Set<Car> cars = new TreeSet<>(new Comparator<Car>() {
//            @Override
//            public int compare(Car oCar1, Car oCar2) {
//                //method compare to we get from the string class
//                return oCar1.getBrand().compareTo(oCar2.getBrand());
//            }
//        });
//        for(int i=0; i<100;i++){
//            cars.add(new Car("brand"+i,i));
//        }
//        for(Car car : cars){
//            // ordering is automated
//            System.out.println(car);
//        }


//        Set<Integer> numbers = new TreeSet<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer integer, Integer t1) {
//                //sort by number
//
////                if (integer>t1){
////                    return -1;
////                }else if (integer<t1){
////                    return 1;
////                }else{
////                    return 0;
////                }
//
//                //call compare method from class integer
//                //sort ask
//                //return integer.compareTo(t1);
//
//                //sort desc
//                return -integer.compareTo(t1);
//
//
//
//        }});
//        for(int i=0; i<100;i++){
//            numbers.add((int)(Math.random()*10));
//        }
//        for(int number : numbers){
//            // ordering is automated
//            System.out.println(number);
//        }





















//        ///conclusion!
//        //interface collection extend iterable!!!
//
//
//        CarCollection cars = new CarArrayList();
//        //ok
//        //Collection<Car> cars = new HashSet<Car>();
//        //ok
//        //Collection<Car> cars = new LinkedList<Car>();
//        //ok
//        //Collection<Car> cars = new ArrayList<Car>();
//
//        //Foreach not applicable to type 'Car.CarList'
//        //CarList cars = new CarArrayList();
//        //OK
//        //List<Car> cars = new ArrayList<Car>();
//
//
//        for(int i=0; i<10;i++){
//            cars.add(new Car("Brand"+i,i));
//        }
//        for(Car car:cars){
//            System.out.println(car.getBrand()+" "+car.getNumber());
//        }













//        // reference to different objects
//        Car car1 = new Car("BMW", 1);
//        Car car2 = new Car("BMW", 1);
//        //result false because of different hash
//        System.out.println(car1==car2);
//
//        // reference to same object
//        Car car3 = new Car("BMW", 1);
//        Car car4 = car3;
//        //result True because of same hash
//        System.out.println(car3==car4);
//
//        System.out.println();
//        car3.setNumber(5);
//        System.out.println(car3.getNumber());
//        System.out.println(car4.getNumber());
//
//
//        car1 = new Car("BMW", 1);
//        car2 = new Car("BMW", 1);
//        //result false because of different hash
//        System.out.println(car1.equals(car2));
//
//        System.out.println(car1.hashCode());
//        System.out.println(car2.hashCode());
    }
}
