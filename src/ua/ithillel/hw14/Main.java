package ua.ithillel.hw14;

import ua.ithillel.hw14.service.WordRateAnalyzer;

/*  Задан файл с текстом на английском языке. Выделить все различные слова.
    Для каждого слова подсчитать частоту его встречаемости. Слова, отличаю-
    щиеся регистром букв, считать различными. Использовать класс HashMap.   */

public class Main {
    public static void main(String[] args) {
        WordRateAnalyzer wordRateAnalyzer = new WordRateAnalyzer("file.txt");
        wordRateAnalyzer.read();
        wordRateAnalyzer.printStats();
        System.out.println(wordRateAnalyzer);
    }
}
