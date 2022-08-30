package ua.ithillel.hw14.service;

import ua.ithillel.hw14.util.IOUtil;
import java.util.HashMap;
import java.util.Map;

public class WordRateAnalyzer {
    final private String filename;
    private final HashMap<String, Integer> data;

    public WordRateAnalyzer(String filename) {
        this.filename = filename;
        this.data = new HashMap<>();
    }

    public void read() {
        if (!data.isEmpty()) {
            data.clear();
        }
        String content = IOUtil.readFile(filename);
        String[] words = new String[] {};
        if (content != null) {
            content = content.replace("...", " ")
                    .replace(".", " ")
                    .replace("-", " ")
                    .replace(":", " ")
                    .replace(",", " ")
                    .replace("  ", " ");
            words = content.split(" ");
        }
        for (String word : words) {
            if (data.containsKey(word)) {
                int count = data.get(word);
                data.put(word, ++count);
            } else {
                data.put(word, 1);
            }
        }
    }

    public void printStats() {
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " - " + value + " times");
        }
    }

    public HashMap<String, Integer> getResult() {
        return data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
