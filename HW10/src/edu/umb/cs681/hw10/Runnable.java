package edu.umb.cs681.hw10;

import java.time.LocalDateTime;

public class Runnable implements java.lang.Runnable {

    Directory apps = new Directory("apps",0,LocalDateTime.MAX,null);

    @Override
    public void run() {
        System.out.println(apps.isDirectory());
        System.out.println(apps.isLink());
        System.out.println(apps.getChildren());


    }


}
