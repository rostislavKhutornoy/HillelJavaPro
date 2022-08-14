package ua.ithillel.hw11.util;

import java.io.*;

public class IOUtil {
    public static String readFile(String filename) {
        int i;
        String str = "";
        try (FileInputStream fileInputStream = new FileInputStream(filename)) {
            do {
                i = fileInputStream.read();
                if (i != -1) {
                    str += (char) i;
                }
            } while (i != -1);
            return str;
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            return null;
        } catch (IOException e) {
            System.out.println("An I/O Error Occurred");
            return null;
        }
    }

    public static void writeFile(String filename, String toWrite, Boolean append) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename, append)) {
            fileOutputStream.write(toWrite.getBytes());
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("An I/O Error Occurred");
        }
    }

    public static boolean isFileEmpty(String filename) {
        File file = new File(filename);
        return file.length() == 0;
    }
}
