package edu.umb.cs681.hw07;

import java.time.LocalDateTime;

public class File extends FSElement{
    public File(String name, int size, LocalDateTime creation_time, Directory parent) {
        super(name, size, creation_time, parent);
        parent.appendChild(this);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isFile() {
        return true;
    }

    @Override
    public boolean isLink() {
        return false;
    }
}
