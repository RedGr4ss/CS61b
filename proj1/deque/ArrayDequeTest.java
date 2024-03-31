package deque;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {
        ArrayDeque<String> ad = new ArrayDeque<>();

        assertTrue("A newly initialized ArrayDeque should be empty", ad.isEmpty());
        ad.addFirst("front");

        assertEquals(1, ad.size());
        assertFalse("ArrayDeque should now contain 1 item", ad.isEmpty());

        ad.addLast("middle");
        assertEquals(2, ad.size());

        ad.addLast("back");
        assertEquals(3, ad.size());

        System.out.println("Printing out deque: ");
        ad.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that ad is empty afterwards. */
    public void addRemoveTest() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        assertTrue("ArrayDeque should be empty upon initialization", ad.isEmpty());

        ad.addFirst(10);

        assertFalse("ArrayDeque should not be empty after adding an item", ad.isEmpty());

        ad.removeFirst();

        assertTrue("ArrayDeque should be empty after removal", ad.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(3);

        ad.removeLast();
        ad.removeFirst();
        ad.removeLast();
        ad.removeFirst();

        assertEquals("Size of deque should be 0 after removing from an empty deque", 0, ad.size());
    }

    @Test
    /* Check if you can create ArrayDeques with different parameterized types*/
    public void multipleParamTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<>();
        ArrayDeque<Double> ad2 = new ArrayDeque<>();
        ArrayDeque<Boolean> ad3 = new ArrayDeque<>();

        ad1.addFirst("string");
        ad2.addFirst(3.14159);
        ad3.addFirst(true);

        String s = ad1.removeFirst();
        double d = ad2.removeFirst();
        boolean b = ad3.removeFirst();
    }

    @Test
    /* check if null is returned when removing from an empty ArrayDeque. */
    public void emptyNullReturnTest() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        assertNull("Should return null when removeFirst is called on an empty Deque", ad.removeFirst());
        assertNull("Should return null when removeLast is called on an empty Deque", ad.removeLast());
    }

    @Test
    /* Add a large number of elements to deque; check if order is correct. */
    public void bigArrayDequeTest() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < 1000000; i++) {
            ad.addLast(i);
        }

        for (int i = 0; i < 100000; i++) {
            assertEquals("Should have the same value", i, (int) ad.removeFirst());
        }

        for (int i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (int) ad.removeLast());
        }
    }
    @Test
    public void remove(){
    ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            ad.addLast(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(ad.removeFirst());
        }
    }
}
