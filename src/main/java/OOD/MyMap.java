package OOD;

import java.util.*;
import javafx.util.Pair;

public class MyMap {

    int size = 0;

    List<Pair<Integer, Integer>>[] buckets = new ArrayList[10];

    public void put(int key, int value) {
        int index = key % buckets.length;
        System.out.println("key:" + key + "  index:" + index);
        if (buckets[index] == null) {
            buckets[index] = new ArrayList<>();
        }
        for (int i = 0; i < buckets[index].size(); i++) {
            if (buckets[index].get(i).getKey() == key) {
                buckets[index].remove(i);
                break;
            }
        }
        buckets[index].add(new Pair<>(key, value));
        size++;
        if (buckets[index].size() > 4) {
            extend();
        }
    }

    public int get(int key) {
        int index = key % buckets.length;
        if (buckets[index] == null) {
            throw new NullPointerException();
        }
        Pair<Integer, Integer> pair = getBucketPair(index, key);
        if (pair == null) {
            throw new NullPointerException();
        }
        return pair.getValue();
    }

    public boolean containsKey(int key) {
        int index = key % buckets.length;
        if (buckets[index] == null) {
            return false;
        }
        if (getBucketPair(index, key) != null) {
            return true;
        }
        return false;
    }

    private Pair<Integer, Integer> getBucketPair(int index, int key) {
        if (buckets[index] == null) {
            return null;
        }
        for (Pair<Integer, Integer> pair : buckets[index]) {
            if (pair.getKey() == key) {
                return pair;
            }
        }
        return null;
    }

    private void extend() {
        System.out.println("!!!!!!!!!!!! extend !!!!!!!!!!!!!!");
        List<Pair<Integer, Integer>>[] oldBuckets = buckets;
        buckets = new ArrayList[oldBuckets.length * 2];

        for (List<Pair<Integer, Integer>> list : oldBuckets) {
            if (list != null) {
                for (Pair<Integer, Integer> pair : list) {
                    put(pair.getKey(), pair.getValue());
                }
            }
        }
    }


    public int size() {
        return this.size;
    }

    //Test
    public static void main(String[] args) {
        MyMap map = new MyMap();

        map.put(1, 1);
        map.put(3, 3);
        map.put(4, 4);

        System.out.println(map.size()); // 3
        System.out.println(map.containsKey(1)); // true
        System.out.println(map.containsKey(5)); // false
        System.out.println(map.get(3)); // 3
        System.out.println(map.get(4)); // 4


        System.out.println("--------------------------");

        map.put(13, 13);
        map.put(23, 23);
        map.put(33, 33);
        map.put(43, 43);
        System.out.println(map.buckets[3].size());
        System.out.println(map.buckets.length); // 20

        System.out.println("--------------------------");

        map.put(1, 5);
        System.out.println(map.get(1)); // 5

    }

}
