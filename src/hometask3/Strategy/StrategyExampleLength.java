package hometask3.Strategy;

public class StrategyExampleLength implements Strategy {
    private String input;

    public StrategyExampleLength(String input) {
        this.input = input;
    }

    @Override
    public void run() {
        System.out.println("Input length: " + input.length());
    }
}

