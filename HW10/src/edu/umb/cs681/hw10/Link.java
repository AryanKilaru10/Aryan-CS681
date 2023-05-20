package edu.umb.cs681.hw10;

import java.time.LocalDateTime;



public class Link extends FSElement{
    FSElement target;
    public Link(String name, int size, LocalDateTime creation_time, FSElement target, Directory parent) {
        super(name, size, creation_time, parent);

        this.target = target;

        parent.appendChild(this);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    public FSElement getTarget() {
       l1.lock();
       try {
           return target;
       }
       finally {
           l1.unlock();
       }
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isLink() {
        return true;
    }
}
