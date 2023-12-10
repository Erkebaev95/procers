package test_project.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> sharedQueue = new LinkedList<>();
        Producer producer1 = new Producer(sharedQueue, 3,3);
        Producer producer2 = new Producer(sharedQueue, 5,5);
        Printer printer = new Printer(sharedQueue);

        Thread producerThread1 = new Thread(producer1);
        Thread producerThread2 = new Thread(producer2);
        Thread printerThread = new Thread(printer);

        producerThread1.start();
        producerThread2.start();
        printerThread.start();

    }
}
