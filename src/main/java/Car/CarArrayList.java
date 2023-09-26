package Car;

import java.util.Arrays;
import java.util.Iterator;

public class CarArrayList implements CarList{

    private Car[] array=new Car[10];
    private int size=0;

    private void checkIndex(int index){
        //use it everythere
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
    @Override
    public Car get(int index) {

        checkIndex(index);
        return array[index];

    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array=new Car[10];
        size=0;
    }

    @Override
    public boolean contain(Car car) {
        return findElement(car) != -1;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
//        for (int i = index; i< size-1; i++){
//            array[i]=array[i+1];
//        }

        if(index<0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index+1, array, index, size -1- index);


        size--;
        return true;
    }
    @Override
    public boolean add(Car car) {
        //check if array must grow up
        increaseArray();
        array[size]=car;
        size++;
        return true;

    }

    @Override
    public boolean remove(Car car) {
        return removeAt(findElement(car));
    }
    public int findElement(Car car) {
        int result=-1;
        for(int i = 0; i< size; i++){
            if(array[i].equals(car)){
                result=i;
            }
        }
        return result;
    }

    @Override
    public boolean add(Car car,int index) {

        increaseArray();
        //before
//        for (int i = size; i>index; i--){
//            array[i]=array[i-1];

        //after
        //that will be work much faster
        if(index<0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);

        array[index]=car;
        size++;
        return true;
    }
    private void increaseArray(){
        //old fashion way
//        if(size>=array.length){
//            Car[] newArray=new Car[array.length*2];
//            for(int i = 0; i< array.length; i++){
//                newArray[i]=array[i];
//            }
//            array=newArray;
//        }
        //new fashion way
        if(size>=array.length){
            array= Arrays.copyOf(array,array.length*2);
        }
    }
    //must be in use must be overrided
    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {

            int index =0;


            //check if you have another element in collection
            @Override
            public boolean hasNext() {
                //collection will have elements if index less than size
                return index < size;
            }
            //return next element in collection
            @Override
            public Car next() {
//                Car car = array[index++];
//                return car;
                //short statement
                return array[index++];
            }
        };
    }
}
