package Car;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;





public class CarListTest {
    //method before will be called before each method
    private CarList carList;
    private Car testCar;
    @Before
    public void setUp() throws Exception {
        //init
        //initialize solution with array list
//        carList = new CarArrayList();

        //initialize solution with Linked list
        carList = new CarLinkedList();
        //init
        for(int i =0;i<100;i++){
            carList.add(new Car(("Brand"+i),i));

        }
        testCar = new Car("Toyota",15);
    }
    @Test
    public void whenAdded100ElementsThenSizeMustBe100(){

        assertEquals(100,carList.size());
    }
    @Test
    public void whenCarAddedTryToFoundWithContainsMethod(){

        assertEquals(100,carList.size());
        assertTrue(carList.add(testCar));
        assertEquals(101,carList.size());
        assertTrue(carList.contain(testCar));

    }


    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased(){

        assertEquals(100,carList.size());

        assertTrue(carList.removeAt(5));

        assertEquals(99,carList.size());

    }
    @Test
    public void whenElementRemovedThenSizeMustBeDecreased(){
        carList.add(testCar);
        assertEquals(101,carList.size());
        assertTrue(carList.remove(testCar));
        assertEquals(100,carList.size());

    }
    @Test
    public void whenNonExistElementRemovedThenReturnFalse(){

        assertFalse(carList.remove(testCar));
    }
    @Test
    public void whenListClearedTheSizeMustBe0(){
        carList.clear();
        assertEquals(0,carList.size());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownException(){
        //we set only 100 places so last one must be 99 and not 100
        carList.get(100);
    }
    @Test
    public void methodGetReturnRightValue(){
        testCar=carList.get(0);
        assertEquals("Brand0",testCar.getBrand());
    }
    @Test
    public void methodAddCarWithIndexIntoMiddleOfArray(){
        testCar=new Car("BMW",50);
        carList.add(testCar,50);
        assertEquals(101,carList.size());
        Car carFromList = carList.get(50);
        assertEquals("BMW", carFromList.getBrand());
    }
    @Test
    public void methodAddCarWithIndexIntoStartOfArray(){
        testCar=new Car("BMW",0);
        carList.add(testCar,0);
        assertEquals(101,carList.size());
        Car carFromList = carList.get(0);
        assertEquals("BMW", carFromList.getBrand());
    }
    @Test
    public void methodAddCarWithIndexIntoEndOfArray(){
        testCar=new Car("BMW",1);
        carList.add(testCar,100);
        assertEquals(101,carList.size());
        Car carFromList = carList.get(100);
        assertEquals("BMW", carFromList.getBrand());
    }
}