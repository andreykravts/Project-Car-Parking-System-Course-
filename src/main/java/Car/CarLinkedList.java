package Car;

import java.util.Iterator;

public class CarLinkedList implements CarList, CarQueue{
    private Node first;
    private Node last;
    private int size=0;



    @Override
    public Car peak() {
        return size>0 ? get(0):null;
//        if(size > 0){
//            return get(0);
//        }
//        return null;
    }

    @Override
    public Car poll() {
        Car car = get(0);
        removeAt(0);
        return car;
    }

    @Override
    public Car get(int index) {


        return getNode(index).value;
    }

    @Override
    public boolean removeAt(int index) {
        Node nodeDelete=getNode(index);
        Node nodeNext=nodeDelete.next;
        Node nodePrevious=nodeDelete.previous;
        //what if nodeNext is null?

        if(nodeNext!=null) {
            nodeNext.previous=nodePrevious;
        }else{
            last=nodePrevious;

        }


        //what if nodePrevious is null?
        if(nodePrevious!=null) {
            nodePrevious.next = nodeNext;
        }else{
            first=nodeNext;
        }
            size--;
            return true;

        //garbage collector will be deleted object that didn't have any reference on it and free memory
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first=null;
        last=null;
        size=0;
    }

    @Override
    public boolean contain(Car car) {
        return findElement(car) != -1;
    }



    @Override
    public boolean add(Car car, int index) {
        if(index<0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(index==size){

            //if you get there do exit from the method
            return add(car);
        }
        //get reference to object node in index

        Node nodeNext=getNode(index);
        Node nodePrevious = nodeNext.previous;
        //make new object create reference to next and previous values
        Node newNode=new Node(nodePrevious,car,nodeNext);
        //make changes on the Previous and Next Node make changes in their references
        //first we will change reference in the next node
        nodeNext.previous=newNode;

        //second we will change reference in the previous node
        if(nodePrevious!=null){
            //if this is not first node in our collection
            nodePrevious.next=newNode;
        }else{
            //if this is first node in our collection change reference of first
            first=newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(Car car) {
        //check if we had at least 1 value in the collection if not add this one
        if(size==0){
            Node node = new Node(null,car,null);
            first=node;
            last=node;
        }else{
            Node secondLast=last;
            last=new Node(secondLast,car,null);
            secondLast.next=last;

        }
        size++;
        return true;
    }


    @Override
    public boolean remove(Car car) {
        int result=findElement(car);
        if(result>-1){
            return removeAt(result);
        }
        return false;
    }


    private int findElement(Car car) {
        int result = -1;
        Node node =first;
        for(int i=0;i<size;i++){
            if(node.value.equals(car)){
                result=i;
            }
            //put it in the end
            node=node.next;
        }
        return result;
    }


    private Node getNode(int index){
        //check if index in bounds
        if(index<0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for(int i=0;i<index;i++){
            node = node.next;
        }
        return node;
    }

    //must be in use must be overrided
    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {
            private Node node = first;
            int index =0;
            //check if you have another element in collection
            @Override
            public boolean hasNext() {
                //collection will have elements if index less than size
                return node !=null;
            }
            //return next element in collection
            @Override
            public Car next() {
                Car car = node.value;
                node=node.next;
                return car;
            }
        };
    }


    private static class Node{
        private Node previous;
        private Car value;
        private Node next;

        public Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }


}

