import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {
    static Stream<Arguments> streamProvider() {
        return Stream.of(
                Arguments.of(new int[]{100, 5, 20}, new int[]{5, 20, 100}),
                Arguments.of(new int[]{3, 6, 7, 1}, new int[]{1, 3, 6, 7}),
                Arguments.of(new int[]{2, 222, 22, 2222}, new int[]{2, 22, 222, 2222}),
                Arguments.of(new int[]{1, 9, 3, 7, 5}, new int[]{1, 3, 5, 7, 9}),
                Arguments.of(new int[]{2, 6, 10, 4, 8}, new int[]{2, 4, 6, 8, 10})
        );
    }

    @ParameterizedTest(name="#{index} - Test with Argument {0}, {1}")
    @MethodSource("streamProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int[] result = new int[random_array.length];
        System.out.println("random_array " + Arrays.toString(random_array));
        System.out.println("correct_array " + Arrays.toString(correct_array));

        for(index=0; index < random_array.length; index++){
            test.add(random_array[index]);
        }
        System.out.println("test " + test);

        for(index=0; index < random_array.length; index++){
            result[index] = test.poll();
        }
        System.out.println("result " + Arrays.toString(result));
        assertEquals(Arrays.toString(correct_array), Arrays.toString(result));
    }

    @Test
    public void whenExceptionThrown_ThenNullPointerException(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
            queue.add(null);
        });
        System.out.println("exception " + exception);

    }

    @Test
    public void whenExceptionThrown_thenClassCastException() {
        Exception exception = assertThrows(ClassCastException.class, () -> {
            Queue queue = new PriorityQueue();
            queue.add(new Object());
        });
        System.out.println("exception " + exception);

    }

    @Test
    public void whenExceptionThrown_thenInitialCapacity() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Queue queue = new PriorityQueue(0);
        });
        System.out.println("exception " + exception);
    }

}