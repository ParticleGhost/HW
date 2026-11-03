package hometask3;

import hometask3.Adapter.Adapter;
import hometask3.Adapter.AdoptedInterface;
import hometask3.Adapter.TargetInterface;
import hometask3.Builder.*;
import hometask3.Chain.*;
import hometask3.Proxy.*;
import hometask3.Strategy.*;
import hometask3.Decorator.*;

import java.util.Scanner;

public class Task3 {
    public static void run() {
        System.out.println("Type student in schema: name lastname [age] [email] ([] - is optional):");
        String input = new Scanner(System.in).nextLine();

        //Стратегия
        StrategyContext context = new StrategyContext(new StrategyExampleLength(input));
        context.runStrategy(input);

        context.setStrategy(new StrategyExampleHashcode(input));
        context.runStrategy(input);

        //Цепочка обязанностей
        ChainClass chain = new ChainExampleName();
        chain.setNext(new ChainExampleLastname())
                .setNext(new ChainExampleEnd());

        chain.chain(new ChainInput(input));

        //Билдер
        BuilderClass student = null;

        if (input != null && !input.isEmpty()) {
            String[] parts = input.split(" ");
            if (parts.length > 3) {
                student = new BuilderClass.Builder(input)
                        .age(parts[2])
                        .email(parts[3])
                        .build();
            } else if (parts.length > 2) {
                student = new BuilderClass.Builder(input)
                        .age(parts[2])
                        .build();
            } else {
                student = new BuilderClass.Builder(input).build();
            }
            if (student != null) {
                System.out.println("Student recorded as: " + student);
            } else {
                System.out.println("Invalid input.");
            }
            System.out.println("-Builder process ended.-\n");
        }

        //Прокси
        ProxyStudents studentsBase = new ProxyObject();
        System.out.println("First attempt to load student_base.json:");
        studentsBase.run();
        System.out.println("Second attempt to load student_base.json:");
        studentsBase.run();
        System.out.println("-Proxy process ended.-\n");

        //Декоратор
        System.out.println("Base output from decorator:");
        Decorator baseStudent = new StudentProcessor();
        System.out.println(baseStudent.process(input));

        System.out.println("Output with validation:");
        Decorator withValidation = new DecoratorValidation(new StudentProcessor());
        System.out.println(withValidation.process(input));

        System.out.println("Full output:");
        Decorator full = new DecoratorAutoEmail(new DecoratorValidation(new StudentProcessor()));
        System.out.println(full.process(input));
        System.out.println("-Decorator process ended.-\n");

        //Адаптер
        TargetInterface adapter = new Adapter(new AdoptedInterface());
        adapter.targetMethod();
        System.out.println("-Adapter process ended.-");
    }
}
