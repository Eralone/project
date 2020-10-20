package lesson1;

public class Lesson1 {
    // Homework 1.1
    public static void main(String[] args) {
        // Homework 1.2
        int in = 655;
        long lo = 755555;
        byte by = 1;
        short sho = 1222;

        double dob = 26.7d;
        float flo = 2.4f;

        char cha = '$';
        String str = "Hello, World!";

        boolean tf = true;

        System.out.println("Задние 1.3: " + homework3(26, 24, 15, 6)); // Homework 1.3

        if ((homework4(5, 8) <= 20) && (homework4(5, 8) >= 10)) { // Homework 1.4
            System.out.println("Задание 1.4: true");
        } else {
            System.out.println("Задание 1.4: false");
        }

        System.out.println("Задние 1.5: " + homework5("6", "4", "2")); // Homework 1.5

        System.out.println("Задние 1.6: " + homework6(3600)); // Homework 1.6

    }


    // Homework 1.3

    public static int homework3(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    // Homework 1.4

    public static int homework4(int var1, int var2) {
        return var1 + var2;
    }

    // Homework 1.5

    public static String homework5(String a5, String b5, String c5) {
        int d = Integer.parseInt(a5 + b5 + c5);
        if ((d >= 100) && (d < 1000)) {
            return c5 + b5 + a5;
        } else if (d < 100) {
            return "Значение меньше 100";
        } else {
            return "Значение больше 1000";
        }
    }

    // Homework 1.6
    public static String homework6(int ves) {

        double ves1 = ves;
        double ves2;

        if ((ves % 4 == 0) && (ves>100)) {
            ves2 = (ves / 100) %4;

                if (ves2 == 0) {
                    return "високосный";
                }
                else {
                    return "не високосный";
                }

        }
        else if ((ves % 4 == 0) && (ves<100)) {
            return "високосный";
        }
        else {
            return " не високосный";
        }
    }
}
