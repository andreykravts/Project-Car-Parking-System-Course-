package Car;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;

public class CarSetTest {
    //method before will be called before each method
    private CarSet carSet;
    private Car testCar;
    @Before
    public void setUp() throws Exception {
        //init

        //initialize solution with hashsetlist
        carSet = new CarHashSet();
        //init
        for(int i =0;i<100;i++){
            carSet.add(new Car(("Brand"+i),i));

        }
        testCar = new Car("Toyota",15);
    }
    @Test
    public void whenWeTryAddNumberOfSameElementsOnlyOneOfThemWillBeAdded(){
        assertEquals(100,carSet.size());
        assertTrue(carSet.add(testCar));
        assertFalse(carSet.add(testCar));
        assertFalse(carSet.add(testCar));
        assertFalse(carSet.add(testCar));
        assertFalse(carSet.add(testCar));
        assertEquals(101,carSet.size());
    }
    @Test
    public void whenElementRemovedThenReturnTrue(){
        assertEquals(100,carSet.size());
        carSet.add(testCar);
        assertTrue(carSet.remove(testCar));
        assertEquals(100,carSet.size());
    }


    @Test
    public void whenTryRemoveSaneElement2TimesThenReturnFales(){
        assertEquals(100,carSet.size());
        carSet.add(testCar);
        assertTrue(carSet.remove(testCar));
        assertFalse(carSet.remove(testCar));
        assertEquals(100,carSet.size());
    }

    @Test
    public void whenTryToRemoveTheElementThatDidntExistsThenReturnFalse(){
        assertFalse(carSet.remove(testCar));
    }
    @Test
    public void whenListClearedtheSizeMustBe0(){
        carSet.clear();
        assertEquals(0,carSet.size());
    }

    @Test
    public void whenElementAddedThenSizeMustBeIncreased(){
        assertEquals(100,carSet.size());
        carSet.add(testCar);
        assertEquals(101,carSet.size());
    }


    @Test
    public void whenElementRemovedThenSizeMustBeDecreased(){
        carSet.add(testCar);
        assertEquals(101,carSet.size());
        assertTrue(carSet.remove(testCar));
        assertEquals(100,carSet.size());

    }
    @Test
    public void whenAdded100ElementsThenSizeMustBe100(){

        assertEquals(100,carSet.size());
    }
    @Test
    public void whenCarAddedTryToFoundWithContainsMethod(){

        assertEquals(100,carSet.size());
        assertTrue(carSet.add(testCar));
        assertEquals(101,carSet.size());
        assertTrue(carSet.contain(testCar));

    }
}