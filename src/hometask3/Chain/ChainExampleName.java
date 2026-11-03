package hometask3.Chain;

public class ChainExampleName extends ChainClass {
    @Override
    public void chain(ChainInput chainInput) {
        if (chainInput.getInputOne() == null || chainInput.getInputOne().isEmpty()) {
            System.out.println("Input is empty!");
            return;
        }
        System.out.println("Name: " + chainInput.getInputOne());
        passToNext(chainInput);
    }
}
