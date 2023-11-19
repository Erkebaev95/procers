package test_project;

import java.util.concurrent.BlockingQueue;

public class Printer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Printer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Получение числа из очереди
                int number = queue.take();

                // Печать числа
                System.out.println(number);

                // Задержка перед печатью следующего числа
                Thread.sleep((long) (Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
