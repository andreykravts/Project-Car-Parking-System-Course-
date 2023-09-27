package Car;

import java.util.Iterator;

public class CarHashSet implements CarSet{
    private static final double LOAD_FACTOR=0.75;
    private static int INITIAL_CAPACITY=16;
    private Entry[] array = new Entry[INITIAL_CAPACITY];
    private int size=0;



    //////////////////////////////////////////////////
//    private Map<Car,Object> map = new HashMap<>();
//    private Object obj=new Object();
//
//    @Override
//    public boolean add(Car car) {
//        if(map.containsKey(car)){
//            return false;
//        }else {
//            map.put(car, obj);
//            return true;
//        }
//    }
//    @Override
//    public boolean remove(Car car) {
//        Object removed = map.remove(car, obj);
//        return removed != null;
//    }
//
//    @Override
//    public boolean contain(Car car) {
//        return map.containsKey(car);
//    }
//    @Override
//    public int size() {
//        return map.size();
//    }
//    @Override
//    public void clear() {
//        map.clear();
//    }
//
//
//    @Override
//    public Iterator<Car> iterator() {
//        return map.keySet().iterator();
//    }

    ///////////////////////////////////////////



    @Override
    public boolean add(Car car) {

        //high persent of collision
        //use loadFactor
        if(size>=(array.length*LOAD_FACTOR)){
            increaseArray();
        }
        boolean added=add(car,array);
        if(added) {
            size++;
        }
        return added;


    }


    public boolean add(Car car, Entry[] dst) {
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
    public boolean remove(Car car) {
        //first we want get number of position on array that we will be put our element
        int position = getElementPosition(car , array.length);
        if (array[position]==null){
            return false;

        }else{
            // check next
            Entry secondLast = array[position];
            Entry last = secondLast.next;
            if(secondLast.value.equals(car)){
                array[position] = last;
                size--;
                return true;
            }
            while(last!=null) {
                if (last.value.equals(car)) {
                    secondLast.next = last.next;
                    size--;
                    return true;
                } else {
                    secondLast = last;
                    last = last.next;
                }
            }
            return false;
        }

    }
    @Override
    public boolean contain(Car car) {
        //first we want get number of position on array that we will be put our element
        int position = getElementPosition(car , array.length);
        if (array[position]==null){
            return false;

        }else{
            // check next
            Entry secondLast = array[position];
            Entry last = secondLast.next;
            if(secondLast.value.equals(car)){
                return true;
            }
            while(last!=null) {
                if (last.value.equals(car)) {
                    return true;
                } else {
                    last = last.next;
                }
            }
            return false;
        }

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

    private int getElementPosition(Car car,int arrayLenght){
        // car hash code = 16
        // 16 % 16 =1
        //put it in cell number 1


        //we must sure that result that will back will positive because we can search for cell with negative value
        // use Math.abs
        //get absolute value of the number
        return Math.abs(car.hashCode() % arrayLenght);
    }


    private void increaseArray(){
        Entry[] newArray = new Entry[INITIAL_CAPACITY*2];
        for(Entry entry : array){
            Entry existedElement = entry;
            while(existedElement!=null){
                add(existedElement.value, newArray);
                existedElement = existedElement.next;
            }
        }
        array=newArray;
    }

    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {

            int index = 0;

            //index of cell in array
            int arrayIndex=0;

            //object entry
            Entry entry;



            @Override
            public boolean hasNext() {

                return index<size;
            }

            @Override
            public Car next() {
                //find cell into array that have some value into
                while(array[arrayIndex]==null){
                    arrayIndex++;
                }
                //check what status of entry
                if(entry==null){
                    entry=array[arrayIndex];
                }
                //element
                Car result = entry.value;
                //set into entry next element of linked list
                entry = entry.next;
                //here we checked if linked list is ended and we must move forward into array
                if(entry==null){
                    arrayIndex++;
                }
                index++;
                return result;
            }
        };
    }


    private static class Entry{
        private Car value;
        private Entry next;

        public Entry(Car value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }
}
