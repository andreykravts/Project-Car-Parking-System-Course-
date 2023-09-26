package Car;

import java.util.List;
import java.util.Set;

public class CarMapList implements CarMap{
    private static final double LOAD_FACTOR=0.75;
    private static int INITIAL_CAPACITY=16;
    private Entry[] array = new Entry[INITIAL_CAPACITY];
    private int size=0;

    private void increaseArray(){
        Entry[] newArray = new Entry[INITIAL_CAPACITY*2];
        for(Entry entry : array){
            Entry existedElement = entry;
            while(existedElement!=null){
                put(existedElement.value, newArray);
                existedElement = existedElement.next;
            }
        }
        array=newArray;
    }
    private int getElementPosition(Car value,int arrayLenght){
        // car hash code = 16
        // 16 % 16 =1
        //put it in cell number 1


        //we must sure that result that will back will positive because we can search for cell with negative value
        // use Math.abs
        //get absolute value of the number
        return Math.abs(value.hashCode() % arrayLenght);
    }

    @Override
    public void put(CarOwner key, Car value) {
        //high persent of collision
        //use loadFactor
        if(size>=(array.length*LOAD_FACTOR)){
            increaseArray();
        }
        boolean added=put(value,array);
        if(added) {
            size++;
        }
        //return added;
    }

    public boolean put(Car car, Entry[] dst) {
        //first we want get number of position on array that we will be put our element
        int position = getElementPosition(car , dst.length);
        //if the cell is empty do this
        if (dst[position]==null){
            //null because we didn't know
            Entry entry = new Entry(car,null);
            dst[position]=entry;
            //move size++ to method that call method add
            //size++;
            return true;
        } else {
            //check if it the same car already in dst
            Entry existedElement = dst[position];

            //because of this is may be linked list we must put that process in the loop
            //so we can move forward in the loop
            //unlimited
            while(true) {


                if (existedElement.value.equals(car)) {
                    return false;
                } else if (existedElement.next == null) {
                    existedElement.next = new Entry(car, null);
                    return true;
                } else {
                    //if existed element mext is not null so try to get next of that next element
                    existedElement = existedElement.next;
                }
            }

        }
    }





    @Override
    public Car get(CarOwner key) {
        return null;
    }

    @Override
    public Set<CarOwner> keySet() {
        return null;
    }

    @Override
    public List<Car> values() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean remove(CarOwner key) {
        return false;
    }
    private static class Entry{
        private CarOwner key;
        private Car value;
        private Entry next;

        public Entry(CarOwner key,Car value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
