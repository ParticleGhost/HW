package hometask3.Decorator;

public class DecoratorValidation extends StudentProcessorDecorator {
    public DecoratorValidation(Decorator wrapped) {
        super(wrapped);
    }

    @Override
    public DecoratorStudent process(String input) {
        DecoratorStudent student = super.process(input);
        boolean invalidState = false;

        if (student != null) {
            if (student.getLastname() == null || student.getLastname().isEmpty()) {
                System.out.println("Invalid input: lastname is necessary!");
                invalidState = true;
            }
            if (student.getAge() < 0 || student.getAge() > 120) {
                System.out.println("WARNING: age must be >0 and <120: " + student.getAge());
                invalidState = true;
            }
            if (student.getEmail() != null && !student.getEmail().isEmpty() && !student.getEmail().contains("@")) {
                System.out.println("WARNING: email must contain '@': " + student.getEmail());
                invalidState = true;
            }
            if (!invalidState) {
                System.out.println("Validation: OK.");
            }
        }
        return student;
    }
}
