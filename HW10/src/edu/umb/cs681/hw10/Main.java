package edu.umb.cs681.hw10;
public class Main {
    public static void main(String[] args) {
        Runnable run1 = new Runnable();
        Runnable run2 = new Runnable();
        Runnable run3 = new Runnable();
        Runnable run4 = new Runnable();
        Runnable run5 = new Runnable();
        Runnable run6 = new Runnable();
        Runnable run7 = new Runnable();
        Runnable run8 = new Runnable();
        Runnable run9 = new Runnable();
        Runnable run10 = new Runnable();

        Thread thr1 = new Thread(run1);
        Thread thr2 = new Thread(run2);
        Thread thr3 = new Thread(run3);
        Thread thr4 = new Thread(run4);
        Thread thr5 = new Thread(run5);
        Thread thr6 = new Thread(run6);
        Thread thr7 = new Thread(run7);
        Thread thr8 = new Thread(run8);
        Thread thr9 = new Thread(run9);
        Thread thr10 = new Thread(run10);

        thr1.start();
        thr2.start();
        thr3.start();
        thr4.start();
        thr5.start();
        thr6.start();
        thr7.start();
        thr8.start();
        thr9.start();
        thr10.start();
    }

}


