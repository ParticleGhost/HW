package hometask3.Proxy;

public class ProxyObject implements ProxyStudents {
    private RealObject realObject;

    @Override
    public void run() {
        if (realObject == null) {
            realObject = new RealObject();
        }
        realObject.run();
    }
}
