package edu.umb.cs681.hw07;

//imports

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {

    private LinkedList<FSElement> c;
    public Directory(String name, int size, LocalDateTime creation_time, Directory parent) {
        super(name, size, creation_time, parent);

        if(parent!=null){
            parent.appendChild(this);
        }
    }

    public int CountChildren(){
        return getChildren().size();
    }

    public LinkedList<Directory> get_Sub_Directory(){
        LinkedList<Directory> directories = new LinkedList<Directory>();
        for (FSElement c: getChildren()){
            if(c.isDirectory()){directories.add((Directory) c);}
        }
        return directories;
    }

    public LinkedList<File> get_files(){
        LinkedList<File> files = new LinkedList<File>();
        for (FSElement f: getChildren()){
            if(f.isFile()){ files.add((File) f);}
        }
        return files;
    }

    public int getTotalSize(){
        int size = 0;
        for (FSElement s: getChildren()){
            if(s instanceof Directory) {
                size += ((Directory) s).getTotalSize();
            }
            else{
                size += s.getSize();
            }
        }
        return size;
    }

    public LinkedList<FSElement> getChildren(){ return c; }

    public void appendChild(FSElement c){
        if(this.c == null){ this.c = new LinkedList<FSElement>();}
        this.c.add(c);
    }



    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isLink() {
        return false;
    }
}
