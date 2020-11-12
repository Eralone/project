package lesson2;

public class Lesson2 {

    public static void main(String[] args) {
        // Homework2-1
        int[] hm21 = {1, 1, 0, 0, 1};
        for (int i = 0; i < hm21.length; i++) {
            hm21[i] = (hm21[i] == 1 ? 0 : 1);
            System.out.print(hm21[i] + "\t");
        }
        System.out.println(" - Задание 1");

        homework22(" - Задание 2");

        homework23 (" - Задание 3");

        homework24 (" - Задание 4");

        homework25 (" - Задание 5");

        homework26 (" - Задание 6");


    }
    public static void homework22 (String hm22) {
        int []fill = new int[8];
        for (int i = 0; i < fill.length; i++) {
            fill[i] = (i==0) ? 1:fill[i-1] + 3;
            System.out.print(fill[i] + "\t");
        }
        System.out.println(hm22);
    }

    public static void homework23 ( String hm23) {
        int[] ab = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int j = 0; j < ab.length; j++) {
            ab[j] = (ab[j] < 6) ? ab[j] * 2 : ab[j];
            System.out.print(ab[j] + "\t");
        }
        System.out.println(hm23);
    }
    public static void homework24 ( String hm24) {
        int[] a4 = {2,20,34,12,1,214,2,421,5,2,3,78};
        int max = 0;
        for (int q = 0; q < a4.length; q++) {
            if (a4[q] >= max)
                max = a4[q];
        }
        System.out.println(max + hm24);
        int min = 0;
        for (int s = 0; s < a4.length; s++) {
            if (a4[s] <= min)
                min = a4[s];
        }
        System.out.println(min + hm24);
        }

    public static void homework25 ( String hm25) {

        int x1 = 0;
        int y1 = 9;
        int[][] a5 = new int [10][10];
        for (int x = 0; x < a5.length; x++ ) {
            for (int y = 0; y < a5.length; y ++) {
                a5[x][y] = (x==y) ? 1: (x == x1 && y == y1) ? 1:0;
                System.out.print(a5[x][y]+"\t");
            }
            x1+=1;
            y1-=1;
            System.out.println();
        }
        System.out.println(hm25);
    }

    public static void homework26 ( String hm26) {

        int[] a6 = {1,4,6,5,2,4,};
        boolean b6;
        int c6 = 0;
        int i = 0;

        for (int j =i; j < a6.length ; j++) {
            c6 += a6[j];
        }
        b6 = (a6[i] == c6/2 || a6[i] +a6 [i+1] == c6/2 || a6[i] + a6[i+1] +a6 [i+2] == c6/2 || a6[i] + a6[i+1] + a6[i+2] +a6 [i+3] == c6/2 || a6[i] + a6[i+1] + a6[i+2] + a6[i+3] +a6 [i+4] == c6/2) ? true:false;
        System.out.println(b6 + hm26);
    }
}

