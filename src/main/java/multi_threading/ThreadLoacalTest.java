package multi_threading;

public class ThreadLoacalTest {

    ThreadLocal<Integer> a = new ThreadLocal<Integer>();

    public void test() {
        a.get();
        a.set(1);
    }
}
