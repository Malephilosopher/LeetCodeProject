package leetcode.PrintInOrder;

import java.util.concurrent.atomic.AtomicInteger;

public class FooPer {

    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);
    private final Object object = new Object();
    public FooPer() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (object){
            while(firstJobDone.get() != 1)
            {
                object.wait();
            }
            // printSecond.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstJobDone.incrementAndGet();
            object.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (object){
            while(firstJobDone.get() != 1)
            {
                object.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondJobDone.incrementAndGet();
            object.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (object)
        {
            while(secondJobDone.get() != 1)
            {
                object.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
