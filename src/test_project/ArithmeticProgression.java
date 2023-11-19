package test_project;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class ArithmeticProgression implements Runnable {
    private BlockingQueue<Integer> queue;
    private int initialTerm;
    private int commonDifference;

    public ArithmeticProgression(BlockingQueue<Integer> queue, int initialTerm, int commonDifference) {
        this.queue = queue;
        this.initialTerm = initialTerm;
        this.commonDifference = commonDifference;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Генерация числа в арифметической прогрессии
                int nextTerm = initialTerm;
                initialTerm += commonDifference;

                // Добавление числа в очередь
                queue.put(nextTerm);

                // Задержка перед генерацией следующего числа
                Thread.sleep((long) (Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
