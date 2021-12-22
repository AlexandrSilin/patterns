package Behavioral.strategy;

public class QuickSortStrategy implements SortStrategy {
    @Override
    public String[] sort(String[] array) {
        System.out.println("Quick sort");
        return array;
    }
}
