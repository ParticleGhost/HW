package hometask3.Chain;

public abstract class ChainClass {
    protected ChainClass next;

    public ChainClass setNext(ChainClass next) {
        this.next = next;
        return next;
    }

    public abstract void chain(ChainInput chainInput);

    protected void passToNext(ChainInput chainInput) {
        if(next != null) {
            next.chain(chainInput);
        }
    }
}
