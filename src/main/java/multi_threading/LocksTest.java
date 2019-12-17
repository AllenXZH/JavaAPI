package multi_threading;

import java.util.concurrent.locks.*;

public class LocksTest {

    static Lock reentrantLock = new ReentrantLock();

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static StampedLock stampedLock = new StampedLock();


    public static void main(String[] args) {

        reentrantLock.tryLock();
        reentrantLock.unlock();

        Lock readLock = readWriteLock.readLock();
        readLock.lock();

        try {
            //
        } catch (Exception e) {

        } finally {
            readLock.unlock();
        }
    }
}
