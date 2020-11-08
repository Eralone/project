package Lesson6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {

    static void add_text1() {
        try {
            FileOutputStream txt1 = new FileOutputStream("text1.txt");
            byte[] line1 = ("Вопрос: как вывести массив переменных в одном write?    " + "Ответ: видимо - никак...\n").getBytes();
            byte[] line2 = ("Вопрос: а можно ли несколько write использовать в одном создании файла?    " + "Ответ: можно\n").getBytes();
            txt1.write(line1);
            txt1.write(line2);
            txt1.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void add_text2() {
        try {
            FileOutputStream txt2 = new FileOutputStream("text2.txt");
            byte[] line3 = ("Сейчас будет описание FileOutputStream на английском:\n" + "A file output stream is an output stream for writing data to a File or to a FileDescriptor. Whether or not a file is available or may be created depends upon the underlying platform. Some platforms, in particular, allow a file to be opened for writing by only one FileOutputStream (or other file-writing object) at a time. In such situations the constructors in this class will fail if the file involved is already open.").getBytes();
            txt2.write(line3);
            txt2.close();
        } catch (IOException t) {
            System.out.println(t.getMessage());
        }
    }

    static void add_text3() {

        try {
            FileOutputStream txt3 = new FileOutputStream("text3.txt");
            FileInputStream intxt1 = new FileInputStream("text1.txt");
            FileInputStream intxt2 = new FileInputStream("text2.txt");
            InputStreamReader isrtxt1 = new InputStreamReader (intxt1, StandardCharsets.UTF_8);
            InputStreamReader isrtxt2 = new InputStreamReader (intxt2, StandardCharsets.UTF_8);

            int integrint;

            while ((integrint = isrtxt1.read()) != -1) {
                System.out.print((char) integrint);
                txt3.write(integrint);
            }
            while ((integrint = isrtxt2.read()) != -1) {
                System.out.print((char) integrint);
                txt3.write(integrint);
            }

        } catch (IOException r) {
            System.out.println(r.getMessage());

        }
    }

    public static void main(String[] args) {
        add_text1();
        add_text2();
        add_text3();
    }
}
