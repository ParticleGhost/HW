package hometask3.Strategy;

public class StrategyContext {
    private Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void runStrategy(String input) {
        if (strategy == null) {
            throw new IllegalStateException("strategy doesn't chosen.");
        }
        strategy.run();
    }
}
