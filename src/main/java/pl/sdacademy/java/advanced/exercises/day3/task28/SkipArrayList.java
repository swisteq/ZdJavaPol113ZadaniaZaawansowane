package pl.sdacademy.java.advanced.exercises.day3.task28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SkipArrayList<T> extends ArrayList<T> {

    public List<T> getEveryNthElement(int startIndex, int skip) {
        List<T> everyNthElements = new ArrayList<>();
        int currentIndex = startIndex;
        while(currentIndex < this.size()) {
            T currentValue = this.get(currentIndex);
            everyNthElements.add(currentValue);
            currentIndex += skip + 1;
        }
        return everyNthElements;
    }
}
