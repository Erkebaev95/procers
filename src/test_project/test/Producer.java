package test_project.test;

import java.util.Queue;

public class Producer implements Runnable {
    private final Queue<Integer> sharedQueue;
    private int initialTerm;
    private int commonDifference;

    public Producer(Queue<Integer> sharedQueue, int initialTerm, int commonDifference) {
        this.sharedQueue = sharedQueue;
        this.initialTerm = initialTerm;
        this.commonDifference = commonDifference;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int nextValue = initialTerm;
                initialTerm += commonDifference;
                sharedQueue.add(nextValue);
                Thread.sleep((long) (Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
