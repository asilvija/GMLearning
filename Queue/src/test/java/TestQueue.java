import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestQueue {

    @Test
    public void testQueue() {
       Queue queue = new MonitarableQueue(5);
       Object obj1 = 2;
       Object obj2 = 5;
       Object obj3 = 8;
       
       queue.enqueue(obj1);
       boolean test1 = queue.enqueue(obj2);
       queue.enqueue(obj3);
       
       assertThat(test1, is(true));
       assertThat(queue.peek(),is(obj1));
       assertThat(queue.dequeue(), is(obj1));
    }

}
