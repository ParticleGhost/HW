import java.util.Scanner;
import hometask1.Task1;
import hometask2.Task2;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean continueOperating = true;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("\nChoose module (1-4, 'q' for exit): ");
            if (input.hasNextInt()) {
                int moduleNumber = input.nextInt();

                // ДЗ к модулю 1
                if (moduleNumber == 1) {
                    Task1.run();
                }

                // ДЗ к модулю 2
                else if (moduleNumber == 2) {
                    Task2.run();
                }

                // Обработка неверного номера модуля
                else if ((moduleNumber >= 3 && moduleNumber <= 4)) {
                    System.out.println("Hometask for this module does not yet exist.");
                }

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
    }
}