import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LinkedListTest tests the LinkedList class
 *
 * @author  Valerie Foster
 * @version 2/6/2018
 */
public class LinkedListTest {

    LinkedList<Integer> testList;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        testList = new LinkedList<Integer>();
        testList.addAtEnd(1);
        testList.addAtEnd(2);
        testList.addAtEnd(3);
        testList.addAtEnd(4);
    }

    @Test
    public void testBasics() {
        assertEquals(4, testList.size());
    }
    
    @Test
    public void testClear() {
        testList.clear();
        assertEquals(0, testList.size());
    }
    
    @Test
    public void testGetElement() {
        Integer num = 2;
        assertEquals(num, testList.getElement(2));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testGetElementPrecon1() {
        testList.getElement(5);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testGetElementPrecon2() {
        testList.getElement(-5);
    }
    
    @Test
    public void testAddAtPos() {
        Integer num1 = -1;
        Integer num2 = -2;
        Integer num3 = -3;
        // case of adding a value at the front, uses addAtFront method
        testList.addAtPos(1, num1);
        assertEquals(num1, testList.getElement(1));
        // case of adding a value in the middle
        testList.addAtPos(3, num2);
        assertEquals(num2, testList.getElement(3));
        // case of adding a value at the end, uses addAtEnd method
        testList.addAtPos(7, num3);
        assertEquals(num3, testList.getElement(7));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAddAtPosPrecon1() {
        testList.addAtPos(7, 7);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAddAtPosPrecon2() {
        testList.addAtPos(-7, 7);
    }
    
    @Test
    public void testRemove() {
        // case of removing a value at the beginning
        testList.remove(1);
        assertEquals(3, testList.size());
        // case of removing a value in the middle
        testList.remove(2);
        assertEquals(2, testList.size());
        // case of removing a value at the end
        testList.remove(2);
        assertEquals(1, testList.size());
        // case of removing the only value in the list
        testList.remove(1);
        assertEquals(0, testList.size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemovePrecon1() {
        testList.remove(5);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testRemovePrecon2() {
        testList.remove(-5);
    }
    
    @Test
    public void testMoveUp() {
        // case of moving a value not in the list
        assertFalse(testList.moveUp(7));
        // case of moving a value at the top
        assertFalse(testList.moveUp(1));
        // case of moving a value second from the top
        Integer num1 = 2;
        testList.moveUp(num1);
        assertEquals(num1, testList.getElement(1));
        // case of moving a value in the middle
        Integer num2 = 3;
        testList.moveUp(num2);
        assertEquals(num2, testList.getElement(2));
        // case of moving a value at the bottom
        Integer num3 = 4;
        testList.moveUp(num3);
        assertEquals(num3, testList.getElement(3));
        
        testList.clear();
        Integer int1 = -1;
        Integer int2 = -2;
        testList.addAtEnd(int1);
        // case of only one element in the list
        assertFalse(testList.moveUp(int1));
        testList.addAtEnd(int2);
        // case of only two elements in the list
        testList.moveUp(int2);
        assertEquals(int2, testList.getElement(1));
    }
    
    @Test
    public void testMoveDown() {
        // case of moving a value not in the list
        assertFalse(testList.moveDown(7));
        // case of moving a value at the bottom
        assertFalse(testList.moveDown(4));
        // case of moving a value second from the bottom
        Integer num1 = 3;
        testList.moveDown(num1);
        assertEquals(num1, testList.getElement(4));
        // case of moving a value in the middle
        Integer num2 = 2;
        testList.moveDown(num2);
        assertEquals(num2, testList.getElement(3));
        // case of moving a value at the top
        Integer num3 = 1;
        testList.moveDown(num3);
        assertEquals(num3, testList.getElement(2));
        
        testList.clear();
        Integer int1 = -1;
        Integer int2 = -2;
        testList.addAtEnd(int1);
        // case of only one element in the list
        assertFalse(testList.moveDown(int1));
        testList.addAtEnd(int2);
        // case of only two elements in the list
        testList.moveDown(int1);
        assertEquals(int1, testList.getElement(2));
    }
    
}
