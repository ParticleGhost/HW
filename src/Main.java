import java.util.Scanner;
import hometask1.Task1;
import hometask2.Task2;
import hometask3.Task3;
import hometask4.Task4;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean continueOperating = true;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("\nChoose module (1-4, 'q' for exit): ");
            if (input.hasNextInt()) {
                int moduleNumber = input.nextInt();
                input.nextLine();

                // ДЗ к модулю 1
                if (moduleNumber == 1) {
                    Task1.run();
                }

                // ДЗ к модулю 2
                else if (moduleNumber == 2) {
                    Task2.run();
                }

                // ДЗ к модулю 3
                else if (moduleNumber == 3) {
                    Task3.run();
                }

                else if (moduleNumber == 4) {
                    Task4.run(input);
                }

                // Обработка неверного номера модуля
                else {
                    System.out.println("Invalid value.");
                }
            } else if (input.hasNext()) {
                if (input.next().equals("q")) {
                        continueOperating = false;
                } else {
                    System.out.println("Invalid value.");
                }
            }
        } while (continueOperating);
        input.close();
        System.exit(1);
    }
}