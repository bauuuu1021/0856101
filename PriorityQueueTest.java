import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(value=Parameterized.class)
public class PriorityQueueTest {

    private PriorityQueue<Integer> random, testQueue;
    private Integer[] correct;

    @Parameters
    public static Collection testCase() {
        return Arrays.asList(new Integer[][][] {
                {{2, 3, 1}, {1, 2, 3}},
                {{1, 3, -1}, {-1, 1, 3}},
                {{100, -1, 8, 32}, {-1, 8, 32, 100}},
                {{5, 10, 30, 20, 15}, {5, 10, 15, 20, 30}},
                {{-800, 5, 67, -44, 465, 7412}, {-800, -44, 5, 67, 465, 7412}}
        });
    }

    public PriorityQueueTest(Integer[] a, Integer[] b) {
        random = new PriorityQueue<Integer>();
        Collections.addAll(random, a);
        correct = b;
    }

    @Test
    public void pollTest() {
        int index = 0;
        assertEquals(correct.length, random.size());
        while (!(random.isEmpty())) {
            assertEquals(correct[index++], random.poll());
        }
    }

    @Test(expected = NullPointerException.class)
    public void add_null() {
        testQueue = new PriorityQueue<Integer>();
        testQueue.add(null);
    }

    @Test(expected = NullPointerException.class)
    public void create_nullArr() {
        testQueue = new PriorityQueue<Integer>();
        Integer[] arr = null;
        testQueue.toArray(arr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrong_type() {
    	PriorityQueue priority = new PriorityQueue<Integer>(-1);
    }
}
