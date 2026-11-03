package hometask4;

public class AlternatingOutput {

    private static final Object lock = new Object();
    private static boolean firstTurn = true;
    private static volatile boolean running = true;

    public static void run() {
        running = true;
        firstTurn = true;
        Thread t1 = new Thread(() -> {
            while (running) {
                synchronized (lock) {
                    while (!firstTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.println("1");
                    firstTurn = false;
                    lock.notifyAll();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (running) {
                synchronized (lock) {
                    while (firstTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.println("2");
                    firstTurn = true;
                    lock.notifyAll();
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void stop() {
        running = false;
    }
}