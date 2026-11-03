package hometask4;

import java.util.concurrent.CountDownLatch;

public class DeadlockDemo {
    static class Student {
        private final String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Student bower, CountDownLatch latch) {
            System.out.format("%s is bowing %s.%n", this.name, bower.getName());
            latch.countDown();
            try {
                latch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            bower.bowBack(this);
        }

        public synchronized void bowBack(Student bower) {
            System.out.format("%s is bowing %s.%n", this.name, bower.getName());
        }
    }

    public static void run() {
        final Student andrey = new Student("Andrey");
        final Student valentin = new Student("Valentin");

        CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread(() -> {
            andrey.bow(valentin, latch);
        });
        Thread t2 = new Thread(() -> {
            valentin.bow(andrey, latch);
        });

        t1.start();
        t2.start();
    }
}
