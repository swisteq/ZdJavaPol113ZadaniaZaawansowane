package pl.sdacademy.java.advanced.exercises.day1.task4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Storage {
    private Map<String, List<String>> storage;

    public Storage() {
        this.storage = new HashMap<>();
    }

    public void addToStorage(String key, String value) {
        if(storage.containsKey(key)) {
            //List<String> list = storage.get(key);
            //list.add(value);
            storage.get(key).add(value);
        } else {
            List<String> list = new ArrayList<>();
            list.add(value);
            storage.put(key, list);
        }
    }

    public void printValues(String key) {
        System.out.println(getValues(key));
    }

    public List<String> getValues(String key) {
        return storage.get(key);
    }

    public List<String> findValues(String searchedValue) {
        return storage.entrySet()
                .stream()
                .filter(entry -> entry.getValue().contains(searchedValue))
                //.map(entry -> entry.getKey())
                .map(Map.Entry::getKey)
                //.toList()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Storage storage = new Storage();
        storage.addToStorage("0", "value0_0");
        storage.addToStorage("0", "value0_1");
        storage.addToStorage("1", "value1_0");
        storage.addToStorage("1", "value0_0");
        storage.addToStorage("2", "value2_0");
        storage.printValues("1");
    }
}

