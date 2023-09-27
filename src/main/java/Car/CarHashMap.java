package Car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarHashMap implements CarMap{
    private static final double LOAD_FACTOR=0.75;
    private static final int INITIAL_CAPACITY=16;
    private Entry[] array = new Entry[INITIAL_CAPACITY];
    private int size=0;

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



    private void increaseArray(){
        Entry[] newArray = new Entry[INITIAL_CAPACITY*2];
        //copy elements to newArray
        for(Entry entry : array){
            Entry existedElement = entry;
            while(existedElement!=null){
                //copy elements from original array to new increased array with method put
                put(existedElement.key,existedElement.value,newArray);
                existedElement = existedElement.next;
            }
        }
        array=newArray;
    }
    private int getElementPosition(CarOwner carOwner,int arrayLength){
        // CarOwner hash code = 16
        // 16 % 16 =1
        //put it in cell number 1
        //we must sure that result that will back will positive because we can search for cell with negative value
        // use Math.abs
        //get absolute value of the number
        return Math.abs(carOwner.hashCode() % arrayLength);
    }

    private boolean put(CarOwner key, Car value,Entry[] dest) {
        //thies method put elements of original array to increased


        //first we want get number of position on array that we will be put our element
        int position = getElementPosition(key , dest.length);
        Entry existedElement = dest[position];


        if (existedElement==null){
            //if the cell is empty set new element here
            // null for the next
            // parameters key value next
            Entry entry = new Entry(key,value,null);
            dest[position]=entry;
            //
            //size must be grown, but now its growth outside of method
            //size++;
            //
            //if we have something in the array we must check
            //if the key is same?
            //if next element cell  is free?//here is the problem (or forgot to add)
            return true;
        }else{
            //because of this is may be linked list we must put that process in the loop
            //so we can move forward in the linked list
            //unlimited
            while(true) {
                //if key already exist we will rewrite value,because we cannot save same keys,objects in hash map
                if (existedElement.key.equals(key)) {
                    //rewrite object values
                    existedElement.value=value;
                    //quit from loop
                    //you didnt add you a replace value
                    return false;
                }
                //if keys didnt same check the next element in linked list
                //check the next element
                if (existedElement.next == null) {
                    existedElement.next = new Entry(key,value, null);
                    //
                    //
                    //size must be grown, but now its growth outside of method
                    //size++;
                    //
                    //
                    //quit from loop
                    return true;
                }
                //check the next element
                existedElement = existedElement.next;

            }

        }
    }
    @Override
    public void put(CarOwner key, Car value) {
        //increase array if need
        if(size>=(array.length*LOAD_FACTOR)){
            increaseArray();
        }
        //that element put elements to array

        boolean put = put(key,value,array);
        //if true size +
        //if false size -
        if(put){
            size++;
        }
    }




    @Override
    public Car get(CarOwner key) {
        //first we want get number of position on array that we want to return
        int position = getElementPosition(key , array.length);
        //this element in cell
        Entry existedElement = array[position];
        //now we must check linked list of cell
        //next element


        //because of this is may be linked list we must put that process in the loop
        //so we can move forward in the linked list

        while(existedElement.next != null) {
            //check the next element
            existedElement = existedElement.next;
            //if we found same key we will return value a car
            if(existedElement.key.equals(key)){
                return existedElement.value;
            }
        }
        //if we didnt found car return null
        return null;

    }

    @Override
    public Set<CarOwner> keySet() {
        Set<CarOwner> result = new HashSet<CarOwner>();

        for(Entry entry : array){
            Entry existedElement=entry;
            while (existedElement!=null){
                //put value into result set
                result.add(existedElement.key);
                //move to the next element
                existedElement=existedElement.next;
            }
        }


        return result;
    }

    @Override
    public List<Car> values() {
        List<Car> result = new ArrayList<Car>();

        for(Entry entry : array){
            Entry existedElement=entry;
            while (existedElement!=null){
                //put key into result set
                result.add(existedElement.value);
                //move to the next element
                existedElement=existedElement.next;
            }
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean remove(CarOwner key) {
        //first we want get number of position on array that we want to return
        int position = getElementPosition(key , array.length);
        //this element in cell
        Entry existedElement = array[position];
        //now we must check linked list of cell
        //next element


        //because of this is may be linked list we must put that process in the loop
        //so we can move forward in the linked list

        if(existedElement != null && existedElement.key.equals(key)) {
            //rewrite reference
            //value of array[position] is move outside linked list and next.element take it place
            array[position]=existedElement.next;
            //size must be decreased
            size--;
            //successful deletion
            return true;
        }else{
            //if keys doesnt equals try next element until it done
            while(existedElement.next != null) {
                //check the next element
                Entry nextElement = existedElement.next;
                if(nextElement==null){
                    return false;
                }
                //if we found same key we will return value a car
                if(nextElement.key.equals(key)){
                    existedElement.next=nextElement.next;
                        size--;
                    return true;
                }
                //move to next element in linked list
                existedElement=existedElement.next;
            }
        }

        //if we didnt found car return false
        //
        return false;
    }

}
