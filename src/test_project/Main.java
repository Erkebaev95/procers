package test_project;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        // Создание производителей и потока для каждого
        ArithmeticProgression producer1 = new ArithmeticProgression(queue, 3, 3);
        ArithmeticProgression producer2 = new ArithmeticProgression(queue, 5, 5);
        Printer printer = new Printer(queue);

        Thread producerThread1 = new Thread(producer1);
        Thread producerThread2 = new Thread(producer2);
        Thread printerThread = new Thread(printer);

        // Запуск потоков
        producerThread1.start();
        producerThread2.start();
        printerThread.start();

    }
}