// 多一个位置来判断空满
class MyCircularQueue {
    int[] queue;
    int front;
    int rear;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k + 1];
        front = 0;
        rear = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is
     * successful.
     */
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is
     * successful.
     */
    public boolean deQueue() {
        if (isEmpty())
            return false;
        front = (front + 1) % queue.length;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty())
            return -1;
        return queue[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty())
            return -1;
        return queue[(rear - 1 + queue.length) % queue.length];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if (front == rear)
            return true;
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if ((rear + 1) % queue.length == front)
            return true;
        return false;
    }
}

// 用flag标识位 判断空满
class MyCircularQueue {
    int[] queue;
    int front;
    int rear;
    boolean flag;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k];
        front = 0;
        rear = 0;
        flag = true;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is
     * successful.
     */
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        queue[rear] = value;
        if (rear + 1 >= queue.length)
            flag = false;
        rear = (rear + 1) % queue.length;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is
     * successful.
     */
    public boolean deQueue() {
        if (isEmpty())
            return false;
        if (front + 1 >= queue.length)
            flag = true;
        front = (front + 1 + queue.length) % queue.length;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty())
            return -1;
        return queue[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty())
            return -1;
        return queue[(rear + queue.length - 1) % queue.length];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if (front == rear && flag)
            return true;
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if (rear == front && !flag)
            return true;
        return false;
    }
}
