
public interface Queue {
 boolean enqueue(Object obj);
 Object dequeue();
 boolean isFull();
 boolean isEmpty();
 Object peek();
}
