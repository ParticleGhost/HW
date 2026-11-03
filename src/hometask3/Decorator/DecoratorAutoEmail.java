package hometask3.Decorator;

public class DecoratorAutoEmail extends StudentProcessorDecorator {
    public DecoratorAutoEmail(Decorator wrapped) {
        super(wrapped);
    }

    @Override
    public DecoratorStudent process(String input) {
        DecoratorStudent student = super.process(input);

        if (student != null && (student.getEmail() == null || student.getEmail().isEmpty())) {
            String email = ((student.getName() + "." + student.getLastname()).toLowerCase() + "@stud.bs");
            student.setEmail(email);
            System.out.println("Email generated: " + email);
        }
        return student;
    }
}
