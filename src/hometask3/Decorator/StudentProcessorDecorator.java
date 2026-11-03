package hometask3.Decorator;

public abstract class StudentProcessorDecorator implements Decorator {
    protected final Decorator wrapped;

    public StudentProcessorDecorator(Decorator wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public DecoratorStudent process(String input) {
        return wrapped.process(input);
    }
}
