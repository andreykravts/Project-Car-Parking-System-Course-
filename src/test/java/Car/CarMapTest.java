package Car;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarMapTest {
    private CarMap map;
    private Car testCar;
    private CarOwner key;
    @Before
    public void setUp() throws Exception {
        //init
        map = new CarMapList();
    }

    @Test
    public void whenPut100ElementsThenSizeBecome100() {
        for(int i =0;i<100;i++){
            key=new CarOwner(i,"Name"+i,"LastName"+i);
            testCar=new Car(("Brand"+i),i);
            map.put(key,testCar);
        }
        assertEquals(100,map.size());

    }
    //the keys cant be same so we will check it in this test
    @Test
    public void whenPut100ElementsWith10KeysThenSizeBecome10() {
        for(int i =0;i<100;i++){
            int index = i % 10;
            key=new CarOwner(index,"Name"+index,"LastName"+index);
            testCar=new Car(("Brand"+index),index);
            map.put(key,testCar);
        }
        assertEquals(10,map.size());

    }

    @Test
    public void methodGetMustReturnRightValue() {
        for(int i =0;i<100;i++){
            key=new CarOwner(i,"Name"+i,"LastName"+i);
            testCar=new Car(("Brand"+i),i);
            map.put(key,testCar);
        }
        key=new CarOwner(50,"firstname"+50,"secondname"+50);

        Car value = map.get(key);
        String expectedCarBrand="Brand50";

        assertEquals(expectedCarBrand,value.getBrand());
    }

    @Test
    public void countOfKeysMustBeEqualsToCountOfValues() {
        for(int i =0;i<100;i++){
            key=new CarOwner(i,"Name"+i,"LastName"+i);
            testCar=new Car(("Brand"+i),i);
            map.put(key,testCar);
        }
        assertEquals(100,map.size());
        assertEquals(100,map.keySet().size());
        assertEquals(100,map.values().size());
    }

    @Test
    public void whenRemoveOneElementTheResultWillBe99AndWeCantDeleteSameObjectTwice() {
        for(int i =0;i<100;i++){
            key=new CarOwner(i,"Name"+i,"LastName"+i);
            testCar=new Car(("Brand"+i),i);
            map.put(key,testCar);
        }
        assertEquals(100,map.size());
        key=new CarOwner(2,"Name"+2,"LastName"+2);
        assertTrue(map.remove(key));
        assertEquals(99,map.size());
        assertFalse(map.remove(key));

    }

    @Test
    public void whenPut100ElementsThenSizeBecome100CheckWhatSizeOfListMap() {
        for(int i =0;i<100;i++){
            key=new CarOwner(i,"Name"+i,"LastName"+i);
            testCar=new Car(("Brand"+i),i);
            map.put(key,testCar);
        }
        assertEquals(100,map.size());
    }

    @Test
    public void clear() {
        map.clear();
        assertEquals(0,map.size());
    }
}