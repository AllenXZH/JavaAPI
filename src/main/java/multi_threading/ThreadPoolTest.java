package multi_threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    /**
     * Creates a new {@code ThreadPoolExecutor} with the given initial
     * parameters.
     *
     * param corePoolSize the number of threads to keep in the pool, even
     *        if they are idle, unless {@code allowCoreThreadTimeOut} is set
     * param maximumPoolSize the maximum number of threads to allow in the
     *        pool
     * param keepAliveTime when the number of threads is greater than
     *        the core, this is the maximum time that excess idle threads
     *        will wait for new tasks before terminating.
     * param unit the time unit for the {@code keepAliveTime} argument
     * param workQueue the queue to use for holding tasks before they are
     *        executed.  This queue will hold only the {@code Runnable}
     *        tasks submitted by the {@code execute} method.
     * param threadFactory the factory to use when the executor
     *        creates a new thread
     * param handler the handler to use when execution is blocked
     *        because the thread bounds and queue capacities are reached
     * throws IllegalArgumentException if one of the following holds:<br>
     *         {@code corePoolSize < 0}<br>
     *         {@code keepAliveTime < 0}<br>
     *         {@code maximumPoolSize <= 0}<br>
     *         {@code maximumPoolSize < corePoolSize}
     * throws NullPointerException if {@code workQueue}
     *         or {@code threadFactory} or {@code handler} is null
     */

    public static void main(String[] agrs) {

        ExecutorService excutor = new ThreadPoolExecutor(5, 10, 10000,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100) );

        excutor.submit(() -> {System.out.println("a new thread");} );
    }
}
