package Behavioral.strategy;

public class Sorter {
    private SortStrategy strategy;

    public Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public String[] sort(String[] array) {
        return strategy.sort(array);
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }
}
