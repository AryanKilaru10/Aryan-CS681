package edu.umb.cs681.hw07;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class FileSystem {
    private static ReentrantLock slock = new ReentrantLock();
    private ReentrantLock l1 = new ReentrantLock();
    private LinkedList<Directory> root_dir;
    private static FileSystem file = null;

    public void add_Root(Directory root){
        l1.lock();
        try{
            root_dir = new LinkedList<Directory>();
            root_dir.add(root);

        }finally {
            l1.unlock();
        }
    }

    public FileSystem(){};

    public LinkedList<Directory> get_root_directories(){
        l1.lock();
        try {
            return this.root_dir;
        }finally {
            l1.unlock();
        }

    }

    public static FileSystem get_File_Instance(){
        slock.lock();
        try {
            if (file == null){
                file = new FileSystem();
            }
            return file;
        }finally {
            slock.unlock();
        }

    }

}
