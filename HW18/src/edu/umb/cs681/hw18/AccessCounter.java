package edu.umb.cs681.hw18;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;

public class AccessCounter {
    private static AccessCounter instance;
    private static final Lock lock = new ReentrantLock();
    private final Map<Path, Integer> counterMap;

    public AccessCounter() {
        counterMap = new ConcurrentHashMap<>();
    }

    public static AccessCounter getInstance() {
        if (instance == null) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new AccessCounter();
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public void incrementCount(Path filePath) {
        lock.lock();
        try {
            counterMap.compute(filePath, (key, value) -> (value == null) ? 1 : value + 1);
        } finally {
            lock.unlock();
        }
    }

    public int getCount(Path filePath) {
        lock.lock();
        try {
            return counterMap.compute(filePath, (k, v) -> (v == null) ? 0 : v);
        } finally {
            lock.unlock();
        }
    }

}