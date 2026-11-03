package hometask3.Adapter;

public class Adapter implements TargetInterface {
    private final AdoptedInterface adopted;

    public Adapter(AdoptedInterface adopted) {
        this.adopted = adopted;
    }

    @Override
    public void targetMethod() {
        adopted.method();
        adopted.someOtherMethod();
    }
}
