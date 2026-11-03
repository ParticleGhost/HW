package hometask3.Decorator;

public class StudentProcessor implements Decorator {
    @Override
    public DecoratorStudent process(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        String[] parts = input.trim().split(" ");
        DecoratorStudent student = new DecoratorStudent(parts[0], parts.length > 1 ? parts[1] : "");

        if (parts.length > 2) {
            try {
                student.setAge(Integer.parseInt(parts[2]));
            } catch (NumberFormatException ignored) {}
        }
        if (parts.length > 3) {
            student.setEmail(parts[3]);
        }
        return student;
    }
}
