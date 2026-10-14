package hometask2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Task2 {
    public static void run() throws Exception {

        // Чтение JSON-файла и внесение данных в созданный массив экземпляров класса Student
        ObjectMapper mapper = new ObjectMapper();
        Path path = Paths.get("data", "Student_base.json");
        Student[] students = mapper.readValue(path.toFile(), Student[].class);

        Scanner input = new Scanner(System.in);
        System.out.println("Show detail info? (y/n)");
        switch (input.next()) {

            // Последовательный старт нескольких стримов с выводом промежуточной информации об обработке в консоли
            case "y":
                System.out.println("Students with their books registry. Students sorted by lastname, name; books sorted by page count:");
                Arrays.stream(students)
                        .sorted(Comparator.comparing(Student::getLastname)
                                .thenComparing(Student::getName))
                        .forEach(s -> {
                            System.out.println(s);
                            s.getBooks().stream()
                                    .sorted(Comparator.comparing(Book::getPageCount))
                                    .forEach(System.out::println);

                        });

                System.out.println("\nBooks now filtered by date of publishing (>2000) and limited by 3 on each student:");
                Arrays.stream(students)
                        .sorted(Comparator.comparing(Student::getLastname)
                                .thenComparing(Student::getName))
                        .forEach(s -> {
                            System.out.println(s);
                            s.getBooks().stream()
                                    .sorted(Comparator.comparing(Book::getPageCount))
                                    .filter(b -> b.getDatePublished() > 2000)
                                    .limit(3)
                                    .forEach(System.out::println);
                        });

                System.out.println("\nList of books after all operations, before moving on the date:");
                Arrays.stream(students)
                        .sorted(Comparator.comparing(Student::getLastname)
                                .thenComparing(Student::getName))
                        .flatMap(s -> s.getBooks().stream())
                        .sorted(Comparator.comparing(Book::getPageCount))
                        .distinct()
                        .filter(b -> b.getDatePublished() > 2000)
                        .limit(3)
                        .forEach(System.out::println);
                System.out.println("\nAnd the final answer:\n");

            //Целевой стрим задания
            case "n":
                Arrays.stream(students)
                        .sorted(Comparator.comparing(Student::getLastname)
                                .thenComparing(Student::getName))
                        .peek(System.out::println)
                        .flatMap(s -> s.getBooks().stream())
                        .sorted(Comparator.comparing(Book::getPageCount))
                        .distinct()
                        .filter(b -> b.getDatePublished() > 2000)
                        .limit(3)
                        .map(Book::getDatePublished)
                        .findFirst()
                        .ifPresentOrElse(year -> System.out.println("\nFounded book date published: " + year),
                                () -> System.out.println("\nBook does not found."));
        }
    }
}
