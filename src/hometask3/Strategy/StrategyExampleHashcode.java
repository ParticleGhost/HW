package hometask3.Strategy;

public class StrategyExampleHashcode implements Strategy {
    private String input;

    public StrategyExampleHashcode(String input) {
        this.input = input;
    }
    
    @Override
    public void run() {
        System.out.println("Input hashcode: " + input.hashCode() + "\n-Strategy process ended.-\n");
    }
}
