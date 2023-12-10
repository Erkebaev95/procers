package test_project.test;

import java.util.concurrent.BlockingQueue;

public class Client implements Runnable {
    private final BlockingQueue<String> clientRequests;

    public Client(BlockingQueue<String> clientRequests) {
        this.clientRequests = clientRequests;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((long) (Math.random() * 5000));

                String request = "Client request #" + System.currentTimeMillis();
                clientRequests.offer(request);
                System.out.println("Client sent request: " + request);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
