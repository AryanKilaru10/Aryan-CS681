package edu.umb.cs681.hw8;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeFactorizer extends RunnablePrimeFactorizer implements Runnable{

    public RunnableCancellablePrimeFactorizer(long dividend, long from, long to) {
        super(dividend, from, to);
    }
    private final ReentrantLock l1 = new ReentrantLock();
    private boolean stop = false;
    public void setStop(){
        l1.lock();;
        try {
            stop = true;
        } finally{
            l1.unlock();
        }
    }

    public void generatePrimeFactors(){
        long divisor = from;
        while( dividend != 1 && divisor <= to ){
            if(stop){
                System.out.println("The primes are stopped");
                break;
            }
            if( divisor > 2 && isEven(divisor)) {
                divisor++;
                continue;
            }
            if(dividend % divisor == 0) {
                factors.add(divisor);
                dividend /= divisor;
            }else {
                if(divisor==2){ divisor++; }
                else{ divisor += 2; }
            }
        }
    }
    @Override
    public void run(){
        generatePrimeFactors();
    }

    public static void main(String[] args){
        System.out.println("Factorization of 36");
        RunnableCancellablePrimeFactorizer runnable = new RunnableCancellablePrimeFactorizer(36, 2, (long)Math.sqrt(36));
        Thread thread = new Thread(runnable);
        System.out.println("Thread #" + thread.getId() +
                " performs factorization in the range of " + runnable.getFrom() + "->" + runnable.getTo());
        thread.start();
        runnable.setStop();
        System.out.println("Final result: " + runnable.getPrimeFactors() + "\n");
    }


}


