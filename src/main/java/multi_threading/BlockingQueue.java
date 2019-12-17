package multi_threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueue {

    ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    ArrayBlockingQueue<String> arrayQueue = new ArrayBlockingQueue<>(256);

    LinkedBlockingDeque<String> linkedQueue = new LinkedBlockingDeque<>();

    PriorityBlockingQueue<String> pq = new PriorityBlockingQueue<>();



}
