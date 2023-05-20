package edu.umb.cs681.hw10;

//imports

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public abstract class FSElement {
    private String name;
    protected ReentrantLock l1 = new ReentrantLock();
    private int size;
    private LocalDateTime creation_time;
    private Directory parent;
    public FSElement(String name, int size, LocalDateTime creation_time, Directory parent){
        this.name = name;
        this.size = size;
        this.creation_time = creation_time;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public LocalDateTime getCreation_time() {
        return creation_time;
    }

    public Directory getParent() {
        return parent;
    }

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isLink();

}
