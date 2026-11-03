package hometask3.Chain;

public class ChainInput {
    private String inputOne;
    private String inputTwo;

    public ChainInput(String input) {
        if (input != null && !input.isEmpty()) {
            String[] parts = input.split(" ");
            if (parts.length > 0) {this.inputOne = parts[0];}
            if (parts.length > 1) {this.inputTwo = parts[1];}
        }
    }

    public String getInputOne() {
        return inputOne;
    }

    public String getInputTwo() {
        return inputTwo;
    }
}
