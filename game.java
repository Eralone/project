package Lesson3.Lessin3;

import java.util.Random;
import java.util.Scanner;

public class game {

    public static final Scanner Sfill = new Scanner(System.in); // средство для ввода пользователем данных в терминал
    public static final Random RanForPC = new Random();

    public static final char human_fill = 'X'; //ввод человека, значения не меняются
    public static final char pc_fill = 'O'; //ввод компьютера, значения не меняются
    public static final char empty_fill = '_'; //пустые строки, значения не меняются

    public static int mapX; // кол-во столбцов на карте
    public static int mapY; // кол-во строк на карте
    public static char[][] field; // создание поля (массива)

    public static int quantityWin = 4; //Кол-во ячеек для победы (3 или 4), если 3, то mapX;mapY=3, если 4, то mapX;mapY=5

    public static void initMap() {

        mapX = 5; // кол-во столбцов на карте
        mapY = 5; // кол-во строк на карте
        field = new char [mapY][mapX]; // создание массива

        for (int y = 0; y < mapX; y++) { // создание поля
            for (int x = 0; x < mapX; x++) {
                field[y][x]=empty_fill;
            }
        }
    }

    public static void printMap() { //Вывод массива
        for (int y = 0; y < mapX; y++) {
            for (int x = 0; x < mapX; x++) {
                System.out.print("| " + field[y][x] + " |");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn() { //Ввод данных пользователем
        int x;
        int y;
        do {
            System.out.println( "Введите значение по вертикали от 1 до " +mapX);
            y = Sfill.nextInt() -1;
            System.out.println( "Введите значение по горизонтали от 1 до " +mapY);
            x = Sfill.nextInt() -1;
        } while (!ValidCell(y,x) || !EmptyCell(y,x));
        field[y][x] = human_fill;
    }

    public static void pcTurn() {
        int x;
        int y;
        do {
            y = RanForPC.nextInt(mapY); // рандом от 0 до 2,99 для y
            x = RanForPC.nextInt(mapX); // рандом от 0 до 2,99 для x
        } while (!EmptyCell(y,x));
        field[y][x] = pc_fill;
    }

    public static boolean ValidCell (int y, int x) { //репит при некорректных значениях
        return x >= 0 && x < mapX && y >= 0 && y < mapY;
    }

    public static boolean EmptyCell (int y, int x) { //репит, если значение не равно '_'
        return field[y][x] == empty_fill;
    }

    public static boolean checkWin(char c) {


        if (quantityWin == 3) {
            for (int y = 0; y < mapY; y++) {
                for (int x = 0; x < mapX; x++) {
                    if (field[0][x] + field[1][x] + field[2][x] == c * quantityWin) {
                        return true;
                    } else if (field[y][0] + field[y][1] + field[y][2] == c * quantityWin) {
                        return true;
                    }
                }
            }
            if (field[0][0] + field[1][1] + field[2][2] == c * quantityWin) {
                return true;
            } else if (field[0][2] + field[1][1] + field[2][0] == c * quantityWin) {
                return true;
            } else {
                return false;
            }
        }
        else if (quantityWin == 4) {
            for (int y = 0; y < mapY; y++) {
                for (int x = 0; x < mapX; x++) {
                    if (field[0][x] + field[1][x] + field[2][x] + field[3][x] == c * quantityWin || field[1][x] + field[2][x] + field[3][x] + field[4][x] == c * quantityWin) {
                        return true;
                    } else if (field[y][0] + field[y][1] + field[y][2] + field[y][3] == c * quantityWin || field[y][1] + field[y][2] + field[y][3] + field[y][4] == c * quantityWin) {
                        return true;
                    }
                }
            }
            if (field[0][0] + field[1][1] + field[2][2] + field[3][3] == c * quantityWin || field[1][1] + field[2][2] + field[3][3] + field[4][4] == c * quantityWin) {
                return true;
            } else if (field[0][3] + field[1][2] + field[2][1] + field[3][0] == c * quantityWin || field[1][4] + field[2][3] + field[3][2] + field[4][1] == c * quantityWin) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFullMap() {
        for (int y = 0; y < mapY; y++) {
            for (int x = 0; x < mapX; x++) {
                if (field[y][x] == empty_fill) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {


        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(human_fill)) {
                System.out.println("Вы победили!");
                break;
            }
            if (isFullMap()) {
                System.out.println("Ничья!");
                break;
            }
            pcTurn();
            printMap();
            if (checkWin(pc_fill)) {
                System.out.println("Компьютер победил, попробуйте еще!");
                break;
            }
            if (isFullMap()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }
}