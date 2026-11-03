package hometask4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void run(Scanner scanner) {
        DeadlockDemo.run();
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        long[] ids = bean.findMonitorDeadlockedThreads();
        if (ids != null) {
            System.out.println("Deadlock detected! Threads ID: " + Arrays.toString(ids));
        }

        System.out.println("Run livelock process? ('y' to run, then 'q' to end process)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("y")) {
            LivelockDemo.run();

            while (true) {
                String cmd = scanner.nextLine();
                if (cmd.equals("q")) {
                    LivelockDemo.stop();
                    System.out.println("Livelock stopped.");
                    break;
                }
                System.out.println("Invalid input. Type 'q' to end livelock.");
            }
        } else {
            System.out.println("Livelock skipped.");
        }

        System.out.println("Run 1-2 process? ('y' to run, then 'q' to end process)");
        input = scanner.nextLine();
        if (input.equalsIgnoreCase("y")) {
            AlternatingOutput.run();

            while (true) {
                String cmd = scanner.nextLine();
                if (cmd.equals("q")) {
                    AlternatingOutput.stop();
                    System.out.println("Process stopped.");
                    break;
                }
                System.out.println("Invalid input. Type 'q' to end process.");
            }
        } else {
            System.out.println("1-2 process skipped.");
        }
    }
}
