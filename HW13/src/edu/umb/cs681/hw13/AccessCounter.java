package edu.umb.cs681.hw13;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AccessCounter {
    private static AccessCounter instance;
    private static ReentrantLock l1 = new ReentrantLock();
    private ReentrantReadWriteLock l2 = new ReentrantReadWriteLock();
    private final Map<Path, Integer> counterMap;

    AccessCounter() {
        counterMap = new HashMap<>();
    }

    public static AccessCounter getInstance() {
        if (instance == null) {
            l1.lock();
            try {
                if (instance == null) {
                    instance = new AccessCounter();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }

    public void increment(Path filePath) {
        l2.writeLock().lock();
        try {
            counterMap.put(filePath, counterMap.getOrDefault(filePath, 0) + 1);
        } finally {
            l2.writeLock().unlock();
        }
    }

    public int getCount(Path filePath) {
        l2.readLock().lock();
        try {
            return counterMap.getOrDefault(filePath, 0);
        } finally {
            l2.readLock().unlock();
        }
    }
}
