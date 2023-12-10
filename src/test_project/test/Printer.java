package test_project.test;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class Printer implements Runnable {
    private final Queue<Integer> sharedQueue;

    public Printer(Queue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {

                if (!sharedQueue.isEmpty()) {
                    int value = sharedQueue.poll();
                    System.out.println("Printer printed: " + value);
                }
                else {
                    System.out.println("Printer is empty!");
                }

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
