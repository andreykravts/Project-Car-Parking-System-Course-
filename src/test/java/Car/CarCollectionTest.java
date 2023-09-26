package Car;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarCollectionTest {
    private CarCollection carCollection;
    @Before
    public void setUp() throws Exception {
        carCollection = new CarHashSet();
        //carCollection = new CarArrayList();
        //carCollection = new CarLinkedList();
        for(int i =0;i<100;i++) {
            carCollection.add(new Car(("Brand" + i), i));
        }
    }

    @Test
    public void whenCarAddedTryToFoundWithContainsMethod(){

        assertEquals(100,carCollection.size());
        assertTrue(carCollection.contain(new Car("Brand20", 20)));

    }
    @Test
    public void testforEachLoop(){

        int index = 0;
//        //ask if have next value?
//        while(carCollection.iterator().hasNext()){
//            //put next value in the variable
//            Car car =carCollection.iterator().next();
//        }
        for(Car car : carCollection){
            index++;
        }
        assertEquals(100,index);

    }

}