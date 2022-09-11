package ua.ithillel.hw17;

/*  1. Определить, сколько раз повторяется в тексте каждое слово, которое встречается в нем.
    2. В каждом слове текста k-ю букву заменить заданным символом. Если k больше длины слова, корректировку не выполнять.
    3. Напечатать без повторения слова текста, у которых первая и последняя буквы совпадают
    4. Подсчитать количество содержащихся в данном тексте знаков препинания
*/

import ua.ithillel.hw17.service.StringHandler;

public class Main {
    public static void main(String[] args) {
        StringHandler example = new StringHandler("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Venenatis cras sed felis eget velit aliquet sagittis. " +
                "Vitae ultricies leo integer malesuada.");
        System.out.println(example.repetition());
        System.out.println(example.replace(5, 'o'));
        System.out.println(example.sameLetters());
        System.out.println(example.punctuation());
    }
}
