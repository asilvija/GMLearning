public class MonitarableQueue implements Queue {
    private final Object[] _queue;
    private int _front = 0;
    private int rear = -1;
    private final int _maxSize;

    public MonitarableQueue(int maxSize) {
        _maxSize = maxSize;
        _queue = new Object[maxSize];
    }

    // add (store) an item to the queue
    public boolean enqueue(Object obj) {
        if (isFull()) {
            try {
                throw new Exception("Overflow error!");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            getQueue()[++rear] = obj;
        }
        return true;
    }

    // remove (access) an item from the queue.
    public Object dequeue() {
        if (isEmpty()) {
            return 0;
        }
        Object obj = getQueue()[_front];
        _front++;
        return obj;
    }

    public boolean isFull() {
        return rear >= _maxSize - 1;
    }

    public boolean isEmpty() {
        return (_front < 0 || _front > rear);
    }

    public Object peek() {
        return getQueue()[_front];
    }

    public Object[] getQueue() {
        return _queue;
    }

}
