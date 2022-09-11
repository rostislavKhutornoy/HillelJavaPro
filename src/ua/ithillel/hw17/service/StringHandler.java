package ua.ithillel.hw17.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHandler {
    private String string;

    public StringHandler(String string) {
        this.string = string;
    }

    public Map<String, Integer> repetition() {
        Map<String, Integer> wordsRepetitionStats = new HashMap<>();
        Matcher matcher = Pattern.compile("\\w+").matcher(string);
        while (matcher.find()) {
            if (wordsRepetitionStats.containsKey(matcher.group())) {
                wordsRepetitionStats.put(matcher.group(), wordsRepetitionStats.get(matcher.group()) + 1);
            } else {
                wordsRepetitionStats.put(matcher.group(), 1);
            }
        }
        return wordsRepetitionStats;
    }

    public String replace(int index, char replacement) {
        Matcher matcher = Pattern.compile("\\w{" + (index - 1) + "}(\\w+)").matcher(string);
        StringBuilder newString = new StringBuilder(string);
        while (matcher.find()) {
            newString.replace(matcher.start() + index - 1, matcher.start() + index, String.valueOf(replacement));
        }
        string = newString.toString();
        return string;
    }

    public Set<String> sameLetters() {
        Set<String> words = new HashSet<>();
        Matcher matcher = Pattern.compile("\\b([A-z])\\w*([A-z]\\1)\\b").matcher(string);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    public int punctuation() {
        int counter = 0;
        Matcher matcher = Pattern.compile("[^\\w\\s]").matcher(string);
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }

    @Override
    public String toString() {
        return string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
