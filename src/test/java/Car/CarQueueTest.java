package Car;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarQueueTest {
    private CarQueue queue;
    @Before
    public void setUp() throws Exception {
        //init
        queue=new CarLinkedList();
        for (int i = 0; i<10; i++){
            queue.add(new Car("brand"+i,i));
        }
    }

    @Test
    public void add() {

        assertEquals(10,queue.size());
    }

    @Test
    public void peak() {
        Car car = queue.peak();
        assertEquals("brand0",car.getBrand());
        assertEquals(10,queue.size());
    }

    @Test
    public void poll() {
        Car car = queue.poll();
        assertEquals("brand0",car.getBrand());
        assertEquals(9,queue.size());
    }
}