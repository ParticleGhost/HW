package hometask3.Chain;

public class ChainExampleLastname extends ChainClass {
    @Override
    public void chain(ChainInput chainInput) {
        if (chainInput.getInputOne() == null || chainInput.getInputOne().isEmpty()) {
            return;
        }
        if (chainInput.getInputTwo() == null || chainInput.getInputTwo().isEmpty()) {
            System.out.println("Input doesn't have any other symbols.");
            passToNext(chainInput);
            return;
        }
        System.out.println("Lastname: " + chainInput.getInputTwo());
        passToNext(chainInput);
    }
}
